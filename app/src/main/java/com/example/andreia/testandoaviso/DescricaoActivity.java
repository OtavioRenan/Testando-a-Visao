package com.example.andreia.testandoaviso;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ViewFlipper;

public class DescricaoActivity extends AppCompatActivity {

    private Button btnDescricaoMais;
    private ViewFlipper flipperDescricao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descricao);

        btnDescricaoMais = (Button) findViewById(R.id.btnDescricaoMais);
        flipperDescricao = (ViewFlipper) findViewById(R.id.flipperDescricao);

        btnDescricaoMais.setOnClickListener(onClick);

    }

    View.OnClickListener onClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.btnDescricaoMais:
                    flipperDescricao.showNext();
                    break;
            }
        }
    };

 /*
    public  void onClick(View arg0){
        switch (arg0.getId()) {
            case R.id.btnDescricaoMais:
                flipperDescricao.showNext();
                break;
        }
    }
*/


        public void onClickTelaMain(View v) {
            Intent i = new Intent(DescricaoActivity.this, MainActivity.class);
            startActivity(i);
            finish();
        }



    }