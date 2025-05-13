package hmf2.bootjpa1.dao;

import hmf2.bootjpa1.business.Tag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagDAO extends CrudRepository<Tag, Long> {
}
