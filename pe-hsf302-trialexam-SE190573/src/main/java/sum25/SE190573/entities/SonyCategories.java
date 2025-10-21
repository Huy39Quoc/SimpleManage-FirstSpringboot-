package sum25.SE190573.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "SonyCategories")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SonyCategories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CateID")
    private int cateID;

    @Column(name = "CateName", length = 50)
    private String cateName;

    @Column(name = "Status", length = 10)
    private String status;

    @OneToMany(mappedBy = "category")
    private List<SonyProducts> productsList = new ArrayList<>();

    public SonyCategories(String cateName, String status) {
        this.cateName = cateName;
        this.status = status;
    }
}
