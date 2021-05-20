package com.example.apitest.vo;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrdersInfo {

	String shop_no;
	String currency;
	String order_id;
	String market_id;
	String market_order_info;
	String buyer_name;
	String buyer_email;
	String buyer_phone;
	String buyer_cellphone;
	String member_id;
	String member_email;
	String member_authentication;
	String billing_name;
	String bank_code;
	String bank_code_name;
	ArrayList<String> payment_method;
	ArrayList<String> payment_method_name;
	String payment_gateway_name;
	String sub_payment_method_name;
	String sub_payment_method_code;
	String paid;
	String order_date;
	String first_order;
	String payment_date;
	String order_from_mobile;
	String order_price_amount;
	String use_escrow;
	String group_no_when_ordering;

	InitialOrderAmount initial_order_amount;
	ActualOrderAmount actual_order_amount;

	String membership_discount_amount;
	String coupon_discount_price;
	String shipping_fee_discount_amount;
	String app_discount_amount;
	String actual_payment_amount;
	String points_spent_amount;
	String final_points_spent_amount;
	String credits_spent_amount;
	String bank_account_no;
	String bank_account_owner_name;
	String market_customer_id;
	String market_seller_id;
	String initial_payment_amount;
	String payment_amount;
	String cancel_date;
	String order_place_name;
	String order_place_id;
	String payment_confirmation;
	String postpay_commission;
	String commission;
	String postpay;
	String admin_additional_amount;
	String shipping_fee;
	String final_shipping_fee;
	String additional_shipping_fee;
	String international_shipping_insurance;
	String additional_handling_fee;
	String shipping_type;
	String shipping_type_text;
	String shipping_status;
	String wished_delivery_date;
	String wished_delivery_time;
	String wished_carrier_id;
	String wished_carrier_name;
	String return_confirmed_date;
	String total_supply_price;
	String naver_point;
	ArrayList<AdditionalOrderInfoList> additional_order_info_list;
	String store_pickup;
	String easypay_name;
	String loan_status;
	String receiver_id_card_no;
	String shipping_message;
	String subscription;

	ArrayList<Items> items;
	ArrayList<Receivers> receivers;

	Buyer buyser;
	ArrayList<ShippingFeeDetail> shipping_fee_detail;

	ArrayList<RegionalSurchargeDetail> regional_surcharge_detail;
	@JsonProperty(value = "return")
	ArrayList<Return> rReturn;

	ArrayList<Cancellation> cancellation;

	@JsonProperty(value = "exchange")
	ArrayList<Exchange> exchange;

	String multiple_addresses;
	String exchange_rate;
	String first_payment_method;
	String naverpay_payment_information;
}
