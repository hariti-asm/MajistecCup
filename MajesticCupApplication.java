package ma.hariti.asmaa.wrm.majesticcup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.security.SecureRandom;
import java.util.Base64;

@SpringBootApplication
public class MajesticCupApplication {

    public static void main(String[] args) {
        String secretKey = generateSecureKey();
        System.out.println("Generated Secret Key: " + secretKey);

        SpringApplication.run(MajesticCupApplication.class, args);
    }

    public static String generateSecureKey() {
        byte[] keyBytes = new byte[32];
        new SecureRandom().nextBytes(keyBytes);
        return Base64.getEncoder().encodeToString(keyBytes);
    }
}