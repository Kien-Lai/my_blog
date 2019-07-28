package myblog.controller;

import myblog.config.config;
import myblog.model.Post;
import myblog.modelRepository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class HomeController {
    @Autowired
    private PostRepository postRepository;

    @GetMapping("/")
    public ModelAndView home(@RequestParam Optional<Integer> pageNumber) {
        // convert yêu cầu trang của client sang số
        int page;
        page = pageNumber.isPresent() ? (pageNumber.get() > 0 ? pageNumber.get() -1 : 0) : 0;

        // lấy danh sách các bài viết với pagination
        Pageable pagination = PageRequest.of(page, config.POST_PER_PAGE, Sort.by("createdAt").descending());
        Page<Post> lstPost =null;
        try {
            lstPost = postRepository.findAll(pagination);
        } catch (Exception err){
            // trả về page error ở đây
            System.out.println(err);
        }

        // trả lại view cho client
        ModelAndView mav = new ModelAndView("home");
        mav.addObject("posts", lstPost.getContent());
            return mav;
    }
}
