package softuniBlog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import softuniBlog.entity.Article;
import softuniBlog.repository.ArticleRepository;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

@Controller
public class HomeController {
    
    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("/")
    public String index(Model model) {
    
        Set<Article> articles = new HashSet<>(this.articleRepository.findAll());
    
        model.addAttribute("articles", articles);
        model.addAttribute("view", "home/index");
        return "base-layout";
    }
}
