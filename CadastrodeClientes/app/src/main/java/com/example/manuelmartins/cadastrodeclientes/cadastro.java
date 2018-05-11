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

    /*
  public void actionPerformed(ActionEvent e) {

// clicou no inserir

        if (e.getSource() == b1) {

            try {

                    String numero = tfCodigo.getText();

                    String tipo = tfTipo.getText();

                    String bairro = tfBairro.getText();

                    double area = Double.parseDouble(tfArea.getText());

                    int numero_quartos =
                    Integer.parseInt(this.tfNumeroQuartos.getText());

                    int numero_banheiros =
                    Integer.parseInt(this.tfNumeroBanheiros.getText());

                    int numero_garagens =
                    Integer.parseInt(this.tfGaragens.getText());

                    double preco = Double.parseDouble(this.tfPreco.getText()
           );

           Imovel i = new
                Imovel(numero,tipo,bairro,area,numero_quartos,numero_banheiros,
                numero_garagens,preco);

                if (rep.inserir(i)) {

                JOptionPane.showMessageDialog(this, "imóvel inserido com
                sucesso");

                limpa_campos();

                }

                else

                JOptionPane.showMessageDialog(this, "Repositório cheio");

                }

                catch(Exception ex) {

                JOptionPane.showMessageDialog(this, ex.getMessage());

                }

            }

          // clicou no consultar

        if (e.getSource() == b2) {

            try {

                Imovel c = rep.procurar(tfCodigo.getText());

                if (c != null) {

                tfTipo.setText(c.getTipo());

                tfBairro.setText(c.getBairro());

                tfArea.setText("" + c.getArea());

                tfNumeroQuartos.setText("" + c.getNumero_quartos());

                tfNumeroBanheiros.setText("" + c.getNumero_banheiros());

                tfGaragens.setText("" + c.getNumero_garagens());

                tfPreco.setText("" + c.getPreco());

        }

        else

        JOptionPane.showMessageDialog(this, "imóvel não
        localizado");
     }

     catch(Exception ex) {

            JOptionPane.showMessageDialog(this, ex.getMessage());

}

}

// clicou no alterar

        if (e.getSource() == b3) {

            try {

                String numero = tfCodigo.getText();

                String tipo = tfTipo.getText();

                String bairro = tfBairro.getText();

                double area = Double.parseDouble(tfArea.getText());

                int numero_quartos =
                Integer.parseInt(this.tfNumeroQuartos.getText());

                int numero_banheiros =
                Integer.parseInt(this.tfNumeroBanheiros.getText());
                int numero_garagens = Integer.parseInt(this.tfGaragens.getText());

                double preco = Double.parseDouble(this.tfPreco.getText() );

                Imovel i = new Imovel( numero, tipo, bairro, area, numero_quartos,
                numero_banheiros, numero_garagens, preco);

                if (rep.atualizar(i)) {

                JOptionPane.showMessageDialog(this, "imóvel atualizado com
                sucesso");

                limpa_campos();

                }

                else

                JOptionPane.showMessageDialog(this, "Imóvel não
                encontrado");

                }

                catch(Exception ex) {

                JOptionPane.showMessageDialog(this, ex.getMessage());

        } }

        // clicou no remover

        if (e.getSource() == b4) {

                if (rep.remover(tfCodigo.getText())) {

                    JOptionPane.showMessageDialog(this, "imóvel removido
                    com sucesso");

                limpa_campos();

                }

                else

                    JOptionPane.showMessageDialog(this, "imóvel não
                    localizado");

                }

        }
    * */




}
