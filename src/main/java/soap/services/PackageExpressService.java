package soap.services;
import soap.model.PackageExpress;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;

import java.util.List;

@WebService(name="PackageExpressService")
    public interface PackageExpressService {
        @WebMethod
        @WebResult(name="PackageExpress")
        PackageExpress getPackageExpressById(@WebParam(name="id")Long id);

        @WebMethod
        List<PackageExpress> getPackageExpress();

        @WebMethod
        PackageExpress createPackageExpress(@WebParam(name = "packageExpress")PackageExpress packageExpress);

        @WebMethod
        boolean deletePackageExpress(@WebParam(name = "id")Long id);

    }
