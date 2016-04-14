package com.cardvalue.penguin.service.impl;

import com.cardvalue.penguin.dto.BaiduCoordinatorConvertResponseDTO;
import com.cardvalue.penguin.dto.Coordinator;
import com.cardvalue.penguin.service.BaiduMapService;
import com.cardvalue.penguin.util.Constants;
import com.cardvalue.penguin.util.HttpUtils;
import com.cardvalue.penguin.util.Result;
import org.apache.commons.lang.StringUtils;
import org.apache.http.client.methods.HttpGet;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BaiduMapServiceImpl implements BaiduMapService {

	private final static Logger logger = LoggerFactory.getLogger(BaiduMapServiceImpl.class);
	
	@Value(" ${baidu.map.coordinator.convert.url} ")
	private String coordinatorConvertUrl;

	@Override
	public Result<Map<String, Double>> convertCoordinators(Map<String, Double> coordinator) {
		List<Map<String, Double>> coordinatorList = new ArrayList<Map<String, Double>>();
		coordinatorList.add(coordinator);
		Result<List<Map<String, Double>>> result = convertCoordinators(coordinatorList);
		Result<Map<String, Double>> r = new Result<Map<String, Double>>();
		if(StringUtils.equals(result.getCode(), Constants.RESULT_CODE_SUCCESS)){
			r.setCode(Constants.RESULT_CODE_SUCCESS); 
			r.setPayload(result.getPayload().get(0));
		}else{
			r.setCode(Constants.RESULT_CODE_FAILED);
			r.setMessage(result.getMessage());
		}
		return r;
	}
	
	@Override
	public Result<List<Map<String, Double>>> convertCoordinators(List<Map<String, Double>> coordinatorList) {
		StringBuilder sb = new StringBuilder();
		for(Map<String, Double> coord : coordinatorList){
			sb.append(coord.get("x")).append(",").append(coord.get("y")).append(";");
		}
		String coords = sb.toString();
		coords = StringUtils.removeEnd(coords, ";");
		Map<String, String> map = new HashMap<String, String>();
		map.put("coords", coords);
		map.put("from", "1");
		map.put("to", "5");
		Result<List<Map<String, Double>>> result = new Result<List<Map<String, Double>>>();
		try{
			String responseBody = HttpUtils.executeHttpRequest(coordinatorConvertUrl, map, HttpGet.METHOD_NAME);
			ObjectMapper mapper = new ObjectMapper();
			BaiduCoordinatorConvertResponseDTO response = mapper.readValue(responseBody, BaiduCoordinatorConvertResponseDTO.class);
			if(response.getStatus() == 0){
				result.setCode(Constants.RESULT_CODE_SUCCESS);
				List<Map<String, Double>> coordList = new ArrayList<Map<String, Double>>();
				for(Coordinator coord : response.getResult()){
					Map<String, Double> m = new HashMap<String, Double>();
					m.put("x", Double.valueOf(coord.getX()));
					m.put("y", Double.valueOf(coord.getY()));
					coordList.add(m);
				}
				result.setPayload(coordList);
			}else{
				result.setCode(Constants.RESULT_CODE_FAILED);
				result.setMessage(String.valueOf(response.getStatus()));
			}
		}catch(Exception e){
			result.setCode(Constants.RESULT_CODE_FAILED);
			logger.error("Error occurs while convert baidu coordinators", e);
		}
		return result;
	}

}
