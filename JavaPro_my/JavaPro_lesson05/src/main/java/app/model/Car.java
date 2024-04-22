package app.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Car{

    private Long id;
    private String brand;
    private BigDecimal price;
    private int year;

    public Car() {
    }

    public Car(String brand, BigDecimal price, int year) {
        this.brand = brand;
        this.price = price;
        this.year = year;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setYear(int year) {
        this.year = year;
    }
    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (year != car.year) return false;
        if (!Objects.equals(id, car.id)) return false;
        if (!Objects.equals(brand, car.brand)) return false;
        return Objects.equals(price, car.price);
    }
    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (brand != null ? brand.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + year;
        return result;
    }

    @Override
    public String toString(){
        return String.format("Car: ID - %d, brand - %s, price - %.2f, year - %d",
                id, brand, price, year);
    }
}
