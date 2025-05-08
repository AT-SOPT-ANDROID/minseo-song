package org.sopt.at.domain.usecase

import org.sopt.at.domain.model.SignUpRequestInfo
import org.sopt.at.domain.model.SignUpResponseInfo
import org.sopt.at.domain.repository.AuthRepository
import javax.inject.Inject

class PostSignUpUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(signUpRequestInfo: SignUpRequestInfo): Result<SignUpResponseInfo> =
        authRepository.signUp(signUpRequestInfo)
}