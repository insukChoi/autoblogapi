package com.bengaluru.autoblogapi.api.serviceImpl;

import lombok.Getter;
import lombok.Setter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@ConfigurationProperties(prefix="tip")
@Getter
@Setter
public class TipServiceImplTest {
    private RestTemplate restTemplate;
    private String uri;
    private String apiType;
    private String authKey;
    private String fileName;
    private String fileOutputDir;


    @Test
    public void propertiesMatch(){
        assertThat(getUri(), is("http://www.fss.or.kr/fss/kr/openApi/api/tip.jsp"));
        assertThat(getApiType(), is("json"));
        //assertThat(getAuthKey(), is("123XXXXXX45XXXXXXXXX67XXXXXXXC89"));
        assertThat(getFileName(), is("tip"));
        assertThat(getFileOutputDir(), is("D:\\log"));
    }


}