package com.example.apitest.service;

import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.apitest.repository.admin.AdminRepository;
import com.example.apitest.repository.mall.MallRepository;
import com.example.apitest.vo.AdminMallInfo;
import com.example.apitest.vo.CafeCustomer;
import com.example.apitest.vo.CafeOrder;
import com.example.apitest.vo.MakeShopCustomer;
import com.example.apitest.vo.MallAuthInfo;
import com.example.apitest.vo.OrderData;
import com.example.apitest.vo.OrderReturn;
import com.example.apitest.vo.Product;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TestService {

    @Autowired
    private Gson gson;

    RestTemplate restTemplate = new RestTemplate();

    MakeShopCustomer makeshopcustomer;
    CafeCustomer cafecustomer;

    CafeOrder cafeorder = new CafeOrder();
    // jpa, mysql
    @Autowired
    @Resource(name = "adminRepository")
    private AdminRepository adminRepository;

    @Autowired
    @Resource(name = "mallRepository")
    private MallRepository mallRepository;

    @Autowired
    MongoService mongoservice;

    public List<AdminMallInfo> adminSearch(String mall_name) {

        try {
            List<AdminMallInfo> adminMallInfo = adminRepository.findByMall_name(mall_name);

            return adminMallInfo;
        } catch (Exception e) {
            mongoservice.msave("admin_mall_info_error", e.getMessage());
            return null;
        }
    }

    public MallAuthInfo authSearch(String mall_id) {
        try {
            MallAuthInfo mallAuthInfo = mallRepository.findByMallID(mall_id);

            return mallAuthInfo;
        } catch (Exception e) {
            mongoservice.msave("mall_auth_info_error", e.getMessage());
            return null;
        }
    }

    public String cafeCustomerSearch(Map<String, Object> orderReqMap) {

        try {

            String name = String.valueOf(orderReqMap.get("name"));
            String hosting_no = String.valueOf(orderReqMap.get("hosting_no"));
            String hosting_mall_id = String.valueOf(orderReqMap.get("hosting_mall_id"));
            String mall_id = String.valueOf(orderReqMap.get("mall_id"));
            String mall_no = String.valueOf(orderReqMap.get("mall_no"));
            String hosting_mall_no = String.valueOf(orderReqMap.get("hosting_mall_no"));
            String authorization = String.valueOf(orderReqMap.get("authorization"));

            restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));
            String url = "https://" + hosting_mall_id + ".cafe24api.com/api/v2/admin/customersprivacy?limit=10&shop_no=" + hosting_mall_no;

            HttpHeaders headers = new HttpHeaders();
            String access_token = "Bearer " + authorization;

            // log.info(access_token);
            headers.add("Authorization", access_token);

            final HttpEntity<String> entity = new HttpEntity(headers);

            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

            cafecustomer = gson.fromJson(response.getBody(), CafeCustomer.class);

            List<Map<String, Object>> listMap = new ArrayList<>();

            for (int i = 0; i < cafecustomer.getCustomersprivacy().size(); i++) {
                Map<String, Object> tempMap = new HashMap();
                if (cafecustomer.getCustomersprivacy().get(i).getCellphone().length() != 0) {
                    tempMap.put("cellphone", cafecustomer.getCustomersprivacy().get(i).getCellphone());
                    tempMap.put("hname", cafecustomer.getCustomersprivacy().get(i).getName());
                    tempMap.put("id", cafecustomer.getCustomersprivacy().get(i).getMember_id());
                    listMap.add(tempMap);
                }
            }
            String res = name + "  \n";
            int count = listMap.size();
            int cnt = 0;

            for (int i = 0; i < count; i++) {

                String url2 = "https://shopapi.lunasoft.co.kr/customer/info/" + hosting_mall_id + "?call_type=admin&hosting_mall_no="
                        + hosting_mall_no + "&hosting_no=" + hosting_no + "&mall_id=" + mall_id + "&mall_no=" + mall_no
                        + "&realtime_yn=y&search_text=" + listMap.get(i).get("cellphone") + "&search_type=phone&service_no=5&session_id=open-tester";

                ResponseEntity<String> response2 = restTemplate.exchange(url2, HttpMethod.GET, entity, String.class);

                if (response2.getBody().contains((String) listMap.get(i).get("id"))) {
                    res += (i + 1) + "번 일치 ";
                    cnt++;
                } else {
                    res += (i + 1) + "번 불일치 ";
                }

                res += listMap.get(i).get("cellphone") + " , " + listMap.get(i).get("hname") + " , "
                        + listMap.get(i).get("id") + "     " + response2.getBody() + "\n";
            }
            if (cnt == count) {
                log.info(name + " 회원정보 일치");
                return "회원정보 일치 \n" + res;
            } else {
                log.info(name + " 회원정보 불일치");
                return "회원정보 불일치 \n" + res;
            }

        } catch (Exception e) {
            mongoservice.msave("cafe24_customer_error", e.getMessage());
            return "cafe24 회원 정보 error";
        }
    }

    public String makeShopCustomerSearch(Map<String, Object> orderReqMap) {
        try {
            String name = String.valueOf(orderReqMap.get("name"));
            String hosting_no = String.valueOf(orderReqMap.get("hosting_no"));
            String hosting_mall_id = String.valueOf(orderReqMap.get("hosting_mall_id"));
            String mall_id = String.valueOf(orderReqMap.get("mall_id"));
            String mall_no = String.valueOf(orderReqMap.get("mall_no"));
            String hosting_mall_no = String.valueOf(orderReqMap.get("hosting_mall_no"));
            String hosting_url_addr = String.valueOf(orderReqMap.get("hosting_url_addr"));
            String license_key = String.valueOf(orderReqMap.get("license_key"));
            String api_key = String.valueOf(orderReqMap.get("api_key"));

            restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));
            String url = hosting_url_addr + "/list/open_api.html?mode=search&type=user&limit=10";
            HttpHeaders headers = new HttpHeaders();

            headers.add("licensekey", license_key);
            headers.add("shopkey", api_key);

            final HttpEntity<String> entity = new HttpEntity<String>(headers);

            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

            makeshopcustomer = gson.fromJson(response.getBody(), MakeShopCustomer.class);

            List<Map<String, Object>> listMap = new ArrayList<>();

            for (int i = 0; i < makeshopcustomer.getList().size(); i++) {
                Map<String, Object> tempMap = new HashMap();
                if (cafecustomer.getCustomersprivacy().get(i).getCellphone().length() == 0) {
                    continue;
                } else {
                    tempMap.put("mobile", makeshopcustomer.getList().get(i).getMobile());
                    tempMap.put("hname", makeshopcustomer.getList().get(i).getHname());
                    tempMap.put("id", makeshopcustomer.getList().get(i).getId());
                    listMap.add(tempMap);
                }

            }

            String res = name + "  \n";
            int cnt = 0;
            int count = listMap.size();

            for (int i = 0; i < listMap.size(); i++) {

                String url2 = "https://shopapi.lunasoft.co.kr/customer/info/" + hosting_mall_id + "?call_type=admin&hosting_mall_no="
                        + hosting_mall_no + "&hosting_no=" + hosting_no + "&mall_id=" + mall_id + "&mall_no=" + mall_no
                        + "&realtime_yn=y&search_text=" + listMap.get(i).get("mobile") + "&search_type=phone&service_no=5&session_id=open-tester";
                ResponseEntity<String> response2 = restTemplate.exchange(url2, HttpMethod.GET, entity, String.class);

                res += (i + 1) + "번 :";

                if (response2.getBody().contains((String) listMap.get(i).get("hname"))
                        && response2.getBody().contains((String) listMap.get(i).get("id"))) {
                    res += "일치 ";
                    cnt++;
                } else {
                    res += "불일치 ";
                }

                res += (String) listMap.get(i).get("mobile") + " ,  " + (String) listMap.get(i).get("hname") + " , "
                        + (String) listMap.get(i).get("id") + "     " + response2.getBody() + "\n";
            }

            if (cnt == count) {
                log.info(name + " 회원정보 일치");
                return "회원정보 일치 \n" + res;
            } else {
                log.info(name + " 회원정보 불일치");
                return "회원정보 불일치 \n" + res;
            }

        } catch (Exception e) {
            mongoservice.msave("makeshop_customer_error", e.getMessage());
            return "makeshop 회원 정보 error";
        }

    }

    public String makeShopOrderSearch(Map<String, Object> orderReqMap) {
        try {
            String name = String.valueOf(orderReqMap.get("name"));
            String hosting_no = String.valueOf(orderReqMap.get("hosting_no"));
            String hosting_mall_id = String.valueOf(orderReqMap.get("hosting_mall_id"));
            String mall_id = String.valueOf(orderReqMap.get("mall_id"));
            String mall_no = String.valueOf(orderReqMap.get("mall_no"));
            String hosting_mall_no = String.valueOf(orderReqMap.get("hosting_mall_no"));
            String hosting_url_addr = String.valueOf(orderReqMap.get("hosting_url_addr"));
            String license_key = String.valueOf(orderReqMap.get("license_key"));
            String api_key = String.valueOf(orderReqMap.get("api_key"));

            restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));

            OrderReturn orderReturn = new OrderReturn();

            SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
            Calendar cal = Calendar.getInstance();
            cal.add(cal.DATE, -1); // 하루 뺀다
            String yesterday = format1.format(cal.getTime());

            cal = Calendar.getInstance();
            cal.add(cal.MONTH, -1);
            cal.add(cal.DATE, +1);
            String a_month_ago = format1.format(cal.getTime());

//		log.info(yesterday);
//		log.info(a_month_ago);

            String url = hosting_url_addr + "/list/open_api.html?mode=search&type=order&limit=5&InquiryTimeFrom=" + a_month_ago
                    + " 00:00:00&InquiryTimeTo=" + yesterday + " 23:59:59";
            // log.info(url);
            HttpHeaders headers = new HttpHeaders();

            headers.add("licensekey", license_key);
            headers.add("shopkey", api_key);

            final HttpEntity<String> entity = new HttpEntity(headers);

            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

            // makeshoporder = gson.fromJson(response.getBody(), MakeShopOrder.class);
            JsonObject jsonObj = gson.fromJson(response.getBody(), JsonObject.class);

            orderReturn.setReturn_code(jsonObj.get("return_code").getAsString());

            if ("0000".equals(jsonObj.get("return_code").getAsString()) && jsonObj.get("totalCount") != null) {
                orderReturn.setTotalCount(jsonObj.get("totalCount").getAsInt());
                orderReturn.setTotalPage(jsonObj.get("totalPage").getAsInt());
                orderReturn.setCount(jsonObj.get("count").getAsInt());

                if (orderReturn.getCount() > 0) {
                    for (Map.Entry<String, JsonElement> orderDataKeySet : jsonObj.getAsJsonObject("list").entrySet()) {
                        JsonElement orderData = orderDataKeySet.getValue();

                        OrderData tempObj = gson.fromJson(orderData.toString(), OrderData.class);
                        List<Product> productList = new ArrayList<>();
                        for (Map.Entry<String, JsonElement> productKeySetProductKeySet : orderData.getAsJsonObject().get("product").getAsJsonObject()
                                .entrySet()) {
                            JsonElement product = productKeySetProductKeySet.getValue();
                            productList.add(gson.fromJson(product.toString(), Product.class));
                        } // for - end
                        tempObj.setProductList(productList);
                        orderReturn.getList().add(tempObj);
                    } // for - end
                } // if - end
            } // if - end

            String res = name + "  \n";

            int cnt = 0;
            int count = orderReturn.getList().size();

            for (int i = 0; i < orderReturn.getList().size(); i++) {

                String url2 = "https://shopapi.lunasoft.co.kr/gate/order/order_no/" + hosting_mall_id + "/" + mall_no + "/" + mall_id + "/"
                        + hosting_no + "?call_type=admin&hosting_mall_no=" + hosting_mall_no + "&order_no="
                        + orderReturn.getList().get(i).getOrder().getOrdernum() + "&service_no=5";
                ResponseEntity<String> response2 = restTemplate.exchange(url2, HttpMethod.GET, entity, String.class);

                if (response2.getBody().contains(orderReturn.getList().get(i).getOrder().getOrdernum())
                        && response2.getBody().contains(orderReturn.getList().get(i).getOrder().getSender())) {
                    res += (i + 1) + "번 : 일치 ";
                    cnt++;
                } else {
                    res += (i + 1) + "번 : 불일치 ";
                }

                res += orderReturn.getList().get(i).getOrder().getOrdernum() + " " + orderReturn.getList().get(i).getOrder().getSender() + "\n";
                res += response2.getBody() + "\n";
            }

            if (cnt == count) {
                //log.info(name + "  " + res);
                return "주문정보 일치 \n" + res;
            } else {
                //log.info(name + "  " + res);
                return "주문정보 불일치  \n" + res;
            }

        } catch (Exception e) {
            mongoservice.msave("makeshop_order_error", e.getMessage());
            return "makeshop 주문 정보 error";
        }
    }

    public String cafeOrderSearch(Map<String, Object> orderReqMap) {
        try {
            String name = String.valueOf(orderReqMap.get("name"));
            String hosting_no = String.valueOf(orderReqMap.get("hosting_no"));
            String hosting_mall_id = String.valueOf(orderReqMap.get("hosting_mall_id"));
            String mall_id = String.valueOf(orderReqMap.get("mall_id"));
            String mall_no = String.valueOf(orderReqMap.get("mall_no"));
            String hosting_mall_no = String.valueOf(orderReqMap.get("hosting_mall_no"));
            String authorization = String.valueOf(orderReqMap.get("authorization"));

            restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));

            SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
            Calendar cal = Calendar.getInstance();
            cal.add(cal.DATE, -1); // 하루 뺀다
            String yesterday = format1.format(cal.getTime());

            cal = Calendar.getInstance();
            cal.add(cal.MONTH, -1);
            cal.add(cal.DATE, +1);
            String a_month_ago = format1.format(cal.getTime());

            // log.info(yesterday);
            // log.info(a_month_ago);

            String url = "https://" + hosting_mall_id + ".cafe24api.com/api/v2/admin/orders?shop_no=" + hosting_mall_no
                    + "&embed=items,receivers,buyer,return,cancellation,exchange&date_type=order_date&limit=5&start_date=" + a_month_ago
                    + "&end_date=" + yesterday;

            HttpHeaders headers = new HttpHeaders();
            String access_token = "Bearer " + authorization;

            // log.info(access_token);
            headers.add("Authorization", access_token);

            final HttpEntity<String> entity = new HttpEntity<String>(headers);

            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

            // log.info(response.getBody());
            cafeorder = gson.fromJson(response.getBody(), CafeOrder.class);

            List<Map<String, Object>> listMap = new ArrayList<>();

            for (int i = 0; i < cafeorder.getOrders().size(); i++) {
                Map<String, Object> tempMap = new HashMap<String, Object>();
                tempMap.put("id", cafeorder.getOrders().get(i).getOrder_id());
                tempMap.put("bname", cafeorder.getOrders().get(i).getBuyer_name());

                listMap.add(tempMap);
            }

            String res = name + "  \n";
            int count = listMap.size();
            int cnt = 0;

            for (int i = 0; i < listMap.size(); i++) {

                String url2 = "https://shopapi.lunasoft.co.kr/gate/order/order_no/" + hosting_mall_id + "/" + mall_no + "/" + mall_id + "/"
                        + hosting_no + "?call_type=admin&hosting_mall_no=" + hosting_mall_no + "&order_no=" + listMap.get(i).get("id")
                        + "&service_no=5";
                ResponseEntity<String> response2 = restTemplate.exchange(url2, HttpMethod.GET, entity, String.class);

                res += (i + 1) + "번 :";

                if (response2.getBody().contains((String) listMap.get(i).get("id"))) {
                    res += "일치";
                    cnt++;
                } else {
                    res += "불일치";
                }

                res += (String) listMap.get(i).get("id") + ", " + (String) listMap.get(i).get("bname") + " " + response2.getBody() + "\n";
            }

            if (cnt == count) {
                log.info(name + " 주문정보 일치 ");
                return "주문정보 일치 \n" + res;
            } else {
                log.info(name + " 주문정보 불일치 ");
                return "주문정보 불일치  \n" + res;
            }

        } catch (Exception e) {
            mongoservice.msave("cafe24_order_error", e.getMessage());
            return "cafe24 주문 정보 error";
        }
    }

    // 기간동안 상품수 조회 ///////
    public String productCount(String mall_id, String hosting_mall_id, String access_token) {
        try {
            String result = "";
            String[] Start_date = {"2019-01-01", "2020-01-01", "2021-01-01"};
            String[] End_date = {"2019-12-31", "2020-12-31", "2021-12-31"};

            HttpHeaders headers = new HttpHeaders();

            String token = "Bearer " + access_token;

            headers.add("Authorization", token);

            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

            String curdate = formatter.format(date);

            log.info(curdate);

            restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));

            for (int i = 0; i < Start_date.length; i++) {

                String url = "https://" + hosting_mall_id + ".cafe24api.com/api/v2/admin/products/count?shop_no=1&created_start_date=" + Start_date[i]
                        + "&created_end_date=" + End_date[i];

//                      log.info(url);

                final HttpEntity<String> entity = new HttpEntity(headers);

                ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

                result += Start_date[i].split("-")[0] + "년도 : " + response.getBody() + "\n";

            }
            List<String> list = mallRepository.findByRegdate(mall_id, curdate);
            result += "mall_id : " + list.get(0).split(",")[0] + "\n";
            for (int i = 0; i < list.size(); i++) {
                result += "reg_date : " + list.get(i).split(",")[2] + "\t";
                result += "count : " + list.get(i).split(",")[1] + "\n";
            }

            return result;
        } catch (Exception e) {
            mongoservice.msave("mall_has_no_product", e.getMessage());
            log.info(e.getMessage());
            return "해당 업체에 적재된 상품이 없습니다.";
        }
    }

}
