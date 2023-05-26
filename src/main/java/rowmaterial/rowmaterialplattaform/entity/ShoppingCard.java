package rowmaterial.rowmaterialplattaform.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.apache.catalina.User;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@Entity
@Table(name = "shoping_card")
public class ShoppingCard implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_shoping_card;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "productId")
    private Products product;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_userplattform", referencedColumnName = "id_user_plattform")
    private Usuario user;

    /*****************************Constructor***************************************************/


    /***************************Gets y Sets*********************************************/
    public void setId_shoping_card(Long idShopingCard) {
        this.id_shoping_card = idShopingCard;
    }

    public Long getId_shoping_card() {
        return id_shoping_card;
    }
}
