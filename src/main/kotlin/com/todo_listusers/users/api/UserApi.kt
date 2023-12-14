package com.todo_listusers.users.api

import com.todo_listusers.users.dto.UserDTO
import com.todo_listusers.users.bl.UserBl
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/users")
class UserApi (
        private val userBl: UserBl
){
    @GetMapping("/user/{userId}")
    fun getUserById(
            @PathVariable userId: Long
    ): ResponseEntity<UserDTO>{
        val user = userBl.getUserById(userId)
        return ResponseEntity(user, HttpStatus.OK)
    }
    @PostMapping("/user")
    fun createNewUser(
            @RequestBody userDTO: UserDTO
    ): ResponseEntity<UserDTO>{
        val user = userBl.createNewUser(userDTO)
        return ResponseEntity(user, HttpStatus.OK)
    }
}