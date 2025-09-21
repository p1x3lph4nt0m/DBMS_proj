package com.distributor.backend.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import com.distributor.backend.dto.DriverDto;
import com.distributor.backend.entity.Driver;
import com.distributor.backend.mapper.DriverMapper;
import com.distributor.backend.repository.DriverRepository;
import com.distributor.backend.service.DriverService;
import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class DriverServiceImpl implements DriverService {
    
    private DriverRepository driverRepository;
    
    @Override
    public DriverDto addDriver(DriverDto driverDto) {
        Driver driver = DriverMapper.maptoDriver(driverDto);
        Driver savedDriver = driverRepository.save(driver);
        return DriverMapper.maptoDriverDto(savedDriver);
    }

    @Override
    public List<String> getAllDriverLicences() {
        List<Driver> drivers = driverRepository.findAll();
        return drivers.stream()
                      .map(Driver::getLicense)
                      .toList();
    }

}
