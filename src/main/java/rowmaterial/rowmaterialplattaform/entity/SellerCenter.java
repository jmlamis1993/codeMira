package rowmaterial.rowmaterialplattaform.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import rowmaterial.rowmaterialplattaform.enumerated.TypeProduct;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@Entity(name = "seller_center")
public class SellerCenter implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_seller", nullable = false)
    private Long id_seller;


    //@NotNull(message = "Debe tener valores esta Propiedad")
    //@NotEmpty(message = "NO puede contener elemento vacio")
    @Column(name = "name_center",nullable = false)
    private String nameCenter;

    @Column(name = "type_seller",nullable = false)
    @Enumerated
    private TypeProduct typeProduct;

    @Column(name = "email_seller",nullable = false)
    private String emailSeller;


    /******************Constructor****************************************************************/

    public SellerCenter(String nameCenter, TypeProduct typeProduct, String emailSeller) {
        this.nameCenter = nameCenter;
        this.typeProduct = typeProduct;
        this.emailSeller = emailSeller;
    }

    public SellerCenter() {
    }

    /******************Get y Sets*******************************************************/
    public void setId_seller(Long idSeller) {
        this.id_seller = idSeller;
    }

    public Long getId_seller() {
        return id_seller;
    }


    public String getNameCenter() {
        return nameCenter;
    }

    public void setNameCenter(String nameCenter) {
        this.nameCenter = nameCenter;
    }

    public TypeProduct getTypeProduct() {
        return typeProduct;
    }

    public void setTypeProduct(TypeProduct typeProduct) {
        this.typeProduct = typeProduct;
    }

    public String getEmailSeller() {
        return emailSeller;
    }

    public void setEmailSeller(String emailSeller) {
        this.emailSeller = emailSeller;
    }
}
