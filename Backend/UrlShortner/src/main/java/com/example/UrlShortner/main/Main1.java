package com.example.UrlShortner.main;

import com.example.UrlShortner.Services.FunctionService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.security.Key;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class Main1 {
    public static void main(String[] args) {
         String jwtToken = "eyJhbGciOiJSUzI1NiIsImtpZCI6IjkzYjQ5NTE2MmFmMGM4N2NjN2E1MTY4NjI5NDA5NzA0MGRhZjNiNDMiLCJ0eXAiOiJKV1QifQ.eyJpc3MiOiJodHRwczovL2FjY291bnRzLmdvb2dsZS5jb20iLCJhenAiOiI1MjcwMzY1NjQ2Mjctdjk1bXVkZnF1cGJrYXBpbmllN2VlN2Jub3VsaWJocjYuYXBwcy5nb29nbGV1c2VyY29udGVudC5jb20iLCJhdWQiOiI1MjcwMzY1NjQ2Mjctdjk1bXVkZnF1cGJrYXBpbmllN2VlN2Jub3VsaWJocjYuYXBwcy5nb29nbGV1c2VyY29udGVudC5jb20iLCJzdWIiOiIxMTQ5MDUyNzU5MDI0NTQ4OTkyNTAiLCJlbWFpbCI6ImFrYXNoa3VtYXIyazEwQGdtYWlsLmNvbSIsImVtYWlsX3ZlcmlmaWVkIjp0cnVlLCJhdF9oYXNoIjoiYnRzU2pGUEViUVBtY3ZmX0x6aW1QZyIsIm5hbWUiOiJBa2FzaCBrdW1hciIsInBpY3R1cmUiOiJodHRwczovL2xoMy5nb29nbGV1c2VyY29udGVudC5jb20vYS9BQ2c4b2NJc05neDUxbnNkSG1rZlZSQWthUHBZUFlIS2xTa25nbmdIdTNGTHpIVkdCYVRKeU1NQjlBPXM5Ni1jIiwiZ2l2ZW5fbmFtZSI6IkFrYXNoIiwiZmFtaWx5X25hbWUiOiJrdW1hciIsImlhdCI6MTcxMjgzNjI0MywiZXhwIjoxNzEyODM5ODQzfQ.yN5zUH43Er5TGTO1ovH8mJxoWDiUC8t7mXR9dm35gOYmsHwq4qVlgWjKEz56Jf5wzA5xYN19aGcR1qzw5VWvvIPEqEGuVgAOkmu_b2ZbiUJJyMDBlRfkVJhHeRrUlH_0km1pfmqL1If1ygqsWi9T6Ua3ndK_SNdfmVFKc8UwqrtXlBZ8q_duM1gFooT6WXXMgqkUychskqGzzALvlZyh6FKlJSKVFpc7CPEEHX8iAKXYjQhRE_C2xPm66ol9DOy-omlqNHjq2WXxCMdQPQxC9ugMRJIeawUMPtSSmVDGbZepHg1grnbbq9CB4po5xYMhu0UB4L4iehVi_RWyOENadw"; // Replace with your actual JWT token

         Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
            String signingKey = Base64.getEncoder().encodeToString(key.getEncoded());
         
        // Decode the JWT token
        Object claims = Jwts.parserBuilder()
        .requireAudience("string")
        .build().setSigningKey(key)
        .parse(jwtToken).getBody();
        // Get the email claim from the decoded JWT token
       // String email = (String) claims.get("email");

        //System.out.println("Email: " + email);
        System.out.println(claims);

    }
}
