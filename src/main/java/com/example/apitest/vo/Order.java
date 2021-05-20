package com.example.apitest.vo;

import com.google.gson.*;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.lang.reflect.Type;
import java.util.List;

@Getter
@Setter
@ToString
public class Order implements JsonDeserializer {

    @SerializedName("ordernum")
    private String ordernum;
    @SerializedName("order_date")
    private String orderDate;
    @SerializedName("is_member")
    private String isMember;
    @SerializedName("start_price")
    private int startPrice;
    @SerializedName("pay_price")
    private int payPrice;
    @SerializedName("deli_price")
    private int deliPrice;
    @SerializedName("order_status")
    private String orderStatus;
    @SerializedName("repay_price")
    private int repayPrice;
    @SerializedName("sender")
    private String sender;
    @SerializedName("phone")
    private String phone;
    @SerializedName("mobile")
    private String mobile;
    @SerializedName("email")
    private String email;
    @SerializedName("pay_path")
    private String payPath;
    @SerializedName("memo")
    private List<Memo> memoList;
    @SerializedName("link_id")
    private String linkId;
    @SerializedName("link_url")
    private String linkUrl;
    @SerializedName("id")
    private String id;
    @SerializedName("mem_type")
    private String memType;
    @SerializedName("used_emoney")
    private int usedEmoney;
    @SerializedName("used_reserve")
    private int usedReserve;
    @SerializedName("group_name")
    private String groupName;
    @SerializedName("add_info")
    private Object addInfo;
    @SerializedName("total_product_price")
    private int totalProductPrice;
    @SerializedName("reserve")
    private String reserve;
    @SerializedName("basket_count")
    private int basketCount;

    @Override
    public Order deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {

        Order order = new Order();

        JsonObject json = jsonElement.getAsJsonObject();
        order.setTotalProductPrice(json.get("total_product_price").getAsInt());
        order.setStartPrice(json.get("start_price").getAsInt());
        order.setPayPrice(json.get("deli_price").getAsInt());
        order.setRepayPrice(json.get("repay_price").getAsInt());
        order.setBasketCount(json.get("basket_count").getAsInt());
        order.setUsedEmoney(json.get("used_emoney").getAsInt());
        order.setUsedReserve(json.get("used_reserve").getAsInt());

        return order;
    }
}
