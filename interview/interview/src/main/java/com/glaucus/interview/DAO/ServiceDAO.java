package com.glaucus.interview.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.glaucus.interview.Beans.NumberId;

public interface ServiceDAO extends JpaRepository<NumberId, Long>{
	
	@Query(value = "SELECT MAX(n.ID) FROM NUMBER n",nativeQuery = true)
	public long getData();
	
	
	@Modifying//(clearAutomatically = true)
	@Query(value = "INSERT INTO NUMBER (ID) VALUE (:val)",nativeQuery = true)
	@Transactional
	public void updateData(@Param("val") long val);
}
