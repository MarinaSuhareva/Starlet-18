package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Product;
import ru.netology.domain.Book;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

public class ProductManagerTest {
    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);

    Product book1 = new Book(1, "Солярис", 520, "С.Лем");
    Product book2 = new Book(2, "Сказки", 350, "А.С.Пушкин");
    Product book3 = new Book(3, "Юмористические рассказы", 735, "А.Чехов");
    Product book4 = new Book(4, "учение Дона Хуана", 1100, "К.Кастанеда");
    Product phone1 = new Smartphone(5, "iPhone SE", 27000, "Apple Inc");
    Product phone2 = new Smartphone(6, "iPhone XR", 38000, "Apple Inc");
    Product phone3 = new Smartphone(7, "Nokia 520", 7500, "Nokia Corporation");
    Product phone4 = new Smartphone(8, "Philips E590", 6250, "Philips N.V");

    @Test
    public void findTheProductByName() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        manager.add(phone1);
        manager.add(phone2);
        manager.add(phone3);
        manager.add(phone4);


        Product[] actual = manager.searchBy("iP");
        Product[] expected = new Product[]{phone1, phone2};
        Assertions.assertArrayEquals(expected, actual);

    }


    @Test
    public void findTheProductByName2() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        manager.add(phone1);
        manager.add(phone2);
        manager.add(phone3);
        manager.add(phone4);

        Product[] actual = manager.searchBy("English");
        Product[] expected = new Product[]{};
        Assertions.assertArrayEquals(expected, actual);
    }
}
