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
public class Return implements JsonDeserializer {
    @SerializedName("basket_num")
    private int basketNum;
    @SerializedName("reason")
    private String reason;
    @SerializedName("request_date")
    private String requestDate;
    @SerializedName("completed_date")
    private String completedDate;

    @Override
    public Return deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        
        Return returnData = new Return();
        returnData.setBasketNum(jsonElement.getAsJsonObject().get("basket_num").getAsInt());
        return returnData;
    }
}
