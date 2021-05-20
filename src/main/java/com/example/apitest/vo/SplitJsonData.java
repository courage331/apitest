//package com.example.apitest.vo;
//
//import kr.co.lunasoft.orderapi.vo.common.ApiProcResult;
//import kr.co.lunasoft.orderapi.vo.common.auth.AuthInfo;
//import lombok.*;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@Getter
//@Setter
//@ToString
//@NoArgsConstructor
//public class SplitJsonData {
//
//    private String newOrderYn;
//    private ApiProcResult apiResult;
//    private AuthInfo authInfo;
//    private OrderReturn orderReturn;
//    private OrderData orderData;
//    private int mallNo;
//    private Map<String, Object> paramMap;
//    private String url;
//    private String sessionId;
//    
//    @Builder
//    public SplitJsonData(ApiProcResult apiResult, AuthInfo authInfo, OrderData orderData, int mallNo, Map<String, Object> paramMap,
//                         String newOrderYn, String url, String sessionId) {
//        
//        this.apiResult = apiResult;
//        this.authInfo = authInfo;
//        this.mallNo = mallNo;
//        this.newOrderYn = newOrderYn;
//        this.url = url;
//        this.sessionId = sessionId;
//        this.orderData = orderData;
//
//        Map<String, Object> tempMap = new HashMap<>();
//        tempMap.putAll(paramMap);
//        tempMap.put("page", 1);
//        this.paramMap = tempMap;
//
//        List<OrderData> tempOrderDataList = new ArrayList<>();
//        tempOrderDataList.add(orderData);
//
//        OrderReturn tempOrderReturn = new OrderReturn();
//        tempOrderReturn.setCount(tempOrderDataList.size());
//        tempOrderReturn.setList(tempOrderDataList);
//        tempOrderReturn.setReturn_code("0000");
//        tempOrderReturn.setTotalCount(orderData.getProductList().size());
//        tempOrderReturn.setTotalPage(1);
//        this.orderReturn = tempOrderReturn;
//    }
//
//
//}
