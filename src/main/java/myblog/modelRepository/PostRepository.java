package myblog.modelRepository;

import myblog.model.Post;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface PostRepository extends PagingAndSortingRepository<Post, String> {

    @Modifying
    @Query(value = "INSERT INTO myblog.post (post_id, title, short_description, content, created_at, author_id) VALUES " +
            "(:postId, :title, :shortDescription, :content, :createdAt, :authorId)", nativeQuery = true)
    public abstract void insertNewPost(@Param("postId") String postId, @Param("title") String title, @Param("shortDescription") String shortDescription,
                              @Param("content") String content, @Param("createdAt") String createdAt, @Param("authorId") String authorId);

}
