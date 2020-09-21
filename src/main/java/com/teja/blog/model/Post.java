package com.teja.blog.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity(name = "Post")
@Table(name = "post")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;
    @NotBlank
    @Column(nullable = false)
    private String title;
    @NotBlank
    @Lob
    private String description;
    @Lob
    @NotBlank
    private String content;
    private String genre;
    private Long CategoryId;
    @ManyToOne(fetch = FetchType.LAZY)

    @JsonIgnore
    @JoinColumn(name = "categoryId", insertable = false, updatable = false)
    private Category category;

    @JsonBackReference
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
