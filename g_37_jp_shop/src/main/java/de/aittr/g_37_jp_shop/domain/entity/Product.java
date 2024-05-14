package de.aittr.g_37_jp_shop.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.springframework.lang.NonNull;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    @NotNull(message = "Product title cannot be null")
    // null и пустая строка "" - это разные вещи.
    @NotBlank(message = "Product title cannot be empty")

//     например, нам нужно определенное заполнения данного поля:
//     Banana - V
//     banana - X
//     Ba -X
//     BANANA - X
//     Banana3 - X
//     Banana# - X
//     Банан - X

    @Pattern(
            regexp = "[A-Z][a-z]{2,}",
            message = "Product title should be at least 3 character length, " +
                    "start with capital letter and may contain only latin characters"
    )
    private String title;

    @Column(name = "price")
    @NotNull(message = "Product price cannot be null")
    @DecimalMin(
            value = "0.01",
            message = "Product price should be equal to or greater than 0.01"
    )
    @DecimalMax(
            value = "100000.00",
            inclusive = false,
            message = "Product price should be lesser than 100 000.- €"
    )
    private BigDecimal price;

    @Column(name = "isActive")
    private boolean isActive;
    @Column(name = "image")
    private String image;

    public Long getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public BigDecimal getPrice() {
        return price;
    }
    public boolean isActive() {
        return isActive;
    }
    public String getImage() {
        return image;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    public void setActive(boolean active) {
        isActive = active;
    }
    public void setImage(String image) {
        this.image = image;
    }

    public Product() {
    }
    public Product(Long id, String title, BigDecimal price, boolean isActive) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.isActive = isActive;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (isActive != product.isActive) return false;
        if (!Objects.equals(id, product.id)) return false;
        if (!Objects.equals(title, product.title)) return false;
        if (!Objects.equals(price, product.price)) return false;
        return Objects.equals(image, product.image);
    }
    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (isActive ? 1 : 0);
        result = 31 * result + (image != null ? image.hashCode() : 0);
        return result;
    }

    @Override
    public String toString(){
        return String.format("Product: ID - %d, title - %s, price - %.2f, active - %s",
                id, title, price, isActive ? "yes" : "no");
    }
}
