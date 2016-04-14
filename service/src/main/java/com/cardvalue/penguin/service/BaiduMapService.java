package com.cardvalue.penguin.service;

import com.cardvalue.penguin.util.Result;

import java.util.List;
import java.util.Map;

public interface BaiduMapService {

	Result<List<Map<String, Double>>> convertCoordinators(List<Map<String, Double>> coordinatorList);

	Result<Map<String, Double>> convertCoordinators(Map<String, Double> coordinator);
	
}
