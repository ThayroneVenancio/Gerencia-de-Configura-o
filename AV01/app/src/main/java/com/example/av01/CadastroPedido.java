package com.example.av01;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CadastroPedido extends Activity {

    private AlertDialog.Builder dialog;
    private EditText produto;
    private EditText valor;
    private EditText descriçao;
    private EditText dataPedido;
    private EditText dataPrevPedido;
    private Button salvar;
    private Button voltar;
    private Double preco;
    private String descProduto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_pedido);

        produto = findViewById(R.id.txt_produtoPedido);
        valor = findViewById(R.id.txt_valorPedido);
        descriçao = findViewById(R.id.txt_descProduto);
        dataPedido = findViewById(R.id.dt_dataPedido);
        dataPrevPedido = findViewById(R.id.dt_dataPrevista);
        salvar = findViewById(R.id.bt_salvarPedido);
        voltar = findViewById(R.id.bt_voltar);


        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog = new AlertDialog.Builder(CadastroPedido.this);
                String mensagem = "";
                mensagem += "\n Pedido: " +produto.getText();
                mensagem += "\n Valor: " +valor.getText();
                mensagem += "\n Descrição do Produto: " +descriçao.getText();
                mensagem += "\n Data do Pedido: " +dataPedido.getText();
                mensagem += "\n Data Prevista da Entrega: " +dataPrevPedido.getText();

                dialog.setTitle("Detalhes do Pedido");
                dialog.setMessage(mensagem);

                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                dialog.setCancelable(false);

                dialog.create();
                dialog.show();

            }
        });

        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CadastroPedido.this, MenuPrincipal.class));
            }
        });
    }





    public AlertDialog.Builder getDialog() {
        return dialog;
    }

    public EditText getProduto() {
        return produto;
    }

    public EditText getValor() {
        return valor;
    }

    public EditText getDescriçao() {
        return descriçao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public EditText getDataPedido() {
        return dataPedido;
    }

    public EditText getDataPrevPedido() {
        return dataPrevPedido;
    }

    public Button getSalvar() {
        return salvar;
    }

    public Button getVoltar() {
        return voltar;
    }

    public void setDialog(AlertDialog.Builder dialog) {
        this.dialog = dialog;
    }

    public void setProduto(EditText produto) {
        this.produto = produto;
    }

    public void setValor(EditText valor) {
        this.valor = valor;

    }

    public String getDescProduto() {
        return descProduto;
    }

    public void setDescProduto(String descProduto) {
        this.descProduto = descProduto;
    }

    public void setDescriçao(EditText descriçao) {
        this.descriçao = descriçao;
    }

    public void setDataPedido(EditText dataPedido) {
        this.dataPedido = dataPedido;
    }

    public void setDataPrevPedido(EditText dataPrevPedido) {
        this.dataPrevPedido = dataPrevPedido;
    }

    public void setSalvar(Button salvar) {
        this.salvar = salvar;
    }

    public void setVoltar(Button voltar) {
        this.voltar = voltar;
    }

    public boolean verificarValor(Double preco){

        Double verificar = preco;

        if(verificar > 0){
            return true;
        }else{
            return false;
        }
    }

    public void informarProduto(String infProduto){
        this.descProduto = infProduto;
    }


}
