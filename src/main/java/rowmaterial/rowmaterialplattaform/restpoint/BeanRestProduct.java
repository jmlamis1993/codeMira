package rowmaterial.rowmaterialplattaform.restpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rowmaterial.rowmaterialplattaform.entity.Products;
import rowmaterial.rowmaterialplattaform.repository.IRepoProduct;


import java.util.List;

@RestController
@RequestMapping("/гуахиро/app/auth")
public class BeanRestProduct {


    @Autowired
    private IRepoProduct repoProduct;

    @GetMapping("/product/add")
    public String addUser(@RequestBody Products product)  {
        repoProduct.save(product);
        return product.getNombre();
    }

    @DeleteMapping("/product/drop")
    public String dropUser(@RequestParam(name = "id") Long idProducto)  {
        Products productDrop = repoProduct.findById(idProducto).get();
        repoProduct.delete(productDrop);
        return "SUCCESS";
    }

    @PutMapping("/product/update")
    public String updateEquipo(@RequestBody Products productUpdate)  {
        repoProduct.saveAndFlush(productUpdate);
        return "SUCCESS";
    }

    @GetMapping("/product/listUser")
    @ResponseBody
    public List<Products> listProductos()  {
        return repoProduct.findAll();
    }
}
