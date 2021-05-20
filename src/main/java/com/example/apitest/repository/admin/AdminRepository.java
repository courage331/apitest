package com.example.apitest.repository.admin;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.apitest.vo.AdminMallInfo;

@Repository("adminRepository")
public interface AdminRepository extends JpaRepository<AdminMallInfo, String> {

	@Transactional // 메소드 내에서 Exception이 발생하면 해당 메소드에서 이루어진 db작업을 롤백한다.
	@Query(value = "select * from db_admin.tb_mall_info " + "where mall_name = :mall_name ", nativeQuery = true) // :를 기준으로 parameter 표시
	List<AdminMallInfo> findByMall_name(@Param("mall_name") String mall_name);

}
