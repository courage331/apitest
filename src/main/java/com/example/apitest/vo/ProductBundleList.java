package com.example.apitest.vo;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ProductBundleList {
	String product_no;
	String product_code;
	String variant_code;
	String product_name;
	String product_name_default;
	String option_id;
	String option_value;
	String option_value_default;
	String additional_option_value;
	ArrayList<AdditionalOptionValues> additional_option_values;
	String quantity;
	String supplier_id;
	String eng_product_name;
	String hs_code;
	String option_price;
}
