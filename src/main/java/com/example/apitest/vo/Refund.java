package com.example.apitest.vo;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Refund {
    @SerializedName("basket_num")
    private String basketNum;
    @SerializedName("refund_status")
    private String refundStatus;
    @SerializedName("refund_type")
    private String refundType;
    @SerializedName("refund_status_date")
    private String refundStatusDate;
    @SerializedName("refund_bankname")
    private String refundBankname;
    @SerializedName("refund_accounter")
    private String refundAccounter;
    @SerializedName("refund_account")
    private String refundAccount;

    @SerializedName("return_deli_price")
    private int returnDeliPrice;
    @SerializedName("refund_used_emoney")
    private int refundUsedEmoney;
    @SerializedName("refund_used_reserve")
    private int refundUsedReserve;
    @SerializedName("refund_emoney")
    private int refundEmoney;
    @SerializedName("refund_reserve")
    private int refundReserve;
    @SerializedName("refund_total_price")
    private int refundTotalPrice;
    @SerializedName("refund_price")
    private int refundPrice;
    @SerializedName("refund_method")
    private String refundMethod;
    @SerializedName("refund_reason")
    private String refundReason;

}
