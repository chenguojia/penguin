package com.cardvalue.penguin.repository;

import com.cardvalue.penguin.model.ApplyProcess;


public interface ApplyProcessRepositoryCustom {
	public ApplyProcess findByProcessTypeAndStepNum(int processType, int stepNum);
}
