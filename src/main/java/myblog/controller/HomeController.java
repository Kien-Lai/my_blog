package myblog.controller;

import myblog.model.User;
import myblog.modelRepository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class HomeController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/home")
    public String home() {
        return "home";
    }
}
