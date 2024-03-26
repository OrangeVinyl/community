package org.encore.apartment.community.domain.user.info.data.dto.user;

import java.time.LocalDateTime;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;

@Getter
public class UpdateRequestUserDto {

	private Long userIdx;

	@NotBlank
	private String userNickname;

	@NotBlank
	@Email
	private String userEmail;

	@NotBlank
	@Pattern(regexp = "^\\d{3}-\\d{4}-\\d{4}$", message = "전화번호는 010-XXXX-XXXX 형식이어야 합니다.")
	private String userMobile;
}
