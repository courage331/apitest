package com.example.apitest.vo;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Document(collection = "apitest1")
public class ErrorCode {
	String code;
	String content;
}
