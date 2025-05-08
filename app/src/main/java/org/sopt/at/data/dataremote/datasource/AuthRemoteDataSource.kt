package org.sopt.at.data.dataremote.datasource

import org.sopt.at.data.dataremote.dto.base.NullableBaseResponse
import org.sopt.at.data.dataremote.dto.request.SignUpRequestDto
import org.sopt.at.data.dataremote.dto.response.SignUpResponseDto

interface AuthRemoteDataSource {
    suspend fun signUp(signUpRequestDto: SignUpRequestDto): NullableBaseResponse<SignUpResponseDto>
}