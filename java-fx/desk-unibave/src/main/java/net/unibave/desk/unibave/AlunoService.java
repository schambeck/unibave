package net.unibave.desk.unibave;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface AlunoService {

    @GET("alunos")
    Call<List<Aluno>> findAll();

}
