package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.domain.NotFoundException;
import ru.netology.repository.ProductRepository;
import ru.netology.manager.ProductManager;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();

    private Book book1 = new Book(1, "Book1", 255, "Steinbeck");
    private Book book2 = new Book(2, "Book2", 150, "Maugham");
    private Book book3 = new Book(3, "Book3", 250, "Faulkner");
    private Book siesta = new Book(4, "Siesta", 350, "Hemingway");


    @Test
    void shouldRemoveByExistingId() {

        repository.save(book1);
        repository.save(book2);
        repository.save(book3);

        repository.removeById(3);

        Product[] expected = new Product[]{book1, book2};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);


    }

    @Test
    void shouldRemoveByNotExistingId() {

        repository.save(book1);
        repository.save(book2);

        assertThrows(NotFoundException.class, () -> {
            repository.removeById(7);

        });


    }

}