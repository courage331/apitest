package com.example.apitest.vo;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductImages {

    @SerializedName("maximage")
    private String maximage;
    @SerializedName("minimage")
    private String minimage;
    @SerializedName("tinyimage")
    private String tinyimage;
}
