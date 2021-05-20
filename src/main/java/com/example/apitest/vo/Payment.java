package com.example.apitest.vo;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Payment {

    @SerializedName("paymethod")
    private String paymethod;
    @SerializedName("pay_date")
    private String payDate;
    @SerializedName("card_state")
    private String cardState;
    @SerializedName("pay_status")
    private String payStatus;
    @SerializedName("card_flag")
    private String cardFlag;
    @SerializedName("card_partcancel_code")
    private String cardPartcancelCode;
    @SerializedName("in_card_price")
    private String inCardPrice;
    @SerializedName("banker")
    private String banker;
    @SerializedName("bank_account")
    private String bankAccount;
    @SerializedName("bank_name")
    private String bankName;

}
