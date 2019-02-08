package com.example.andreia.testandoaviso.bancoSQLite;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.example.andreia.testandoaviso.TesteActivity;
import com.example.andreia.testandoaviso.entity.BancoHistorico;

import java.util.ArrayList;
import java.util.List;

public class Banco extends SQLiteOpenHelper{

    private static final String NOME_BANCO = "banco.db";
    private static final int VERSAO = 1;
    private Context context;

    public Banco(Context context) {
        super(context, NOME_BANCO, null, VERSAO);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE IF NOT EXISTS tabela_dados(" +
                "_id INT AUTO_INCREMENT," +
                "letra_grande_erro INT," +
                "letra_grande_acerto INT," +
                "letra_pequena_erro INT," +
                "letra_pequena_acerto INT," +
                "pontos_erro INT," +
                "pontos_acerto INT," +
                "PRIMARY KEY(_id) )";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void salvarDados(BancoHistorico bh){
        if(bh != null) {

            int letra_grande_erro = bh.getLetra_grande_erro();
            int letra_grande_acerto = bh.getLetra_grande_acerto();
            int letra_pequena_erro = bh.getLetra_pequena_erro();
            int letra_pequena_acerto = bh.getLetra_pequena_acerto();
            int pontos_erro = bh.getPontos_erro();
            int pontos_acerto = bh.getPontos_acerto();
            int total_Erro = bh.getTotal_Erro();
            int total_Acerto = bh.getTotal_Acerto();

                ContentValues values = new ContentValues();

                values.put("letra_grande_erro", letra_grande_erro);
                values.put("letra_grande_acerto", letra_grande_acerto);
                values.put("letra_pequena_erro", letra_pequena_erro);
                values.put("letra_pequena_acerto", letra_pequena_acerto);
                values.put("pontos_erro", pontos_erro);
                values.put("pontos_acerto", pontos_acerto);
                values.put("total_Erro", total_Erro);
                values.put("total_Acerto", total_Acerto);
                getWritableDatabase().insert("tabela_dados", null, values);

        }
    }

    public List<BancoHistorico> listarDados(){

        List<BancoHistorico> dados = new ArrayList<BancoHistorico>();
        String sql = "select * from tabela_dados";

        Cursor c = getReadableDatabase().rawQuery(sql, null);
        while (c.moveToNext()){
            int letra_grande_erro = c.getInt(c.getColumnIndex("letra_grande_erro"));
            int letra_grande_acerto = c.getInt(c.getColumnIndex("letra_grande_acerto"));
            int letra_pequena_erro = c.getInt(c.getColumnIndex("letra_pequena_erro"));
            int letra_pequena_acerto = c.getInt(c.getColumnIndex("letra_pequena_acerto"));
            int pontos_erro = c.getInt(c.getColumnIndex("pontos_erro"));
            int pontos_acerto = c.getInt(c.getColumnIndex("pontos_acerto"));
            int total_Erro = c.getInt(c.getColumnIndex("total_Erro"));
            int total_Acerto = c.getInt(c.getColumnIndex("total_Acerto"));

            BancoHistorico bh2 = new BancoHistorico();

            bh2.setLetra_grande_erro(letra_grande_erro);
            bh2.setLetra_grande_acerto(letra_grande_acerto);
            bh2.setLetra_pequena_erro(letra_pequena_erro);
            bh2.setLetra_pequena_acerto(letra_pequena_acerto);
            bh2.setPontos_erro(pontos_erro);
            bh2.setPontos_acerto(pontos_acerto);
            bh2.setTotal_Erro(total_Erro);
            bh2.setTotal_Acerto(total_Acerto);

            dados.add(bh2);

        }
        return dados;
    }
}
