package org.sopt.at.data.repositoryimpl

import org.sopt.at.data.dataremote.datasource.AuthRemoteDataSource
import org.sopt.at.data.mapper.todata.toData
import org.sopt.at.data.mapper.todomain.toDomain
import org.sopt.at.domain.model.SignUpInfo
import org.sopt.at.domain.model.UserInfo
import org.sopt.at.domain.repository.AuthRepository
import javax.inject.Inject


class AuthRepositoryImpl @Inject constructor(
    private val authRemoteDataSource: AuthRemoteDataSource
) : AuthRepository {
    override suspend fun signUp(signUpInfo: SignUpInfo): Result<UserInfo> =
        runCatching {
            val response = authRemoteDataSource.signUp(signUpInfo.toData())
            response.data?.toDomain() ?: throw IllegalStateException("회원가입 응답이 null입니다.")
        }
}