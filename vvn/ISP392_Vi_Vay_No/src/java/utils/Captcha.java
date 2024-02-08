/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 *
 * @author lvhn1
 */
public class Captcha {
    
    private static final String HCAPTCHA_SECRET_KEY = "ES_66b603ebcdef481fb622b756ac44b3e2";
    
    public boolean verifyCaptcha(String captchaResponse) {
        try {
            String url = "https://hcaptcha.com/siteverify";
            String params = "secret=" + URLEncoder.encode(HCAPTCHA_SECRET_KEY, "UTF-8")
                    + "&response=" + URLEncoder.encode(captchaResponse, "UTF-8");

            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("POST");
            con.setDoOutput(true);

            try (OutputStream os = con.getOutputStream()) {
                os.write(params.getBytes());
                os.flush();
            }

            try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }

                return response.toString().contains("\"success\":true");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
}
