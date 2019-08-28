package com.bengaluru.autoblogapi.api.serviceImpl;

import com.bengaluru.autoblogapi.api.domain.Api;
import com.bengaluru.autoblogapi.api.domain.File;
import com.bengaluru.autoblogapi.api.service.TipService;
import com.bengaluru.autoblogapi.common.RestApiUtil;
import com.bengaluru.autoblogapi.common.TimeUtil;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.FileWriter;
import java.io.IOException;

@Service
@EnableAutoConfiguration
@ConfigurationProperties(prefix="tip")
@Getter
@Setter
public class TipServiceImpl implements TipService {
    private RestTemplate restTemplate;
    private String uri;
    private String apiType;
    private String authKey;
    private String fileName;
    private String fileOutputDir;

    @Autowired
    public TipServiceImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @Override
    public void doProcess() throws Exception{
        // API body 받아 옴
        String resultApi = getTipApi().getBody();
        // 파일 저장
        boolean isSaved = saveFile(resultApi);

        if (isSaved){
            System.out.println(TimeUtil.getToday("yyyy-MM-dd") + " API 데이터 파일 저장 완료!!!");

            // Json 응답 파싱
            JsonParser Parser = new JsonParser();
            JsonObject jsonObj = (JsonObject) Parser.parse(resultApi);
            JsonObject respObj = jsonObj.getAsJsonObject("reponse");
            if ("\"1\"".equals(respObj.get("resultCode").toString())){  // API 로 가져온 데이터가 있으면!!!
                JsonArray tipArr = respObj.getAsJsonArray("result");
                for (int i = 0; i < tipArr.size(); i++) {
                    JsonObject tipObj = (JsonObject) tipArr.get(i);
                    System.out.println("일자 : " + tipObj.get("regDate"));
                    System.out.println("제목 : " + tipObj.get("subject"));
                    /*System.out.println("내용 : " + tipObj.get("contentsKor"));
                    System.out.println("원본URL : " + tipObj.get("originUrl"));*/

                    // blog 등록

                    // access token 얻기
                    String accessToken = RestApiUtil.getAccessToken(restTemplate);
                    System.out.println("accessToken = " + accessToken);
                    //// TODO : 공통으로 bloag 등록 함수 만들기

                }
            }


        } else {
            System.out.println(TimeUtil.getToday("yyyy-MM-dd") + " API 데이터 파일 저장에 실패 하였습니다.");
        }
    }

    @Override
    public ResponseEntity<String> getTipApi() throws Exception{
        Api api = Api.builder()
                .uri(getUri())
                .apiType(getApiType())
                .authKey(getAuthKey())
                .startDate(TimeUtil.getBeforeDay(-7,"yyyy-MM-dd")) // 7일 전 날짜
                //.startDate(TimeUtil.getToday("yyyy-MM-dd"))
                .endDate(TimeUtil.getToday("yyyy-MM-dd"))
                .build();

        return RestApiUtil.request(restTemplate, HttpMethod.GET, api);
    }

    @Override
    public boolean saveFile(String contents) {
        File file = File.builder()
                .fileName(getFileName())
                .fileOutputDir(getFileOutputDir())
                .build();

        java.io.File saveFile = new java.io.File(file.getFileOutputDir()  + java.io.File.separatorChar + file.getFileName());
        System.out.println("파일 경로 = " + saveFile.getAbsolutePath());
        try {
            FileWriter fw = new FileWriter(saveFile, true);
            fw.write(contents);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
