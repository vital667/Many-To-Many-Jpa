package com.example.manytomanyjpa.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "followed_categories",
            joinColumns = @JoinColumn(name = "photo_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<Category> followedCategories = new ArrayList<>();

    public Photo(String name) {
        this.name = name;
    }

    public void followCategory(Category category) {
        followedCategories.add(category);
    }

    public void showCategories() {
        System.out.println(name + " belongs to:");
        for (Category i : followedCategories)
            System.out.println(i.getId() + " - " + i.getName());
    }
}
