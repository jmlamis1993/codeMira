package rowmaterial.rowmaterialplattaform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rowmaterial.rowmaterialplattaform.entity.Products;
import rowmaterial.rowmaterialplattaform.entity.Usuario;

import java.util.Optional;

@Repository
public interface IRepoProduct extends JpaRepository<Products, Long> {

    public Optional<Products> findByNombre(String nombre);
}
