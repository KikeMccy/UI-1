package com.example.ui_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btEnviar(View view){
        //Creamos el Intent
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        EditText txtNombre = (EditText)findViewById(R.id.txtNombre);
        RadioButton rdoGenero = (RadioButton)findViewById(R.id.rdoFemenino);
        EditText txtFechaNac = (EditText)findViewById(R.id.txtFechaNac);
        EditText txtTelefono = (EditText)findViewById(R.id.txtTelefono);

        //Creamos la información a pasar entre actividades - Pares Key-Value
        Bundle b = new Bundle();
        b.putString("NOMBRE", txtNombre.getText().toString());
        if(rdoGenero.isChecked())
            b.putString("GENERO",rdoGenero.getText().toString());
        else
            b.putString("GENERO","Masculino");
        b.putString("FECHA",txtFechaNac.getText().toString());
        b.putString("TELEFONO",txtTelefono.getText().toString());

        if (txtNombre.getText().toString().trim().equalsIgnoreCase(""))
            txtNombre.setError("Ingrese Nombre");
        else if(txtFechaNac.getText().toString().trim().equalsIgnoreCase(""))
            txtFechaNac.setError("Ingrese Fecha de Nacimiento");
        else if(txtTelefono.getText().toString().trim().equalsIgnoreCase(""))
            txtTelefono.setError("Ingrese Teléfono");
        else{
        //Añadimos la información al intent
        intent.putExtras(b);
        // Iniciamos la nueva actividad
        startActivity(intent);
        }
    }
}