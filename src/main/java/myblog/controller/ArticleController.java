package myblog.controller;

import myblog.model.Post;
import myblog.modelRepository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class ArticleController {

    @Autowired
    PostRepository postRepository;

    @GetMapping("/posts/{postName}")
    public ModelAndView post(@PathVariable(value = "postName") String postName) {
        Optional<Post> currentPost = postRepository.findById(postName);
        if(!currentPost.isPresent()){
            // return error page here

        }
        ModelAndView mav = new ModelAndView("article");
        mav.addObject("post", currentPost.get());
        return mav;
    }
}
