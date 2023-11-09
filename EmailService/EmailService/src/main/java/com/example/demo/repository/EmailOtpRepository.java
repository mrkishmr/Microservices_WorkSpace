package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.EmailOtp;

@Repository
public interface EmailOtpRepository extends JpaRepository<EmailOtp,Integer> {

	public List<EmailOtp> findByEmail(String email);
}
