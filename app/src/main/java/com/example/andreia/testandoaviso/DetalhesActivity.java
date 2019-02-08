package com.example.andreia.testandoaviso;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.andreia.testandoaviso.entity.BancoHistorico;

import java.util.ArrayList;
import java.util.List;

public class DetalhesActivity extends AppCompatActivity {

    int acertos;
    int erros;
    int letra_grande_erro;
    int letra_grande_acerto;
    int letra_pequena_erro;
    int letra_pequena_acerto;
    int pontos_erro;
    int pontos_acerto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);

        TextView verde = (TextView)findViewById(R.id.viewAcerto);
        TextView vermelho = (TextView)findViewById(R.id.viewErro);

        acertos = (int)getIntent().getExtras().get("acerto");
        erros = (int)getIntent().getExtras().get("erro");
/*
        letra_grande_erro = (int)getIntent().getExtras().get("letra_grande_erro");
        letra_grande_acerto = (int)getIntent().getExtras().get("letra_grande_acerto");
        letra_pequena_erro = (int)getIntent().getExtras().get("letra_pequena_erro");
        letra_pequena_acerto = (int)getIntent().getExtras().get("letra_pequena_acerto");
        pontos_erro = (int)getIntent().getExtras().get("pontos_erro");
        pontos_acerto = (int)getIntent().getExtras().get("pontos_acerto");
*/
        String ac = String.valueOf(acertos);
        String er = String.valueOf(erros);

        verde.setText(ac);
        vermelho.setText(er);
    }

    public void onClickTelaMain(View w){
        Intent m = new Intent(DetalhesActivity.this, MainActivity.class);
        startActivity(m);
        finish();
    }


    public List<BancoHistorico> listarDados(){

        List<BancoHistorico> dados = new ArrayList<BancoHistorico>();

            int letragrande_erro = letra_grande_erro;
            int letragrande_acerto = letra_grande_acerto;
            int letrapequena_erro = letra_pequena_erro;
            int letrapequena_acerto = letra_pequena_acerto;
            int pontoserro = pontos_erro;
            int pontosacerto = pontos_acerto;
            int total_Erro = erros;
            int total_Acerto = acertos;

            BancoHistorico bh2 = new BancoHistorico();

            bh2.setLetra_grande_erro(letragrande_erro);
            bh2.setLetra_grande_acerto(letragrande_acerto);
            bh2.setLetra_pequena_erro(letrapequena_erro);
            bh2.setLetra_pequena_acerto(letrapequena_acerto);
            bh2.setPontos_erro(pontoserro);
            bh2.setPontos_acerto(pontosacerto);
            bh2.setTotal_Erro(total_Erro);
            bh2.setTotal_Acerto(total_Acerto);

            dados.add(bh2);


        return dados;
    }

}
