package com.site.controller;

import com.site.entity.News;
import com.site.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/news")
public class NewsController {

    @Autowired
    NewsService newsService;

    @PostMapping("")
    public News sendMessage(@RequestBody News news) {
        return newsService.sendMessage(news);
    }

}