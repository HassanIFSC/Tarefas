package com.example.apptarefas.domain.usecase

import com.example.apptarefas.data.model.Task
import com.example.apptarefas.domain.repository.TaskRepository
import javax.inject.Inject

class DeleteTask @Inject constructor(private val repository: TaskRepository) {
    suspend operator fun invoke(task: Task) {
        repository.deleteTask(task)
    }
}