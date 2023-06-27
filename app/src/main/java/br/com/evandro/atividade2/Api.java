package br.com.evandro.atividade2;

import java.util.List;

import br.com.evandro.atividade2.model.Album;
import br.com.evandro.atividade2.model.Comment;
import br.com.evandro.atividade2.model.Post;
import br.com.evandro.atividade2.model.Todo;
import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    @GET("/todos")
    Call<List<Todo>> getTodos();

    @GET("/comments")
    Call<List<Comment>> getComments();

    @GET("/albums")
    Call<List<Album>> getAlbums();

    @GET("/posts")
    Call<List<Post>> getPosts();

}