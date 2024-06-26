package org.encore.apartment.community.domain.matchingStatus.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.encore.apartment.community.domain.matching.data.repository.MatchingRepository;
import org.encore.apartment.community.domain.matchingStatus.data.dto.RequestInsertMatchingStatusDto;
import org.encore.apartment.community.domain.matchingStatus.data.dto.ResponseMatchingStatusDto;
import org.encore.apartment.community.domain.matchingStatus.data.entity.MatchingStatus;
import org.encore.apartment.community.domain.matchingStatus.data.repository.MatchingStatusRepository;
import org.encore.apartment.community.domain.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("matchingStatus")
@RequiredArgsConstructor
public class MatchingStatusServiceImpl implements MatchingStatusService {

	private final MatchingStatusRepository matchingStatusRepository;
	private final UserRepository userRepository;
	private final MatchingRepository matchingRepository;

	public MatchingStatus toEntity(RequestInsertMatchingStatusDto requestInsertMatchingStatusDto) {
		return MatchingStatus.builder()
			.matching(
				matchingRepository.findById(requestInsertMatchingStatusDto.getMatchingId()).get())
			.user(
				userRepository.findByUserId(requestInsertMatchingStatusDto.getUserId()).get())
			.build();
	}

	@Override
	public void insertMatchingStatusInfo(RequestInsertMatchingStatusDto params) {
		MatchingStatus matchingStatus = toEntity(params);
		matchingStatusRepository.save(matchingStatus);
		log.info("insertMatchingStatusInfo = {}", matchingStatus);
	}

	@Override
	public Optional<ResponseMatchingStatusDto> findMatchingStatusInfo(Long id) {
		Optional<MatchingStatus> matchingStatus = matchingStatusRepository.findById(id);
		log.info("findMatchingStatusInfo = {}", matchingStatus);

		return matchingStatus.map(ResponseMatchingStatusDto::new);
	}

	@Override
	public List<ResponseMatchingStatusDto> findMatchingStatusInfoList() {
		List<MatchingStatus> matchingStatusList = matchingStatusRepository.findAll();
		log.info("findMatchingStatusInfoList = {}", matchingStatusList);

		return matchingStatusList.stream().map(ResponseMatchingStatusDto::new).collect(Collectors.toList());
	}

	@Override
	public void deleteMatchingStatusInfo(Long id) {
		matchingStatusRepository.deleteById(id);
		log.info("deleteMatchingStatusInfo = {}", id);
	}
}
