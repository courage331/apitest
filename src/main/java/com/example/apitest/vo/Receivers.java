package com.example.apitest.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Receivers {
	String shop_no;
	String name;
	String name_furiganaString;
	String phone;
	String cellphone;
	String virtual_phone_no;
	String zipcode;
	String address1;
	String address2;
	String address_state;
	String address_city;
	String address_street;
	String address_full;
	String name_en;
	String city_en;
	String state_en;
	String street_en;
	String country_code;
	String country_name;
	String country_name_en;
	String shipping_message;
	String clearance_information_type;
	String clearance_information;
	String wished_delivery_date;
	String wished_delivery_time;
	String shipping_code;
}
