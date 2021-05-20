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
public class Product implements JsonDeserializer {

    @SerializedName("num")
    private int num;
    @SerializedName("delivery_num")
    private String deliveryNum;
    @SerializedName("brandcode")
    private String brandcode;
    @SerializedName("product_uid")
    private int productUid;
    @SerializedName("prd_option_uid")
    private String prdOptionUid;
    @SerializedName("product_name")
    private String productName;
    @SerializedName("product_cate1")
    private String productCate1;
    @SerializedName("basket_status")
    private String basketStatus;
    @SerializedName("issue_status")
    private String issueStatus;
    @SerializedName("basket_stock")
    private int basketStock;
    @SerializedName("sell_price")
    private int sellPrice;
    @SerializedName("product_price")
    private int productPrice;
    @SerializedName("product_buyprice")
    private String productBuyprice;
    @SerializedName("product_reserve")
    private String productReserve;
    @SerializedName("option_price")
    private int optionPrice;
    @SerializedName("option_type")
    private String optionType;
    @SerializedName("option_data")
    private String optionData;
    @SerializedName("api_option_data")
    private String apiOptionData;
    @SerializedName("plus_price")
    private String plusPrice;
    @SerializedName("plus_reserve")
    private String plusReserve;
    @SerializedName("reserve_chk")
    private String reserveChk;
    @SerializedName("cancelend_date")
    private String cancelendDate;
    @SerializedName("tradeend_date")
    private String tradeendDate;
    @SerializedName("stock_key")
    private String stockKey;
    @SerializedName("free_deli")
    private String freeDeli;
    @SerializedName("vat")
    private String vat;
    @SerializedName("trade_num")
    private Integer tradeNum;
    @SerializedName("product_images")
    private ProductImages productImages;
    @SerializedName("deliveryInfo")
    private DeliveryInfo deliveryInfo;

    @Override
    public Product deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        Product product = new Product();

        JsonObject json = jsonElement.getAsJsonObject();
        product.setNum(json.get("num").getAsInt());
        product.setProductUid(json.get("product_uid").getAsInt());
        product.setProductPrice(json.get("product_price").getAsInt());
        product.setSellPrice(json.get("sell_price").getAsInt());
        product.setOptionPrice(json.get("option_price").getAsInt());
        product.setBasketStock(json.get("basket_stock").getAsInt());
        product.setTradeNum(json.get("trade_num").getAsInt());

        return product;
    }
}
