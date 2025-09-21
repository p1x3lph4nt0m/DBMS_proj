package com.distributor.backend.mapper;

import com.distributor.backend.dto.DriverDto;
import com.distributor.backend.entity.Driver;

public class DriverMapper {
    public static DriverDto maptoDriverDto(Driver driver){
        return new DriverDto(
                driver.getLicenseNumber(),
                driver.getAadhaarNumber(),
                driver.getFirstName(),
                driver.getLastName(),
                driver.getPhoneNumber(),
                driver.getHouseNumber(),
                driver.getLocality(),
                driver.getCity(),
                driver.getZipCode()
        );
    }

    public static Driver maptoDriver(DriverDto driverDto){
        return new Driver(
                driverDto.getLicenseNumber(),
                driverDto.getAadhaarNumber(),
                driverDto.getFirstName(),
                driverDto.getLastName(),
                driverDto.getPhoneNumber(),
                driverDto.getHouseNumber(),
                driverDto.getLocality(),
                driverDto.getCity(),
                driverDto.getZipCode()
        );
    }
}
