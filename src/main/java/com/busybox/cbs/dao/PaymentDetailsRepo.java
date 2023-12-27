package com.busybox.cbs.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.busybox.cbs.model.PaymentDetails;

public interface PaymentDetailsRepo extends JpaRepository<PaymentDetails, Long> {

}
