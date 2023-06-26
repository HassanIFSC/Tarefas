package com.example.apptarefas.data.local

import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import com.example.apptarefas.data.model.Task

@Dao
interface TaskDao {
    @Query("SELECT * FROM task ORDER BY id DESC")
    suspend fun getAllTasks(): List<Task>

    @Query("SELECT * FROM task WHERE id ==:id")
    suspend fun getTaskById(id: Int): Task

    @Insert(onConflict = REPLACE)
    suspend fun insertTask(task: Task): Long

    @Delete
    suspend fun deleteTask(task: Task)

    @Update
    suspend fun updateTask(task: Task)
}