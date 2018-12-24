package com.site.service;

import com.site.entity.News;
import com.site.repo.NewsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsService {

    @Autowired
    private NewsRepo newsRepo;

    public News sendMessage(News news){
        if (news.getText() != null){
            return newsRepo.save(news);
        }
        return null;
    }

    public List<News> getListMessage(){
        return newsRepo.findAll();
    }
}
