package com.otpverification.service;

import com.twilio.http.TwilioRestClient;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class OtpService {

    @Value("${twilio.phone-number}")
    private String twilioPhoneNumber;

    public String generateOtp(String to) {
        // Generate a random OTP, e.g., a 6-digit number
        int otp = new Random().nextInt(900000) + 100000;
        // Send the OTP via Twilio SMS
        sendOtpSms(to, String.valueOf(otp));
        return String.valueOf(otp);
    }

    public void sendOtpSms(String to, String otp) {
        Message message = Message.creator(new PhoneNumber(to), new PhoneNumber(twilioPhoneNumber), "Your OTP is: " + otp).create();
    }
}


