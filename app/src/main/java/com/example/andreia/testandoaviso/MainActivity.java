package com.example.andreia.testandoaviso;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnMainIniciar = (Button)findViewById(R.id.btnMainIniciar);
        btnMainIniciar.setOnClickListener(onClickTelaTeste);

    }

    public void onCLickTelaDescricao(View v){
        Intent i = new Intent(MainActivity.this, DescricaoActivity.class);
        startActivity(i);
        finish();

    }

    public void onCLickTelaHistorico(View s){
        Intent e = new Intent(MainActivity.this, HistoricoActivity.class);
        startActivity(e);
        finish();
    }


    View.OnClickListener onClickTelaTeste = new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setMessage("ESTE APLICATIVO NÃO FOI DESENVOLVIDO POR PROFISSIONAIS DA SAÚDE, E NÃO TEM O FITO DE FAZER DIAGNOSTICOS !");
            builder.setPositiveButton("OK", onClickOkAlert);
            AlertDialog alerta = builder.create();
            alerta.show();
        }
    };

    DialogInterface.OnClickListener onClickOkAlert = new DialogInterface.OnClickListener(){

        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            Intent e = new Intent(MainActivity.this, TesteActivity.class);
            startActivity(e);
            finish();
        }
    };

}
