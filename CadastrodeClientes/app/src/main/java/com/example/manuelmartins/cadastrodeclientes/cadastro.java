package com.example.manuelmartins.cadastrodeclientes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class cadastro extends AppCompatActivity implements View.OnClickListener {
    private EditText etCodigo,etNome,etEndereco,etCpf,etTelefone,etEmail;
    private Button btInserir,btConsultar,btRemover,btAlterar;
    private Repositorio rep;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);



        etCodigo = (EditText) findViewById(R.id.edtCodigo);
        etNome = (EditText) findViewById(R.id.edtNome);

        etEndereco = (EditText) findViewById(R.id.edtEndereco);
        etCpf = (EditText) findViewById(R.id.edtCpf);
        etTelefone = (EditText) findViewById(R.id.edtTelefone);
        etEmail = (EditText) findViewById(R.id.edtEmail);

        btInserir = (Button) findViewById(R.id.btInserir);
        btConsultar = (Button) findViewById(R.id.btConsultar);
        btRemover = (Button) findViewById(R.id.btRemover);
        btAlterar = (Button) findViewById(R.id.btAlterar);

        rep = new Repositorio(100);

        btInserir.setOnClickListener(this);
        btConsultar.setOnClickListener(this);
        btAlterar.setOnClickListener(this);
        btRemover.setOnClickListener(this);

    }

    public void limpa_campos(){

        etCodigo.setText("");
        etNome.setText("");
        etEndereco.setText("");
        etCpf.setText("");
        etTelefone.setText("");
        etEmail.setText("");

    }

    private boolean isCampovazio(String valor){
        boolean resultado = (TextUtils.isEmpty(valor) || valor.trim().isEmpty());
        return resultado;
    }

    private boolean isEmailValido(String email){
        boolean resultado = (Patterns.EMAIL_ADDRESS.matcher(email).matches());
        return resultado;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btInserir: {

                try {

                    String codigo = etCodigo.getText().toString();
                    String nome = etNome.getText().toString();
                    String cpf = etCpf.getText().toString();
                    String endereco = etEndereco.getText().toString();
                    String telefone = etTelefone.getText().toString();
                    String email = etEmail.getText().toString();

                    Cliente cliente = new Cliente(codigo,nome,cpf,endereco,telefone,email);

                    if (!isCampovazio(codigo) && !isCampovazio(nome) && !isCampovazio(cpf) &&
                            !isCampovazio(endereco) && !isCampovazio(telefone)&& !isCampovazio(email)&&
                            isEmailValido(email) && rep.inserir(cliente)){

                        Toast.makeText(getApplicationContext(), R.string.msg_cliente_inserido, Toast.LENGTH_SHORT).show();
                        limpa_campos();
                        etCodigo.requestFocus();

                    } else {

                        Toast.makeText(getApplicationContext(), R.string.msg_campos_invalidos_brancos, Toast.LENGTH_SHORT).show();

                    }

                }
                catch (Exception ex){

                    Toast.makeText(getApplicationContext(), ex.getMessage(), Toast.LENGTH_SHORT).show();

                }

                break;
            }

            case R.id.btConsultar: {

                try {

                    Cliente cliente = rep.procurar(etCodigo.getText().toString());

                    if (cliente != null){
                        etCodigo.setText(cliente.getCodigo());
                        etNome.setText(cliente.getNome());
                        etCpf.setText(cliente.getCPF());
                        etEndereco.setText(cliente.getEndereco());
                        etTelefone.setText(cliente.getTelefone());
                        etEmail.setText(cliente.getEmail());

                    }else {

                        Toast.makeText(getApplicationContext(), R.string.msg_n_localisado, Toast.LENGTH_SHORT).show();

                    }

                }
                catch (Exception ex){

                    Toast.makeText(getApplicationContext(), ex.getMessage(), Toast.LENGTH_SHORT).show();
                }

                break;
            }

            case R.id.btAlterar: {

                try {

                    String codigo = etCodigo.getText().toString();
                    String nome = etNome.getText().toString();
                    String cpf = etCpf.getText().toString();
                    String endereco = etEndereco.getText().toString();
                    String telefone = etTelefone.getText().toString();
                    String email = etEmail.getText().toString();

                    Cliente cliente = new Cliente(codigo,nome,cpf,endereco,telefone,email);

                    if(rep.atualizar(cliente)){

                        Toast.makeText(getApplicationContext(), R.string.msg_atualizado, Toast.LENGTH_SHORT).show();

                        limpa_campos();

                        etCodigo.requestFocus();

                    }else{

                        Toast.makeText(getApplicationContext(), R.string.msg_encontrado, Toast.LENGTH_SHORT).show();

                    }

                }
                catch (Exception ex){

                    Toast.makeText(getApplicationContext(), ex.getMessage(), Toast.LENGTH_SHORT).show();

                }

                break;
            }

            case R.id.btRemover: {

                if(rep.remover(etCodigo.getText().toString())){

                    Toast.makeText(getApplicationContext(), R.string.msg_removido, Toast.LENGTH_SHORT).show();

                    limpa_campos();
                    etCodigo.requestFocus();

                }else{

                    Toast.makeText(getApplicationContext(), R.string.msg_n_localisado, Toast.LENGTH_SHORT).show();

                }

                break;
            }
        }

    }

}
