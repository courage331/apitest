package com.example.apitest.vo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;

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
public class MakeShopOrder {
	@Id
	String return_code;

	String totalCount;

	String totalPage;

	String count;

	private List<OrderData> list = new ArrayList<>();
//	@SerializedName("list")
//	ArrayList<OrderDetail> list;
}
