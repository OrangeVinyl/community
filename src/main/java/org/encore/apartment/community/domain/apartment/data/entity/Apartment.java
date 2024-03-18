package org.encore.apartment.community.domain.apartment.data.entity;

import org.hibernate.annotations.ColumnDefault;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Apartment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "apartment_id")
	private Long apartmentId;

	@NotBlank
	@Column(name = "apartment_name")
	private String apartmentName;

	@NotBlank
	@Column(name = "apartment_address")
	private String apartmentAddress;

	@Column(name = "apartment_total_household")
	@ColumnDefault("0")
	private Integer apartmentTotalHousehold;

	@Builder
	public Apartment(String apartmentName, String apartmentAddress, Integer apartmentTotalHousehold) {
		this.apartmentName = apartmentName;
		this.apartmentAddress = apartmentAddress;
		this.apartmentTotalHousehold = apartmentTotalHousehold;
	}

}
