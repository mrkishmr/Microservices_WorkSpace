package com.example.demo.controller;

import java.util.Random;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.config.EmailSenderService;
import com.example.demo.entity.EmailOtp;
import com.example.demo.service.EmailService;

import jakarta.mail.MessagingException;

@RestController

@RequestMapping("/emailservice")
public class EmailController {
	
	@Autowired
	private EmailSenderService emailSender;
	@Autowired
	private EmailService emailService;

	@GetMapping("/sendOtp/{email}")
	public String sendOtp(@PathVariable String email) throws MessagingException
	{
		String otp=generateOtp();
		String to=email;
		String subject="OTP Request";
		String body="Your OTP is: "+otp;
		emailSender.sendEmail(to,subject,body);
		EmailOtp emotp=new EmailOtp();
		emotp.setEmail(email);
		emotp.setOtp(otp);
		return emailService.addEmailOtp(emotp);
	}
	@PostMapping("/verifyOtp")
	public String verifyOtp(@RequestBody EmailOtp emailOtp)
	{
		String email=emailOtp.getEmail();
		String otp=emailOtp.getOtp();
		List<EmailOtp> emotp=emailService.getOtpbyEmail(email);
		for(EmailOtp eotp:emotp)
		{
		if(eotp.getOtp().equals(otp))
		{
			return "Otp verified successfully";
		}
		}
		return "Otp did not match";
	}
	public static String generateOtp()
	{
		String num="0123456789";
		Random rnd=new Random();
		char ch[]=new char[6];
		for(int i=0;i<ch.length;i++)
		{
			ch[i]=num.charAt(rnd.nextInt(num.length()));
		}
		String otp=new String(ch);
		return otp;
	}
}
