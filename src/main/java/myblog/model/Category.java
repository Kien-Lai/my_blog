package myblog.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Category")
public class Category {

    @Id
    @Column(name = "category_id")
    private String categoryId;

    private String description;

    @OneToMany
    @JoinColumn(name = "category_id", insertable = false, updatable = false)
    List<PostCategory> lstPostCategory;

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public List<PostCategory> getLstPostCategory() {
        return lstPostCategory;
    }

    public void setLstPostCategory(List<PostCategory> lstPostCategory) {
        this.lstPostCategory = lstPostCategory;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
