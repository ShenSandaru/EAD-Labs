package lk.ac.mrt.fit.library_api.service;

import lk.ac.mrt.fit.library_api.model.Book;
import lk.ac.mrt.fit.library_api.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    public Optional<Book> updateBook(Long id, Book details) {
        return bookRepository.findById(id).map(existingBook -> {
            existingBook.setTitle(details.getTitle());
            existingBook.setAuthor(details.getAuthor());
            existingBook.setIsbn(details.getIsbn());
            existingBook.setPrice(details.getPrice());
            return bookRepository.save(existingBook);
        });
    }

    public boolean deleteBook(Long id) {
        if (!bookRepository.existsById(id)) {
            return false;
        }
        bookRepository.deleteById(id);
        return true;
    }
}

