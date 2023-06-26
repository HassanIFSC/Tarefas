package com.example.apptarefas.presentation.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import com.example.apptarefas.R
import com.example.apptarefas.data.model.Task
import com.example.apptarefas.databinding.FragmentNewTaskBinding
import com.example.apptarefas.presentation.viewmodel.TaskViewModel


class NewTaskFragment : BaseFragments(R.layout.fragment_new_task) {

    private lateinit var mBinding: FragmentNewTaskBinding
    private val mViewModel: TaskViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentNewTaskBinding.inflate(layoutInflater)
        return mBinding.root
    }

    override fun onResume() {
        super.onResume()
        setUI()
    }

    private fun setUI() {
        mBinding.btnAdd.setOnClickListener {
            if (mBinding.newTitle.text!!.isEmpty()) {
                Toast.makeText(context, "Por favor, dê um nome à sua tarefa", Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            }
            val title = mBinding.newTitle.text.toString()
            val details = mBinding.newDetails.text.toString()
            mViewModel.addTask(
                Task(
                    title = title,
                    details = details
                )
            )
            finishTheFragment()
        }

        mBinding.btnCancel.setOnClickListener {
            finishTheFragment()
        }
    }
}