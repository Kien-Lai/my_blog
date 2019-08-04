package myblog.modelRepository;

import myblog.model.PostCategory;
import org.springframework.data.repository.CrudRepository;

public interface PostCategoryRepository extends CrudRepository<PostCategory, String> {
}
