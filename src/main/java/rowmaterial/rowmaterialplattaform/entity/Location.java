package rowmaterial.rowmaterialplattaform.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import rowmaterial.rowmaterialplattaform.enumerated.RegionsRepublica;
import rowmaterial.rowmaterialplattaform.enumerated.TypeProduct;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@Entity(name = "location")
public class Location implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_location", nullable = false)
    private Long id_location;

    @Column(name = "disctric",nullable = false)
    @Enumerated
    private RegionsRepublica regionsRepublica;

    /************************Relation*******************************************/

    @OneToMany(mappedBy="locationProduct", cascade = CascadeType.REMOVE, fetch=FetchType.EAGER)
    private List<Products> products = new ArrayList<Products>();

    @OneToMany(mappedBy="locationuser", cascade = CascadeType.REMOVE, fetch=FetchType.EAGER)
    private List<Usuario> users = new ArrayList<Usuario>();

    /************************Cnstructor*****************************************/
    public Location(RegionsRepublica regionsRepublica) {
        this.regionsRepublica = regionsRepublica;
    }

    public Location() {


    }
}
