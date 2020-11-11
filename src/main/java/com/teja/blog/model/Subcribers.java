package com.teja.blog.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Subscribers")
@Table(name = "subscribers")
public class Subcribers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Email
//    @Column(unique = true)
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
