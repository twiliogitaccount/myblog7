package com.otpverification.controller;

import com.otpverification.service.OtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/otp")
public class OtpController {

    @Autowired
    private OtpService otpService;

    // Generate and send OTP
    @PostMapping("/send")
    public ResponseEntity<String> sendOtp(@RequestParam String phoneNumber) {
        String otp = otpService.generateOtp("+"+phoneNumber);
        // Store the OTP and associate it with the user in your database
        return ResponseEntity.ok("OTP sent to " + phoneNumber);
    }

    // Verify OTP
    @PostMapping("/verify")
        public ResponseEntity<String> verifyOtp(@RequestParam String phoneNumber, @RequestParam String otp) {
        // Retrieve the stored OTP for the user from the database and compare it with the submitted OTP
        // If they match, the OTP is valid
        return ResponseEntity.ok("OTP verified successfully");
    }
}
