package com.workshops.fightmode;

import java.util.List;

public interface PaoYingShupIntf {
	public PaoYingShupType takeAction(List<PaoYingShupType> actionHist);
	public String getEngineName();
	
}
