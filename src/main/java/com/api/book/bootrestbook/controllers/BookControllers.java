package com.api.book.bootrestbook.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.book.bootrestbook.entities.Book;
import com.api.book.bootrestbook.service.BookService;


@RestController
public class BookControllers {

        // Autowired it will create  a Object
        @Autowired
        private BookService bookService;




        @GetMapping("/book")
        public List<Book> getBooks(){
            // Book book=new Book();
            // book.setId(101);
            // book.setTitle("Mother");
            // book.setAuthor("God");
            // In Java sprinboot automatially convert object into json and return
            // this is Because of One dependency i.e jackson
            // object to json and json to Object
            // return book;
            List<Book> allBooks=bookService.getAllBooks();
            return allBooks;
            
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
