package org.encore.apartment.community.domain.facility.data.dto;

import java.util.Date;

import org.encore.apartment.community.domain.facility.data.entity.Reservation;

import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReservationAllDto {
	@NotNull
	private Integer reservationId;

	@NotNull
	private String reservationUserId;

	@NotNull
	private Integer reservationFacilityId;

	@NotNull
	private Date reservationStartTime;

	@NotNull
	private Date reservationEndTime;

	@NotNull
	private Integer reservationHeadcount;

	@NotNull
	private Boolean deleteYn;

	public static Reservation toEntity(ReservationAllDto reservationAllDto) {
		return Reservation.builder()
			.reservationUserId(reservationAllDto.getReservationUserId())
			.reservationFacilityId(reservationAllDto.getReservationFacilityId())
			.reservationStartTime(reservationAllDto.getReservationStartTime())
			.reservationEndTime(reservationAllDto.getReservationEndTime())
			.reservationHeadcount(reservationAllDto.getReservationHeadcount())
			.build();
	}//

	public ReservationAllDto(Reservation reservation) {
		this.reservationId = reservation.getReservationId();
		this.reservationUserId = reservation.getReservationUserId();
		this.reservationFacilityId = reservation.getReservationFacilityId();
		this.reservationStartTime = reservation.getReservationStartTime();
		this.reservationEndTime = reservation.getReservationEndTime();
		this.reservationHeadcount = reservation.getReservationHeadcount();
		this.deleteYn = reservation.getDeleteYn();
	}
}

/*
reservation_id
reservation_user_id
reservation_facility_id
reservation_start_time
reservation_end_time
 */
