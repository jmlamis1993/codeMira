package rowmaterial.rowmaterialplattaform.restpoint;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rowmaterial.rowmaterialplattaform.entity.Products;
import rowmaterial.rowmaterialplattaform.entity.Usuario;
import rowmaterial.rowmaterialplattaform.repository.IRepoUser;


import java.util.List;

@RestController
@RequestMapping("/гуахиро/app/auth")
public class BeanRestUsuario {

    @Autowired
    private IRepoUser repoUser;

    @GetMapping("/user/add")
    public String addUser(@RequestBody Usuario user)  {
        repoUser.save(user);
        return user.getUsername();
    }

    @DeleteMapping("/user/drop")
    public String dropUser(@RequestParam(name = "id") Long idUser)  {
        Usuario userDrop = repoUser.findById(idUser).get();
        repoUser.delete(userDrop);
        return "SUCCESS";
    }

    @PutMapping("/user/update")
    public String updateEquipo(@RequestBody Usuario userUpdate)  {
        repoUser.saveAndFlush(userUpdate);
        return "SUCCESS";
    }

    @GetMapping("/user/listUser")
    @ResponseBody
    public List<Usuario> listUsers()  {
        return repoUser.findAll();
    }

    /*******************Utils***********************************/

    public String addProductUser(@RequestParam(name = "idUser") Long idUser , @RequestParam(name = "producto") Products producto)  {
        Usuario userComanda = repoUser.findById(idUser).get();
        userComanda.getProducts().add(producto);
        repoUser.saveAndFlush(userComanda);
        return "SUCCESS";
    }
}
