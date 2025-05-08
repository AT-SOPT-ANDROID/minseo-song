package org.sopt.at.data.dataremote.service

import org.sopt.at.data.dataremote.dto.base.NullableBaseResponse
import org.sopt.at.data.dataremote.dto.request.SignUpRequestDto
import org.sopt.at.data.dataremote.dto.response.SignUpResponseDto
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {
    @POST("/api/v1/auth/signup")
    suspend fun signUp(
        @Body signUpRequestDto: SignUpRequestDto
    ): NullableBaseResponse<SignUpResponseDto>
}