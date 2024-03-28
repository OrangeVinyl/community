package org.encore.apartment.community.domain.facility.data.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Reservation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "reservation_id")
	private Integer reservationId;

	// user tbl에 user_id와 연결 필요
	@Column(name = "reservation_user_id", nullable = false)
	private String reservationUserId;

	// facility tbl에 facility_id와 연결 필요
	@Column(name = "reservation_facility_id", nullable = false)
	private Integer reservationFacilityId;

	@Column(name = "reservation_start_time", nullable = false)
	private Date reservationStartTime;

	@Column(name = "reservation_end_time", nullable = false)
	private Date reservationEndTime;

	@Column(name = "reservation_headcount", nullable = false)
	private Integer reservationHeadcount;

	@Column(name = "delete_yn", columnDefinition = "boolean default false")
	@ColumnDefault("false")
	private Boolean deleteYn;

//	@Builder
//	public Reservation(
//		Integer reservationId,
//		String reservationUserId,
//		Integer reservationFacilityId,
//		Date reservationStartTime,
//		Date reservationEndTime,
//		Integer reservationHeadcount,
//		Boolean deleteYn
//	) {
//		this.reservationId = reservationId;
//		this.reservationUserId = reservationUserId;
//		this.reservationFacilityId = reservationFacilityId;
//		this.reservationStartTime = reservationStartTime;
//		this.reservationEndTime = reservationEndTime;
//		this.reservationHeadcount = reservationHeadcount;
//		if (deleteYn == null)
//			this.deleteYn = getDeleteYn();
//		else
//			this.deleteYn = deleteYn;
//	}
	@Builder
	public Reservation(
		String reservationUserId,
		Integer reservationFacilityId,
		Date reservationStartTime,
		Date reservationEndTime,
		Integer reservationHeadcount
	) {
		this.reservationUserId = reservationUserId;
		this.reservationFacilityId = reservationFacilityId;
		this.reservationStartTime = reservationStartTime;
		this.reservationEndTime = reservationEndTime;
		this.reservationHeadcount = reservationHeadcount;
		if (getDeleteYn() == null)
			this.deleteYn = false;
	}


	public void update(){
		this.reservationId = this.getReservationId();
		this.reservationUserId = this.getReservationUserId();
		this.reservationFacilityId = this.getReservationFacilityId();
		this.reservationStartTime = this.getReservationStartTime();
		this.reservationEndTime = this.getReservationEndTime();
		this.reservationHeadcount = this.getReservationHeadcount();
		this.deleteYn = true;
	}
}
