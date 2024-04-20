package app.domain;

import java.util.Locale;
import java.util.Objects;

public class Product {

    private Long id;
    private String name;
    private double price;
    private String article;

    public Product(Long id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.price, price) == 0 && Objects.equals(id, product.id) && Objects.equals(name, product.name) && Objects.equals(article, product.article);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, article);
    }

    @Override
    public String toString() {
        // Продукт: ИД - 4, наименование - Банан, цена - 180.00, артикул - Б-5
//        return "Продукт: ИД - " + id + ", наименование - " + name + ", цена - " + price + ", артикул - " + article;
        return String.format(Locale.US, "Продукт: ИД - %d, наименование - %s, цена - %.2f, артикул - %s",
                id, name, price, article);
    }
}