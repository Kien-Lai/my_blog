package myblog.model;

import javax.persistence.*;

@Entity
@Table(name = "post_catalogue")
@IdClass(PostCategoryId.class)
public class PostCategory {

    @Id
    @Column(name = "post_id")
    private String postId;

    @Id
    @Column(name = "category_id")
    private String categoryId;

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }
}
