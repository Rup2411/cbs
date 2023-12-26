package com.busybox.cbs.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.busybox.cbs.model.MemberDetails;

@EnableJpaRepositories
public interface MemberDetailsRepo extends JpaRepository<MemberDetails, Long>{

}
