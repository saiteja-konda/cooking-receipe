package com.teja.blog.model;


import lombok.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "tag")
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Tag implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private long id;

    private String name;

    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "tags")
    private List<Post> posts = new ArrayList<Post>();

    public void setName(String name) {
        this.name = name;
    }


    public Tag entries(List<Post> posts) {
        this.posts = posts;
        return this;
    }

    public Tag addEntry(Post post) {
        this.posts.add(post);
        post.getTags().add(this);
        return this;
    }

    public Tag removeEntry(Post post) {
        this.posts.remove(post);
        post.getTags().remove(this);
        return this;
    }


}
