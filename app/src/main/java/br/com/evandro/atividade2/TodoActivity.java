package br.com.evandro.atividade2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import br.com.evandro.atividade2.model.Todo;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TodoActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo);

        Objects.requireNonNull(getSupportActionBar()).setTitle("ToDo");

        Api api = ApiClient.getClient().create(Api.class);
        Call<List<Todo>> call = api.getTodos();
        call.enqueue(new Callback<List<Todo>>() {
            @Override
            public void onResponse(@NonNull Call<List<Todo>> call, @NonNull Response<List<Todo>> response) {
                if (response.body() == null) {
                    return;
                }

                fillList(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<List<Todo>> call, @NonNull Throwable t) {
                Log.e("Evandro", "Falha ao obter todos.");
            }
        });
    }

    public void fillList(List<Todo> todos) {
        Toast.makeText(this,"qtd: " + todos.size(), Toast.LENGTH_SHORT).show();
        LinearLayout ll = findViewById(R.id.layoutVerticalItems);

        for (Todo todo : todos) {
            Button bt = new Button(this);
            bt.setText(todo.getTitle());
            bt.setOnClickListener(v -> {
                Intent intent = new Intent(getApplicationContext(), DetailTodoActivity.class);
                intent.putExtra("objTodo", todo);
                startActivity(intent);
            });

            ll.addView(bt);
        }
    }

}