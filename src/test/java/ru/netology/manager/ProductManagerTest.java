package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    private ProductManager manager = new ProductManager();

    private Smartphone iPhone1 = new Smartphone(1, "iPhone 13", 69900, "Apple");
    private Smartphone iPhone2 = new Smartphone(2, "iPhone 12", 54900, "Apple");
    private Smartphone iPhone3 = new Smartphone(3, "iPhone SE", 39900, "Apple");
    private Smartphone samsung = new Smartphone(4, "Samsung Galaxy", 88890, "Samsung");
    private Product product = new Product(6, "Xiaomi", 65800);


    private Book book1 = new Book(1, "Book1", 255, "Steinbeck");
    private Book book2 = new Book(2, "Book2", 150, "Maugham");
    private Book book3 = new Book(3, "Book3", 250, "Faulkner");
    private Book siesta = new Book(4, "Siesta", 350, "Hemingway");


    @Test
    void shouldSearchSmartphoneByName() {

        String textForSearch = "iPhone";

        manager.add(iPhone1);
        manager.add(samsung);

        Product[] expected = new Product[]{iPhone1};
        Product[] actual = manager.searchBy(textForSearch);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchSeveralSmartphonesByName() {

        String textForSearch = "iPhone";

        manager.add(iPhone1);
        manager.add(samsung);
        manager.add(iPhone3);

        Product[] expected = new Product[]{iPhone1, iPhone3};
        Product[] actual = manager.searchBy(textForSearch);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchSmartphoneByManufacturer() {

        String textForSearch = "Apple";

        manager.add(iPhone2);
        manager.add(samsung);

        Product[] expected = new Product[]{iPhone2};
        Product[] actual = manager.searchBy(textForSearch);
        assertArrayEquals(expected, actual);

    }

    @Test
    void shouldSearchSmartphoneByNotExistingManufacturer() {

        String textForSearch = "Xiaomi";

        manager.add(iPhone2);
        manager.add(samsung);
        manager.add(product);

        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy(textForSearch);
        assertArrayEquals(expected, actual);

    }

    @Test
    void shouldSearchBookByName() {

        String textForSearch = "Book";


        manager.add(book2);
        manager.add(siesta);

        Product[] expected = new Product[]{book2};
        Product[] actual = manager.searchBy(textForSearch);
        assertArrayEquals(expected, actual);


    }

    @Test
    void shouldSearchBookByAuthor() {

        String textForSearch = "Maugham";

        manager.add(book2);
        manager.add(siesta);

        Product[] expected = new Product[]{book2};
        Product[] actual = manager.searchBy(textForSearch);
        assertArrayEquals(expected, actual);


    }


}