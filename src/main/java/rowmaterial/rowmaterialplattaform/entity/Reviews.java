package rowmaterial.rowmaterialplattaform.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import rowmaterial.rowmaterialplattaform.enumerated.DeliveryStatus;
import rowmaterial.rowmaterialplattaform.enumerated.TypeProduct;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@Entity(name = "review")
public class Reviews {
    @Id
    @Column(name = "id_delivery",nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_delivery;

    @Column(name = "clasification",nullable = false)
    @Enumerated
    private DeliveryStatus deliveryStatus;

    @Column(name = "review",nullable = false)
    private String review;

    /********************************Relation********************************************************/

    @ManyToMany
    List<Usuario> userRivews;

    @ManyToMany
    List<Products> userProducts;

    /******************************Constructor*************************************************/

    public Reviews(DeliveryStatus deliveryStatus, String review) {
        this.deliveryStatus = deliveryStatus;
        this.review = review;
    }

    /**************************Gets y Sets*******************************************/

    public void setId(Long id) {
        this.id_delivery = id;
    }

    public Long getId() {
        return id_delivery;
    }
}
