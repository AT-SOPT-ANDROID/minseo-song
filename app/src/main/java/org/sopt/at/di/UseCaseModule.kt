package org.sopt.at.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.sopt.at.domain.repository.AuthRepository
import org.sopt.at.domain.usecase.PostSignUpUseCase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    @Singleton
    fun providePostSignUpUseCase(
        authRepository: AuthRepository
    ): PostSignUpUseCase = PostSignUpUseCase(authRepository)
}