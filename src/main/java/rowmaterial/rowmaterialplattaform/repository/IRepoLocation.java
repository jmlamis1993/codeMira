package rowmaterial.rowmaterialplattaform.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rowmaterial.rowmaterialplattaform.entity.Location;
import rowmaterial.rowmaterialplattaform.entity.Usuario;

import java.util.List;
import java.util.Optional;

@Repository
public interface IRepoLocation extends JpaRepository<Location, Long> {

    public List<Location> findAll();

}
