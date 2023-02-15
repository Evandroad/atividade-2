package br.com.evandro.atividade2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import br.com.evandro.atividade2.model.Todo;

public class DetailTodoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_todo);

        Intent intent = getIntent();
        Todo todo = intent.getParcelableExtra("objTodo");

        TextView tv = findViewById(R.id.tvIdTodo);
        tv.setText(String.valueOf(todo.getId()));
        tv = findViewById(R.id.tvIdUserTodo);
        tv.setText(String.valueOf(todo.getUserId()));
        tv = findViewById(R.id.tvTitleTodo);
        tv.setText(todo.getTitle());
        CheckBox cb = findViewById(R.id.cbStatus);
        cb.setChecked(todo.isCompleted());
    }

    public void cbClick(View v) {
        CheckBox cb = findViewById(R.id.cbStatus);
        Intent intent = getIntent();
        Todo todo = intent.getParcelableExtra("objTodo");
        todo.setCompleted(cb.isChecked());
    }

}