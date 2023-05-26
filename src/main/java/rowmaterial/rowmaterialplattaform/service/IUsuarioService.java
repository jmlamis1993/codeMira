package rowmaterial.rowmaterialplattaform.service;





import rowmaterial.rowmaterialplattaform.entity.Usuario;

import java.util.List;

public interface IUsuarioService {

    public Usuario salvar(Usuario usuario);
    public Usuario findById(Long id);
    public Usuario findByName(String nombre);
    public List<Usuario> findAll();
    public void eliminar(Long id);
}
