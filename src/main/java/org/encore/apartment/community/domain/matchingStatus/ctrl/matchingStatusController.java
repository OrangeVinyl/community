package org.encore.apartment.community.domain.matchingStatus.ctrl;

import org.encore.apartment.community.domain.matchingStatus.data.dto.RequestInsertMatchingStatusDto;
import org.encore.apartment.community.domain.matchingStatus.service.MatchingStatusService;
import org.encore.apartment.community.global.util.api.ApiResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/matchingStatus")
public class matchingStatusController {

	@Resource(name = "matchingStatus")
	private MatchingStatusService service;

	@Operation(summary = "매칭에 참여한 인원이 발생할 경우 매칭참여정보테이블에 매칭에 지원한 인원의 user_id 삽입")
	@PostMapping("/insert")
	public ApiResponse<?> insertMatchingStatusInfo(@RequestBody RequestInsertMatchingStatusDto params) {
		service.insertMatchingStatusInfo(params);
		log.info("MatchingStatusController insertMatchingStatusInfo = {}", params);

		return ApiResponse.createSuccessWithNoContent();
	}

	/*@Operation(summary = "매칭에 참여한 인원이 발생할 경우 매칭참여정보테이블에 매칭에 지원한 인원의 user_id 삽입")
	@PostMapping("/insert")
	public ResponseEntity<Void> insertMatchingStatusInfo(@RequestBody RequestInsertMatchingStatusDto params) {
		service.insertMatchingStatusInfo(params);
		log.info("MatchingStatusController insertMatchingStatusInfo = {}", params);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@GetMapping("/find/{id}")
	public ResponseEntity<Optional<ResponseMatchingStatusDto>> findMatchingStatusInfo(@PathVariable Long id) {
		Optional<ResponseMatchingStatusDto> dto = service.findMatchingStatusInfo(id);
		log.info("MatchingStatusController findMatchingStatusInfo = {}", dto);

		return new ResponseEntity<Optional<ResponseMatchingStatusDto>>(dto, HttpStatus.OK);
	}

	@GetMapping("/list")
	public ResponseEntity<List<ResponseMatchingStatusDto>> findMatchingStatusInfoList() {
		List<ResponseMatchingStatusDto> dto = service.findMatchingStatusInfoList();
		log.info("MatchingStatusController findMatchingStatusInfoList = {}", dto);

		return new ResponseEntity<List<ResponseMatchingStatusDto>>(dto, HttpStatus.OK);
	}

	@PostMapping("/update/{id}")
	public ResponseEntity<Void> updateMatchingStatusInfo(@PathVariable("id") Long id,
		@RequestBody UpdateMatchingStatusDto params) {
		log.info("MatchingStatusController updateMatchingStatusInfo = {}", params);
		service.updateMatchingStatusInfoById(id, params);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteMatchingStatusInfo(@PathVariable Long id) {
		log.info("MatchingStatusController deleteMatchingStatusInfo = {}", id);
		service.deleteMatchingStatusInfo(id);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}*/

}


