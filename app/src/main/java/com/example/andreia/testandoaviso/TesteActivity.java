package com.example.andreia.testandoaviso;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.example.andreia.testandoaviso.bancoSQLite.Banco;
import com.example.andreia.testandoaviso.entity.BancoHistorico;

public class TesteActivity extends AppCompatActivity {

    BancoHistorico bh = new BancoHistorico();
    private String c = "Certo";
    private String e = "Errado";

    private Button btnTesteMais;
    private Button btnTesteHome;
    private ViewFlipper flipperTeste;

    private boolean validacao_b = true;
    private boolean validacao_b2 = true;
    private boolean validacao_p = true;
    private boolean validacao_c = true;
    private boolean validacao_l = true;
    private boolean validacao_d = true;
    private boolean validacao_e = true;
    private boolean validacao_f = true;
    private boolean validacao_z = true;
    private boolean validacao_o = true;
    private boolean validacao_t = true;
    private boolean validacao_2 = true;
    private boolean validacao_5 = true;
    private boolean validacao_5_1 = true;
    private boolean validacao_5_2 = true;
    private boolean validacao_6 = true;
    private boolean validacao_6_1 = true;
    private boolean validacao_7 = true;
    private boolean validacao_7_1 = true;
    private boolean validacao_7_2 = true;
    private boolean validacao_8 = true;
    private boolean validacao_10 = true;
    private boolean validacao_35 = true;
    private boolean validacao_74 = true;
    private boolean validacao_56 = true;
    private boolean validacao_45 = true;
    private boolean validacao_42 = true;
    private boolean validacao_42_1 = true;
    private boolean validacao_29 = true;
    private boolean validacao_26 = true;
    private boolean validacao_16 = true;
    private boolean validacao_13 = true;
    private boolean validacao_12 = true;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teste);

        btnTesteMais = (Button)findViewById(R.id.btnTesteMais);
        btnTesteHome = (Button)findViewById(R.id.btnTesteHome);
        flipperTeste = (ViewFlipper)findViewById(R.id.flipperTeste);

        btnTesteMais.setOnClickListener(onClickMais);
        btnTesteHome.setOnClickListener(onClickTelaDetalhes);

    }
// Abaixo estão os botões de mover os layouts
    View.OnClickListener onClickMais = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.btnTesteMais:
                    flipperTeste.showNext();
                    break;
            }//método do botão para mudar o fliper
        }
    };

    public void onClickTesteVoltar(View pre){
        flipperTeste.showPrevious();
    } //método do botão para mudar o fliper

// Abaixo estão os os metodos para o dialogo com a interface
    View.OnClickListener onClickTelaDetalhes = new View.OnClickListener(){

        @Override
        public void onClick(View view) {
            AlertDialog.Builder builder = new AlertDialog.Builder(TesteActivity.this);
            builder.setMessage("TEM CERTEZA QUE DESEJA SAIR?");
            builder.setPositiveButton("OK", onClickOkAlert);
            builder.setNegativeButton("Cancelar", onClickCancelarAlert);
            AlertDialog alerta = builder.create();
            alerta.show();
        }
    };

    DialogInterface.OnClickListener onClickOkAlert = new DialogInterface.OnClickListener(){

        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            Banco b = new Banco(TesteActivity.this);
            b.salvarDados(bh);
            Toast.makeText(TesteActivity.this, "Dados Salvos no Banco", Toast.LENGTH_SHORT).show();

            //Já que o banco não esta funcionando, aqui está o falcete *_*
            //Aqui está o método normal, que salva os dados no banco
            Intent dt = new Intent(TesteActivity.this, DetalhesActivity.class);
            dt.putExtra("acerto", bh.getTotal_Acerto());
            dt.putExtra("erro", bh.getTotal_Erro());
/*            dt.putExtra("letra_grande_erro", bh.getLetra_grande_erro());
            dt.putExtra("letra_grande_acerto", bh.getLetra_grande_acerto());
            dt.putExtra("letra_pequena_erro", bh.getLetra_pequena_erro());
            dt.putExtra("letra_pequena_acerto", bh.getLetra_pequena_acerto());
            dt.putExtra("pontos_erro", bh.getPontos_erro());
            dt.putExtra("pontos_acertos", bh.getPontos_acerto());
            */
            startActivity(dt);
            bh =  new BancoHistorico();
            finish();
        }
    };

    DialogInterface.OnClickListener onClickCancelarAlert = new DialogInterface.OnClickListener(){

        @Override
        public void onClick(DialogInterface dialogInterface, int i) {

        }
    };

    //Abaixo se encontra todas os métodos de validação das imagens
    public void onClickVerificar_p(View q){

        EditText letra_p = (EditText)findViewById(R.id.txtl_p);
        String p = letra_p.getText().toString();

        if(p.compareTo("") == 0){
            Toast.makeText(TesteActivity.this, "Digite o valor!!", Toast.LENGTH_SHORT).show();
        }   else {
            if (p.compareTo("p") == 0 || p.compareTo("P") == 0) {
                if(validacao_p == true){
                    bh.setLetra_pequena_acerto(bh.getLetra_pequena_acerto() + 1);
                    bh.setTotal_Acerto(bh.getTotal_Acerto() + 1);
                    Toast.makeText(TesteActivity.this, bh.getTotal_Acerto() + " Acertos", Toast.LENGTH_SHORT).show();
                    validacao_p = false;
                    flipperTeste.showNext();
                } else {
                    flipperTeste.showNext();
                }

            } else {
                bh.setLetra_pequena_erro(bh.getLetra_pequena_erro() +1);
                bh.setTotal_Erro(bh.getTotal_Erro() + 1);
                Toast.makeText(TesteActivity.this, bh.getTotal_Erro() + " Erros", Toast.LENGTH_SHORT).show();
                flipperTeste.showNext();
            }

        }
    }

    public void onClickVerificar_c(View q){

        EditText letra_c = (EditText)findViewById(R.id.txtL_c);
        String cc = letra_c.getText().toString();

        if(c.compareTo("") == 0){
            Toast.makeText(TesteActivity.this, "Digite o valor!!", Toast.LENGTH_SHORT).show();
        }   else {
            if (cc.compareTo("c") == 0 || cc.compareTo("C") == 0) {
                if(validacao_c == true){
                    bh.setLetra_grande_acerto(bh.getLetra_grande_acerto() + 1);
                    bh.setTotal_Acerto(bh.getTotal_Acerto() + 1);
                    Toast.makeText(TesteActivity.this, bh.getTotal_Acerto() + " Acertos", Toast.LENGTH_SHORT).show();
                    validacao_c = false;
                    flipperTeste.showNext();
                } else {
                    flipperTeste.showNext();
                }

            } else {
                bh.setLetra_grande_erro(bh.getLetra_grande_erro() + 1);
                bh.setTotal_Erro(bh.getTotal_Erro() + 1);
                Toast.makeText(TesteActivity.this, bh.getTotal_Erro() + " Erros", Toast.LENGTH_SHORT).show();
                flipperTeste.showNext();
            }

        }
    }

    public void onClickVerificar_l(View q){

        EditText letra_l = (EditText)findViewById(R.id.txtL_l);
        String l = letra_l.getText().toString();

        if(c.compareTo("") == 0){
            Toast.makeText(TesteActivity.this, "Digite o valor!!", Toast.LENGTH_SHORT).show();
        }   else {
            if (l.compareTo("l") == 0 || l.compareTo("L") == 0) {
                if (validacao_l == true) {
                    bh.setLetra_grande_acerto(bh.getLetra_grande_acerto() + 1);
                    bh.setTotal_Acerto(bh.getTotal_Acerto() + 1);
                    Toast.makeText(TesteActivity.this, bh.getTotal_Acerto() + " Acertos", Toast.LENGTH_SHORT).show();
                    validacao_l = false;
                    flipperTeste.showNext();
                } else {
                    flipperTeste.showNext();
                }
            } else {
                bh.setLetra_grande_erro(bh.getLetra_grande_erro() + 1);
                bh.setTotal_Erro(bh.getTotal_Erro() + 1);
                Toast.makeText(TesteActivity.this, bh.getTotal_Erro() + " Erros", Toast.LENGTH_SHORT).show();
                flipperTeste.showNext();
            }

        }
    }



    public void onClickVerificar_o(View w){

        EditText letra_o = (EditText)findViewById(R.id.txtl_o);
        String o = letra_o.getText().toString();

        if(o.compareTo("") == 0){
            Toast.makeText(TesteActivity.this, "Digite o valor!!", Toast.LENGTH_SHORT).show();
        }   else {
            if (o.compareTo("o") == 0 || o.compareTo("O") == 0) {
                if (validacao_o == true){
                    bh.setLetra_grande_acerto(bh.getLetra_grande_acerto() + 1);
                    bh.setTotal_Acerto(bh.getTotal_Acerto() + 1);
                    Toast.makeText(TesteActivity.this, bh.getTotal_Acerto() + " Acertos", Toast.LENGTH_SHORT).show();
                    validacao_o = false;
                    flipperTeste.showNext();
                } else {
                    flipperTeste.showNext();
                }
            } else {
                bh.setLetra_grande_erro(bh.getLetra_grande_erro() + 1);
                bh.setTotal_Erro(bh.getTotal_Erro() + 1);
                Toast.makeText(TesteActivity.this, bh.getTotal_Erro() + " Erros", Toast.LENGTH_SHORT).show();
                flipperTeste.showNext();
            }
        }
    }

    public void onClickVerificar_z(View er){

        EditText letra_z = (EditText)findViewById(R.id.txt_z);
        String z = letra_z.getText().toString();

        if(z.compareTo("") == 0){
            Toast.makeText(TesteActivity.this, "Digite o valor!!", Toast.LENGTH_SHORT).show();
        }   else {
            if (z.compareTo("z") == 0 || z.compareTo("Z") == 0) {
                if(validacao_z == true){
                    bh.setLetra_pequena_acerto(bh.getLetra_pequena_acerto() + 1);
                    bh.setTotal_Acerto(bh.getTotal_Acerto() + 1);
                    Toast.makeText(TesteActivity.this, bh.getTotal_Acerto() + " Acertos", Toast.LENGTH_SHORT).show();
                    validacao_z = false;
                    flipperTeste.showNext();
                } else {
                    flipperTeste.showNext();
                }
            } else {
                bh.setLetra_pequena_erro(bh.getLetra_pequena_erro() +1);
                bh.setTotal_Erro(bh.getTotal_Erro() + 1);
                Toast.makeText(TesteActivity.this, bh.getTotal_Erro() + " Erros", Toast.LENGTH_SHORT).show();
                flipperTeste.showNext();
            }

        }
    }

    public void onClickVerificar_e(View r){

        EditText letra_e = (EditText)findViewById(R.id.txt_e);
        String ee = letra_e.getText().toString();

        if(ee.compareTo("") == 0){
            Toast.makeText(TesteActivity.this, "Digite o valor!!", Toast.LENGTH_SHORT).show();
        }   else {
            if (ee.compareTo("e") == 0 || ee.compareTo("E") == 0) {
                if(validacao_e == true){
                    bh.setLetra_pequena_acerto(bh.getLetra_pequena_acerto() + 1);
                    bh.setTotal_Acerto(bh.getTotal_Acerto() + 1);
                    Toast.makeText(TesteActivity.this, bh.getTotal_Acerto() + " Acertos", Toast.LENGTH_SHORT).show();
                    validacao_e = false;
                    flipperTeste.showNext();
                } else {
                    flipperTeste.showNext();
                }
            } else {
                bh.setLetra_pequena_erro(bh.getLetra_pequena_erro() +1);
                bh.setTotal_Erro(bh.getTotal_Erro() + 1);
                Toast.makeText(TesteActivity.this, bh.getTotal_Erro() + " Erros", Toast.LENGTH_SHORT).show();
                flipperTeste.showNext();
            }

        }
    }


    public void onClickVerificar_b(View t){

        EditText letra_b = (EditText)findViewById(R.id.txt_b);
        String b = letra_b.getText().toString();

        if(b.compareTo("") == 0){
            Toast.makeText(TesteActivity.this, "Digite o valor!!", Toast.LENGTH_SHORT).show();
        }   else {
            if (b.compareTo("b") == 0 || b.compareTo("B") == 0) {
                if(validacao_b == true){
                    bh.setLetra_grande_acerto(bh.getLetra_grande_acerto() + 1);
                    bh.setTotal_Acerto(bh.getTotal_Acerto() + 1);
                    Toast.makeText(TesteActivity.this, bh.getTotal_Acerto() + " Acertos", Toast.LENGTH_SHORT).show();
                    validacao_b = false;
                    flipperTeste.showNext();
                } else {
                    flipperTeste.showNext();
                }
            } else {
                bh.setLetra_grande_erro(bh.getLetra_grande_erro() +1);
                bh.setTotal_Erro(bh.getTotal_Erro() + 1);
                Toast.makeText(TesteActivity.this, bh.getTotal_Erro() + " Erros", Toast.LENGTH_SHORT).show();
                flipperTeste.showNext();
            }
        }

    }

    public void onClickVerificar_d(View t){

        EditText letra_d = (EditText)findViewById(R.id.txtL_d);
        String d = letra_d.getText().toString();

        if(d.compareTo("") == 0){
            Toast.makeText(TesteActivity.this, "Digite o valor!!", Toast.LENGTH_SHORT).show();
        }   else {
            if (d.compareTo("d") == 0 || d.compareTo("D") == 0) {
                if(validacao_d == true){
                    bh.setLetra_pequena_acerto(bh.getLetra_pequena_acerto() + 1);
                    bh.setTotal_Acerto(bh.getTotal_Acerto() + 1);
                    Toast.makeText(TesteActivity.this, bh.getTotal_Acerto() + " Acertos", Toast.LENGTH_SHORT).show();
                    validacao_d = false;
                    flipperTeste.showNext();
                } else {
                    flipperTeste.showNext();
                }
            } else {
                bh.setLetra_pequena_erro(bh.getLetra_pequena_erro() +1);
                bh.setTotal_Erro(bh.getTotal_Erro() + 1);
                Toast.makeText(TesteActivity.this, bh.getTotal_Erro() + " Erros", Toast.LENGTH_SHORT).show();
                flipperTeste.showNext();
            }
        }

    }

    public void onClickVerificar_b2(View t){

        EditText letra_b = (EditText)findViewById(R.id.txtL_b2);
        String b = letra_b.getText().toString();

        if(b.compareTo("") == 0){
            Toast.makeText(TesteActivity.this, "Digite o valor!!", Toast.LENGTH_SHORT).show();
        }   else {
            if (b.compareTo("b") == 0 || b.compareTo("B") == 0) {
                if(validacao_b2 == true){
                    bh.setLetra_pequena_acerto(bh.getLetra_pequena_acerto() + 1);
                    bh.setTotal_Acerto(bh.getTotal_Acerto() + 1);
                    Toast.makeText(TesteActivity.this, bh.getTotal_Acerto() + " Acertos", Toast.LENGTH_SHORT).show();
                    validacao_b2 = false;
                    flipperTeste.showNext();
                } else {
                    flipperTeste.showNext();
                }
            } else {
                bh.setLetra_pequena_erro(bh.getLetra_pequena_erro() +1);
                bh.setTotal_Erro(bh.getTotal_Erro() + 1);
                Toast.makeText(TesteActivity.this, bh.getTotal_Erro() + " Erros", Toast.LENGTH_SHORT).show();
                flipperTeste.showNext();
            }
        }
    }


    public void onClickVerificar_f(View t){

        EditText letra_f = (EditText)findViewById(R.id.txtL_f);
        String f = letra_f.getText().toString();

        if(f.compareTo("") == 0){
            Toast.makeText(TesteActivity.this, "Digite o valor!!", Toast.LENGTH_SHORT).show();
        }   else {
            if (f.compareTo("f") == 0 || f.compareTo("F") == 0) {
                if(validacao_f == true){
                    bh.setLetra_pequena_acerto(bh.getLetra_pequena_acerto() + 1);
                    bh.setTotal_Acerto(bh.getTotal_Acerto() + 1);
                    Toast.makeText(TesteActivity.this, bh.getTotal_Acerto() + " Acertos", Toast.LENGTH_SHORT).show();
                    validacao_f = false;
                    flipperTeste.showNext();
                } else {
                    flipperTeste.showNext();
                }
            } else {
                bh.setLetra_pequena_erro(bh.getLetra_pequena_erro() +1);
                bh.setTotal_Erro(bh.getTotal_Erro() + 1);
                Toast.makeText(TesteActivity.this, bh.getTotal_Erro() + " Erros", Toast.LENGTH_SHORT).show();
                flipperTeste.showNext();
            }
        }

    }

    public void onClickVerificar_t(View q){

        EditText letra_t = (EditText)findViewById(R.id.txtL_t);
        String t = letra_t.getText().toString();

        if(t.compareTo("") == 0){
            Toast.makeText(TesteActivity.this, "Digite o valor!!", Toast.LENGTH_SHORT).show();
        }   else {
            if (t.compareTo("t") == 0 || t.compareTo("T") == 0) {
                if(validacao_t == true){
                    bh.setLetra_pequena_acerto(bh.getLetra_pequena_acerto() + 1);
                    bh.setTotal_Acerto(bh.getTotal_Acerto() + 1);
                    Toast.makeText(TesteActivity.this, bh.getTotal_Acerto() + " Acertos", Toast.LENGTH_SHORT).show();
                    validacao_t = false;
                    flipperTeste.showNext();
                } else {
                    flipperTeste.showNext();
                }
            } else {
                bh.setLetra_pequena_erro(bh.getLetra_pequena_erro() +1);
                bh.setTotal_Erro(bh.getTotal_Erro() + 1);
                Toast.makeText(TesteActivity.this, bh.getTotal_Erro() + " Erros", Toast.LENGTH_SHORT).show();
                flipperTeste.showNext();
            }
        }

    }

    public void onClickVerificar_2(View y){

        EditText numero_2 = (EditText)findViewById(R.id.txtNum2);
        // Integer num_2 = Integer.parseInt(numero_2.getText().toString());
        String num_2 = numero_2.getText().toString(); //não sei porque inferno a verificação com números só aceita como string

        if(num_2.compareTo("") == 0){
            Toast.makeText(TesteActivity.this, "Digite o valor!!", Toast.LENGTH_SHORT).show();
        }   else {
            if (num_2.compareTo("2") == 0) {
                if(validacao_2 == true){
                    bh.setPontos_acerto(bh.getPontos_acerto() + 1);
                    bh.setTotal_Acerto(bh.getTotal_Acerto() + 1);
                    Toast.makeText(TesteActivity.this, bh.getTotal_Acerto() + " Acertos", Toast.LENGTH_SHORT).show();
                    validacao_2 = false;
                    flipperTeste.showNext();
                } else{
                    flipperTeste.showNext();
                }
            } else {
                bh.setPontos_erro(bh.getPontos_erro() + 1);
                bh.setTotal_Erro(bh.getTotal_Erro() + 1);
                Toast.makeText(TesteActivity.this, bh.getTotal_Erro() + " Erros", Toast.LENGTH_SHORT).show();
                flipperTeste.showNext();
            }

        }
    }

    public void onClickVerificar_5(View u){

        EditText numero_5 = (EditText)findViewById(R.id.txtNum5);
        String num_5 = numero_5.getText().toString(); //não sei porque inferno a verificação com números só aceita como string

        if(num_5.compareTo("") == 0){
            Toast.makeText(TesteActivity.this, "Digite o valor!!", Toast.LENGTH_SHORT).show();
        }   else {
            if (num_5.compareTo("5") == 0) {
                if(validacao_5 == true){
                    bh.setPontos_acerto(bh.getPontos_acerto() + 1);
                    bh.setTotal_Acerto(bh.getTotal_Acerto() + 1);
                    Toast.makeText(TesteActivity.this, bh.getTotal_Acerto() + " Acertos", Toast.LENGTH_SHORT).show();
                    validacao_5 = false;
                    flipperTeste.showNext();
                } else{
                    flipperTeste.showNext();
                }
            } else {
                bh.setPontos_erro(bh.getPontos_erro() + 1);
                bh.setTotal_Erro(bh.getTotal_Erro() + 1);
                Toast.makeText(TesteActivity.this, bh.getTotal_Erro() + " Erros", Toast.LENGTH_SHORT).show();
                flipperTeste.showNext();
            }
        }
    }


    public void onClickVerificar_5_1(View i){

        EditText numero_5_1 = (EditText)findViewById(R.id.txtNum5_1);
        String num_5_1 = numero_5_1.getText().toString(); //não sei porque inferno a verificação com números só aceita como string


        if(num_5_1.compareTo("") == 0){
            Toast.makeText(TesteActivity.this, "Digite o valor!!", Toast.LENGTH_SHORT).show();
        }   else {
            if (num_5_1.compareTo("5") == 0) {
                if(validacao_5_1 == true){
                    bh.setPontos_acerto(bh.getPontos_acerto() + 1);
                    bh.setTotal_Acerto(bh.getTotal_Acerto() + 1);
                    Toast.makeText(TesteActivity.this, bh.getTotal_Acerto() + " Acertos", Toast.LENGTH_SHORT).show();
                    validacao_5_1 = false;
                    flipperTeste.showNext();
                } else{
                    flipperTeste.showNext();
                }
            } else {
                bh.setPontos_erro(bh.getPontos_erro() + 1);
                bh.setTotal_Erro(bh.getTotal_Erro() + 1);
                Toast.makeText(TesteActivity.this, bh.getTotal_Erro() + " Erros", Toast.LENGTH_SHORT).show();
                flipperTeste.showNext();
            }

        }
    }

    public void onClickVerificar_5_2(View o){

        EditText numero_5_2 = (EditText)findViewById(R.id.txtNum5_2);
        String num_5_2 = numero_5_2.getText().toString(); //não sei porque inferno a verificação com números só aceita como string


        if(num_5_2.compareTo("") == 0){
            Toast.makeText(TesteActivity.this, "Digite o valor!!", Toast.LENGTH_SHORT).show();
        }   else {
            if (num_5_2.compareTo("5") == 0) {
                if(validacao_5_2 == true){
                    bh.setPontos_acerto(bh.getPontos_acerto() + 1);
                    bh.setTotal_Acerto(bh.getTotal_Acerto() + 1);
                    Toast.makeText(TesteActivity.this, bh.getTotal_Acerto() + " Acertos", Toast.LENGTH_SHORT).show();
                    validacao_5_2 = false;
                    flipperTeste.showNext();
                } else{
                    flipperTeste.showNext();
                }
            } else {
                bh.setPontos_erro(bh.getPontos_erro() + 1);
                bh.setTotal_Erro(bh.getTotal_Erro() + 1);
                Toast.makeText(TesteActivity.this, bh.getTotal_Erro() + " Erros", Toast.LENGTH_SHORT).show();
                flipperTeste.showNext();
            }

        }
    }


    public void onClickVerificar_6(View p){

        EditText numero_6 = (EditText)findViewById(R.id.txtNum6);
        String num_6 = numero_6.getText().toString(); //não sei porque inferno a verificação com números só aceita como string

        if(num_6.compareTo("") == 0){
            Toast.makeText(TesteActivity.this, "Digite o valor!!", Toast.LENGTH_SHORT).show();
        }   else {
            if (num_6.compareTo("6") == 0) {
                if(validacao_6 == true){
                    bh.setPontos_acerto(bh.getPontos_acerto() + 1);
                    bh.setTotal_Acerto(bh.getTotal_Acerto() + 1);
                    Toast.makeText(TesteActivity.this, bh.getTotal_Acerto() + " Acertos", Toast.LENGTH_SHORT).show();
                    validacao_6 = false;
                    flipperTeste.showNext();
                } else{
                    flipperTeste.showNext();
                }
            } else {
                bh.setPontos_erro(bh.getPontos_erro() + 1);
                bh.setTotal_Erro(bh.getTotal_Erro() + 1);
                Toast.makeText(TesteActivity.this, bh.getTotal_Erro() + " Erros", Toast.LENGTH_SHORT).show();
                flipperTeste.showNext();
            }
        }

    }

    public void onClickVerificar_6_1(View a){

        EditText numero_6_1 = (EditText)findViewById(R.id.txtNum6_1);
        String num_6_1 = numero_6_1.getText().toString(); //não sei porque inferno a verificação com números só aceita como string

        if(num_6_1.compareTo("") == 0){
            Toast.makeText(TesteActivity.this, "Digite o valor!!", Toast.LENGTH_SHORT).show();
        }   else {
            if (num_6_1.compareTo("6") == 0) {
                if(validacao_6_1 == true){
                    bh.setPontos_acerto(bh.getPontos_acerto() + 1);
                    bh.setTotal_Acerto(bh.getTotal_Acerto() + 1);
                    Toast.makeText(TesteActivity.this, bh.getTotal_Acerto() + " Acertos", Toast.LENGTH_SHORT).show();
                    validacao_6_1 = false;
                    flipperTeste.showNext();
                } else{
                    flipperTeste.showNext();
                }
            } else {
                bh.setPontos_erro(bh.getPontos_erro() + 1);
                bh.setTotal_Erro(bh.getTotal_Erro() + 1);
                Toast.makeText(TesteActivity.this, bh.getTotal_Erro() + " Erros", Toast.LENGTH_SHORT).show();
                flipperTeste.showNext();
            }
        }

    }


    public void onClickVerificar_7(View a){

        EditText numero_7 = (EditText)findViewById(R.id.txtNum7);
        String num_7 = numero_7.getText().toString(); //não sei porque inferno a verificação com números só aceita como string

        if(num_7.compareTo("") == 0){
            Toast.makeText(TesteActivity.this, "Digite o valor!!", Toast.LENGTH_SHORT).show();
        }   else {
            if (num_7.compareTo("7") == 0) {
                if(validacao_7 == true){
                    bh.setPontos_acerto(bh.getPontos_acerto() + 1);
                    bh.setTotal_Acerto(bh.getTotal_Acerto() + 1);
                    Toast.makeText(TesteActivity.this, bh.getTotal_Acerto() + " Acertos", Toast.LENGTH_SHORT).show();
                    validacao_7 = false;
                    flipperTeste.showNext();
                } else{
                    flipperTeste.showNext();
                }
            } else {
                bh.setPontos_erro(bh.getPontos_erro() + 1);
                bh.setTotal_Erro(bh.getTotal_Erro() + 1);
                Toast.makeText(TesteActivity.this, bh.getTotal_Erro() + " Erros", Toast.LENGTH_SHORT).show();
                flipperTeste.showNext();
            }
        }

    }

    public void onClickVerificar_7_1(View a){

        EditText numero_7_1 = (EditText)findViewById(R.id.txtNum7_1);
        String num_7_1 = numero_7_1.getText().toString(); //não sei porque inferno a verificação com números só aceita como string

        if(num_7_1.compareTo("") == 0){
            Toast.makeText(TesteActivity.this, "Digite o valor!!", Toast.LENGTH_SHORT).show();
        }   else {
            if (num_7_1.compareTo("7") == 0) {
                if(validacao_7_1 == true){
                    bh.setPontos_acerto(bh.getPontos_acerto() + 1);
                    bh.setTotal_Acerto(bh.getTotal_Acerto() + 1);
                    Toast.makeText(TesteActivity.this, bh.getTotal_Acerto() + " Acertos", Toast.LENGTH_SHORT).show();
                    validacao_7_1 = false;
                    flipperTeste.showNext();
                } else{
                    flipperTeste.showNext();
                }
            } else {
                bh.setPontos_erro(bh.getPontos_erro() + 1);
                bh.setTotal_Erro(bh.getTotal_Erro() + 1);
                Toast.makeText(TesteActivity.this, bh.getTotal_Erro() + " Erros", Toast.LENGTH_SHORT).show();
                flipperTeste.showNext();
            }
        }

    }

    public void onClickVerificar_7_2(View a){

        EditText numero_7_2 = (EditText)findViewById(R.id.txtNum7_2);
        String num_7_2 = numero_7_2.getText().toString(); //não sei porque inferno a verificação com números só aceita como string

        if(num_7_2.compareTo("") == 0){
            Toast.makeText(TesteActivity.this, "Digite o valor!!", Toast.LENGTH_SHORT).show();
        }   else {
            if(num_7_2.compareTo("") == 0){
                if(validacao_7_2 == true){
                    bh.setPontos_acerto(bh.getPontos_acerto() + 1);
                    bh.setTotal_Acerto(bh.getTotal_Acerto() + 1);
                    Toast.makeText(TesteActivity.this, bh.getTotal_Acerto() + " Acertos", Toast.LENGTH_SHORT).show();
                    validacao_7_2 = false;
                    flipperTeste.showNext();
                } else{
                    flipperTeste.showNext();
                }
            } else {
                bh.setPontos_erro(bh.getPontos_erro() + 1);
                bh.setTotal_Erro(bh.getTotal_Erro() + 1);
                Toast.makeText(TesteActivity.this, bh.getTotal_Erro() + " Erros", Toast.LENGTH_SHORT).show();
                flipperTeste.showNext();
            }

        }

    }

    public void onClickVerificar_8(View a){

        EditText numero_8 = (EditText)findViewById(R.id.txtNum8);
        String num_8 = numero_8.getText().toString(); //não sei porque inferno a verificação com números só aceita como string

        if(num_8.compareTo("") == 0){
            Toast.makeText(TesteActivity.this, "Digite o valor!!", Toast.LENGTH_SHORT).show();
        }   else {
            if (num_8.compareTo("8") == 0) {
                if(validacao_8 == true){
                    bh.setPontos_acerto(bh.getPontos_acerto() + 1);
                    bh.setTotal_Acerto(bh.getTotal_Acerto() + 1);
                    Toast.makeText(TesteActivity.this, bh.getTotal_Acerto() + " Acertos", Toast.LENGTH_SHORT).show();
                    validacao_8 = false;
                    flipperTeste.showNext();
                } else{
                    flipperTeste.showNext();
                }
            } else {
                bh.setPontos_erro(bh.getPontos_erro() + 1);
                bh.setTotal_Erro(bh.getTotal_Erro() + 1);
                Toast.makeText(TesteActivity.this, bh.getTotal_Erro() + " Erros", Toast.LENGTH_SHORT).show();
                flipperTeste.showNext();
            }
        }

    }

    public void onClickVerificar_10(View a){

        EditText numero_10 = (EditText)findViewById(R.id.txtNum10);
        String num_10 = numero_10.getText().toString(); //não sei porque inferno a verificação com números só aceita como string

        if(num_10.compareTo("") == 0){
            Toast.makeText(TesteActivity.this, "Digite o valor!!", Toast.LENGTH_SHORT).show();
        }   else {
            if (num_10.compareTo("10") == 0) {
                if(validacao_10 == true){
                    bh.setPontos_acerto(bh.getPontos_acerto() + 1);
                    bh.setTotal_Acerto(bh.getTotal_Acerto() + 1);
                    Toast.makeText(TesteActivity.this, bh.getTotal_Acerto() + " Acertos", Toast.LENGTH_SHORT).show();
                    validacao_10 = false;
                    flipperTeste.showNext();
                } else{
                    flipperTeste.showNext();
                }
            } else {
                bh.setPontos_erro(bh.getPontos_erro() + 1);
                bh.setTotal_Erro(bh.getTotal_Erro() + 1);
                Toast.makeText(TesteActivity.this, bh.getTotal_Erro() + " Erros", Toast.LENGTH_SHORT).show();
                flipperTeste.showNext();
            }
        }

    }

    public void onClickVerificar_35(View a){

        EditText numero_35 = (EditText)findViewById(R.id.txtNum35);
        String num_35 = numero_35.getText().toString(); //não sei porque inferno a verificação com números só aceita como string

        if(num_35.compareTo("") == 0){
            Toast.makeText(TesteActivity.this, "Digite o valor!!", Toast.LENGTH_SHORT).show();
        }   else {
            if (num_35.compareTo("35") == 0) {
                if(validacao_35 == true){
                    bh.setPontos_acerto(bh.getPontos_acerto() + 1);
                    bh.setTotal_Acerto(bh.getTotal_Acerto() + 1);
                    Toast.makeText(TesteActivity.this, bh.getTotal_Acerto() + " Acertos", Toast.LENGTH_SHORT).show();
                    validacao_35 = false;
                    flipperTeste.showNext();
                } else{
                    flipperTeste.showNext();
                }
            } else {
                bh.setPontos_erro(bh.getPontos_erro() + 1);
                bh.setTotal_Erro(bh.getTotal_Erro() + 1);
                Toast.makeText(TesteActivity.this, bh.getTotal_Erro() + " Erros", Toast.LENGTH_SHORT).show();
                flipperTeste.showNext();
            }
        }

    }


    public void onClickVerificar_74(View a){

        EditText numero_74 = (EditText)findViewById(R.id.txtNum74);
        String num_74 = numero_74.getText().toString(); //não sei porque inferno a verificação com números só aceita como string

        if(num_74.compareTo("") == 0){
            Toast.makeText(TesteActivity.this, "Digite o valor!!", Toast.LENGTH_SHORT).show();
        }   else {
            if (num_74.compareTo("74") == 0) {
                if(validacao_74 == true){
                    bh.setPontos_acerto(bh.getPontos_acerto() + 1);
                    bh.setTotal_Acerto(bh.getTotal_Acerto() + 1);
                    Toast.makeText(TesteActivity.this, bh.getTotal_Acerto() + " Acertos", Toast.LENGTH_SHORT).show();
                    validacao_74 = false;
                    flipperTeste.showNext();
                } else{
                    flipperTeste.showNext();
                }
            } else {
                bh.setPontos_erro(bh.getPontos_erro() + 1);
                bh.setTotal_Erro(bh.getTotal_Erro() + 1);
                Toast.makeText(TesteActivity.this, bh.getTotal_Erro() + " Erros", Toast.LENGTH_SHORT).show();
                flipperTeste.showNext();
            }
        }

    }

    public void onClickVerificar_56(View a){

        EditText numero_56 = (EditText)findViewById(R.id.txtNum56);
        String num_56 = numero_56.getText().toString(); //não sei porque inferno a verificação com números só aceita como string

        if(num_56.compareTo("") == 0){
            Toast.makeText(TesteActivity.this, "Digite o valor!!", Toast.LENGTH_SHORT).show();
        }   else {
            if (num_56.compareTo("56") == 0) {
                if(validacao_56 == true){
                    bh.setPontos_acerto(bh.getPontos_acerto() + 1);
                    bh.setTotal_Acerto(bh.getTotal_Acerto() + 1);
                    Toast.makeText(TesteActivity.this, bh.getTotal_Acerto() + " Acertos", Toast.LENGTH_SHORT).show();
                    validacao_56 = false;
                    flipperTeste.showNext();
                } else{
                    flipperTeste.showNext();
                }
            } else {
                bh.setPontos_erro(bh.getPontos_erro() + 1);
                bh.setTotal_Erro(bh.getTotal_Erro() + 1);
                Toast.makeText(TesteActivity.this, bh.getTotal_Erro() + " Erros", Toast.LENGTH_SHORT).show();
                flipperTeste.showNext();
            }
        }

    }

    public void onClickVerificar_45(View a){

        EditText numero_45 = (EditText)findViewById(R.id.txtNum45);
        String num_45 = numero_45.getText().toString(); //não sei porque inferno a verificação com números só aceita como string

        if(num_45.compareTo("") == 0){
            Toast.makeText(TesteActivity.this, "Digite o valor!!", Toast.LENGTH_SHORT).show();
        }   else {
            if (num_45.compareTo("45") == 0) {
                if(validacao_45 == true){
                    bh.setPontos_acerto(bh.getPontos_acerto() + 1);
                    bh.setTotal_Acerto(bh.getTotal_Acerto() + 1);
                    Toast.makeText(TesteActivity.this, bh.getTotal_Acerto() + " Acertos", Toast.LENGTH_SHORT).show();
                    validacao_45 = false;
                    flipperTeste.showNext();
                } else{
                    flipperTeste.showNext();
                }
            } else {
                bh.setPontos_erro(bh.getPontos_erro() + 1);
                bh.setTotal_Erro(bh.getTotal_Erro() + 1);
                Toast.makeText(TesteActivity.this, bh.getTotal_Erro() + " Erros", Toast.LENGTH_SHORT).show();
                flipperTeste.showNext();
            }
        }

    }

    public void onClickVerificar_42(View a){

        EditText numero_42 = (EditText)findViewById(R.id.txtNum42);
        String num_42 = numero_42.getText().toString(); //não sei porque inferno a verificação com números só aceita como string

        if(num_42.compareTo("") == 0){
            Toast.makeText(TesteActivity.this, "Digite o valor!!", Toast.LENGTH_SHORT).show();
        }   else {
            if (num_42.compareTo("42") == 0) {
                if(validacao_42 == true){
                    bh.setPontos_acerto(bh.getPontos_acerto() + 1);
                    bh.setTotal_Acerto(bh.getTotal_Acerto() + 1);
                    Toast.makeText(TesteActivity.this, bh.getTotal_Acerto() + " Acertos", Toast.LENGTH_SHORT).show();
                    validacao_42 = false;
                    flipperTeste.showNext();
                } else{
                    flipperTeste.showNext();
                }
            } else {
                bh.setPontos_erro(bh.getPontos_erro() + 1);
                bh.setTotal_Erro(bh.getTotal_Erro() + 1);
                Toast.makeText(TesteActivity.this, bh.getTotal_Erro() + " Erros", Toast.LENGTH_SHORT).show();
                flipperTeste.showNext();
            }
        }

    }

    public void onClickVerificar_42_1(View a){

        EditText numero_42_1 = (EditText)findViewById(R.id.txtNum42_1);
        String num_42_1 = numero_42_1.getText().toString(); //não sei porque inferno a verificação com números só aceita como string

        if(num_42_1.compareTo("") == 0){
            Toast.makeText(TesteActivity.this, "Digite o valor!!", Toast.LENGTH_SHORT).show();
        }   else {
            if (num_42_1.compareTo("42") == 0) {
                if(validacao_42_1 == true){
                    bh.setPontos_acerto(bh.getPontos_acerto() + 1);
                    bh.setTotal_Acerto(bh.getTotal_Acerto() + 1);
                    Toast.makeText(TesteActivity.this, bh.getTotal_Acerto() + " Acertos", Toast.LENGTH_SHORT).show();
                    validacao_42_1 = false;
                    flipperTeste.showNext();
                } else{
                    flipperTeste.showNext();
                }
            } else {
                bh.setPontos_erro(bh.getPontos_erro() + 1);
                bh.setTotal_Erro(bh.getTotal_Erro() + 1);
                Toast.makeText(TesteActivity.this, bh.getTotal_Erro() + " Erros", Toast.LENGTH_SHORT).show();
                flipperTeste.showNext();
            }
        }

    }


    public void onClickVerificar_29(View a){

        EditText numero_29 = (EditText)findViewById(R.id.txtNum29);
        String num_29 = numero_29.getText().toString(); //não sei porque inferno a verificação com números só aceita como string

        if(num_29.compareTo("") == 0){
            Toast.makeText(TesteActivity.this, "Digite o valor!!", Toast.LENGTH_SHORT).show();
        }   else {
            if (num_29.compareTo("29") == 0) {
                if(validacao_29 == true){
                    bh.setPontos_acerto(bh.getPontos_acerto() + 1);
                    bh.setTotal_Acerto(bh.getTotal_Acerto() + 1);
                    Toast.makeText(TesteActivity.this, bh.getTotal_Acerto() + " Acertos", Toast.LENGTH_SHORT).show();
                    validacao_29 = false;
                    flipperTeste.showNext();
                } else{
                    flipperTeste.showNext();
                }
            } else {
                bh.setPontos_erro(bh.getPontos_erro() + 1);
                bh.setTotal_Erro(bh.getTotal_Erro() + 1);
                Toast.makeText(TesteActivity.this, bh.getTotal_Erro() + " Erros", Toast.LENGTH_SHORT).show();
                flipperTeste.showNext();
            }
        }

    }

    public void onClickVerificar_26(View a){

        EditText numero_26 = (EditText)findViewById(R.id.txtNum26);
        String num_26 = numero_26.getText().toString(); //não sei porque inferno a verificação com números só aceita como string

        if(num_26.compareTo("") == 0){
            Toast.makeText(TesteActivity.this, "Digite o valor!!", Toast.LENGTH_SHORT).show();
        }   else {
            if (num_26.compareTo("26") == 0) {
                if(validacao_26 == true){
                    bh.setPontos_acerto(bh.getPontos_acerto() + 1);
                    bh.setTotal_Acerto(bh.getTotal_Acerto() + 1);
                    Toast.makeText(TesteActivity.this, bh.getTotal_Acerto() + " Acertos", Toast.LENGTH_SHORT).show();
                    validacao_26 = false;
                    flipperTeste.showNext();
                } else{
                    flipperTeste.showNext();
                }
            } else {
                bh.setPontos_erro(bh.getPontos_erro() + 1);
                bh.setTotal_Erro(bh.getTotal_Erro() + 1);
                Toast.makeText(TesteActivity.this, bh.getTotal_Erro() + " Erros", Toast.LENGTH_SHORT).show();
                flipperTeste.showNext();
            }
        }

    }

    public void onClickVerificar_16(View a){

        EditText numero_16 = (EditText)findViewById(R.id.txtNum16);
        String num_16 = numero_16.getText().toString(); //não sei porque inferno a verificação com números só aceita como string

        if(num_16.compareTo("") == 0){
            Toast.makeText(TesteActivity.this, "Digite o valor!!", Toast.LENGTH_SHORT).show();
        }   else {
            if (num_16.compareTo("16") == 0) {
                if(validacao_16 == true){
                    bh.setPontos_acerto(bh.getPontos_acerto() + 1);
                    bh.setTotal_Acerto(bh.getTotal_Acerto() + 1);
                    Toast.makeText(TesteActivity.this, bh.getTotal_Acerto() + " Acertos", Toast.LENGTH_SHORT).show();
                    validacao_16 = false;
                    flipperTeste.showNext();
                } else{
                    flipperTeste.showNext();
                }
            } else {
                bh.setPontos_erro(bh.getPontos_erro() + 1);
                bh.setTotal_Erro(bh.getTotal_Erro() + 1);
                Toast.makeText(TesteActivity.this, bh.getTotal_Erro() + " Erros", Toast.LENGTH_SHORT).show();
                flipperTeste.showNext();
            }
        }

    }

    public void onClickVerificar_13(View a){

        EditText numero_13 = (EditText)findViewById(R.id.txtNum13);
        String num_13 = numero_13.getText().toString(); //não sei porque inferno a verificação com números só aceita como string

        if(num_13.compareTo("") == 0){
            Toast.makeText(TesteActivity.this, "Digite o valor!!", Toast.LENGTH_SHORT).show();
        }   else {
            if (num_13.compareTo("13") == 0) {
                if(validacao_13 == true){
                    bh.setPontos_acerto(bh.getPontos_acerto() + 1);
                    bh.setTotal_Acerto(bh.getTotal_Acerto() + 1);
                    Toast.makeText(TesteActivity.this, bh.getTotal_Acerto() + " Acertos", Toast.LENGTH_SHORT).show();
                    validacao_13 = false;
                    flipperTeste.showNext();
                } else{
                    flipperTeste.showNext();
                }
            } else {
                bh.setPontos_erro(bh.getPontos_erro() + 1);
                bh.setTotal_Erro(bh.getTotal_Erro() + 1);
                Toast.makeText(TesteActivity.this, bh.getTotal_Erro() + " Erros", Toast.LENGTH_SHORT).show();
                flipperTeste.showNext();
            }
        }

    }

    public void onClickVerificar_12(View a){

        /*NumberPicker np = null;
        np.setMinValue(0);
        np.setMaxValue(99);
        np = (NumberPicker)findViewById(R.id.txtNum_12);
        np.setWrapSelectorWheel(false);*/


        EditText numero_12 = (EditText)findViewById(R.id.txtNum12);
        String num_12 = numero_12.getText().toString(); //não sei porque inferno a verificação com números só aceita como string



        if(num_12.compareTo("") == 0){
            Toast.makeText(TesteActivity.this, "Digite o valor!!", Toast.LENGTH_SHORT).show();
        }   else {
            if (num_12.compareTo("12") == 0) {
                if(validacao_12 == true){
                    bh.setPontos_acerto(bh.getPontos_acerto() + 1);
                    bh.setTotal_Acerto(bh.getTotal_Acerto() + 1);
                    Toast.makeText(TesteActivity.this, bh.getTotal_Acerto() + " Acertos", Toast.LENGTH_SHORT).show();
                    validacao_12 = false;
                    flipperTeste.showNext();
                } else{
                    flipperTeste.showNext();
                }
            } else {
                bh.setPontos_erro(bh.getPontos_erro() + 1);
                bh.setTotal_Erro(bh.getTotal_Erro() + 1);
                Toast.makeText(TesteActivity.this, bh.getTotal_Erro() + " Erros", Toast.LENGTH_SHORT).show();
                flipperTeste.showNext();
            }
        }

    }



}
