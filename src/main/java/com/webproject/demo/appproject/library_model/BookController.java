package com.webproject.demo.appproject.library_model;

import com.webproject.demo.appproject.library_model.Book;
import com.webproject.demo.appproject.library_model.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    // Show all books
    @GetMapping("/library_index")
    public String viewLibrary(Model model) {
        model.addAttribute("books", bookService.bookList);
        return "library_index"; // maps to library_index.jsp
    }

    // Show add book form
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("book", new Book());
        return "library-add"; // maps to library-add.jsp
    }

    // Save a new book
    @PostMapping("/save")
    public String saveBook(@ModelAttribute("book") Book book) {
        bookService.addBook(book.getTitle(), book.getAuthor(), book.getIsbn());
        return "redirect:/library_index";
    }

    // Show edit form
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") int id, Model model) {
        Book book = bookService.findById(id);
        model.addAttribute("book", book);
        return "library-add"; // reuse library-add.jsp for editing
    }

    // Update book
    @PostMapping("/update")
    public String updateBook(@ModelAttribute("book") @Valid Book book) {
        bookService.updateBooks(book);
        return "redirect:/library_index";
    }

    // Delete book
    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") int id) {
        bookService.deleteById(id);
        return "redirect:/library_index";
    }
}

