package com.cuspide.LibraryProject.book;

import com.cuspide.LibraryProject.author.Author;
import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String title;
    private String isbn;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;
}
