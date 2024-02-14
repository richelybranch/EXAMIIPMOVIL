package com.rycry.examiipmovil;

import android.provider.BaseColumns;

public final class Contract {

    // Constructor privado para evitar instancias accidentales de la clase contract
    private Contract() {}

    /* Definir la estructura de la tabla y las columnas */
    public static class UsuarioEntry implements BaseColumns {
        public static final String TABLE_NAME = "usuario";
        public static final String COLUMN_NOMBRE = "Nombre";
        public static final String COLUMN_APELLIDO = "Apellido";
        public static final String COLUMN_DIRECCION = "Direccion";
        public static final String COLUMN_TELEFONO = "Telefono";
        public static final String COLUMN_CORREO = "Correo";
    }
}
