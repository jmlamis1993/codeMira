package rowmaterial.rowmaterialplattaform.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import rowmaterial.rowmaterialplattaform.enumerated.BasquectFrequency;
import rowmaterial.rowmaterialplattaform.enumerated.UsuarioRol;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable, UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_user_plattform", nullable = false)
    private Long id_usuario_plattform;

    //@NotNull(message = "Debe tener valores esta Propiedad")
    //@NotEmpty(message = "NO puede contener elemento vacio")
    @Column(name = "username",nullable = false)
    private String userName;

    @Column(name = "email",nullable = false)
    private String email;

    //@NotNull(message = "Debe tener valores esta Propiedad")
    //@NotEmpty(message = "NO puede contener elemento vacio")
    @Column(name = "password",nullable = false)
    private String password;

    @Column(name = "first_name",nullable = false)
    private String first_name;

    @Column(name = "last_name",nullable = false)
    private String last_name;

    @Column(name = "avatar",nullable = true)
    private String avatar;

    @Column(name = "phone_number",nullable = true)
    private String phone_number;

    @Column(name = "rol",nullable = false)
    @Enumerated
    private UsuarioRol rol;

    @Column(name = "basket_frecuency",nullable = true)
    @Enumerated
    private BasquectFrequency basquectFrequency;

    //@NotNull(message = "Debe tener valores esta Propiedad")
    @Column(name = "estado",nullable = false)
    private boolean active;

    public Usuario(String userName, String password, UsuarioRol rol, boolean active) {
        this.userName = userName;
        this.password = password;
        this.rol = rol;
        this.active = active;
    }

    /******************************Relations*****************************************************************/
    @ManyToMany
    @JoinTable(
            name = "ProductsByUsers",
            joinColumns = @JoinColumn(name = "id_user_plattform"),
            inverseJoinColumns = @JoinColumn(name = "id_farmer_product"))
    List<Products> products;

    @ManyToMany
    @JoinTable(
            name = "SalesByUsers",
            joinColumns = @JoinColumn(name = "id_user_plattform"),
            inverseJoinColumns = @JoinColumn(name = "id_sales"))
    List<Sales> sales;

    @OneToOne(mappedBy = "user")
    private ShoppingCard shoppingCard;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "locationId")
    private Location locationuser;


    /******************************Constructor*************************************************************/

    public Usuario(String userName, String email, String password, String first_name, String last_name, String avatar, String phone_number, UsuarioRol rol, boolean active) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.first_name = first_name;
        this.last_name = last_name;
        this.avatar = avatar;
        this.phone_number = phone_number;
        this.rol = rol;
        this.active = active;
    }

    public Usuario() {

    }

    /*****************************Get y Set******************************************************/
    public Long getId_usuario() {
        return id_usuario_plattform;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(rol.name()));
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UsuarioRol getRol() {
        return rol;
    }

    public void setRol(UsuarioRol rol) {
        this.rol = rol;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario_plattform = id_usuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }


    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public Long getId_usuario_plattform() {
        return id_usuario_plattform;
    }

    public void setId_usuario_plattform(Long id_usuario_plattform) {
        this.id_usuario_plattform = id_usuario_plattform;
    }

    public List<Products> getProducts() {
        return products;
    }

    public void setProducts(List<Products> products) {
        this.products = products;
    }

    public List<Sales> getSales() {
        return sales;
    }

    public void setSales(List<Sales> sales) {
        this.sales = sales;
    }

    public ShoppingCard getShoppingCard() {
        return shoppingCard;
    }

    public void setShoppingCard(ShoppingCard shoppingCard) {
        this.shoppingCard = shoppingCard;
    }

    public BasquectFrequency getBasquectFrequency() {
        return basquectFrequency;
    }

    public void setBasquectFrequency(BasquectFrequency basquectFrequency) {
        this.basquectFrequency = basquectFrequency;
    }
}
