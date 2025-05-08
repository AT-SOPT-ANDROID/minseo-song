package org.sopt.at.data.mapper.todata

import org.sopt.at.data.dataremote.dto.request.SignUpRequestDto
import org.sopt.at.domain.model.SignUpInfo

fun SignUpInfo.toData() = SignUpRequestDto(
    loginId = this.loginId,
    password = this.password,
    nickname = this.nickname
)