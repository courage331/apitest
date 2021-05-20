package com.example.apitest.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class OrderReturn {
    private String return_code;
    private int totalCount;
    private int totalPage;
    private int count;
    private List<OrderData> list = new ArrayList<>();
}
