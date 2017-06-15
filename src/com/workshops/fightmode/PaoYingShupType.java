package com.workshops.fightmode;


public enum PaoYingShupType {
	HAMMER("Hammer"),
	SCISSORS("Scissors"),
	PAPER("Paper");
	
	String value;
	PaoYingShupType(String v){
		value = v;
	}
	
	public String getValue(){
		return value;
	}

	@Override
	public String toString() {
		return value;
	}
	
	public int checkResult(PaoYingShupType pType){
		switch(this){
		case HAMMER:
				if(pType == HAMMER) return 0;
				if(pType == SCISSORS) return 1;
				return -1;
		case SCISSORS:
			if(pType == HAMMER) return -1;
			if(pType == SCISSORS) return 0;
			return 1;
		default:
			if(pType == HAMMER) return 1;
			if(pType == SCISSORS) return -1;
			return 0;
		}
	} 
	
}
