package sit.int204.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sit.int204.backend.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}