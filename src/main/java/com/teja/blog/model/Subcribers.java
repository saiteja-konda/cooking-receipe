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
    @Column(unique = true)
    private String email;

}
