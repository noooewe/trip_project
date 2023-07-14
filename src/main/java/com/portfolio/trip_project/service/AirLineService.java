package com.portfolio.trip_project.service;

import com.portfolio.trip_project.dto.AirLineDTO;
import com.portfolio.trip_project.dto.FlightSearchDTO;
import com.portfolio.trip_project.entity.AirLineEntity;
import com.portfolio.trip_project.repository.AirLineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


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



    public AirLineDTO searchFlight(FlightSearchDTO flightSearchDTO) {
        // 데이터베이스에서 출발지, 도착지, 좌석 클래스를 기반으로 매칭되는 항공편 검색
        Optional<AirLineEntity> airLineEntityOptional = airLineRepository.findByDepartureAirportAndArrivalAirportAndSeatPositionClass(
                flightSearchDTO.getDepartureAirport(),
                flightSearchDTO.getArrivalAirport(),
                flightSearchDTO.getSeatPositionClass()
        );

        // 만약 검색된 항공편이 없다면 null 반환
        if (!airLineEntityOptional.isPresent()) {
            return null;
        }

        // 만약 검색된 항공편이 있다면, AirLineEntity를 AirLineDTO로 변환 후 반환
        return AirLineDTO.AirLinetoDTO(airLineEntityOptional.get());
    }


}
