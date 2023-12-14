package com.todo_listusers.users.dto

data class AuthDTO(
        val username: String,
        val secret: String,
        val userId: Long
)