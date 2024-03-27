package org.encore.apartment.community.domain.facility.service;

import java.util.List;
import java.util.stream.Collectors;

import org.encore.apartment.community.domain.facility.data.dto.FacilityDto;
import org.encore.apartment.community.domain.facility.data.entity.Facility;
import org.encore.apartment.community.domain.facility.data.repository.FacilityRepository;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("facility")
@RequiredArgsConstructor
public class FacilityServiceImpl implements FacilityService {

	private final FacilityRepository facilityRepository;

	@Override
	public void createFacility(FacilityDto params) {
		Facility facility = FacilityDto.toEntity(params);
		facilityRepository.save(facility);
		log.info("facility saved : {}", facility);
	}

	@Override
	public List<FacilityDto> readAllFacility() {
		List<Facility> list = facilityRepository.findAll();
		return list.stream().map(FacilityDto::new).collect(Collectors.toList());
	}
}
