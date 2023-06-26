package br.com.evandro.atividade2;

import java.util.List;

import br.com.evandro.atividade2.model.Todo;
import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    @GET("/todos")
    Call<List<Todo>> getTodos();

}