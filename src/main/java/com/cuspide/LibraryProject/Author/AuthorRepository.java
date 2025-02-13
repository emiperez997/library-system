package com.cuspide.LibraryProject.Author;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

public interface AuthorRepository extends JpaRepository<Author, UUID> { }
