package com.example.apitest.vo;

import java.util.ArrayList;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CafeOrder {

	@SerializedName("orders")
	ArrayList<OrdersInfo> orders;
}
