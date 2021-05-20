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
public class Extension implements JsonDeserializer {

    @SerializedName("basket_num")
    private int basketNum;
    @SerializedName("ext_type")
    private String extType;
    @SerializedName("ext_type_txt")
    private String extTypeTxt;
    @SerializedName("ext_title")
    private String extTitle;
    @SerializedName("ext_price")
    private int extPrice;
    @SerializedName("ext_reserve")
    private int extReserve;
    @SerializedName("ext_status")
    private String extStatus;
    @SerializedName("couponnum")
    private String couponnum;

    @Override
    public Extension deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {

        Extension extension = new Extension();
        JsonObject json = jsonElement.getAsJsonObject();

        extension.setBasketNum(json.get("bastket_num").getAsInt());
        extension.setExtPrice(json.get("ext_price").getAsInt());

        return extension;
    }
}
