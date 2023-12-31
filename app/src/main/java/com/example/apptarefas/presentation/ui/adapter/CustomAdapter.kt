package com.example.apptarefas.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.apptarefas.R
import com.example.apptarefas.data.model.Task

class CustomAdapter : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewTask: TextView

        init {
            textViewTask = itemView.findViewById(R.id.text_task)
        }
    }

    private var mList: MutableList<Task> = mutableListOf()
    private var mListener: OnItemClickListener? = null

    fun setData(list: List<Task>) {
        mList = list.toMutableList()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textViewTask.text = mList[position].title
        holder.itemView.setOnClickListener {
            mListener?.onItemClicked(mList[position])
        }
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    fun setListener(listener: OnItemClickListener) {
        mListener = listener
    }

    fun removeData(pos: Int): Task {
        val task = mList[pos]
        mList.removeAt(pos)
        return task
    }

    interface OnItemClickListener {
        fun onItemClicked(task: Task)
    }

    abstract class SwipeToDeleteCallback : ItemTouchHelper.Callback() {

        override fun getMovementFlags(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder
        ): Int {
            val swipeFlag = ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
            return makeMovementFlags(0, swipeFlag)
        }

        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder
        ): Boolean {
            return false
        }
    }

}