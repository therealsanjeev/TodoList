package com.example.todolist

import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.todolist.DataBase.MyDbHelper
import com.example.todolist.DataBase.TodoTable
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val todos = ArrayList<Todo>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val todoAdapter = ArrayAdapter<Todo>(
            this,
            android.R.layout.simple_list_item_1,
            android.R.id.text1,
            todos
        )
        val db = MyDbHelper(this).writableDatabase

        fun refreshTodoList () {
            val todoList = TodoTable.getAllTodos(db)
            todos.clear()
            todos.addAll(todoList)
            todoAdapter.notifyDataSetChanged()
        }
        lvToDos.adapter = todoAdapter
        refreshTodoList()

        btAddToDo.setOnClickListener {
            val newTodo = Todo(
                etNewToDo.text.toString(),
                false
            )
            TodoTable.insertTodo(db, newTodo)
            refreshTodoList()
        }
    }
}