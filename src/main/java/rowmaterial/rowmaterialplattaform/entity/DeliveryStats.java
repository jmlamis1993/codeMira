package rowmaterial.rowmaterialplattaform.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import rowmaterial.rowmaterialplattaform.enumerated.DeliveryStatus;
import rowmaterial.rowmaterialplattaform.enumerated.TypeProduct;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@Entity
public class DeliveryStats implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_delivery", nullable = false)
    private String id_delivery;

    //@NotNull(message = "Debe tener valores esta Propiedad")
    //@NotEmpty(message = "NO puede contener elemento vacio")
    @Column(name = "day",nullable = false)
    private int day;

    @Column(name = "month",nullable = false)
    private int month;

    @Column(name = "season",nullable = false)
    private int season;

    @Column(name = "delivery_status",nullable = false)
    @Enumerated
    private DeliveryStatus deliveryStatus;


    /************************Constructor*******************************************************/

    public DeliveryStats(int day, int month, int season, DeliveryStatus deliveryStatus) {
        this.day = day;
        this.month = month;
        this.season = season;
        this.deliveryStatus = deliveryStatus;
    }

    public DeliveryStats() {

    }

    /***********************Gets y Sets**********************************************/

    public void setId_delivery(String idDelivery) {
        this.id_delivery = idDelivery;
    }

    public String getId_delivery() {
        return id_delivery;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
    }

    public DeliveryStatus getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(DeliveryStatus deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }
}
