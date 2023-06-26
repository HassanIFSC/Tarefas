package com.example.apptarefas.domain.usecase

import com.example.apptarefas.data.model.Task
import com.example.apptarefas.domain.repository.TaskRepository
import javax.inject.Inject

class GetAllTasks @Inject constructor(private val repository: TaskRepository) {
    suspend operator fun invoke(): List<Task> {
        return repository.getAllTasks()
    }
}