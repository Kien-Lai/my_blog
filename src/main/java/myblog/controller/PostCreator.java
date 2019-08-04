package myblog.controller;

import myblog.model.Author;
import myblog.model.Category;
import myblog.modelRepository.AuthorRepository;
import myblog.modelRepository.CategoryRepository;
import myblog.modelRepository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class PostCreator {

    @Autowired
    PostRepository postRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    AuthorRepository authorRepository;

    @GetMapping("/oTMbXFS56w/post_creator")
    public ModelAndView postCreator(){
        List<Author> lstAuthor = (List<Author>) authorRepository.findAll();
        List<Category> lstCategory = (List<Category>) categoryRepository.findAll();
        ModelAndView mav = new ModelAndView("post_creator");
        mav.addObject("lstAuthor", lstAuthor);
        mav.addObject("lstCategory", lstCategory);
        return mav;
    }
}
