package com.example.apitest.vo;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShippingFeeDetail {
	String shipping_group_code;
	String supplier_code;
	String shipping_fee;
	String cancel_shipping_fee;
	String additional_shipping_fee;
	String refunded_shipping_fee;
	String return_shpping_fee;
	ArrayList<String> items;
}
