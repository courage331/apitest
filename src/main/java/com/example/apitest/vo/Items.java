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
public class Items {
	String shop_no;
	String item_noString;
	String order_item_code;
	String variant_codeString;
	String product_no;
	String product_code;
	String custom_product_code;
	String custom_variant_code;
	String eng_product_name;
	String option_id;
	String option_value;
	String option_value_default;
	String additional_option_value;
	ArrayList<AdditionalOptionValues> additional_option_values;

	String any_code;
	String product_bundle;
	String product_bundle_no;
	String product_bundle_name;
	String product_bundle_name_default;
	String product_bundle_type;
	String was_product_bundle;
	String original_bundle_item_no;
	String naver_pay_order_id;
	String naver_pay_claim_status;
	String individual_shipping_fee;
	String shipping_fee_type;
	String shipping_fee_type_text;
	String shipping_payment_option;
	String payment_info_id;
	ArrayList<String> original_item_no;
	String store_pickup;
	String ordered_date;
	String shipped_date;
	String delivered_date;
	String cancel_date;
	String return_confirmed_date;
	String return_request_date;
	String return_date;
	String return_collected_date;
	String cancel_request_date;
	String refund_date;
	String exchange_request_date;
	String exchange_date;
	String product_material;
	String product_material_eng;
	String cloth_fabric;
	String product_weight;
	String volume_size;
	String volume_size_weight;
	String clearance_category;
	String clearance_category_info;
	String clearance_category_code;
	String hs_code;
	String one_plus_n_event;
	String origin_place;
	String origin_place_no;
	String made_in_code;
	String gift;
	String item_granting_gift;
	String subscription;
	ArrayList<ProductBundleList> product_bundle_list;
	String market_cancel_request;
	String market_cancel_request_quantity;
	String market_fail_reason;
	String market_fail_reason_guide;
	String market_custom_variant_code;

}
