package org.sopt.at.domain.usecase

import org.sopt.at.domain.model.GetMyNickNameResponseInfo
import org.sopt.at.domain.repository.AuthRepository
import javax.inject.Inject

class GetMyNickNameUseCase @Inject constructor(
    private val authRepository: AuthRepository
){
    suspend operator fun invoke(userId: Long): Result<GetMyNickNameResponseInfo> =
        authRepository.getMyNickName(userId)
}