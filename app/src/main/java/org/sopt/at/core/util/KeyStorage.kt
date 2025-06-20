package org.sopt.at.core.util

object KeyStorage {
    val ID_REGEX = Regex("^[a-z0-9]{6,12}$")
    val PASSWORD_REGEX = Regex("^[a-zA-Z\\d]{8,20}$")
}