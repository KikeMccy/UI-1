package com.example.ui_1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    //Variable de texto para seleccionar fecha
    EditText txtObtenerFecha;
    //Variables para capturar año, mes y dia seleccionados
    private int anioSel, mesSel, diaSel;
    //Variables para tomar fecha actual para abrir calendario
    private int anioAct, mesAct, diaAct;
    //Variable para calendario
    static final int FECHA_OP = 0;
    Calendar calendario = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Captura la fecha actual
        diaAct = calendario.get(Calendar.DAY_OF_MONTH);
        mesAct= calendario.get(Calendar.MONTH);
        anioAct = calendario.get(Calendar.YEAR);

        //Selecciono el EditText de Fecha
        txtObtenerFecha = (EditText) findViewById(R.id.txtFechaNac);

        //Abrir Calendario
        txtObtenerFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog(FECHA_OP);
            }
        });
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
        else if(txtFechaNac.getText().toString().trim().equalsIgnoreCase("DD/MM/AA"))
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

    private void asignarFecha() {
        txtObtenerFecha.setText((diaSel) + "/" + mesSel + "/" + anioSel+" ");
    }

    private DatePickerDialog.OnDateSetListener fechaSeleccionada =
            new DatePickerDialog.OnDateSetListener() {
                public void onDateSet(DatePicker view, int anio, int mes, int dia) {
                    diaSel = dia;
                    mesSel = mes;
                    anioSel = anio;
                    asignarFecha();
                }
            };

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case FECHA_OP:
                return new DatePickerDialog(this, fechaSeleccionada, anioAct, mesAct, diaAct);
        }
        return null;
    }

}