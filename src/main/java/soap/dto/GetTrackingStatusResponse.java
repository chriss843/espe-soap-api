package soap.dto;

import jakarta.xml.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@XmlRootElement(name = "GetTrackingStatusResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class GetTrackingStatusResponse {

    private String status;
    private String currentLocation;
    private LocalDate estimatedDeliveryDate;
    private History history;

    @XmlAccessorType(XmlAccessType.FIELD)
    public static class History {
        private List<Event> event;

        public List<Event> getEvent() { return event; }
        public void setEvent(List<Event> event) { this.event = event; }
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    public static class Event {
        private LocalDate date;
        private String description;
        private String location;

        public LocalDate getDate() { return date; }
        public void setDate(LocalDate date) { this.date = date; }

        public String getDescription() { return description; }
        public void setDescription(String description) { this.description = description; }

        public String getLocation() { return location; }
        public void setLocation(String location) { this.location = location; }
    }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getCurrentLocation() { return currentLocation; }
    public void setCurrentLocation(String currentLocation) { this.currentLocation = currentLocation; }

    public LocalDate getEstimatedDeliveryDate() { return estimatedDeliveryDate; }
    public void setEstimatedDeliveryDate(LocalDate estimatedDeliveryDate) { this.estimatedDeliveryDate = estimatedDeliveryDate; }

    public History getHistory() { return history; }
    public void setHistory(History history) { this.history = history; }
}
