package com.example.queryapply;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Map;

@Controller
public class QueryController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("queryForm", new QueryForm());
        return "index"; // Thymeleaf 템플릿의 이름
    }

    @PostMapping("/")
    public String executeQuery(@ModelAttribute QueryForm queryForm, Model model) {
        List<Map<String, Object>> results = jdbcTemplate.queryForList(queryForm.getQuery());
        model.addAttribute("data", results);
        return "index";
    }
}
