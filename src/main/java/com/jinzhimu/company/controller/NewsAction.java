package com.jinzhimu.company.controller;

import com.jinzhimu.company.databean.HttpResult;
import com.jinzhimu.company.databean.HttpResultType;
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

import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Created by MyPC on 2017/6/11.
 */
@RestController
public class NewsAction {

    @Autowired private NewsRepository newsRepository;

    @RequestMapping(value = "/news",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<News> news(@Param("pageNum") Integer pageNum,@Param("size") Integer size){
        if( pageNum !=null && size !=null){
            return newsRepository.findAll(new PageRequest(pageNum,size,new Sort(Sort.Direction.DESC,"sendTime"))).getContent();
        }else {
            return (List<News>) newsRepository.findAll();
        }
    }

//    @RequestMapping(value = "/pageNews",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    public List<News> news(){
//
//    }

    @RequestMapping(value = "/newsAllNums",method = RequestMethod.GET)
    public Integer newsAllNums(){
        return ((List<News>)newsRepository.findAll()).size();
    }

    @RequestMapping(value = "/news",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public HttpResultType sendNews(@Param("title")String title, @Param("text")String text, @Param("auther") String auther, @Param("source")String source) throws IOException {
        News news = new News(title, text, auther, source, new Date(), 0);
        News n = newsRepository.save(news);
        if (n != null) {
            return HttpResultType.SUCCESS;
        } else {
            return HttpResultType.FAILD;
        }
    }

}
