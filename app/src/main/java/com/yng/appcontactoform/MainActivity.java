package com.yng.appcontactoform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import org.w3c.dom.Text;

import java.text.DateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    TextInputLayout tfNombre;
    TextInputLayout tfTelefono;
    TextInputLayout tfEmail;
    TextInputLayout tfDescContacto;

    TextInputEditText tieditNombre;
    DatePicker myDatePicker;


    //datePicker

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tfNombre = (TextInputLayout) findViewById(R.id.tfNombre);
        tfTelefono = (TextInputLayout) findViewById(R.id.tfTelefono);
        tfEmail = (TextInputLayout) findViewById(R.id.tfEmail);
        tfDescContacto = (TextInputLayout) findViewById(R.id.tfDescContacto);
        myDatePicker = (DatePicker) findViewById(R.id.datePicker);

    }

   public void onclickSiguiente(View v)
    {
        String strtfNombre = tfNombre.getEditText().getText().toString().trim();
        String strtfTelefono= tfTelefono.getEditText().getText().toString().trim();
        String strtfEmail = tfEmail.getEditText().getText().toString().trim();
        String strtfDescContacto = tfDescContacto.getEditText().getText().toString().trim();

        String strFechaNac = DateFormat.getDateInstance().format(myDatePicker.getCalendarView().getDate());
        Toast.makeText(this,strFechaNac,Toast.LENGTH_LONG).show();

        Intent intent = new Intent(MainActivity.this, ConfirmaDatos.class);
        intent.putExtra(getResources().getString(R.string.intentNombre),strtfNombre);
        intent.putExtra(getResources().getString(R.string.intentFechNac),strFechaNac);
        intent.putExtra(getResources().getString(R.string.intentTelefon),strtfTelefono);
        intent.putExtra(getResources().getString(R.string.intentEmail),strtfEmail);
        intent.putExtra(getResources().getString(R.string.intentDescrip),strtfDescContacto);
        startActivity(intent);
    }

    public void onclicOk(View v)
    {

        String strFechaNac = DateFormat.getDateInstance().format(myDatePicker.getCalendarView().getDate());
        Toast.makeText(this,getResources().getString(R.string.fechaSel)+strFechaNac,Toast.LENGTH_LONG).show();

        tfTelefono.requestFocus();
    }

    public void onclicCancel(View v)
    {
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

// set current date into datepicker
        myDatePicker.init(year, month, day, null);

        Toast.makeText(this,getResources().getString(R.string.fechaHoy),Toast.LENGTH_LONG).show();

    }
}