package com.example.apitest.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.apitest.service.TestService;
import com.example.apitest.vo.AdminMallInfo;
import com.example.apitest.vo.MallAuthInfo;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/search")
@Slf4j
public class TestController {

	@Autowired
	TestService testservice;

	@RequestMapping(method = RequestMethod.GET, value = "/{name}")
	public String searchCustomer(@PathVariable("name") String name) {
		String result = "";
		String result2 = "";

		Map<String, Object> orderReqMap = new HashMap();

		List<AdminMallInfo> list = testservice.adminSearch(name);
		if (list.size() == 0) {
			return "해당 업체가 없습니다.";
		}
		AdminMallInfo ami = list.get(0);
		String mall_no = ami.getMall_no();
		String mall_id = ami.getMall_id();
		String hosting_no = ami.getHosting_no();

		if (hosting_no.equals("1")) {
			MallAuthInfo mai = testservice.authSearch(mall_id);

			String hosting_mall_no = mai.getHosting_mall_no();
			String hosting_url_addr = mai.getHosting_url_addr();
			String service_no = mai.getService_no();
			String authorization = mai.getAccess_token();
			String hosting_mall_id = mai.getHosting_mall_id();

			orderReqMap.put("name", name);
			orderReqMap.put("mall_no", mall_no);
			orderReqMap.put("mall_id", mall_id);
			orderReqMap.put("hosting_no", hosting_no);
			orderReqMap.put("hosting_mall_no", hosting_mall_no);
			orderReqMap.put("hosting_url_addr", hosting_url_addr);
			orderReqMap.put("service_no", service_no);
			orderReqMap.put("authorization", authorization);
			orderReqMap.put("hosting_mall_id", hosting_mall_id);

			result = testservice.cafeCustomerSearch(orderReqMap);

			result2 = testservice.cafeOrderSearch(orderReqMap);

		} else if (hosting_no.equals("2")) {
			// 메이크샵
			MallAuthInfo mai = testservice.authSearch(mall_id);

			String hosting_mall_no = mai.getHosting_mall_no();
			String hosting_url_addr = mai.getHosting_url_addr();
			String service_no = mai.getService_no();
			String license_key = mai.getLicense_key();
			String api_key = mai.getApi_key();
			String hosting_mall_id = mai.getHosting_mall_id();

			orderReqMap.put("name", name);
			orderReqMap.put("mall_no", mall_no);
			orderReqMap.put("mall_id", mall_id);
			orderReqMap.put("hosting_no", hosting_no);
			orderReqMap.put("hosting_mall_no", hosting_mall_no);
			orderReqMap.put("hosting_url_addr", hosting_url_addr);
			orderReqMap.put("service_no", service_no);
			orderReqMap.put("license_key", license_key);
			orderReqMap.put("api_key", api_key);
			orderReqMap.put("hosting_mall_id", hosting_mall_id);

			result = testservice.makeShopCustomerSearch(orderReqMap);

			result2 = testservice.makeShopOrderSearch(orderReqMap);

		} else {
			return "잘못된 호스팅 입니다";
		}
		log.info(name + " : 호스팅 성공   ");
		return "\n회원 ======================================================\n" + result
				+ "\n주문 =====================================================\n" + result2;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/count/{mallid}")
	public String cafe24ProductCount(@PathVariable("mallid") String mall_id) {
		log.info(mall_id);
		MallAuthInfo mai = testservice.authSearch(mall_id);

		if (mai == null) {
			return "해당 mall_id를 가진 업체가 없습니다.";
		} else {
			String hosting_mall_id = mai.getHosting_mall_id();
			String access_token = mai.getAccess_token();
			return testservice.productCount(mall_id, hosting_mall_id, access_token);
		}

	}

}
