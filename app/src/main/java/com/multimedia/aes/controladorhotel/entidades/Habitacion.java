package com.multimedia.aes.controladorhotel.entidades;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "mos_habitaciones")
public class Habitacion {

    public static final String ID_HABITACION = "_id_habitacion";
    public static final String NOMBRE_HABITACION = "nombre_habitacion";
    public static final String FECHA_RESERVA = "fecha_reserva";
    public static final String IMAGEN1 = "imagen1";
    public static final String IMAGEN2 = "imagen2";
    public static final String IMAGEN3 = "imagen3";
    public static final String IMAGEN4 = "imagen4";
    public static final String IMAGEN5 = "imagen5";
    public static final String IMAGEN6 = "imagen6";


    @DatabaseField(id = true, columnName = ID_HABITACION)
    private int id_habitacion;
    @DatabaseField(columnName = NOMBRE_HABITACION)
    private String nombre_habitacion;
    @DatabaseField(columnName = FECHA_RESERVA)
    private String fecha_reserva;
    @DatabaseField(columnName = IMAGEN1)
    private String imagen1;
    @DatabaseField(columnName = IMAGEN2)
    private String imagen2;
    @DatabaseField(columnName = IMAGEN3)
    private String imagen3;
    @DatabaseField(columnName = IMAGEN4)
    private String imagen4;
    @DatabaseField(columnName = IMAGEN5)
    private String imagen5;
    @DatabaseField(columnName = IMAGEN6)
    private String imagen6;

    public Habitacion(){}
    public Habitacion(int id_habitacion, String nombre_habitacion, String fecha_reserva, String imagen1, String imagen2, String imagen3, String imagen4, String imagen6, String imagen5) {
        this.id_habitacion = id_habitacion;
        this.nombre_habitacion = nombre_habitacion;
        this.fecha_reserva = fecha_reserva;
        this.imagen1 = imagen1;
        this.imagen2 = imagen2;
        this.imagen3 = imagen3;
        this.imagen4 = imagen4;
        this.imagen6 = imagen6;
        this.imagen5 = imagen5;
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
    public String getFecha_reserva() {
        return fecha_reserva;
    }
    public void setFecha_reserva(String fecha_reserva) {
        this.fecha_reserva = fecha_reserva;
    }
    public String getImagen1() {
        return imagen1;
    }
    public void setImagen1(String imagen1) {
        this.imagen1 = imagen1;
    }
    public String getImagen2() {
        return imagen2;
    }
    public void setImagen2(String imagen2) {
        this.imagen2 = imagen2;
    }
    public String getImagen3() {
        return imagen3;
    }
    public void setImagen3(String imagen3) {
        this.imagen3 = imagen3;
    }
    public String getImagen4() {
        return imagen4;
    }
    public void setImagen4(String imagen4) {
        this.imagen4 = imagen4;
    }
    public String getImagen5() {
        return imagen5;
    }
    public void setImagen5(String imagen5) {
        this.imagen5 = imagen5;
    }
    public String getImagen6() {
        return imagen6;
    }
    public void setImagen6(String imagen6) {
        this.imagen6 = imagen6;
    }
}
