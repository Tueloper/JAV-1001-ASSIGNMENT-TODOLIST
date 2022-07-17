package com.tochukwuozurumba.todolist;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //    declare global variables
    private List<String> todoListArray;
    private ArrayAdapter<String> arrayAdapter;
    private EditText todoListInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        todoListArray = new ArrayList<>();

//        instantiate array
        arrayAdapter = new ArrayAdapter<>(this, R.layout.todolist_view_layout, todoListArray);

//        get input todolist text ref
        todoListInput = findViewById(R.id.todolist_input);

//        get display todolist view ref
        ListView displayTodoList = findViewById(R.id.todo_view_id);

//        set array to list view
        displayTodoList.setAdapter(arrayAdapter);

//        when you click on the todo
        deleteTodoList(displayTodoList);
    }

    public void addTodolist(View view) {
//        get the add todo input
        String todoTextValue = todoListInput.getText().toString();

//        add to the todo list array
        todoListArray.add(todoTextValue);

        Log.d("TodoListArray: ", todoListArray.toString());
//        notify adapter that the list has been updated
        arrayAdapter.notifyDataSetChanged();

//        reset input todo
        todoListInput.setText("");
    }

    private void deleteTodoList(ListView listView) {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView singleTodoView = (TextView) view;
                singleTodoView.setPaintFlags(singleTodoView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            }
        });
    }
}