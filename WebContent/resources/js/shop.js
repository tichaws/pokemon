// Get the modal
var modal = document.getElementById('b1');
var modal = document.getElementById('b2');
var modal = document.getElementById('b3');

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
	if (event.target == modal) {
		//modal.style.display = "none";
		model.model('toggle');
	}
}


$(document).ready(function() {
	var account = {"amount" : "",
			   "item" : "",
			   "transactionID" : "",
			   "accountNumber" : "",
			   "accountName" : "",
			   "pin" : "",
			   "pocketSlot_qty" : "",
			   "order" : ""
			   }
	var form = $("#buy1");
	console.log("asssb");
	$(".btnbuy").on("click", function() {	
		clear();
		$("#buy1").modal();
		account.item = $(this).closest(".productbox").data("item");
		account.order = $(this).closest(".productbox").data("order");
		account.pocketSlot_qty = $(this).closest(".productbox").data("pocketslot_qty");
		console.log("a"+account.pocketSlot_qty);
		$("#buy1").find("[data-name=order]").text(account.order);
		$('div.modal-backdrop').remove()
	});
	
	// pay
	$("#paySubmit").on('click', function(){
		if(validatePay(form) == true){
			var input = getDataPay(form);
			$.ajax({
				type : "POST",
				url : "http://192.168.9.154:8080/PaymentGWWeb/PaymentGatewayService/Inquiry",
				headers: {
                    'Access-Control-Allow-Origin': '*'
                },
				crossdomain: true,
				dataType : "json",
				data : JSON.stringify(input),
				success : function(data) {
					if(data.resultCode == "Success"){
						callPayment_conf_form(data);						
					}else{
						isSuccessResultTransaction(false);
					}
				}, 
				error: function(data){
					console.log("data "+data.resultMessage);
				},
			});
		}
	});
			
	function getDataPay(form){
		var accountNumber = $(form).find("input[name=account_number]").val();
		account.pin = $(form).find("input[name=pin]").val();
		account.amount = $(form).find("input[name=amount]").val();
		return { "accountNumber" : accountNumber,
				 "pin" : account.pin,
				 "amount" : account.amount
			}
		}
	
		function validatePay(form){
				var check = false;
				var account_number = $(form).find("input[name=account_number]").val();
				var amount = $(form).find("input[name=amount]").val();
				var pin = $(form).find("input[name=pin]").val();				
				var pay_amount = $(form).find("data[name=pay]").data("pay_amount");
				
				if(isNaN(account_number)){
					alert("กรุณาตรวจสอบเขียนบัญชี");
					check = false;
					return check;
				}else{
					check = true;
				}
				if(isNaN(amount)){
					alert("กรุณาใส่จำนวนเงินที่จ่าย");
					check = false;
					return check;
				}else{
					/*if(amount >=  pay_amount){
						check = true;						
					}else{
						alert("จำนวนเงินไม่พอ");
						check = false;
						return check;
					}*/
				}
				if(isNaN(pin)){
					alert("กรุณากรอก PIN");
					check = false;
					return check;
				}else{
					check = true;
				}
				return check;
			}
		
		var payment_conf_form = $("#confirm");
		function callPayment_conf_form(data){
			account.transactionID = data.transactionID;
			account.accountNumber = data.accountNumber;
			account.accountName = data.accountName;
			$("#confirm").modal();
			$(payment_conf_form).find("[data-name=order]").text(account.order);
			$(payment_conf_form).find("[data-name=tran_id]").text(account.transactionID);
			$(payment_conf_form).find("[data-name=account_number]").text(account.accountNumber);
			$(payment_conf_form).find("[data-name=account_name]").text(account.accountName);
			$(payment_conf_form).find("[data-name=amount]").text(account.amount);
			$('div.modal-backdrop').remove()
		}
		
		function clear(){
			$(form).find("input[name=account_number]").val("");
			$(form).find("input[name=amount]").val("");
			$(form).find("input[name=pin]").val("");				
		}
		
		
		// pay_confirm
		$("#payment_confSubmit").on('click', function(){
			var input = getDataPayConfirm(payment_conf_form);
			$.ajax({
				type : "POST",
				url : "http://192.168.9.154:8080/PaymentGWWeb/PaymentGatewayService/Payment",
				headers: {
	                   'Access-Control-Allow-Origin': '*'
	                    },
				crossdomain: true,
				dataType : "json",
				data : JSON.stringify(input),
				success : function(data) {
					saveTransaction();
					isSuccessResultTransaction(true);
				}, 
				error: function(data){
					isSuccessResultTransaction(false);
				},
			});
		});
		function getDataPayConfirm(form){
			return { "accountNumber" : account.accountNumber,
					 "pin" : account.pin,
					 "amount" : account.amount,
					 "transactionID" : account.transactionID
			}
		}
		
		function isSuccessResultTransaction(success){
			var textResult;
			if(success == true){
				textResult = "Payment Success";
			}else{
				textResult = "Payment Fail";
			}
			$("#modalPayment_result").find("label[data-name=payment_result]").text(textResult);
			$("#modalPayment_result").modal();
			$('div.modal-backdrop').remove()
		}
		
		function saveTransaction(){
			var input = getDataSaveTransactionPayment();
			$.ajax({
				type : "POST",
				url : "paymentTransaction",
				dataType : "json",
				data : {
					transactionPaymentData : JSON.stringify(input)
				}
			});
		}
		function getDataSaveTransactionPayment(){
			return {
				"ITEM_ID" : account.item ,
				"pocketslot_qty" : account.pocketSlot_qty ,
				"transactionID" : account.transactionID
			}
		}
		
		$(document).on('hide.bs.modal','#modalPayment_result', function () {
			window.location.href = "shop";
		});
	
});

