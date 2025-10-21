package sum25.SE190573.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sum25.SE190573.entities.SonyCategories;

@Repository
public interface CategoriesRepository extends JpaRepository<SonyCategories, Integer> {
}
