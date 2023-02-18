package com.example.restaurant.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/pages")
public class PageController {

    @GetMapping("/main")
    public ModelAndView main() { // 타임리프에서 특정한 HTML View 로 보낼때 사용
        return new ModelAndView("aaaa/main"); // resources -> templates 폴더 하위의 경로
    }

}
