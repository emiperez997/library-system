package com.cuspide.LibraryProject.Book;

import com.cuspide.LibraryProject.Author.AuthorDTO;
import com.cuspide.LibraryProject.Exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public BookDTO getBookDTO(Book book) {
        BookDTO bookDTO = new BookDTO();

        bookDTO.setTitle(book.getTitle());
        bookDTO.setSynopsis(book.getSynopsis());
        bookDTO.setPublicationYear(book.getPublicationYear());

        AuthorDTO authorDTO = new AuthorDTO();

        authorDTO.setId(book.getAuthor().getId().toString());
        authorDTO.setFullName(book.getAuthor().getFullName());
        authorDTO.setBirthDate(book.getAuthor().getBirthDate().toString());

        bookDTO.setAuthor(authorDTO);

        return bookDTO;
    }

    public List<BookDTO> getBooks() {
        return bookRepository.findAll().stream().map(this::getBookDTO).toList();
    }

    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    public Book getBookById(UUID id) {
        return bookRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Book not found")
        );
    }

    public Book updateBook(UUID id, Book book) {
        Book bookToUpdate = bookRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Book not found")
        );

        bookToUpdate.setTitle(book.getTitle());
        bookToUpdate.setSynopsis(book.getSynopsis());
        bookToUpdate.setPublicationYear(book.getPublicationYear());

        return bookRepository.save(bookToUpdate);
    }
}
