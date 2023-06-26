package com.example.apptarefas.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apptarefas.data.model.Task
import com.example.apptarefas.domain.usecase.TaskUseCase
import com.example.apptarefas.presentation.state.TaskListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TaskViewModel @Inject constructor(private val useCase: TaskUseCase) : ViewModel() {

    private val _mTaskListState: MutableLiveData<TaskListState> = MutableLiveData<TaskListState>()
    val taskListState: LiveData<TaskListState> = _mTaskListState

    fun getAllTasks() {
        viewModelScope.launch {
            _mTaskListState.value = TaskListState(isLoading = false, tasks = useCase.getAllTasks())
        }
    }

    fun addTask(task: Task) {
        viewModelScope.launch {
            useCase.insertTask(task)
        }
    }

    fun deleteTask(task: Task) {
        viewModelScope.launch {
            useCase.deleteTask(task)
        }
    }

    fun updateTask(task: Task) {
        viewModelScope.launch {
            useCase.updateTask(task)
        }
    }
}