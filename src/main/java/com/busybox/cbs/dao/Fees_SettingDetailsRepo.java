package com.busybox.cbs.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.busybox.cbs.model.Fees_SettingDetails;

@EnableJpaRepositories
public interface Fees_SettingDetailsRepo extends JpaRepository<Fees_SettingDetails, Long>{

}
