package com.example.apitest.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Buyer {
	String shop_no;
	String member_id;
	String member_group_no;
	String name;
	String names_furigana;
	String email;
	String phone;
	String cellphone;
	String customer_notification;
	String updated_date;
	String user_id;
	String user_name;
}
