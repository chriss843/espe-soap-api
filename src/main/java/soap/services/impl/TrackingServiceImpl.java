package soap.services.impl;

import jakarta.jws.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import soap.dto.GetTrackingStatusResponse;
import soap.model.PackageExpress;
import soap.model.TrackingEvent;
import soap.repository.PackageExpressRepository;
import soap.repository.TrackingEventRepository;
import soap.services.TrackingService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@WebService(
        endpointInterface = "soap.services.TrackingService", serviceName = "TrackingService",
        targetNamespace = "http://logistica.com/ws/tracking"
)
public class TrackingServiceImpl implements TrackingService {


    @Autowired
    private PackageExpressRepository packageExpressRepository;

    @Override
    public GetTrackingStatusResponse getTrackingStatus(String trackingNumber) {
        Optional<PackageExpress> packageOptional = packageExpressRepository.findByTrackingNumber(trackingNumber);
        GetTrackingStatusResponse response = new GetTrackingStatusResponse();

        if (packageOptional.isPresent()) {
            PackageExpress packageFound = packageOptional.get();
            response.setStatus(packageFound.getStatus());
            response.setCurrentLocation(packageFound.getCurrentLocation());
            response.setEstimatedDeliveryDate(packageFound.getEstimatedDeliveryDate());

            GetTrackingStatusResponse.History history = new GetTrackingStatusResponse.History();

            if (packageFound.getTrackingEvent() != null && !packageFound.getTrackingEvent().isEmpty()) {
                List<GetTrackingStatusResponse.Event> events = packageFound.getTrackingEvent().stream()
                        .sorted(Comparator.comparing(TrackingEvent::getDate))
                        .map(event -> {
                            GetTrackingStatusResponse.Event soapEvent = new GetTrackingStatusResponse.Event();
                            soapEvent.setDate(event.getDate().toLocalDate());
                            soapEvent.setDescription(event.getDescription());
                            soapEvent.setLocation(event.getLocation());
                            return soapEvent;
                        }).collect(Collectors.toList());
                history.setEvent(events);
            } else {
                history.setEvent(new ArrayList<>());
            }
            response.setHistory(history);
        } else {
            response.setStatus("Paquete no encontrado");
            response.setCurrentLocation("N/A");
            response.setEstimatedDeliveryDate(null);
            response.setHistory(new GetTrackingStatusResponse.History());
            response.getHistory().setEvent(new ArrayList<>());
        }
        return response;
    }

}