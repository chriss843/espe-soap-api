package soap.config;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import jakarta.xml.ws.Endpoint;
import soap.services.impl.TrackingServiceImpl;
import soap.services.impl.PackageExpressServiceImpl;

@Configuration
public class CxfConfig {
    @Bean
    public Endpoint trackingEndpoint(Bus bus, TrackingServiceImpl trackingService) {
        EndpointImpl endpoint = new EndpointImpl(bus, trackingService);
        endpoint.publish("/TrackingService");
        return endpoint;
    }
    @Bean
    public Endpoint packageExpressEndpoint(Bus bus, PackageExpressServiceImpl packageExpressService) {
        EndpointImpl endpoint = new EndpointImpl(bus, packageExpressService);
        endpoint.publish("/PackageExpressService");
        return endpoint;
    }

}
