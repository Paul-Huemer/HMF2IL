package hmf2.bootjpa1.business;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String contents;

    @ManyToOne
    private BlogEntry blogEntry;

    public Comment() {
        this.id = -1;
        this.contents = "";
        this.blogEntry = null;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public BlogEntry getBlogEntry() {
        return blogEntry;
    }

    public void setBlogEntry(BlogEntry blogEntry) {
        this.blogEntry = blogEntry;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return Objects.equals(contents, comment.contents) && Objects.equals(blogEntry, comment.blogEntry);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contents, blogEntry);
    }
}
