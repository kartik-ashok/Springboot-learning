package com.api.book.bootrestbook.controllers;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.book.bootrestbook.entities.Book;
import com.api.book.bootrestbook.service.BookService;


@RestController
public class BookControllers {

        // Autowired it will create  a Object
        @Autowired
        private BookService bookService;

        
        @GetMapping("/book")
        public ResponseEntity<List<Book>> getBooks(){
            List<Book> allBooks=bookService.getAllBooks();
            if(allBooks.size()<=0){
    
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
                // build method will create a responseEntity Object;
            }
            return ResponseEntity.of(Optional.of(allBooks));
            
        }

        @GetMapping("/book/{id}")
        public Book getSingleBook(@PathVariable("id") int id){
          
            Book singleBook=bookService.getSingleBooks(id);
            return singleBook;
            
        }

        @PostMapping("/book")
        public Book addBook(@RequestBody Book book){
            // RequestBody convert json to Object
            // Book singleBook=bookService.getSingleBooks(id);
            Book b=this.bookService.addBook(book);
            return b;
        }


        @DeleteMapping("/book/{bookId}")
        public void addBook(@PathVariable("bookId") int bookId){
           this.bookService.deleteBook(bookId);
        }


        @PutMapping("/book/{bookId}")
        public Book updateBook(@RequestBody Book book,@PathVariable("bookId") int bookId){
            this.bookService.updateBook(book,bookId);
            return book;
        }






}
