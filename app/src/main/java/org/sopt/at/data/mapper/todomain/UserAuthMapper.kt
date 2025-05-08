package org.sopt.at.data.mapper.todomain

import org.sopt.at.data.dataremote.dto.response.SignUpResponseDto
import org.sopt.at.domain.model.UserInfo

fun SignUpResponseDto.toDomain() = UserInfo(
    userId = this.userId,
    nickname = this.nickname
)