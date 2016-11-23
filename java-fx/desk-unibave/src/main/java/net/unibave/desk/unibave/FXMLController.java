package net.unibave.desk.unibave;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FXMLController implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");

        Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://localhost:8080/web-unibave-ws/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

        AlunoService service = retrofit.create(AlunoService.class);
        service.findAll().enqueue(new Callback<List<Aluno>>() {
            @Override
            public void onResponse(Call<List<Aluno>> call, Response<List<Aluno>> response) {
                List<Aluno> alunos = response.body();
                if (response.isSuccessful()) {
                    System.out.println(alunos);
                } else {
                    System.out.println(response.code() + " " + response.message());
                }
            }

            @Override
            public void onFailure(Call<List<Aluno>> call, Throwable throwable) {
                System.out.println("Erro: " + throwable.getMessage());
            }
        });
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
}
