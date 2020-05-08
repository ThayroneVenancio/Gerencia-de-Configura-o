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
        import android.widget.EditText;
        import android.widget.RadioButton;
        import android.widget.RadioGroup;
        import android.widget.Spinner;

public class CadastroVendas extends Activity {

    private AlertDialog.Builder dialog;
    private EditText comprador;
    private EditText produto;
    private EditText valor;
    private Spinner estadoRemetente;
    private Spinner icmsEstRemetente;
    private Spinner estadoDestinatario;
    private Spinner icmsEstDestinatario;
    private String spinnerArray[] = {"", "Acre", "Alagoas", "Amapá", "Amazonas", "Bahia","Ceará", "Distrito Federal", "Espirito Santo",
            "Goiás", "Maranhão", "Mato Grosso", "Mato Grosso do Sul", "Minas Gerais", "Pará", "Paraíba",
            "Paraná","Pernambuco", "Piaui", "Rio de Janeiro", "Rio Grande do Norte", "Rio Grande do Sul",
            "Rondonia", "Roraima", "Santa Catarina", "São Paulo", "Sergipe", "Tocantins"};
    private String spinnerIcmsArray[] = {"", "17%", "17,5%", "18%"};
    private RadioGroup interestadual;
    private RadioButton valor12;
    private RadioButton valor7;
    private Button salvar;
    private Button voltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_vendas);

        comprador = findViewById(R.id.txt_comprador);
        produto = findViewById(R.id.txt_produto);
        valor = findViewById(R.id.txt_valor);
        estadoRemetente = findViewById(R.id.sp_estadoRe);
        icmsEstRemetente = findViewById(R.id.sp_icmsEstadoRe);
        estadoDestinatario = findViewById(R.id.sp_estadoDest);
        icmsEstDestinatario = findViewById(R.id.sp_icmsEstDest);
        interestadual = findViewById(R.id.rg_interetadual);
        valor12 = findViewById(R.id.rdbt_12);
        valor7 = findViewById(R.id.rdbt_7);
        salvar = findViewById(R.id.bt_salvar);
        voltar = findViewById(R.id.bt_voltarVendas);

        final ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, spinnerArray);

        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        estadoRemetente.setAdapter(spinnerAdapter);
        estadoDestinatario.setAdapter(spinnerAdapter);

        final ArrayAdapter<String> spinnerAdapterIcms = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, spinnerIcmsArray);

        spinnerAdapterIcms.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        icmsEstDestinatario.setAdapter(spinnerAdapterIcms);
        icmsEstRemetente.setAdapter(spinnerAdapterIcms);


        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog = new AlertDialog.Builder(CadastroVendas.this);
                String inter = "";
                if (valor12.isChecked()) {
                    inter = "12%";
                }
                if (valor7.isChecked()) {
                    inter = "7%";
                }
                String mensagem = "";
                mensagem += "\nComprador: " + comprador.getText();
                mensagem += "\nProduto: " + produto.getText();
                mensagem += "\nValor: " + valor.getText();
                mensagem += "\nEstado Remetente: " + estadoRemetente.getSelectedItem().toString();
                mensagem += "\nICMS do Estado Remetente: " + icmsEstRemetente.getSelectedItem().toString();
                mensagem += "\nEstado Destinatário: " + estadoDestinatario.getSelectedItem().toString();
                mensagem += "\nICMS do Estado Destinatário: " + icmsEstDestinatario.getSelectedItem().toString();
                mensagem += "\nICMS InterEstadual: " + inter;

                dialog.setTitle("Detalhes da Venda");
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
                startActivity(new Intent(CadastroVendas.this, MenuPrincipal.class));
            }
        });
    }
}
