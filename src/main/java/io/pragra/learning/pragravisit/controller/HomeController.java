package io.pragra.learning.pragravisit.controller;

import io.pragra.learning.pragravisit.entity.GitUser;
import io.pragra.learning.pragravisit.entity.PragraVisitor;
import io.pragra.learning.pragravisit.service.VisitorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
public class HomeController {

    private VisitorService service;
    private RestTemplate template;

    public HomeController(VisitorService service, RestTemplate template) {
        this.service = service;
        this.template = template;
    }

    @GetMapping("/")
    public String home(Model model){
        String heading = "Pragra FullSTack Java CLass";
        model.addAttribute("msg", heading);
        return "index";
    }

    @GetMapping("/visits")
    public String visitor(Model model){
        List<PragraVisitor> visitors = service.getAll();
        model.addAttribute("visitors", visitors);
        return "visitor";
    }

    @GetMapping("/github/{user}")
    public String githubUser(@PathVariable("user") String user, Model model){
        GitUser gitUser = template.getForObject("https://api.github.com/users/{user}", GitUser.class, user);
        model.addAttribute("gitUser", gitUser);
        System.out.println(gitUser);
        return "githubuser";
    }


}
