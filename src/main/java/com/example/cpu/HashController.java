package com.example.cpu;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@RestController
public class HashController {

    @RequestMapping("/hash/{input}")
    public String getDigest(@PathVariable("input") String input) throws NoSuchAlgorithmException {
        for(int i = 0; i < 100_000; i++) { // 10만번 MD5 해시하고 반환
            input = getMD5Digest(input);
        }
        return input;
    }

    @RequestMapping("/hello")
    public String hello() {
        return " deploy another";
    }

    private String getMD5Digest(String input) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(input.getBytes());
        byte[] digest = md.digest();
        String myHash = DatatypeConverter
                .printHexBinary(digest).toUpperCase();

        return myHash;
    }
}