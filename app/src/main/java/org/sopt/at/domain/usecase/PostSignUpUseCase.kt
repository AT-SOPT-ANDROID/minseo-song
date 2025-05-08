package org.sopt.at.domain.usecase

import org.sopt.at.domain.model.SignUpInfo
import org.sopt.at.domain.model.UserInfo
import org.sopt.at.domain.repository.AuthRepository
import javax.inject.Inject

class PostSignUpUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(signUpInfo: SignUpInfo): Result<UserInfo> =
        authRepository.signUp(signUpInfo)
}