package com.example.apitest.vo;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class OrderData {

    private Order order;
    private Payment payment;
    private List<Product> productList;
    private List<Refund> refund;
    private List<Extension> extension;
    @SerializedName("return")
    private List<Return> returnList;
    @SerializedName("pay_history")
    private List<PayHistory> payHistoryList;
}
