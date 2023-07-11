package com.portfolio.trip_project.service;

import com.portfolio.trip_project.dto.AirLineDTO;
import com.portfolio.trip_project.entity.AirLineEntity;
import com.portfolio.trip_project.repository.AirLineRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@RequestMapping
public class AirLineService {

    private AirLineRepository airLineRepository;

    public Long save(AirLineDTO airLineDTO) {
        AirLineEntity airLineEntity = AirLineEntity.AirLinetoSaveEntity(airLineDTO);
        return airLineRepository.save(airLineEntity).getId();
    }
}
