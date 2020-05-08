package com.example.av01;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class CadastroICMS extends Activity {

    private AlertDialog.Builder dialog;
    private Spinner estados;
    private String spinnerArray[] = {"", "Acre", "Alagoas", "Amapá", "Amazonas", "Bahia","Ceará", "Distrito Federal", "Espirito Santo",
            "Goiás", "Maranhão", "Mato Grosso", "Mato Grosso do Sul", "Minas Gerais", "Pará", "Paraíba",
            "Paraná","Pernambuco", "Piaui", "Rio de Janeiro", "Rio Grande do Norte", "Rio Grande do Sul",
            "Rondonia", "Roraima", "Santa Catarina", "São Paulo", "Sergipe", "Tocantins"};
    private RadioGroup porcentagem;
    private RadioButton valor1;
    private RadioButton valor2;
    private RadioButton valor3;
    private Button salvar;
    private Button voltar;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_i_c_m_s);

        estados = findViewById(R.id.spEstados);
        porcentagem = (RadioGroup) findViewById(R.id.rg_porcentagem);
        salvar = findViewById(R.id.bt_salvarPedido);
        valor1 = findViewById(R.id.rdbt_17);
        valor2 = findViewById(R.id.rdbt_18);
        valor3 = findViewById(R.id.rdbt_175);
        salvar = findViewById(R.id.bt_salvar);
        voltar = findViewById(R.id.bt_voltarIcms);

        final ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, spinnerArray);

        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        estados.setAdapter(spinnerAdapter);



        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog = new AlertDialog.Builder(CadastroICMS.this);
                String porc = "";
                if (valor1.isChecked()){
                    porc = "17%";
                }
                if (valor2.isChecked()){
                    porc = "18%";
                }
                if (valor3.isChecked()){
                    porc = "17,5%";
                }
                String mensagem = "";
                mensagem += "\nEstado: "+estados.getSelectedItem().toString();
                mensagem += "\nPorcentagem de ICMS: "+porc;

                dialog.setTitle("Detalhes do Imposto");
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
                startActivity(new Intent(CadastroICMS.this, MenuPrincipal.class));
            }
        });





    }

}
