package com.example.user.myapplication.CrudCenso;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.user.myapplication.Censo;

/**
 * Created by User on 26/07/2017.
 */

public class CensoDelete extends SQLiteOpenHelper {
    public static final String NOME_BD="Meu_Db";
    public static final int VERSAO_BD=1;
    private Context nContext;
    private SQLiteDatabase db;
    private String PATH_BD="/data/user/0/com.example.user.myapplication/database/Meu_Db";
    private String nomeTabela="Censo";

    public CensoDelete(Context context) {
        super(context,NOME_BD,null,VERSAO_BD);
        this.nContext=context;
        db=getWritableDatabase();
        System.out.println("apagado");
    }

    @Override
    public void onCreate(SQLiteDatabase bd) {


    }

    @Override
    public void onUpgrade(SQLiteDatabase bd, int oldVersion, int newVersion) {


    }

    public boolean deleteTable(){
        openBD();
        String deleteTable="DROP TABLE IF EXISTS "+nomeTabela;
        try {
            db.execSQL(deleteTable);
            return true;

        }catch (Exception e){
            e.printStackTrace();
            return false;

        }finally {
            db.close();

        }
    }

    public boolean deleteCenso(Censo censo){
        openBD();
        String deleteCenso="_id= "+censo.getId();
        try {
            db.delete(nomeTabela,deleteCenso,null);
            return true;

        }catch (Exception e){
            e.printStackTrace();
            return false;

        }finally {
            db.close();

        }

    }

    private void openBD(){
        if(!db.isOpen()){
            db=nContext.openOrCreateDatabase(PATH_BD,SQLiteDatabase.OPEN_READWRITE,null);
        }
    }

}
