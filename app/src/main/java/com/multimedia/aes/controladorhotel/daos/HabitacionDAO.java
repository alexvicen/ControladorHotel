package com.multimedia.aes.controladorhotel.daos;

import android.content.Context;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.multimedia.aes.controladorhotel.dbhelper.DBHelperMOS;
import com.multimedia.aes.controladorhotel.entidades.Habitacion;

import java.sql.SQLException;
import java.util.List;

public class HabitacionDAO extends DBHelperMOS {
	static Dao<Habitacion, Integer> dao;

	public static void cargarDao(Context context) throws SQLException {
		dao = getHelper(context).getTecnicoDAO();
	}

	//__________FUNCIONES DE CREACIÓN________________________//

	public static boolean newHabitacion(Context context, int id_habitacion, String nombre_habitacion, String fecha_reserva, String descripcion, String imagen1, String imagen2, String imagen3, String imagen4, String imagen6, String imagen5) {
		Habitacion h = montarHabitacion(id_habitacion, nombre_habitacion, fecha_reserva, descripcion, imagen1, imagen2, imagen3, imagen4, imagen6, imagen5);
		return crearHabitacion(h,context);
	}
	public static boolean crearHabitacion(Habitacion h,Context context) {
		try {
			cargarDao(context);
			dao.create(h);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	public static Habitacion montarHabitacion(int id_habitacion, String nombre_habitacion, String fecha_reserva,String descripcion, String imagen1, String imagen2, String imagen3, String imagen4, String imagen6, String imagen5) {
		Habitacion h =new Habitacion(id_habitacion, nombre_habitacion, fecha_reserva, descripcion, imagen1, imagen2, imagen3, imagen4, imagen6, imagen5);
		return h;
	}

	//__________FUNCIONES DE BORRADO______________________//

	public static void borrarTodasLasHabitaciones(Context context) throws SQLException {
		cargarDao(context);
		DeleteBuilder<Habitacion, Integer> deleteBuilder = dao.deleteBuilder();
		deleteBuilder.delete();
	}
	public static void borrarHabitacionPorID(Context context, int id) throws SQLException {
		cargarDao(context);
		DeleteBuilder<Habitacion, Integer> deleteBuilder = dao.deleteBuilder();
		deleteBuilder.where().eq(Habitacion.ID_HABITACION, id);
		deleteBuilder.delete();
	}

	//__________FUNCIONES DE BUSQUEDA______________________//


	public static List<Habitacion> buscarTodasLasHabitaciones(Context context) throws SQLException {
		cargarDao(context);
		List<Habitacion> listadoHabitacion= dao.queryForAll();
		if(listadoHabitacion.isEmpty()) {
			return null;
		}else{
			return listadoHabitacion;
		}
	}
	public static Habitacion buscarHabitacionPorId(Context context, int id) throws SQLException {
		cargarDao(context);
		List<Habitacion> listadoHabitacion= dao.queryForEq(Habitacion.ID_HABITACION, id);
		if(listadoHabitacion.isEmpty()) {
			return null;
		}else{
			return listadoHabitacion.get(0);
		}
	}


	//____________________________FUNCIONES DE ACTUALIZAR_________________________________________//



}
