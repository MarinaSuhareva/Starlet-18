package ru.netology.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.exception.NotFoundException;


public class ProductRepositoryTest {


    Product book1 = new Book(1, "Солярис", 520, "С.Лем");
    Product book2 = new Book(2, "Сказки", 350, "А.С.Пушкин");
    Product book3 = new Book(3, "Юмористические рассказы", 735, "А.Чехов");
    Product book4 = new Book(4, "учение Дона Хуана", 1100, "К.Кастанеда");
    Product phone1 = new Smartphone(5, "iPhone SE", 27000, "Apple Inc");
    Product phone2 = new Smartphone(6, "iPhone XR", 38000, "Apple Inc");
    Product phone3 = new Smartphone(7, "Nokia 520", 7500, "Nokia Corporation");
    Product phone4 = new Smartphone(8, "Philips E590", 6250, "Philips N.V");


    @Test
    public void removeByIdProduct() {
        ProductRepository repository = new ProductRepository();
        repository.save(book1);
        repository.save(book2);
        repository.save(book3);
        repository.save(book4);
        repository.save(phone1);
        repository.save(phone2);
        repository.save(phone3);
        repository.save(phone4);

        repository.removeById(4);

        Product[] actual = repository.findAll();
        Product[] expected = {book1, book2, book3, phone1, phone2, phone3, phone4};
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void removeByIdProduct2() {
        ProductRepository repository = new ProductRepository();
        repository.save(book1);
        repository.save(book2);
        repository.save(book3);
        repository.save(book4);
        repository.save(phone1);
        repository.save(phone2);
        repository.save(phone3);
        repository.save(phone4);

        assertThrows(NotFoundException.class, () -> {
            repository.removeById(9);
        });

    }
}
