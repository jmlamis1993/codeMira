package rowmaterial.rowmaterialplattaform.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import rowmaterial.rowmaterialplattaform.enumerated.PaymentType;
import rowmaterial.rowmaterialplattaform.enumerated.SaleStatus;
import rowmaterial.rowmaterialplattaform.enumerated.TypeProduct;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@Entity(name = "sales")
public class Sales implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_sales", nullable = false)
    private Long id_sales;

    //@NotNull(message = "Debe tener valores esta Propiedad")
    //@NotEmpty(message = "NO puede contener elemento vacio")
    @Column(name = "fecha_sale")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaSale;

    @Column(name = "sale_status",nullable = false)
    @Enumerated
    private SaleStatus saleStatus;

    @Column(name = "payment_type",nullable = false)
    @Enumerated
    private PaymentType paymentType;

    /**********************Gets y Sets**********************************************************/

    @ManyToMany
    @JoinTable(
            name = "SalesByUsers",
            joinColumns = @JoinColumn(name = "id_user_plattform"),
            inverseJoinColumns = @JoinColumn(name = "id_farmer_product"))
    List<Products> products;

    /***********************Constructors*********************************************************/

    public Sales(Date fechaSale, SaleStatus saleStatus, PaymentType paymentType) {
        this.fechaSale = fechaSale;
        this.saleStatus = saleStatus;
        this.paymentType = paymentType;
    }

    public Sales() {
    }

    /******************************Gets y Sets*************************************************/

    public void setId_sales(Long idSales) {
        this.id_sales = idSales;
    }

    public Long getId_sales() {
        return id_sales;
    }
}
