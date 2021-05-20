package com.example.apitest.vo;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.lang.reflect.Type;

@Getter
@Setter
@ToString
public class DeliveryInfo implements JsonDeserializer {
    @SerializedName("post")
    private String post;
    @SerializedName("address")
    private String address;
    @SerializedName("address2")
    private String address2;
    @SerializedName("deli_price")
    private int deliPrice;
    @SerializedName("add_deli_price")
    private int addDeliPrice;
    @SerializedName("receiver")
    private String receiver;
    @SerializedName("receiver_mobile")
    private String receiverMobile;
    @SerializedName("receiver_phone")
    private String receiverPhone;
    @SerializedName("deli_type")
    private String deliType;
    @SerializedName("delinum")
    private String delinum;
    @SerializedName("delicom")
    private String delicom;
    @SerializedName("delicom_name")
    private String delicomName;
    @SerializedName("delinum_date")
    private String delinumDate;
    @SerializedName("deli_date")
    private String deliDate;
    @SerializedName("delicomplete_date")
    private String delicompleteDate;
    @SerializedName("deliend_date")
    private String deliendDate;
    @SerializedName("deli_msg")
    private String deliMsg;

    @Override
    public DeliveryInfo deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {

        DeliveryInfo deliveryInfo = new DeliveryInfo();
        deliveryInfo.setDeliPrice(jsonElement.getAsJsonObject().get("deli_price").getAsInt());
        deliveryInfo.setAddDeliPrice(jsonElement.getAsJsonObject().get("add_deli_price").getAsInt());

        return deliveryInfo;
    }
}
