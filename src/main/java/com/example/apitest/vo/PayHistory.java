package com.example.apitest.vo;

import com.google.gson.*;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.lang.reflect.Type;

@Getter
@Setter
@ToString
public class PayHistory implements JsonDeserializer {

    @SerializedName("pay_date")
    private String payDate;
    @SerializedName("pay_type")
    private String payType;
    @SerializedName("total_price")
    private int totalPrice;
    @SerializedName("discount_price")
    private int discountPrice;
    @SerializedName("add_price")
    private int addPrice;
    @SerializedName("order_price")
    private int orderPrice;
    @SerializedName("pay_price")
    private int payPrice;
    @SerializedName("used_reserve")
    private int usedReserve;
    @SerializedName("used_emoney")
    private int usedEmoney;
    private String paymethod;
    private String memo;

    @Override
    public PayHistory deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        
        PayHistory payHistory = new PayHistory();
        JsonObject jsonObject = jsonElement.getAsJsonObject();

        payHistory.setTotalPrice(jsonObject.get("total_price").getAsInt());
        payHistory.setDiscountPrice(jsonObject.get("discount_price").getAsInt());
        payHistory.setAddPrice(jsonObject.get("add_price").getAsInt());
        payHistory.setOrderPrice(jsonObject.get("order_price").getAsInt());
        payHistory.setPayPrice(jsonObject.get("pay_price").getAsInt());
        payHistory.setUsedReserve(jsonObject.get("used_reserve").getAsInt());
        payHistory.setUsedEmoney(jsonObject.get("used_emoney").getAsInt());
     
        return payHistory;
    }
}
