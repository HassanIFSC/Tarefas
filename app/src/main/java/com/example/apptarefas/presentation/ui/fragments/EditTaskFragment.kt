package com.example.apptarefas.presentation.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.apptarefas.R
import com.example.apptarefas.data.model.Task
import com.example.apptarefas.databinding.FragmentEditTaskBinding
import com.example.apptarefas.presentation.viewmodel.EditTaskViewModel
import com.example.apptarefas.presentation.viewmodel.TaskViewModel

class EditTaskFragment : BaseFragments(R.layout.fragment_edit_task) {

    private lateinit var mBinding: FragmentEditTaskBinding
    private val mTaskViewModel: TaskViewModel by activityViewModels()
    private val mEditTaskViewModel: EditTaskViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentEditTaskBinding.inflate(layoutInflater)
        return mBinding.root
    }

    override fun onResume() {
        super.onResume()
        mEditTaskViewModel.mTask.observe(viewLifecycleOwner) {
            setUI(it)
        }
    }

    private fun setUI(task: Task) {
        mBinding.editTitle.setText(task.title.toString())
        mBinding.editDetails.setText(task.details.toString())
        mBinding.btnCancel.setOnClickListener {
            finishTheFragment()
        }
        mBinding.btnSave.setOnClickListener {
            val updatedTask = Task(
                task.id,
                mBinding.editTitle.text.toString(),
                mBinding.editDetails.text.toString()
            )
            mTaskViewModel.updateTask(updatedTask)
            finishTheFragment()
        }
        mBinding.btnCancel.setOnClickListener {
            finishTheFragment()
        }
    }

}