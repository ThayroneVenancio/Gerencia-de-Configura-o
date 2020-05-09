package com.example.av01;

import android.widget.EditText;

public class DAO {

    public boolean salvarProduto(CadastroPedido produto){
        System.out.println(produto.getDescProduto() + " foi cadastrado corretamente!!!");
        return true;
    }
}
