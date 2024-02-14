package com.rycry.examiipmovil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private final static String CHANNEL_ID = "canal";
    private EditText Nombre, Apellido, Direccion, Correo, Telefono;
    private Button btnIngresarDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Nombre = findViewById(R.id.edNombre);
        Apellido = findViewById(R.id.edApellido);
        Direccion = findViewById(R.id.edDireccion);
        Correo = findViewById(R.id.edCorreo);
        Telefono = findViewById(R.id.edTelefono);


        btnIngresarDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = Nombre.getText().toString();
                String apellido = Apellido.getText().toString();
                String direccion = Direccion.getText().toString();
                String correo = Correo.getText().toString();
                String telefono = Telefono.getText().toString();


                // Crear instancia de la clase BDHelper
                DatabaseHelper admin = new DatabaseHelper(MainActivity.this, "EXAMIIPMOVIL.db", null, 1);

                // Obtener instancia de la base de datos en modo escritura
                SQLiteDatabase bd = admin.getWritableDatabase();

                if (!nombre.isEmpty() && !apellido.isEmpty() && !direccion.isEmpty() && !telefono.isEmpty() && !correo.isEmpty()) {
                    ContentValues datosusuario = new ContentValues();
                    datosusuario.put("Nombre", nombre);
                    datosusuario.put("Apellido", apellido);
                    datosusuario.put("Direccion", direccion);
                    datosusuario.put("Telefono", telefono);
                    datosusuario.put("Correo", correo);

                    // Insertar los datos del vehículo en la tabla tblVehiculos
                    long resultado = bd.insert("Usuarios", null, datosusuario);

                    if (resultado != -1) {
                        Toast.makeText(MainActivity.this, "Usuario REGISTRADO CORRECTAMENTE", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(MainActivity.this, "Error al registrar el vehículo", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Por favor complete todos los campos", Toast.LENGTH_LONG).show();
                }

                // Cerrar la conexión de la base de datos al finalizar
                bd.close();
            }
        });

    }
}