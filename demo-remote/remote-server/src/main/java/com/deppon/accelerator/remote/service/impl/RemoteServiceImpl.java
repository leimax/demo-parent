package com.deppon.accelerator.remote.service.impl;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.deppon.accelerator.remote.service.RemoteService;
import com.google.common.collect.Maps;

@Service("remoteService")
public class RemoteServiceImpl implements RemoteService {

	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Override
	public Map<String, Object> getInfoMap() {
		logger.info("=====服务端调用开始=====");
		Map<String, Object> infoMap = Maps.newHashMap();
		infoMap.put("a", "对应a的value");
		infoMap.put("b", "对应b的value");
		logger.info("=====服务端调用结束=====");
		return infoMap;
	}

}
