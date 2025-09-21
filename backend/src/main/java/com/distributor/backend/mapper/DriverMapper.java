package com.distributor.backend.mapper;

import com.distributor.backend.dto.DriverDto;
import com.distributor.backend.entity.Driver;

public class DriverMapper {
    public static DriverDto maptoDriverDto(Driver driver){
        return new DriverDto(
                driver.getLicense(),
                driver.getAadhaar(),
                driver.getFname(),
                driver.getLname(),
                driver.getPhone(),
                driver.getHouse(),
                driver.getLocality(),
                driver.getCity(),
                driver.getZip()
        );
    }

    public static Driver maptoDriver(DriverDto driverDto){
        return new Driver(
                driverDto.getLicense(),
                driverDto.getAadhaar(),
                driverDto.getFname(),
                driverDto.getLname(),
                driverDto.getPhone(),
                driverDto.getHouse(),
                driverDto.getLocality(),
                driverDto.getCity(),
                driverDto.getZip()
        );
    }
}
