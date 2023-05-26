package rowmaterial.rowmaterialplattaform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rowmaterial.rowmaterialplattaform.entity.Sales;
import rowmaterial.rowmaterialplattaform.entity.Usuario;

@Repository
public interface IRepoSales extends JpaRepository<Sales, Long> {



}
