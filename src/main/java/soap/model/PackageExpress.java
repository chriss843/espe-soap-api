package soap.model;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "package_express")
@XmlRootElement(name = "packageExpress")
@XmlAccessorType(XmlAccessType.FIELD)


public class PackageExpress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column(name = "tracking_number", unique = true, nullable = false)
    private String trackingNumber;

    @Column(name = "nombreRemitente", nullable = false, length = 50)
    private String senderName;

    @Column(name = "nombreDestinatario", nullable = false, length = 50)
    private String receiverName;

    @Column(name = "ciudadOrigen", nullable = false, length = 50)
    private String origin;

    @Column(name = "ciudadDestino", nullable = false, length = 50)
    private String destination;

    @Column(name = "pesoPaquete", nullable = false)
    private double weight;

    @Column(name = "dimensionesPaquete", nullable = false)
    private String dimensions;

    @Column(name = "estadoPaquete", nullable = false, length = 100)
    private String status;

    @Column(name = "ubicacionActual", nullable = false, length = 50)
    private String currentLocation;

    @Column(name = "fechaEstimadaEntrega")
    private LocalDate estimatedDeliveryDate;

    @XmlTransient
    @OneToMany(mappedBy = "packageExpress", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<TrackingEvent> trackingEvent;

    public PackageExpress() {
    }

    public PackageExpress(Long id, String trackingNumber, String senderName,
                          String receiverName, String origin, String destination,
                          double weight, String dimensions, String status, String currentLocation,
                          LocalDate estimatedDeliveryDate, List<TrackingEvent> trackingEvent) {

        this.id = id;
        this.trackingNumber = trackingNumber;
        this.senderName = senderName;
        this.receiverName = receiverName;
        this.origin = origin;
        this.destination = destination;
        this.weight = weight;
        this.dimensions = dimensions;
        this.status = status;
        this.currentLocation = currentLocation;
        this.estimatedDeliveryDate = estimatedDeliveryDate;
        this.trackingEvent = trackingEvent;

    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTrackingNumber() {
        return trackingNumber;
    }
    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }
    public String getSenderName() {
        return senderName;
    }
    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getReceiverName() {
        return receiverName;
    }
    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }

    public LocalDate getEstimatedDeliveryDate() {
        return estimatedDeliveryDate;
    }

    public void setEstimatedDeliveryDate(LocalDate estimatedDeliveryDate) {
        this.estimatedDeliveryDate = estimatedDeliveryDate;
    }

    public List<TrackingEvent> getTrackingEvent() {
        return trackingEvent;
    }

    public void setTrackingEvent(List<TrackingEvent> trackingEvent) {
        this.trackingEvent = trackingEvent;
    }
}