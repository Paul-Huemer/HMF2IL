package hmf2.bootjpa1.business;

import jakarta.persistence.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class BlogEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String contents;

    private Date timestamp;

    public BlogEntry() {
        this.id = -1;
        this.contents= "";
        this.timestamp = new Date();
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

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        BlogEntry blogEntry = (BlogEntry) o;
        return Objects.equals(contents, blogEntry.contents);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(contents);
    }

    // -- comments --

    @OneToMany(mappedBy="blogEntry", cascade = CascadeType.ALL)
    private Set<Comment> comments;

    public Set<Comment> getComments() {
        if (comments == null) {
            this.comments = new HashSet<>();
        }
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    public void addComment(Comment comment) {
        getComments().add(comment);
        comment.setBlogEntry(this);
    }

    public void removeComment(Comment comment) {
        if (getComments().contains(comment)) {
            getComments().remove(comment);
            comment.setBlogEntry(null);
        }
    }

    // -- tags --

    @ManyToMany(mappedBy="blogentries")
    private Set<Tag> tags;

    public Set<Tag> getTags() {
        if (tags == null) {tags = new HashSet<>();}
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    public void addTag(Tag tag) {
        getTags().add(tag);
        tag.getBlogentries().add(this);
    }

    public void removeTag(Tag tag) {
        if (getTags().contains(tag)) {
            getTags().remove(tag);
            tag.getBlogentries().remove(this);
        }
    }
}
