package com.example.apitest.vo;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Memo {
    @SerializedName("reg_date")
    private String regDate;
    @SerializedName("mod_date")
    private String modDate;
    @SerializedName("content")
    private String content;
    @SerializedName("type")
    private String type;
    @SerializedName("admin_id")
    private String adminId;
    @SerializedName("status")
    private String status;
}
