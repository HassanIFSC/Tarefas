package com.example.apptarefas.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.apptarefas.data.model.Task

@Database(
    entities = [Task::class],
    version = 1
)

abstract class TaskDatabase : RoomDatabase() {
    abstract fun getTaskDao(): TaskDao

    companion object {
        const val DATABASE_NAME = "BD_Tarefas"
    }
}