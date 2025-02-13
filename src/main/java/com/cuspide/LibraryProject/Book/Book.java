package com.cuspide.LibraryProject.Book;

import com.cuspide.LibraryProject.Author.Author;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name = "book")
public class Book {

    public Book() {
        this.id = UUID.randomUUID();
    }

    @Id
    private UUID id;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String synopsis;

    @Column(name = "publication_year", nullable = false)
    private Integer publicationYear;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;

}
