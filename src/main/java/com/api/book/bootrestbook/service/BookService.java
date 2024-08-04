package com.api.book.bootrestbook.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.book.bootrestbook.dao.BookRepo;
import com.api.book.bootrestbook.entities.Book;

@Component
public class BookService {
    @Autowired
    private BookRepo bookRepo;
    
    public List<Book> getAllBooks(){
       List<Book> listOfBooks= (List<Book>) this.bookRepo.findAll();
        return listOfBooks;
    }

     public Book getSingleBooks(int id){
        Book book=null;
        try {
      book=  this.bookRepo.findById(id);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return book;
    }

    public Book addBook(Book book){
            // list.add(book);
           Book savedBook= this.bookRepo.save(book);
            return savedBook;
    }

    
    public void deleteBook(int bookId){
        this.bookRepo.deleteById(bookId);
    }


        public void updateBook(Book book,int bookId){
            book.setId(bookId);
        this.bookRepo.save(book);
    }



    

}
