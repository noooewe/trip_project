package com.portfolio.trip_project.service;

import com.portfolio.trip_project.dto.AirLineDTO;
import com.portfolio.trip_project.entity.AirLineEntity;
import com.portfolio.trip_project.repository.AirLineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class AirLineService {

    private final AirLineRepository airLineRepository;

    public Long save(AirLineDTO airLineDTO) {
        AirLineEntity airLineEntity = AirLineEntity.AirLinetoSaveEntity(airLineDTO);
        return airLineRepository.save(airLineEntity).getId();
    }

    public List<AirLineDTO> findAll() {
        List<AirLineEntity> airLineEntityList = airLineRepository.findAll();
        List<AirLineDTO> airLineDTOList = new ArrayList<>();
        for (AirLineEntity airLineEntity: airLineEntityList) {
            airLineDTOList.add(AirLineDTO.AirLinetoDTO(airLineEntity));
        }
        return airLineDTOList;
    }

    public void delete(Long id) {
        airLineRepository.deleteById(id);
    }


}
