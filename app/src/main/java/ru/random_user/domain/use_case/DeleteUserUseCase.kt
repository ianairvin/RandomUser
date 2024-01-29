package ru.random_user.domain.use_case

import ru.random_user.domain.repository.UserRepository
import javax.inject.Inject

class DeleteUsersUseCase @Inject constructor(
    private val userRepository : UserRepository
) {
    suspend operator fun invoke(){
        userRepository.deleteUsers()
    }
}