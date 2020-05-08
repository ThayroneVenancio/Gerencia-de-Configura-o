package com.example.av01;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MenuPrincipal extends Activity {

    private ListView lista;
    private String[] listaCadastros = {"Cadastro do Imposto sobre Circulação de Mercadorias e Serviços (ICMS) por estado", "Cadastro de Pedidos", "Cadastro de Vendas"};
    private Button sair;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        lista = findViewById(R.id.listaCadastros);
        sair = findViewById(R.id.bt_sairMenu);

        final ArrayAdapter<String> adaptador = new ArrayAdapter<String>(
                getApplicationContext(), android.R.layout.simple_list_item_1,android.R.id.text1, listaCadastros

        );


        lista.setAdapter(adaptador);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        Intent intent = new Intent(MenuPrincipal.this, CadastroICMS.class);
                        startActivity(intent);

                        break;

                    case 1:
                        Intent intent1 = new Intent(MenuPrincipal.this, CadastroPedido.class);
                        startActivity(intent1);

                        break;

                    case 2:
                        Intent intent2 = new Intent(MenuPrincipal.this, CadastroVendas.class);
                        startActivity(intent2);
                }

            }
        });

        sair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuPrincipal.this, MainActivity.class));
            }
        });
    }
}







