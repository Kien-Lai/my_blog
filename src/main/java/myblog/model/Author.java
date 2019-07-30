package myblog.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "author")
public class Author {

    @Id
    @Column(name = "author_id")
    private String authorId;

    private String nickname;

    private String fullname;

    private String description;

    @ManyToMany
    @JoinColumn(name = "auth_id", insertable = false, updatable = false)
    List<PostCategory> lstPostCatalogue;

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<PostCategory> getLstPostCatalogue() {
        return lstPostCatalogue;
    }

    public void setLstPostCatalogue(List<PostCategory> lstPostCatalogue) {
        this.lstPostCatalogue = lstPostCatalogue;
    }
}
