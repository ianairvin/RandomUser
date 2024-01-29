package ru.random_user.domain.use_case

import ru.random_user.domain.entity.User
import ru.random_user.domain.repository.UserRepository
import javax.inject.Inject

class GetUserFromApiUseCase @Inject constructor(
    private val userRepository : UserRepository
) {
    suspend operator fun invoke() : Result<String> {
        return userRepository.getUserFromApi()
    }
}