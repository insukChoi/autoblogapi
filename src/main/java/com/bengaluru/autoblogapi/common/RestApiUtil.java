package com.bengaluru.autoblogapi.common;

import com.bengaluru.autoblogapi.api.domain.Api;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

public class RestApiUtil {

    /*
     * 금융 데이터 가져오기 API
     */
    public static ResponseEntity<String> request(RestTemplate restTemplate, HttpMethod method, Api api) throws Exception{
        ResponseEntity<String> responseEntity;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.valueOf("application/x-www-form-urlencoded; charset=utf-8"));

        /*
         * GET 호출
         */
        if (method.matches("GET")){
            String requestURL = api.getUri() + "?apiType=" + api.getApiType() + "&startDate="+api.getStartDate()+"&endDate="+api.getEndDate()+"&authKey="+api.getAuthKey();
            responseEntity = restTemplate.exchange(requestURL, HttpMethod.GET, null, String.class);
        }
        /*
         * POST 호출
         */
        else{
            responseEntity = null;
        }

        return responseEntity;
    }

    /*
     * Tistory access token 받아오기
     */
    public static String getAccessToken(RestTemplate restTemplate) throws Exception{
        String requestURL = "https://www.tistory.com/oauth/access_token?client_id=27a9317e6d38ebc99a5dc6f725ab5f03&client_secret=198062c07d44763d8515a10e3c8644e3d0c3edf252de73356956357efbde73eb0610198c&redirect_uri=&code=&grant_type=authorization_code";
        System.out.println("requestURL = " + requestURL);
        ResponseEntity<String> responseEntity= restTemplate.exchange(requestURL, HttpMethod.GET, null, String.class);
//String 타입으로 받아오면 JSON 객체 형식으로 넘어옴
        return responseEntity.getBody();
    }

/*    *//*
     * 블로그 자동 등록 API
     *//*
    public static ResponseEntity<String> autoBlogRegist(RestTemplate restTemplate) throws Exception{

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);//JSON 변환
        headers.set("Authorization", appKey); //appKey 설정 ,KakaoAK kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk 이 형식 준수

        HttpEntity entity = new HttpEntity("parameters", headers);
        URI url=URI.create("https://www.tistory.com/apis/post/write?access_token=27a9317e6d38ebc99a5dc6f725ab5f03");
        ResponseEntity response= restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
//String 타입으로 받아오면 JSON 객체 형식으로 넘어옴

    }*/
}
