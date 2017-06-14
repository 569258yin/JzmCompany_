package com.jinzhimu.company.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jinzhimu.company.model.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.jinzhimu.company.model.News;
import com.jinzhimu.company.repository.NewsRepository;
import com.jinzhimu.company.util.GsonUtil;

@Controller
public class TestAction {


    @Autowired
    private NewsRepository newsRepository;

//    @GetMapping("/")
//    public ModelAndView index() {
//        return new ModelAndView("index");
//    }

    @GetMapping("/news_index")
    public ModelAndView news_index() {
        return new ModelAndView("news/news_index");
    }

    @GetMapping("/getNews")
    public ModelAndView getNews(HttpServletRequest request) {
        String id = request.getParameter("id");
        News news = newsRepository.findById(Long.parseLong(id));
        ModelAndView mv = new ModelAndView("news/news");
        mv.addObject("news", news);
        return mv;
    }

    @PostMapping("/sendNews")
    public void sendNews(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String text = (String) request.getParameter("text") + "";
        News news = new News("测试", text, "威海金之木", "威海金子木", new Date(), 0);
        News n = newsRepository.save(news);
        if (n != null) {
            response.getWriter().write("SUCCESS");
        } else {
            response.getWriter().write("Error");
        }

    }

    @GetMapping("/getAllNews")
    public void getAllNews(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<News> lists = (List<News>) newsRepository.findAll();
        response.getWriter().write(GsonUtil.objectToString(lists));
    }
}
