package org.encore.apartment.community.domain.apartment.data.dto;

import org.encore.apartment.community.domain.apartment.data.entity.Apartment;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UpdateApartmentDto {
	@NotNull
	private Long apartmentId;

	@NotBlank
	private String apartmentName;

	@NotBlank
	private String apartmentAddress;
	private Integer apartmentTotalHousehold;

	public UpdateApartmentDto(Apartment params) {
		this.apartmentId = params.getApartmentId();
		this.apartmentName = params.getApartmentName();
		this.apartmentAddress = params.getApartmentAddress();
		this.apartmentTotalHousehold = params.getApartmentTotalHousehold();
	}
}
