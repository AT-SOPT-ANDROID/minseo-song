package org.sopt.at.data.mapper.todata

import org.sopt.at.data.dataremote.dto.request.SignInRequestDto
import org.sopt.at.domain.model.SignInRequestInfo

fun SignInRequestInfo.toData() = SignInRequestDto(
    loginId = this.loginId,
    password = this.password
)