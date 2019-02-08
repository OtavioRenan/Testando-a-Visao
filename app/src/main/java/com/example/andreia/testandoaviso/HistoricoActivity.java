package com.example.andreia.testandoaviso;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.andreia.testandoaviso.bancoSQLite.Banco;
import com.example.andreia.testandoaviso.entity.BancoHistorico;

import java.util.ArrayList;
import java.util.List;

public class HistoricoActivity extends AppCompatActivity {

    private List<BancoHistorico> dados;
    private ListView lista;
    private Button botao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historico);

        botao = (Button)findViewById(R.id.btnDescricaoHistorico);
        botao.setOnClickListener(onClickTelaDetalhesHistorico);

        dados = new ArrayList<BancoHistorico>();
        lista = (ListView)findViewById(R.id.lista);

        popular();
    }

    public void onClickTelaMain(View w){
        Intent m = new Intent(HistoricoActivity.this, MainActivity.class);
        startActivity(m);
        finish();
    }

    public void popular(){
        Banco b = new Banco(HistoricoActivity.this);
        dados = b.listarDados();

        ArrayAdapter<BancoHistorico> adapter = new ArrayAdapter<BancoHistorico>(HistoricoActivity.this, android.R.layout.simple_list_item_1, dados);
        lista.setAdapter(adapter);
    }


    // Abaixo estão os os metodos para o dialogo com a interface
    View.OnClickListener onClickTelaDetalhesHistorico = new View.OnClickListener(){

        @Override
        public void onClick(View view) {
            AlertDialog.Builder builder = new AlertDialog.Builder(HistoricoActivity.this);
            builder.setPositiveButton("LPA: Acertos nas letras pequenas  -  LPE: Erros nas letras pequenas  -  LGA: Acertos nas letras grandes  -  " +
                    "LGE: Erros nas letras grandes  -  COA: Acertos no teste de cores  -  COE: Erros no teste de cores  -  " +
                    "TTA: Totao de acertos  -  TTE: Total de erros.", onClickAlert);
            AlertDialog alerta = builder.create();
            alerta.show();
        }
    };

    DialogInterface.OnClickListener onClickAlert = new DialogInterface.OnClickListener(){

        @Override
        public void onClick(DialogInterface dialogInterface, int i) {

        }
    };



}
