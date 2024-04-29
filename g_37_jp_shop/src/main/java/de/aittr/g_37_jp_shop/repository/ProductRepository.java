package de.aittr.g_37_jp_shop.repository;

import de.aittr.g_37_jp_shop.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Long> {

    // здесь может быть ничего и не написано

    // в данном случае тело метода и SQL запрос
    // будут сгенерированы фреймворком
    // Product findByTitle(String title);

    // в данном случае тело метода будет сгенерировано
    // фреймворком, но сам SQL запрос он применит тот,
    // который мы ему дали
    @Query(value = "SELECT * FROM product WHERE title = :title", nativeQuery = true)
    Product findByTitle(String title);

    // если названия разные (запроса и колонки в БД)
    // @Query(value = "SELECT * FROM product WHERE title = :title", nativeQuery = true)
    // Product findByTitle(@Param("title") String productTitle);
}
