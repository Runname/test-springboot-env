package com.example.grpc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class GrpcApplication {

    public static void main(String[] args) {
        SpringApplication.run(GrpcApplication.class, args);
    }


    @Value("${mysql.hostname}")
    private String mysqlHostname;

    @Autowired
    private Environment environment;


    @RequestMapping(value = "getEnv", method = RequestMethod.GET)
    public String getEnvForK8sYaml(@RequestParam(name = "type", required = false) String type) {

        String property = StringUtils.isEmpty(type) ? "" : environment.getProperty(type);

        return String.format("mysql.hostname: %s, getValueForTheType: %s", mysqlHostname, property);

    }

}
