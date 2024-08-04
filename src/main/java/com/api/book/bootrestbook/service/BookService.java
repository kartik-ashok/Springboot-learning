package com.api.book.bootrestbook.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.api.book.bootrestbook.entities.Book;

@Component
public class BookService {
    private static List<Book> list=new ArrayList<>();
    static {

        list.add(new Book(0, "abc", "xyz"));
        list.add(new Book(1, "cba", "zyx"));
        list.add(new Book(2, "bca", "yzx"));
        list.add(new Book(3, "cab", "zay"));
    }
    public List<Book> getAllBooks(){
        return list;
    }

     public Book getSingleBooks(int id){
        Book singleBook=list.stream().filter(e->e.getId()==id).findFirst().get();
        return singleBook;
    }

    public Book addBook(Book book){
            list.add(book);
            return book;
    }

    
    public Book deleteBook(int bookId){
         Book deletedBook=list.stream().filter(book->book.getId()==bookId).findFirst().get();
            return deletedBook;
    }


        public void updateBook(Book book,int bookId){
          list =  list.stream().map(e->{
                if (e.getId()==bookId) {
                    e.setTitle(book.getTitle());
                    e.setAuthor(book.getAuthor());
                    
                }
                return book;
            }).collect(Collectors.toList());
            // return deletedBook;
    }



    

}
