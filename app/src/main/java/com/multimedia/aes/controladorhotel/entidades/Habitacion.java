package com.multimedia.aes.controladorhotel.entidades;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "mos_habitaciones")
public class Habitacion {

    public static final String ID_HABITACION = "_id_habitacion";
    public static final String NOMBRE_HABITACION = "nombre_habitacion";

    @DatabaseField(id = true, columnName = ID_HABITACION)
    private int id_habitacion;
    @DatabaseField(columnName = NOMBRE_HABITACION)
    private String nombre_habitacion;

    public Habitacion(){}
    public Habitacion(int id_habitacion, String nombre_habitacion) {
        this.id_habitacion = id_habitacion;
        this.nombre_habitacion = nombre_habitacion;
    }

    public int getId_habitacion() {
        return id_habitacion;
    }
    public void setId_habitacion(int id_habitacion) {
        this.id_habitacion = id_habitacion;
    }
    public String getNombre_habitacion() {
        return nombre_habitacion;
    }
    public void setNombre_habitacion(String nombre_habitacion) {
        this.nombre_habitacion = nombre_habitacion;
    }
}
