package com.example.apitest.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActualOrderAmount {

	String order_price_amount;
	String shipping_fee;
	String points_spent_amount;
	String credits_spent_amount;
	String coupon_discount_price;
	String membership_discount_amount;
	String shipping_fee_discount_amount;
	String app_discount_amount;
	String point_incentive_amount;
	String total_amount_due;
	String payment_amount;
}
