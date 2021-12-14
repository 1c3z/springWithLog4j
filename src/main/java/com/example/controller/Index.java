package com.example.controller;

import com.example.task.Task;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Index {
    private static final Logger LOGGER = LogManager.getLogger(Index.class);

    @RequestMapping(value = "/", produces="text/html")
    public String index(@RequestHeader(value = "User-Agent", defaultValue="") String userAgent){
        Task.asyncLog(userAgent);

        return "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "\t<title>\tlog4j</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "首页记录 User-Agent <br/><br/><br/>" +
                " \t<a href=\"./log?id=111\">go log </a> <br/><br/>\n" +
                " \t<a href=\"./article?id=111\">go article 记录 Referer</a><br/><br/>\n" +
                "</body>\n" +
                "</html>";
    }

    @RequestMapping("/article")
    public String log_article(@RequestHeader(value = "Referer",  defaultValue="") String referer, String id){
        Task.asyncLog(referer);
        LOGGER.info("id: " + id);
        return "ok";
    }

    @RequestMapping("/log")
    public String log(String id){
        LOGGER.info("id: " + id);
        return "ok";
    }
}
