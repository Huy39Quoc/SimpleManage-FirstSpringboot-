package sum25.SE190573.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "SonyProducts")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SonyProducts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProductID")
    private long productID;

    @Column(name = "ProductName", length = 50)
    private String productName;

    @Column(name = "Price")
    private int price;

    @Column(name = "Stock")
    private int stock;

    @Column(name = "CreatedAt")
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "CateID")
    private SonyCategories category;

    public SonyProducts(String productName, int price, int stock, LocalDateTime createdAt, SonyCategories category) {
        this.productName = productName;
        this.price = price;
        this.stock = stock;
        this.createdAt = createdAt;
        this.category = category;
    }
}
