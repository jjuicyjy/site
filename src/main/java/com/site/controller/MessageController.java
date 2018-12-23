package com.site.controller;

import com.site.entity.News;
import com.site.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    NewsService newsService;

    @PostMapping("")
    public News sendMessage(@RequestBody News news) {
        return newsService.sendMessage(news);
    }

}