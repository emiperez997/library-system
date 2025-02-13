package com.cuspide.LibraryProject.Author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping()
    public ResponseEntity<List<Author>> getAuthors() {
        return ResponseEntity.ok(authorService.getAuthors());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Author>> getAuthorById(@PathVariable UUID id) {
        Optional<Author> author = authorService.getAuthorById(id);

        if (author.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(author);

    }

    @PostMapping()
    public ResponseEntity<Author> createAuthor(@RequestBody Author author) {
        return ResponseEntity.ok(authorService.createAuthor(author));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Optional<Author>> updateAuthor(@PathVariable UUID id, @RequestBody Author author) {
        Optional<Author> authorToUpdate = authorService.updateAuthor(id, author);

        if (authorToUpdate.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(authorToUpdate);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Optional<Author>> deleteAuthor(@PathVariable UUID id) {
        Optional<Author> author = authorService.deleteAuthor(id);

        if (author.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(author);
    }
}
