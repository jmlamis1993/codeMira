package rowmaterial.rowmaterialplattaform.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import rowmaterial.rowmaterialplattaform.enumerated.OfferType;


import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@Entity(name = "offers")
public class Offers implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_offer",nullable = false)
    private Long id_offer;

    @Column(name = "type_offers",nullable = false)
    @Enumerated
    private OfferType offerType;

    @Column(name = "selected",nullable = false)
    private boolean activeOffer;

    /*******************************Relations*********************************************************/

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "productId")
    private Products offer;

    /******************************Constructor*****************************************************/

    public Offers(OfferType offerType, boolean activeOffer) {
        this.offerType = offerType;
        this.activeOffer = activeOffer;
    }

    public Offers() {
    }

    /******************************Gets y Sets****************************************************/
    public void setId_offer(Long idOffer) {
        this.id_offer = idOffer;
    }

    public Long getId_offer() {
        return id_offer;
    }

    public OfferType getOfferType() {
        return offerType;
    }

    public void setOfferType(OfferType offerType) {
        this.offerType = offerType;
    }

    public boolean isActiveOffer() {
        return activeOffer;
    }

    public void setActiveOffer(boolean activeOffer) {
        this.activeOffer = activeOffer;
    }

    public Products getOffer() {
        return offer;
    }

    public void setOffer(Products offer) {
        this.offer = offer;
    }
}
