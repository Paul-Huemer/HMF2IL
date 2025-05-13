package hmf2.bootjpa1.business;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    @ManyToMany
    @JoinTable(name="blogentries_tags",
    joinColumns = {@JoinColumn(name="tag_id")},
    inverseJoinColumns = {@JoinColumn(name="blog_entry_id")})
    private Set<BlogEntry> blogentries;

    public Tag() {
        this.id= -1;
        this.name= "";
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<BlogEntry> getBlogentries() {
        if(blogentries == null) {blogentries= new HashSet<BlogEntry>();}
        return blogentries;
    }

    public void setBlogentries(Set<BlogEntry> blogentries) {
        this.blogentries = blogentries;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Tag tag = (Tag) o;
        return Objects.equals(name, tag.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
