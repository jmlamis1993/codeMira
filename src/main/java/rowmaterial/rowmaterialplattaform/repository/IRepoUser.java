package rowmaterial.rowmaterialplattaform.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rowmaterial.rowmaterialplattaform.entity.Usuario;


import java.util.Optional;

@Repository
public interface IRepoUser extends JpaRepository<Usuario, Long> {

    public Optional<Usuario> findByUserName(String nombre);
    public Optional<Usuario> findByEmail(String email);
}
