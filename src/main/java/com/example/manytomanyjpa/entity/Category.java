package com.example.manytomanyjpa.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@ToString
@NoArgsConstructor
@Getter
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "followedCategories")
    private List<Photo> photos = new ArrayList<>();

    public Category(String name) {
        this.name = name;
    }

    public void addPhoto(Photo photo){
        photos.add(photo);
    }
}
