package org.encore.apartment.community.domain.user.auth.service;

import org.encore.apartment.community.domain.user.auth.dto.SignInRequestDto;
import org.encore.apartment.community.domain.user.auth.dto.SignInResponseDto;
import org.encore.apartment.community.domain.user.info.data.entity.User;
import org.encore.apartment.community.domain.user.info.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {
	public final UserRepository userRepository;


	@Transactional(readOnly = true)
	public SignInResponseDto signIn(SignInRequestDto request) {
		User member =  userRepository.findByUserId(request.userId())
				.filter(it -> it.getUserPassword().equals(request.userPassword()))
				.orElseThrow(() -> new IllegalArgumentException("아이디 또는 비밀번호가 일치하지 않습니다."));
		return new SignInResponseDto(member.getUserIdx(), member.getUserId());
	}
}
