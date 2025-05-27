package soap.model;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "tracking_event")
@XmlRootElement(name = "event")
@XmlAccessorType(XmlAccessType.FIELD)

public class TrackingEvent{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fecha", nullable = false)
    private LocalDateTime date;

    @Column(name = "descripción", nullable = false, length = 100)
    private String description;

    @Column(name = "localización", nullable = false, length = 100)
    private String location;


    @XmlTransient
    @ManyToOne
    @JoinColumn(name = "package_express_id")
    private PackageExpress packageExpress;

    public TrackingEvent() {
    }

    public TrackingEvent(Long id, LocalDateTime date, String description,
                         String location, PackageExpress packageExpress) {
        this.id = id;
        this.date = date;
        this.description = description;
        this.location = location;
        this.packageExpress = packageExpress;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public PackageExpress getPackageExpress() {
        return packageExpress;
    }

    public void setPackageExpress(PackageExpress packageExpress) {
        this.packageExpress = packageExpress;
    }
}
