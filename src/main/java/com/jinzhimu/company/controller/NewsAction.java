package com.jinzhimu.company.controller;

import com.jinzhimu.company.model.News;
import com.jinzhimu.company.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by MyPC on 2017/6/11.
 */
@RestController
public class NewsAction {

    @Autowired private NewsRepository newsRepository;

    @RequestMapping(value = "/news",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<News> news(){
        return (List<News>) newsRepository.findAll();
    }

    @RequestMapping(value = "/pageNews",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<News> news(@Param("pageNum") int pageNum,@Param("size") int size){
        return newsRepository.findAll(new PageRequest(pageNum,size,new Sort(Sort.Direction.DESC,"sendTime"))).getContent();
    }

    @RequestMapping(value = "/newsAllNums",method = RequestMethod.GET)
    public Integer newsAllNums(){
        return ((List<News>)newsRepository.findAll()).size();
    }

}
