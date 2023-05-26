package rowmaterial.rowmaterialplattaform.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import rowmaterial.rowmaterialplattaform.enumerated.TypeProduct;
import rowmaterial.rowmaterialplattaform.enumerated.UsuarioRol;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@Entity(name = "product")
public class Products implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_farmer_product", nullable = false)
    private Long idFarmerProduct;

    //@NotNull(message = "Debe tener valores esta Propiedad")
    //@NotEmpty(message = "NO puede contener elemento vacio")
    @Column(name = "price_tag",nullable = false)
    private int price;

    //@NotNull(message = "Debe tener valores esta Propiedad")
    //@NotEmpty(message = "NO puede contener elemento vacio")
    @Column(name = "nombre",nullable = false)
    private String nombre;

    //@NotNull(message = "Debe tener valores esta Propiedad")
    //@NotEmpty(message = "NO puede contener elemento vacio")
    @Column(name = "image",nullable = false)
    private  String image;

    //@NotNull(message = "Debe tener valores esta Propiedad")
    //@NotEmpty(message = "NO puede contener elemento vacio")
    @Column(name = "description",nullable = false)
    private String description;

    @Column(name = "ecofriendly",nullable = false)
    private boolean ecofriendly;

    @Column(name = "type_product",nullable = false)
    @Enumerated
    private TypeProduct typeProduct;

    /***************************Relations********************************/

    @OneToMany(mappedBy="offer", cascade = CascadeType.REMOVE, fetch=FetchType.EAGER)
    private List<Offers> offersProducts = new ArrayList<Offers>();

    @OneToMany(mappedBy="product", cascade = CascadeType.REMOVE, fetch=FetchType.EAGER)
    private List<ShoppingCard> Shop = new ArrayList<ShoppingCard>();

    @ManyToMany
    List<Usuario> user;

    @ManyToMany
    @JoinTable(
            name = "ReviewsByProducts",
            joinColumns = @JoinColumn(name = "id_farmer_product"),
            inverseJoinColumns = @JoinColumn(name = "id_delivery"))
    List<DeliveryStats> deliveryStats;

    @ManyToMany
    @JoinTable(
            name = "SalesByProducts",
            joinColumns = @JoinColumn(name = "id_farmer_product"),
            inverseJoinColumns = @JoinColumn(name = "id_sales"))
    List<Sales> sales;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "locationId")
    private Location locationProduct;

    /***************************Constructor******************************/

    public Products(int price, String nombre, String image, String description, TypeProduct typeProduct) {
        this.price = price;
        this.nombre = nombre;
        this.image = image;
        this.description = description;
        this.typeProduct = typeProduct;
    }

    public Products() {

    }

    /*********************Gets and Sets*****************************************************/

    public Long getIdFarmerProduct() {
        return idFarmerProduct;
    }

    public void setIdFarmerProduct(Long idFarmerProduct) {
        this.idFarmerProduct = idFarmerProduct;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TypeProduct getTypeProduct() {
        return typeProduct;
    }

    public void setTypeProduct(TypeProduct typeProduct) {
        this.typeProduct = typeProduct;
    }

    public List<Offers> getOffersProducts() {
        return offersProducts;
    }

    public void setOffersProducts(List<Offers> offersProducts) {
        this.offersProducts = offersProducts;
    }

    public List<Usuario> getUser() {
        return user;
    }

    public void setUser(List<Usuario> user) {
        this.user = user;
    }

    public List<DeliveryStats> getDeliveryStats() {
        return deliveryStats;
    }

    public void setDeliveryStats(List<DeliveryStats> deliveryStats) {
        this.deliveryStats = deliveryStats;
    }

    public List<Sales> getSales() {
        return sales;
    }

    public void setSales(List<Sales> sales) {
        this.sales = sales;
    }

    public boolean isEcofriendly() {
        return ecofriendly;
    }

    public void setEcofriendly(boolean ecofriendly) {
        this.ecofriendly = ecofriendly;
    }

    public List<ShoppingCard> getShop() {
        return Shop;
    }

    public void setShop(List<ShoppingCard> shop) {
        Shop = shop;
    }



    /***************************Utils******************************************/

}
