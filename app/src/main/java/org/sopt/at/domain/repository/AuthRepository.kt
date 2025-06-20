package org.sopt.at.domain.repository

import org.sopt.at.domain.model.GetMyNickNameResponseInfo
import org.sopt.at.domain.model.SignInRequestInfo
import org.sopt.at.domain.model.SignInResponseInfo
import org.sopt.at.domain.model.SignUpRequestInfo
import org.sopt.at.domain.model.SignUpResponseInfo

interface AuthRepository {
    suspend fun signUp(signUpRequestInfo: SignUpRequestInfo): Result<SignUpResponseInfo>
    suspend fun signIn(signInInfo: SignInRequestInfo): Result<SignInResponseInfo>
    suspend fun getMyNickName(userId: Long): Result<GetMyNickNameResponseInfo>
}