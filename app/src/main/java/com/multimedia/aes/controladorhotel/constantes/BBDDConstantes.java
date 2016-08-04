package com.multimedia.aes.controladorhotel.constantes;

import android.content.Context;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.multimedia.aes.controladorhotel.daos.HabitacionDAO;
import com.multimedia.aes.controladorhotel.entidades.Habitacion;

import java.sql.SQLException;

public class BBDDConstantes {

	public static final String DATABASE_NAME = "meson_crislama.db";
	public static final int DATABASE_VERSION = 1;

	public static Dao<Habitacion, Integer> habitacionDao;

	public static void cerrarDao() {
		habitacionDao = null;
	}

	public static void crearTablas(ConnectionSource connectionSource) throws SQLException {
		TableUtils.createTable(connectionSource, Habitacion.class);

	}

	public static void borrarTablas(ConnectionSource connectionSource) throws SQLException {
		TableUtils.dropTable(connectionSource, Habitacion.class, true);

	}

	public static void borrarDatosTablas(Context context) throws SQLException {
		HabitacionDAO.borrarTodasLasHabitaciones(context);

	}
}
