package com.busybox.cbs.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.busybox.cbs.model.NomineeDetails;

@EnableJpaRepositories
public interface NomineeDetailsRepo extends JpaRepository<NomineeDetails, Long>{

}
