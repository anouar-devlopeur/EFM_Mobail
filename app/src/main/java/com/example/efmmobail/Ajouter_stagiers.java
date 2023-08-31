package com.example.efmmobail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class Ajouter_stagiers extends AppCompatActivity {

    RadioButton RdoiP,RdoiD;
    Button btnAjout,btnAff,btnAnull;
    EditText txtNP,txtNT,txtEE;
    ListView lv;
    classe c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajouter_stagiers);
        c=new classe(this);
        RdoiP=findViewById(R.id.RdoiP);
        RdoiD=findViewById(R.id.RdoiD);
        btnAjout=findViewById(R.id.btnAjout);
        btnAff=findViewById(R.id.btnAffich);
        btnAnull=findViewById(R.id.btnAnull);
        txtNP=findViewById(R.id.txtNP);
        txtNT=findViewById(R.id.txtNT);
        txtEE=findViewById(R.id.txtEE);
        lv=findViewById(R.id.lv);
        SimpleAdapter ad=new SimpleAdapter(this,c.Affiche(),R.layout.aa,new String[]{"nom","tele","email","annee"},new int[]{R.id.nom,R.id.num,R.id.Email,R.id.Annee});
lv.setAdapter(ad);
        btnAnull.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtNP.setText("");
                txtNT.setText("");
                txtEE.setText("");
            }
        });
        btnAjout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (RdoiD.isChecked()){
                    String anne ="1 anne";
                    String n=txtNP.getText().toString();
                    int num=Integer.parseInt( txtNT.getText().toString());
                    String em=txtEE.getText().toString();
                    if (c.Ajoute(n,num,em,em)) Toast.makeText(Ajouter_stagiers.this,
                            "ajoute",Toast.LENGTH_LONG).show();
                }
            }
        });
        btnAff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lv.setAdapter(ad);
            }
        });

    }
}