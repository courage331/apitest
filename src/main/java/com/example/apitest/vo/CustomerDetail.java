package com.example.apitest.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDetail {
	String id;
	String hname;
	String mem_type;
	String simple_type;
	String grade;
	String email;
	String mobile;
	String reserve;
	String email_receive;
	String sms_receive;
	String login_date;
	String reg_date;
	String birth_day;
	String birth_day_year;
	String lifetime;
	String group_id;
	String group_name;
	String push_receive;
	String point;
	String emoney;
	String is_app_use;
	String extension_period;
	String order_count;
}
