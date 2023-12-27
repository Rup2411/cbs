package com.busybox.cbs.dao;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;

import com.busybox.cbs.dto.request.MemberRequestDto;
import com.busybox.cbs.model.MemberDetails;

@EnableJpaRepositories
public interface MemberDetailsRepo extends JpaRepository<MemberDetails, Long>{

	
@Query(value="""
SELECT public_member_id FROM member_details
"""
,nativeQuery = true)
public List<BigInteger> findAllPublicId();

@Query(value="""
select * from member_details where public_member_id = :x
"""
,nativeQuery = true)
public Optional<MemberDetails> findAllPublicId(@Param("x")BigInteger publicId);

}
