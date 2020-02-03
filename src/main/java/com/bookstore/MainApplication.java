package com.bookstore;

import com.bookstore.service.BookstoreService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MainApplication {

    private final BookstoreService bookstoreService;

    public MainApplication(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    @Bean
    public ApplicationRunner init() {
        return args -> {
            System.out.println("Register new author ...");
            bookstoreService.registerAuthor();

            Thread.sleep(5000);

            System.out.println("Update an author ...");
            bookstoreService.updateAuthor();

            Thread.sleep(5000);
            System.out.println("Update books of an author ...");
            bookstoreService.updateBooks();

        };
    }
}


/*
 * 
 * 
 * 
 * 
 * 
 * How To Add created, createdBy, lastModified And lastModifiedBy In Entities Via Hibernate

Note: The same thing can be obtained via Spring Data JPA auditing as here.

Description: This application is an example of adding in an entity the fields, created, createdBy, lastModified and lastModifiedBy via Hibernate support. These fields will be automatically generated/populated.

Key points:

write an abstract class (e.g., BaseEntity) annotated with @MappedSuperclass
in this abstract class, define a field named created and annotate it with the built-in @CreationTimestamp annotation
in this abstract class, define a field named lastModified and annotate it with the built-in @UpdateTimestamp annotation
in this abstract class, define a field named createdBy and annotate it with the @CreatedBy annotation
in this abstract class, define a field named lastModifiedBy and annotate it with the @ModifiedBy annotation
implement the @CreatedBy annotation via AnnotationValueGeneration
implement the @ModifiedBy annotation via AnnotationValueGeneration
every entity that want to take advantage of created, createdBy, lastModified and lastModifiedBy will extend the BaseEntity
store the date-time in UTC

 * 
 * 
 */
