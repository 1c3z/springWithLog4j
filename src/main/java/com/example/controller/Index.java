package com.example.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Index {
    private static final Logger LOGGER = LogManager.getLogger(Index.class);

    @RequestMapping(value = "/", produces="text/html")
    public String index(){
        return "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "\t<title>\tlog4j</title>\n" +
                "</head>\n" +
                "<body>\n" +
                " \t<a href=\"./log?id=111\">go</a>\n" +
                "</body>\n" +
                "</html>";
    }

    @RequestMapping("/log")
    public String log(String id){
        LOGGER.info("id: " + id);
        return "ok";
    }
}
