package com.distributor.backend.service;

import com.distributor.backend.dto.DriverDto;
import java.util.List;

public interface DriverService {
    DriverDto addDriver(DriverDto driverDto);
    List<String> getAllDriverLicences();
}
