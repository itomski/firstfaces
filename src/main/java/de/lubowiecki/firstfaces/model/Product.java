package de.lubowiecki.firstfaces.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p") // JPQL
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String description;

    private LocalDate availableAt;

    private double price;

    public Product() {
    }

    public Product(String name, String description, LocalDate availableAt, double price) {
        this.name = name;
        this.description = description;
        this.availableAt = availableAt;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getAvailableAt() {
        return availableAt;
    }

    public void setAvailableAt(LocalDate availableAt) {
        this.availableAt = availableAt;
    }
}
