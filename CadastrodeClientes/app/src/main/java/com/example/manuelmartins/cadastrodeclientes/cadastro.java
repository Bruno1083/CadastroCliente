package com.example.manuelmartins.cadastrodeclientes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class cadastro extends AppCompatActivity implements View.OnClickListener {
    EditText etCodigo,etNome,etEndereco,etCpf,etTelefone,etEmail;
    Button btInserir,btConsultar,btRemover,btAlterar;
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

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btInserir: {
                try {
                    String codigo = etCodigo.getText().toString();
                    String nome = etCodigo.getText().toString();
                    String endereco = etCodigo.getText().toString();
                    String cpf = etCodigo.getText().toString();
                    String telefone = etCodigo.getText().toString();
                    String email = etCodigo.getText().toString();

                    Cliente cliente = new Cliente(codigo,nome,cpf,telefone,email,endereco);

                    if (rep.inserir(cliente)){
                        //JOptionPane.showMessageDialog(this, "Cliente inserido com sucesso");
                        limpa_campos();
                    } else {
                        //JOptionPane.showMessageDialog(this, "Repositório cheio");
                    }

                }
                catch (Exception ex){

                    //JOptionPane.showMessageDialog(this, ex.getMessage());

                }

                break;
            }
        }

        switch (v.getId()){
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

                        //JOptionPane.showMessageDialog(this, "Cliente não localizado");

                    }

                }
                catch (Exception ex){

                    //JOptionPane.showMessageDialog(this, ex.getMessage());

                }

                break;
            }
        }

        switch (v.getId()){
            case R.id.btAlterar: {

                try {

                    String codigo = etCodigo.getText().toString();
                    String nome = etCodigo.getText().toString();
                    String endereco = etCodigo.getText().toString();
                    String cpf = etCodigo.getText().toString();
                    String telefone = etCodigo.getText().toString();
                    String email = etCodigo.getText().toString();

                    Cliente cliente = new Cliente(codigo,nome,cpf,telefone,email,endereco);

                    if(rep.atualizar(cliente)){
                        //  JOptionPane.showMessageDialog(this, "Cliente atualizado com sucesso");

                        limpa_campos();
                    }else{

                      //JOptionPane.showMessageDialog(this, "Cliente não encontrado");

                    }

                }
                catch (Exception ex){

                    //JOptionPane.showMessageDialog(this, ex.getMessage());

                }

                break;
            }
        }

        switch (v.getId()){
            case R.id.btRemover: {

                if(rep.remover(etCodigo.getText().toString())){
                    // JOptionPane.showMessageDialog(this, "Cliente removido com sucesso");
                   limpa_campos();

                }else{
                    //JOptionPane.showMessageDialog(this, "Cliente não localizado");
                }

                break;
            }
        }

    }

}
