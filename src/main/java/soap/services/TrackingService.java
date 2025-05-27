package soap.services;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import soap.dto.GetTrackingStatusResponse;

@WebService(name = "TrackingService")
    public interface TrackingService {

        @WebMethod(operationName = "GetTrackingStatus")
        @WebResult(name = "GetTrackingStatusResponse")
        GetTrackingStatusResponse getTrackingStatus(
                @WebParam(name = "trackingNumber") String trackingNumber
        );
}
