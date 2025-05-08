package org.sopt.at.domain.usecase

import org.sopt.at.domain.model.SignInRequestInfo
import org.sopt.at.domain.model.SignInResponseInfo
import org.sopt.at.domain.repository.AuthRepository
import javax.inject.Inject

class PostSignInUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(signInRequestInfo: SignInRequestInfo): Result<SignInResponseInfo> =
        authRepository.signIn(signInRequestInfo)
}