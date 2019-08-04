package myblog.controller.restApi;

import myblog.model.Post;
import myblog.model.PostCategory;
import myblog.model.restEntity.CommonResponse;
import myblog.modelRepository.PostCategoryRepository;
import myblog.modelRepository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class SaveNewPost {

    @Autowired
    PostRepository postRepository;

    @Autowired
    PostCategoryRepository postCategoryRepository;

    @RequestMapping(method = RequestMethod.POST, value = "/api/v1/post")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<CommonResponse> saveNewPost(
            @RequestParam("postId") String postId,
            @RequestParam("title") String title,
            @RequestParam("shortDescription") String shortDescription,
            @RequestParam("content") String content,
            @RequestParam("authorId") String authorId,
            @RequestParam("backgroundUrl") String backgroundUrl,
            @RequestParam("categoryId") String[] arrCategoryId){
        try {
            List<PostCategory> arrPostCategory = new ArrayList<>();
            for(String categoryId : arrCategoryId){
                PostCategory postCategory = new PostCategory();
                postCategory.setPostId(postId);
                postCategory.setCategoryId(categoryId);

                arrPostCategory.add(postCategory);
            }
            String createdAt = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(new Date());

            postRepository.insertNewPost(postId, title, shortDescription, content, createdAt, authorId);
            postCategoryRepository.saveAll(arrPostCategory);

            return new ResponseEntity<CommonResponse>(new CommonResponse(200, "Success", null), HttpStatus.OK);
        } catch (Exception error){
            return new ResponseEntity<CommonResponse>(new CommonResponse(500, "Internal Server Error", null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
