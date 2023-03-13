package com.casemd6_be;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CaseMd6BeApplication {

    public static void main(String[] args) {
        SpringApplication.run(CaseMd6BeApplication.class, args);
    }
@Bean
public ModelMapper modelMapper(){
    return new ModelMapper();
}
}
