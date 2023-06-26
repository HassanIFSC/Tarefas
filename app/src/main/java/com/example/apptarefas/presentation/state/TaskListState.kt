package com.example.apptarefas.presentation.state

import com.example.apptarefas.data.model.Task

data class TaskListState(
    val isLoading: Boolean = false,
    val error: String? = "",
    val tasks: List<Task>? = emptyList()
)