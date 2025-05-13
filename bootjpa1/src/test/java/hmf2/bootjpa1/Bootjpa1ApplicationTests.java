package hmf2.bootjpa1;

import hmf2.bootjpa1.business.BlogEntry;
import hmf2.bootjpa1.business.Comment;
import hmf2.bootjpa1.business.Tag;
import hmf2.bootjpa1.dao.BlogEntryDAO;
import hmf2.bootjpa1.dao.TagDAO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

@SpringBootTest
@Transactional
class Bootjpa1ApplicationTests {

	@Autowired
	BlogEntryDAO blogEntryDAO;

	@Autowired
	TagDAO tagDAO;

	@Test
	void testBlogEntryDAO() {
		BlogEntry e1= new BlogEntry();
		e1.setContents("Test Boot "+ new Date());

		long len1 = blogEntryDAO.count();
		e1 = blogEntryDAO.save(e1);
		long len2 = blogEntryDAO.count();

		assertEquals(len1+1, len2);

		BlogEntry e2= blogEntryDAO.findById(e1.getId()).get();
		assertEquals(e1.getContents(), e2.getContents());
		assertEquals(e1,e2);

		blogEntryDAO.delete(e1);
		assertEquals(len1, blogEntryDAO.count());
	}

	@Test
	void testCommentBlogEntryRelation() {
		BlogEntry e1= new BlogEntry();
		e1.setContents("Test Blogentry Comment Relation "+ new Date());

		e1= blogEntryDAO.save(e1);

		Comment c= new Comment();
		c.setContents("Test Comment Relation "+ new Date());
		e1.addComment(c);

		BlogEntry e2= blogEntryDAO.findById(e1.getId()).get();
		assertEquals(e1.getComments().size(), e2.getComments().size());
	}

	@Test
	void testTagBlogEntryRelation() {
		BlogEntry e1= new BlogEntry();
		e1.setContents("Test Blogentry Tag Relation "+ new Date());
		e1= blogEntryDAO.save(e1);

		Tag t1= new Tag();
		t1.setName("Test Tag Relation "+ new Date());
		t1= tagDAO.save(t1);

		e1.addTag(t1);
		BlogEntry e2= blogEntryDAO.findById(e1.getId()).get();
		assertEquals(e1.getTags().size(), e2.getTags().size());
		assertTrue(e2.getTags().contains(t1));
		assertTrue(t1.getBlogentries().contains(e1));
	}
	
}
