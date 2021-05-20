package com.example.apitest.vo;

import java.util.ArrayList;

import org.springframework.data.annotation.Id;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class MakeShopCustomer {
	@Id
	String return_code;

	String totalCount;

	String totalPage;

	String count;

	@SerializedName("list")
	ArrayList<CustomerDetail> list;
}
