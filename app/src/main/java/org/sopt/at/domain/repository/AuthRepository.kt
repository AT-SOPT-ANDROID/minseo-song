package org.sopt.at.domain.repository

import org.sopt.at.domain.model.SignUpInfo
import org.sopt.at.domain.model.UserInfo

interface AuthRepository {
    suspend fun signUp(signUpInfo: SignUpInfo): Result<UserInfo>
}