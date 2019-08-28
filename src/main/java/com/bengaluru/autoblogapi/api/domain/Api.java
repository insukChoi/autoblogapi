package com.bengaluru.autoblogapi.api.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@Builder
@ConfigurationProperties(prefix = "tip")
public class Api {
    private String uri;
    private String apiType;
    private String startDate;
    private String endDate;
    private String authKey;
}
