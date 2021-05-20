package com.example.apitest.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "tb_mall_info") // 실제 db의 테이블과 매칭될 클래스임을 명시한다.
public class AdminMallInfo {
	@Id
	@Column(name = "mall_no")
	String mall_no;

	@Column(name = "mall_id")
	String mall_id;

	@Column(name = "member_id")
	String member_id;

	@Column(name = "member_mall_no")
	String member_mall_no;

	@Column(name = "mall_name")
	String mall_name;

	@Column(name = "mall_stat_code")
	String mall_stat_code;

	@Column(name = "mall_url_addr")
	String mall_url_addr;

	@Column(name = "mall_mobile_url_addr")
	String mall_mobile_url_addr;

	@Column(name = "hosting_no")
	String hosting_no;

	@Column(name = "hosting_url_addr")
	String hosting_url_addr;

	@Column(name = "hosting_mall_no")
	String hosting_mall_no;

	@Column(name = "hosting_mall_id")
	String hosting_mall_id;

	@Column(name = "hosting_mall_sub_id")
	String hosting_mall_sub_id;

	@Column(name = "hosting_mall_pw")
	String hosting_mall_pw;

	@Column(name = "hosting_mall_sub_yn")
	String hosting_mall_sub_yn;

	@Column(name = "hosting_mall_id_sub_yn")
	String hosting_mall_id_sub_yn;

	@Column(name = "hosting_api_auth_yn")
	String hosting_api_auth_yn;

	@Column(name = "hosting_api_use_yn")
	String hosting_api_use_yn;

	@Column(name = "inventory_company_code")
	String inventory_company_code;

	@Column(name = "inventory_company_url_addr")
	String inventory_company_url_addr;

	@Column(name = "yellow_id")
	String yellow_id;

	@Column(name = "plus_mobile_yn")
	String plus_mobile_yn;

	@Column(name = "test_yn")
	String test_yn;

	@Column(name = "create_date")
	String create_date;

	@Column(name = "create_user_code")
	String create_user_code;

	@Column(name = "update_date")
	String update_date;

	@Column(name = "update_user_code")
	String update_user_code;

	@Column(name = "update_user_no")
	String update_user_no;

}
