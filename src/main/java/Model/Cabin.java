package Model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cabin")
public class Cabin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String brand;
    private Integer year;
    private String description;

    @OneToMany(cascade = {CascadeType.PERSIST})
    @JsonIgnoreProperties({"cabin", "client"})

    private List<Messages> messages;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    @JsonIgnoreProperties("cabin")
    public Category category;

    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "cabin")
    @JsonIgnoreProperties({"cabin", "messages"})

    private List<Reservation> reservations;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
