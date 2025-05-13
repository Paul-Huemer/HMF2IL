package hmf2.bootjpa1.dao;

import hmf2.bootjpa1.business.BlogEntry;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogEntryDAO extends CrudRepository<BlogEntry, Long> {
}
