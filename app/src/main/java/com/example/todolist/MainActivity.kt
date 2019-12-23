package com.example.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val todos =ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val todoAdapter = ArrayAdapter<String>(
            this,
            android.R.layout.simple_list_item_1,
            android.R.id.text1,
            todos
        )

        lvToDos.adapter=todoAdapter
        btAddToDo.setOnClickListener{
            val newTodo = etNewToDo.text.toString()

            todos.add(newTodo)
            todoAdapter.notifyDataSetChanged()
        }

    }
}
