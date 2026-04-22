package com.snhu.sslserver;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class ServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }
}

@RestController
class ServerController {
    private static final String DATA = "Shahbaj Singh";
    private static final String ALGORITHM = "SHA-256";

    @RequestMapping("/hash")
    public String myHash() {
        try {
            MessageDigest digest = MessageDigest.getInstance(ALGORITHM);
            byte[] hash = digest.digest(DATA.getBytes(StandardCharsets.UTF_8));
            String checksum = bytesToHex(hash);

            return "<p>data:" + DATA + "</p>"
                    + "<p>Name of Cipher Algorithm Used : " + ALGORITHM + "</p>"
                    + "<p>CheckSum Value: " + checksum + "</p>";
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("Hash algorithm not available", e);
        }
    }

    private String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder(2 * bytes.length);

        for (byte b : bytes) {
            String hex = Integer.toHexString(0xff & b);

            if (hex.length() == 1) {
                hexString.append('0');
            }

            hexString.append(hex);
        }

        return hexString.toString();
    }
}
