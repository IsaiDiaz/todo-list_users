package com.todo_listusers.users.bl

import com.todo_listusers.users.dao.UserEntity
import com.todo_listusers.users.dto.UserDTO
import com.todo_listusers.users.dao.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserBl  (
        private val userRepository: UserRepository
) {

    fun getUserById(userId: Long): UserDTO {
        val user = userRepository.findById(userId).orElse(null)
        if (user == null){
            return UserDTO("", "", "")
        }else{
            return UserDTO(user.username, user.email, user.fullName)
        }
    }

    fun createNewUser(userDTO: UserDTO): UserDTO {
        val userEntity = UserEntity(0, userDTO.username, userDTO.email, userDTO.fullName)
        val user = userRepository.saveAndFlush(userEntity)
        val createdUser = UserDTO(user.username, user.email, user.fullName)
        return createdUser
    }

}