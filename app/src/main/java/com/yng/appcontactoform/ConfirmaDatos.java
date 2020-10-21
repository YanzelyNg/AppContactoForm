package com.yng.appcontactoform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ConfirmaDatos extends AppCompatActivity {

    TextView tvNombre;
    TextView tvfNacimInfo;
    TextView tvTelefInfo;
    TextView tvEmailInfo;
    TextView tvDescripInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirma_datos);

        Bundle parametros = getIntent().getExtras();
        String strtfNombre = parametros.getString(getResources().getString(R.string.intentNombre));
        String strFechaNac= parametros.getString(getResources().getString(R.string.intentFechNac));
        String strtfTelefono= parametros.getString(getResources().getString(R.string.intentTelefon));
        String strtfEmail = parametros.getString(getResources().getString(R.string.intentEmail));
        String strtfDescContacto = parametros.getString(getResources().getString(R.string.intentDescrip));

        tvNombre = (TextView) findViewById(R.id.tvNombre);
        tvfNacimInfo = (TextView) findViewById(R.id.tvfNacimInfo);
        tvTelefInfo = (TextView) findViewById(R.id.tvTelefInfo);
        tvEmailInfo = (TextView) findViewById(R.id.tvEmailInfo);
        tvDescripInfo = (TextView) findViewById(R.id.tvDescripInfo);

        Toast.makeText(this,"Conf"+strtfEmail,Toast.LENGTH_LONG).show();
        tvNombre.setText(strtfNombre);
        tvfNacimInfo.setText(strFechaNac);
        tvTelefInfo.setText(strtfTelefono);
        tvEmailInfo.setText(strtfEmail);
        tvDescripInfo.setText(strtfDescContacto);
    }

    public void onclicEditDatos(View v)
    {
        finish();
    }
}