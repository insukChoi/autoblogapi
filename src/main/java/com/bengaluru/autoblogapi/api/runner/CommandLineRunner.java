package com.bengaluru.autoblogapi.api.runner;

import com.bengaluru.autoblogapi.api.service.TipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommandLineRunner implements org.springframework.boot.CommandLineRunner {
    @Autowired
    private TipService tipService;

    @Override
    public void run(String... args) throws Exception {
       for (String arg : args) {
            switch (arg){
                case "tip" : // 금융꿀팁 200선 API*/
                    tipService.doProcess();
                    break;
            }
        }


    }
}
