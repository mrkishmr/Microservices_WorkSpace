package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.EmailOtp;
import com.example.demo.repository.EmailOtpRepository;

@Service
public class EmailService {

	@Autowired
	private EmailOtpRepository emailOtpRepo;
	
	public String addEmailOtp(EmailOtp emailOtp)
	{
		EmailOtp emotp=emailOtpRepo.save(emailOtp);
		if(emotp!=null)
		{
			return "otp sent successfully";
		}
		return "something went wrong";
	}
	public List<EmailOtp> getOtpbyEmail(String email)
	{
		List<EmailOtp> emotp=emailOtpRepo.findByEmail(email);
		return emotp;
	}
}
