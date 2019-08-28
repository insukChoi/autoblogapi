package com.bengaluru.autoblogapi.api.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class File {
    private String fileName;
    private String fileOutputDir;
}
