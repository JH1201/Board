package com.example.Web_prac.domain;

import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

public class MessageDto {

    private String message;
    private String redirectUri;
    private RequestMethod method;
    private Map<String, Object> data;
}
