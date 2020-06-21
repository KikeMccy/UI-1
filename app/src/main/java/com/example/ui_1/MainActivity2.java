package com.example.ui_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //Localizar los controles
        TextView txtNombre = (TextView)findViewById(R.id.lblNombre);
        TextView rdoGenero = (TextView)findViewById(R.id.lblGenero);
        TextView txtFechaNac = (TextView)findViewById(R.id.lblFechaNac);
        TextView txtTelefono = (TextView)findViewById(R.id.lblTelefono);

        //Recuperamos la información pasada en el intent
        Bundle bundle = this.getIntent().getExtras();

        //Construimos el mensaje a mostrar
        txtNombre.setText(bundle.getString("NOMBRE"));
        rdoGenero.setText(bundle.getString("GENERO"));
        txtFechaNac.setText(bundle.getString("FECHA"));
        txtTelefono.setText(bundle.getString("TELEFONO"));

    }
}