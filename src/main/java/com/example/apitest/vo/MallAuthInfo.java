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
@Table(name = "tb_api_auth_info") // 실제 db의 테이블과 매칭될 클래스임을 명시한다.
public class MallAuthInfo {

	@Id
	@Column(name = "auth_no")
	String auth_no;

	@Column(name = "member_id")
	String member_id;

	@Column(name = "mall_id")
	String mall_id;

	@Column(name = "hosting_no")
	String hosting_no;

	@Column(name = "hosting_mall_no")
	String hosting_mall_no;

	@Column(name = "hosting_mall_id")
	String hosting_mall_id;

	@Column(name = "hosting_url_addr")
	String hosting_url_addr;

	@Column(name = "service_no")
	String service_no;

	@Column(name = "license_key")
	String license_key;

	@Column(name = "api_key")
	String api_key;

	@Column(name = "client_id")
	String client_id;

	@Column(name = "client_secret_key")
	String client_secret_key;

	@Column(name = "auth_stat_text")
	String auth_stat_text;

	@Column(name = "auth_scope_text")
	String auth_scope_text;

	@Column(name = "access_token")
	String access_token;

	@Column(name = "expires_date")
	String expires_date;

	@Column(name = "refresh_token")
	String refresh_token;

	@Column(name = "refresh_token_expires_date")
	String refresh_token_expires_date;

	@Column(name = "issued_date")
	String issued_date;

	@Column(name = "error_code")
	String error_code;

	@Column(name = "error_text")
	String error_text;

	@Column(name = "create_date")
	String create_date;

}
