package com.example.apitest.service;

import javax.annotation.Resource;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.example.apitest.vo.ErrorCode;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MongoService {

	@Resource
	MongoTemplate mongoTemplate;

	// mongodb 저장
	public void msave(String code, String content) {
		ErrorCode errcode = new ErrorCode();
		errcode.setCode(code);
		errcode.setContent(content);
		mongoTemplate.insert(errcode);
		log.info("{}:{}", code, content);
	}

}
