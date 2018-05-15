package com.example.manuelmartins.cadastrodeclientes;

import android.support.v7.app.AlertDialog;
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

    private void validaCanpos(){

        boolean res = false;

        String codigo = etCodigo.getText().toString();
        String nome = etNome.getText().toString();
        String endereco = etEndereco.getText().toString();
        String cpf = etCpf.getText().toString();
        String telefone = etTelefone.getText().toString();
        String email = etEmail.getText().toString();

        if (isCampovazio(codigo)){
            res = true;
            etCodigo.requestFocus();
        }else
            if (isCampovazio(nome)){
            etNome.requestFocus();
            res = true;
            }else
                if (isCampovazio(cpf)){
                etCpf.requestFocus();
                res = true;
                }else
                     if (isCampovazio(endereco)){
                        etEndereco.requestFocus();
                        res = true;
                    }else
                        if (isCampovazio(telefone)){
                        etTelefone.requestFocus();
                        res = true;
                        }else
                            if (!isEmailValido(email)){
                            etEmail.requestFocus();
                            res = true;
                            }

   /* if (res){
        AlertDialog.Builder dlg = new AlertDialog.Builder(this);
        dlg.setTitle("Aviso");
        dlg.setMessage("Ha campos inválidos ou em branco");
        dlg.setNeutralButton("OK",null);
        dlg.show();
    }*/


    }

    private boolean isCampovazio(String valor){
        boolean resultado = (TextUtils.isEmpty(valor) || valor.trim().isEmpty());
        return resultado;
    }

    private boolean isEmailValido(String email){
        boolean resultado = (isCampovazio(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
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

                    validaCanpos();

                    Cliente cliente = new Cliente(codigo,nome,cpf,telefone,email,endereco);

                    if (!isCampovazio(codigo) && !isCampovazio(nome) && !isCampovazio(cpf) &&
                            !isCampovazio(endereco) && !isCampovazio(telefone) && !isEmailValido(email) && rep.inserir(cliente)){

                        Toast.makeText(getApplicationContext(), "Cliente inserido com sucesso", Toast.LENGTH_SHORT).show();
                        limpa_campos();
                        etCodigo.requestFocus();

                    } else {

                        Toast.makeText(getApplicationContext(), "Ha campos inválidos ou em branco", Toast.LENGTH_SHORT).show();

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
                        etEndereco.setText(cliente.getEndereco());
                        etCpf.setText(cliente.getCPF());
                        etTelefone.setText(cliente.getTelefone());
                        etEmail.setText(cliente.getEmail());

                    }else {

                        Toast.makeText(getApplicationContext(), "Cliente não localizado", Toast.LENGTH_SHORT).show();

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
                    String endereco = etEndereco.getText().toString();
                    String cpf = etCpf.getText().toString();
                    String telefone = etTelefone.getText().toString();
                    String email = etEmail.getText().toString();

                    Cliente cliente = new Cliente(codigo,nome,cpf,telefone,email,endereco);

                    if(rep.atualizar(cliente)){

                        Toast.makeText(getApplicationContext(), "Cliente atualizado com sucesso", Toast.LENGTH_SHORT).show();

                        limpa_campos();

                        etCodigo.requestFocus();

                    }else{

                        Toast.makeText(getApplicationContext(), "Cliente não encontrado", Toast.LENGTH_SHORT).show();

                    }

                }
                catch (Exception ex){

                    Toast.makeText(getApplicationContext(), ex.getMessage(), Toast.LENGTH_SHORT).show();

                }

                break;
            }

            case R.id.btRemover: {

                if(rep.remover(etCodigo.getText().toString())){

                    Toast.makeText(getApplicationContext(), "Cliente removido com sucesso", Toast.LENGTH_SHORT).show();

                    limpa_campos();
                    etCodigo.requestFocus();

                }else{

                    Toast.makeText(getApplicationContext(), "Cliente não localizado", Toast.LENGTH_SHORT).show();

                }

                break;
            }
        }

    }

}
