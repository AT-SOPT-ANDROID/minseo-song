package org.sopt.at.data.repositoryimpl

import org.sopt.at.data.dataremote.datasource.AuthRemoteDataSource
import org.sopt.at.data.mapper.todata.toData
import org.sopt.at.data.mapper.todomain.toDomain
import org.sopt.at.domain.model.SignInRequestInfo
import org.sopt.at.domain.model.SignInResponseInfo
import org.sopt.at.domain.model.SignUpRequestInfo
import org.sopt.at.domain.model.SignUpResponseInfo
import org.sopt.at.domain.repository.AuthRepository
import javax.inject.Inject


class AuthRepositoryImpl @Inject constructor(
    private val authRemoteDataSource: AuthRemoteDataSource
) : AuthRepository {
    override suspend fun signUp(signUpRequestInfo: SignUpRequestInfo): Result<SignUpResponseInfo> =
        runCatching {
            val response = authRemoteDataSource.signUp(signUpRequestInfo.toData())
            response.data?.toDomain() ?: throw IllegalStateException("회원가입 응답이 null입니다.")
        }

    override suspend fun signIn(signInInfo: SignInRequestInfo): Result<SignInResponseInfo> =
        runCatching {
            val response = authRemoteDataSource.signIn(signInInfo.toData())
            response.data?.toDomain() ?: throw IllegalStateException("로그인 응답이 null입니다.")
        }


}