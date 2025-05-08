package org.sopt.at.data.dataremote.service

import org.sopt.at.data.dataremote.dto.base.NullableBaseResponse
import org.sopt.at.data.dataremote.dto.request.SignInRequestDto
import org.sopt.at.data.dataremote.dto.request.SignUpRequestDto
import org.sopt.at.data.dataremote.dto.response.GetMyNickNameResponseDto
import org.sopt.at.data.dataremote.dto.response.SignInResponseDto
import org.sopt.at.data.dataremote.dto.response.SignUpResponseDto
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface AuthService {
    @POST("/api/v1/auth/signup")
    suspend fun signUp(
        @Body signUpRequestDto: SignUpRequestDto
    ): NullableBaseResponse<SignUpResponseDto>

    @POST("/api/v1/auth/signin")
    suspend fun signIn(
        @Body signInRequestDto: SignInRequestDto
    ): NullableBaseResponse<SignInResponseDto>

    @GET("/api/v1/users/me")
    suspend fun getMyNickName(
        @Header("userId") userId: Long
    ):NullableBaseResponse<GetMyNickNameResponseDto>
}