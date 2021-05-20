package com.example.apitest.repository.mall;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.apitest.vo.MallAuthInfo;

@Repository("mallRepository")
public interface MallRepository extends JpaRepository<MallAuthInfo, String> {

	@Transactional // 메소드 내에서 Exception이 발생하면 해당 메소드에서 이루어진 db작업을 롤백한다.
	@Query(value = "select * from db_mall.tb_api_auth_info " + "where mall_id = :mall_id and service_no=5", nativeQuery = true) // :를 기준으로 parameter
																																// 표시
	MallAuthInfo findByMallID(@Param("mall_id") String mall_id);

	@Transactional
	@Query(value = "SELECT mall_id, COUNT(product_no) AS cnt, DATE_FORMAT(product_register_date, '%Y') AS register_date "
			+ "FROM db_mall.tb_product_info WHERE mall_id = :mall_id AND date_format(api_update_date, '%Y-%m-%d') = :curdate\n"
			+ "GROUP BY register_date", nativeQuery = true)
	List<String> findByRegdate(String mall_id, String curdate);

}
