package com.todo_listusers.users.dao.repository

import com.todo_listusers.users.dao.UserEntity
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<UserEntity, Long> {
}