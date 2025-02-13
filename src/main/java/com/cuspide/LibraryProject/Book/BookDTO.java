package com.cuspide.LibraryProject.Book;

import com.cuspide.LibraryProject.Author.AuthorDTO;
import lombok.Data;

@Data
public class BookDTO {
    private String title;
    private String synopsis;
    private Integer publicationYear;
    private AuthorDTO author;

}
