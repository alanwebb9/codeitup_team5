package com.codeitup_team5.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codeitup_team5.dao.HealthDataMapper;
import com.codeitup_team5.pojo.HealthData;

@Service("HealthServices")
@Transactional
public class HealthServicesImpl implements HealthServices {
	@Autowired
    HealthDataMapper healthDataMapper;
	@Override
	public List<HealthData> viewalldata(HealthData record) {
		
		return healthDataMapper.selectAllView(record);
	}

	
}
