package com.cuspide.LibraryProject.Author;

import com.cuspide.LibraryProject.Book.Book;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "author")
public class Author {

    public Author() {
        this.id = UUID.randomUUID();
    }

    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "full_name", nullable = false, unique = true)
    private String fullName;

    @Temporal(TemporalType.DATE)
    @Column(name = "birthdate", nullable = false)
    private LocalDate birthDate;

    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
    private List<Book> books;
}
