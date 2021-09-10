package com.fhh.bxgu.utility;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Configuration
@EnableScheduling
public class TokenPool {
    private static int tokenValidLength;
    @Value("${bxgu.token.valid-length}")
    public void setTokenValidLength(int tokenValidLength) {
        TokenPool.tokenValidLength = tokenValidLength;
    }
    private static final Map<String,Long> pool=new HashMap<>();
    public static String getToken() {
        String token = UUID.randomUUID().toString();
        pool.put(token, System.currentTimeMillis());
        return token;
    }
    public static boolean validateToken(String token) {
        Long timestamp = pool.get(token);
        if(timestamp!=null) {
            long result = (System.currentTimeMillis()-timestamp) - tokenValidLength*1000;
            if((System.currentTimeMillis()-timestamp)<tokenValidLength*1000) {
                pool.put(token,System.currentTimeMillis());
                return true;
            }
            pool.remove(token);
        }
        return false;
    }
    @Scheduled(fixedRate=18000000)
    public static void clearUnusedToken() {
        pool.forEach((token,timestamp)->{
            if((System.currentTimeMillis()-timestamp)>tokenValidLength*1000) {
                pool.remove(token);
            }
        });
    }
}
