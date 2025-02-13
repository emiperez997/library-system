package com.cuspide.LibraryProject.Author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> getAuthors() {
        return authorRepository.findAll();
    }

    public Author createAuthor(Author author) {
        return authorRepository.save(author);
    }

    public Optional<Author> getAuthorById(UUID id) {
        Author author = authorRepository.findById(id).orElse(null);

        if (author == null) {
            return Optional.empty();
        }

        return Optional.of(author);
    }

    public Optional<Author> deleteAuthor(UUID id) {
        Optional<Author> author = getAuthorById(id);

        if (author.isEmpty()) {
            return Optional.empty();
        }

        authorRepository.deleteById(id);

        return author;
    }

    public Optional<Author> updateAuthor(UUID id, Author author) {
        Optional<Author> authorToUpdate = getAuthorById(id);

        if (authorToUpdate.isEmpty()) {
            return Optional.empty();
        }

        authorToUpdate.get().setFullName(author.getFullName());
        authorToUpdate.get().setBirthDate(author.getBirthDate());

        authorRepository.save(authorToUpdate.get());

        return authorToUpdate;
    }
}
