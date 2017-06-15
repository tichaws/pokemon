package com.workshops.fightmode;
import java.util.List;
import java.util.Random;

import com.workshops.fightmode.PaoYingShupIntf;
import com.workshops.fightmode.PaoYingShupType;

public class PaoYingShupR {

	Random rand = new Random();
	

	public PaoYingShupType takeAction() {
		int i = rand.nextInt(3);
		PaoYingShupType a;
		switch (i) {
		case 0:
			a = PaoYingShupType.HAMMER;
			break;
		case 1:
			a = PaoYingShupType.SCISSORS;
			break;
		default:
			a = PaoYingShupType.PAPER;
		}
		return a;
	}


}
