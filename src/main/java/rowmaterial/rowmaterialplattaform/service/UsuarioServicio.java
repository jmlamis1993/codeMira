package rowmaterial.rowmaterialplattaform.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rowmaterial.rowmaterialplattaform.entity.Usuario;
import rowmaterial.rowmaterialplattaform.repository.IRepoUser;


import java.util.List;

@Service
public class UsuarioServicio implements IUsuarioService{

    @Autowired
    private IRepoUser repoUser;

    @Override
    public Usuario salvar(Usuario usuario) {
        //usuario.setPassword(passwordEncoder().encode(usuario.getPassword()));
        return repoUser.save(usuario);
    }

    @Override
    public Usuario findById(Long id) {
        return repoUser.findById(id).get();
    }

    @Override
    public Usuario findByName(String nombre) {
        return repoUser.findByUserName(nombre).orElse(null);
    }

    @Override
    public List<Usuario> findAll() {
        return repoUser.findAll();
    }

    @Override
    public void eliminar(Long id) {
        repoUser.deleteById(id);
    }

    /*public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }*/
}
