package com.webproject.demo.appproject.library_model;

import com.webproject.demo.appproject.todo.Todo;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class BookService {
    public static List<Book> bookList = new ArrayList<>();
    private static int bookCounter = 0;

    static {
        bookList.add(new Book(++bookCounter,"Learn Spring boot","in 3 month","12122123"));
        bookList.add(new Book(++bookCounter,"Learn React from Scretch", "in 2 months", "023408934"));
        bookList.add(new Book(++bookCounter,"Learn C#","lets do it","297819263712"));
    }
    public void addBook(String title, String author, String isbn){
        Book book = new Book(++bookCounter,title,author,isbn);
        bookList.add(book);
    }
    public List<Book> findByTitle(String title){
        Predicate<? super Book> predicate = todoCount -> todoCount.getTitle().equalsIgnoreCase(title);
        return bookList.stream().filter(predicate).toList();
    }

    public void deleteById(int id) {
        Predicate<? super Book> predicate = bookCounter -> bookCounter.getId() == id ;
        bookList.removeIf(predicate);
    }
    public Book findById(int id) {
        Predicate<? super Book> predicate =  bookCounter -> bookCounter.getId() == id ;
        Book book = bookList.stream().filter(predicate).findFirst().get();
        return book;
    }
    public void updateBooks(@Valid Book book) {
        deleteById(book.getId());
        bookList.add(book);
    }

}
