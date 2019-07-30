package myblog.model;

import java.io.Serializable;

public class PostCategoryId implements Serializable {

    private String postId;

    private String categoryId;

    public PostCategoryId(){

    }

    public PostCategoryId(String postId, String categoryId){
        this.postId = postId;
        this.categoryId = categoryId;
    }
}
