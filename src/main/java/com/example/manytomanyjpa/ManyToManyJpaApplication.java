package com.example.manytomanyjpa;

import com.example.manytomanyjpa.entity.Category;
import com.example.manytomanyjpa.entity.Photo;
import com.example.manytomanyjpa.repository.CategoryRepository;
import com.example.manytomanyjpa.repository.PhotoRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class ManyToManyJpaApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext configurableApplicationContext =
                SpringApplication.run(ManyToManyJpaApplication.class, args);
        CategoryRepository categoryRepository = configurableApplicationContext.getBean(CategoryRepository.class);
        PhotoRepository photoRepository = configurableApplicationContext.getBean(PhotoRepository.class);

        Photo blackWhiteApple = new Photo("BlackWhite Apple");
        Photo banana = new Photo("Banana");
        Photo blackWhiteGrapes = new Photo("BlackWhite Grapes");
        List<Photo> photos = Arrays.asList(blackWhiteApple, banana, blackWhiteGrapes);

        Category blackWhiteCat = new Category("BlackWhite");
        Category fruitsCat = new Category("Fruits");
        List<Category> categories = Arrays.asList(blackWhiteCat, fruitsCat);

        categoryRepository.saveAll(categories);

        blackWhiteApple.followCategory(blackWhiteCat);
        blackWhiteApple.followCategory(fruitsCat);

        banana.followCategory(fruitsCat);

        blackWhiteGrapes.followCategory(blackWhiteCat);
        blackWhiteGrapes.followCategory(fruitsCat);

        photoRepository.saveAll(photos);

//        Photo myPhoto = photoRepository.findById(1L).get();
//        System.out.println(myPhoto.getName());
//        myPhoto.showCategories();

        for(Photo i : photoRepository.findAll())
            i.showCategories();
    }
}
