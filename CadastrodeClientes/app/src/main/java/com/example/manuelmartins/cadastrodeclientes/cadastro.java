package com.example.manuelmartins.cadastrodeclientes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class cadastro extends AppCompatActivity {
    EditText codigo,nome,endereco,cpf,telefone,email;
    Button inserir,consultar,remover,alterar;
    private Repositorio rep;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);



        codigo = (EditText) findViewById(R.id.edtCodigo);
        nome = (EditText) findViewById(R.id.edtNome);
        endereco = (EditText) findViewById(R.id.edtEndereco);
        cpf = (EditText) findViewById(R.id.edtCpf);
        telefone = (EditText) findViewById(R.id.edtTelefone);
        email = (EditText) findViewById(R.id.edtEmail);

        inserir = (Button) findViewById(R.id.btInserir);
        consultar = (Button) findViewById(R.id.btConsultar);
        remover = (Button) findViewById(R.id.btRemover);
        alterar = (Button) findViewById(R.id.btAlterar);

        rep = new Repositorio(100);

        inserir.setOnClickListener((View.OnClickListener) this);
        consultar.setOnClickListener((View.OnClickListener) this);
        remover.setOnClickListener((View.OnClickListener) this);
        alterar.setOnClickListener((View.OnClickListener) this);


    }

    public void limpa_campos(){

        codigo.setText("");
        nome.setText("");
        endereco.setText("");
        cpf.setText("");
        telefone.setText("");
        email.setText("");

    }

    


}
