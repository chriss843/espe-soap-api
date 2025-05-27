package soap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import soap.model.PackageExpress;

import java.util.Optional; // ¡Importa Optional!

public interface PackageExpressRepository extends JpaRepository<PackageExpress, Long> {
    // Agrega esta línea para definir el método de búsqueda por trackingNumber
    Optional<PackageExpress> findByTrackingNumber(String trackingNumber);
}