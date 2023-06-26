package com.example.apptarefas.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Task(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    @ColumnInfo(name = "nome")
    val title: String? = "",
    @ColumnInfo(name = "descricao")
    val details: String? = ""
)