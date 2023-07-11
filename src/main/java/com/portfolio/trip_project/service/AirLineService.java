package com.portfolio.trip_project.service;

import com.portfolio.trip_project.dto.AirLineDTO;
import com.portfolio.trip_project.entity.AirLineEntity;
import com.portfolio.trip_project.repository.AirLineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AirLineService {

    private final AirLineRepository airLineRepository;

    public Long save(AirLineDTO airLineDTO) {
        AirLineEntity airLineEntity = AirLineEntity.AirLinetoSaveEntity(airLineDTO);
        return airLineRepository.save(airLineEntity).getId();
    }
}
