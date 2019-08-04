package myblog.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "post")
public class Post {

    @Id
    @Column(name = "post_id")
    private String postId;

    private String title;

    @Column(name = "short_description")
    private String shortDescription;

    private String content;

    @Column(name = "created_at")
    private String createdAt;

    @Column(name = "author_id")
    private String authorId;

    @Column(name = "background_url")
    private String backgroundUrl;

    @ManyToOne
    @JoinColumn(name = "author_id", insertable = false, updatable = false)
    Author author;

    @OneToMany
    @JoinColumn(name = "post_id", insertable = false, updatable = false)
    List<PostCategory> lstPostCategory;

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public List<PostCategory> getLstPostCategory() {
        return lstPostCategory;
    }

    public void setLstPostCategory(List<PostCategory> lstPostCategory) {
        this.lstPostCategory = lstPostCategory;
    }

    public String getBackgroundUrl() {
        return backgroundUrl;
    }

    public void setBackgroundUrl(String backgroundUrl) {
        this.backgroundUrl = backgroundUrl;
    }
}
