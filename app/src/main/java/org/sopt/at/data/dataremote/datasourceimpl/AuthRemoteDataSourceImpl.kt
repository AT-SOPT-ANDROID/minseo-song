package org.sopt.at.data.dataremote.datasourceimpl

import org.sopt.at.data.dataremote.datasource.AuthRemoteDataSource
import org.sopt.at.data.dataremote.dto.base.NullableBaseResponse
import org.sopt.at.data.dataremote.dto.request.SignUpRequestDto
import org.sopt.at.data.dataremote.dto.response.SignUpResponseDto
import org.sopt.at.data.dataremote.service.AuthService
import javax.inject.Inject

class AuthRemoteDataSourceImpl @Inject constructor(
    private val authService: AuthService
): AuthRemoteDataSource {
    override suspend fun signUp(signUpRequestDto: SignUpRequestDto): NullableBaseResponse<SignUpResponseDto> =
        authService.signUp(signUpRequestDto = signUpRequestDto)
}