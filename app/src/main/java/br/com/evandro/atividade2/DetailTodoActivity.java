package br.com.evandro.atividade2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.Objects;

import br.com.evandro.atividade2.model.Todo;

public class DetailTodoActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_todo);

        Objects.requireNonNull(getSupportActionBar()).setTitle("Todo Detail");

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