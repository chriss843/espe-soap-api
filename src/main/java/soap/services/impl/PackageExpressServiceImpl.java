package soap.services.impl;

import jakarta.jws.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import soap.model.PackageExpress;
import soap.repository.PackageExpressRepository;
import soap.services.PackageExpressService;

import java.util.List;
import java.util.Optional;

@Component
@WebService(endpointInterface = "soap.services.PackageExpressService",
        serviceName = "PackageExpressService")
public class PackageExpressServiceImpl implements PackageExpressService {

    @Autowired
    private PackageExpressRepository packageExpressRepository;

    @Override
    public PackageExpress getPackageExpressById(Long id) {
        return packageExpressRepository.findById(id).orElse(null);
    }

    @Override
    public List<PackageExpress> getPackageExpress() {
        return packageExpressRepository.findAll();
    }

    @Override
    public PackageExpress createPackageExpress(PackageExpress packageExpress) {
        packageExpress.setId(null);
        return packageExpressRepository.save(packageExpress);
    }

    @Override
    public boolean deletePackageExpress(Long id) {
        Optional<PackageExpress> packageExpress = packageExpressRepository.findById(id);
        if (packageExpress.isPresent()){
            return true;
        }
        return false;
    }
}
