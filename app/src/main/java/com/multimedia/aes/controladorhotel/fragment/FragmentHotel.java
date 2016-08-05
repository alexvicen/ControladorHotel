package com.multimedia.aes.controladorhotel.fragment;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.multimedia.aes.controladorhotel.R;
import com.multimedia.aes.controladorhotel.daos.HabitacionDAO;
import com.multimedia.aes.controladorhotel.entidades.Habitacion;
import com.multimedia.aes.controladorhotel.nucleo.Habitaciones;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FragmentHotel extends Fragment implements View.OnClickListener {

    private View vista;
    private LinearLayout llPrimero, llSegundo, llTercero, llCuarto, llQuinto, llSexto, llSeptimo, llOctavo, llNoveno, llDecimo, llUndecimo, llDuodecimo;
    private TextView txtPrimera, txtSegunda, txtTercera, txtCuarta, txtQuinta, txtSexta, txtSeptima, txtOctava, txtNovena, txtDecima, txtUndecima, txtDuodecima;
    private ImageView ivPrimera, ivSegunda, ivTercera, ivCuarta, ivQuinta, ivSexta, ivSeptima, ivOctava, ivNovena, ivDecima, ivUndecima, ivDuodecima;

    private ArrayList<Habitacion> lista = new ArrayList<Habitacion>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        vista = inflater.inflate(R.layout.fragment_hotel, container, false);
        inicializarVariables();
        rellenarDatos();
        cambiarTipoLetra();
        return vista;
    }

    @Override
    public void onClick(View view) {
        Intent i = new Intent(getContext(), Habitaciones.class);
        if (view.getId()==R.id.llPrimero){
            i.putExtra("habitacion",1);
        }else if (view.getId()==R.id.llSegundo){
            i.putExtra("habitacion",2);
        }else if (view.getId()==R.id.llTercero){
            i.putExtra("habitacion",3);
        }else if (view.getId()==R.id.llCuarto){
            i.putExtra("habitacion",4);
        }else if (view.getId()==R.id.llQuinto){
            i.putExtra("habitacion",5);
        }else if (view.getId()==R.id.llSexto){

        }
        getContext().startActivity(i);
    }
    private void inicializarVariables(){
        llPrimero = (LinearLayout) vista.findViewById(R.id.llPrimero);
        llSegundo = (LinearLayout) vista.findViewById(R.id.llSegundo);
        llTercero = (LinearLayout) vista.findViewById(R.id.llTercero);
        llCuarto = (LinearLayout) vista.findViewById(R.id.llCuarto);
        llQuinto = (LinearLayout) vista.findViewById(R.id.llQuinto);
        llSexto = (LinearLayout) vista.findViewById(R.id.llSexto);
        llSeptimo = (LinearLayout) vista.findViewById(R.id.llSeptimo);
        llOctavo = (LinearLayout) vista.findViewById(R.id.llOctavo);
        llNoveno = (LinearLayout) vista.findViewById(R.id.llNoveno);
        llDecimo = (LinearLayout) vista.findViewById(R.id.llDecimo);
        llUndecimo = (LinearLayout) vista.findViewById(R.id.llUndecimo);
        llDuodecimo = (LinearLayout) vista.findViewById(R.id.llDuodecimo);


        txtPrimera = (TextView) vista.findViewById(R.id.txtPrimera);
        txtSegunda = (TextView) vista.findViewById(R.id.txtSegunda);
        txtTercera = (TextView) vista.findViewById(R.id.txtTercera);
        txtCuarta = (TextView) vista.findViewById(R.id.txtCuarta);
        txtQuinta = (TextView) vista.findViewById(R.id.txtQuinta);
        txtSexta = (TextView) vista.findViewById(R.id.txtSexta);
        txtSeptima = (TextView) vista.findViewById(R.id.txtSeptima);
        txtOctava = (TextView) vista.findViewById(R.id.txtOctava);
        txtNovena = (TextView) vista.findViewById(R.id.txtNovena);
        txtDecima = (TextView) vista.findViewById(R.id.txtDecima);
        txtUndecima = (TextView) vista.findViewById(R.id.txtUndecima);
        txtDuodecima = (TextView) vista.findViewById(R.id.txtDuodecima);

        llPrimero.setOnClickListener(this);
        llSegundo.setOnClickListener(this);
        llTercero.setOnClickListener(this);
        llCuarto.setOnClickListener(this);
        llQuinto.setOnClickListener(this);
        llSexto.setOnClickListener(this);
        llSeptimo .setOnClickListener(this);
        llOctavo .setOnClickListener(this);
        llNoveno .setOnClickListener(this);
        llDecimo .setOnClickListener(this);
        llUndecimo.setOnClickListener(this);
        llDuodecimo.setOnClickListener(this);

        ivPrimera = (ImageView) vista.findViewById(R.id.ivPrimera);
        ivSegunda = (ImageView) vista.findViewById(R.id.ivSegunda);
        ivTercera = (ImageView) vista.findViewById(R.id.ivTercera);
        ivCuarta = (ImageView) vista.findViewById(R.id.ivCuarta);
        ivQuinta = (ImageView) vista.findViewById(R.id.ivQuinta);
        ivSexta = (ImageView) vista.findViewById(R.id.ivSexta);
        ivSeptima = (ImageView) vista.findViewById(R.id.ivSeptima);
        ivOctava = (ImageView) vista.findViewById(R.id.ivOctava);
        ivNovena = (ImageView) vista.findViewById(R.id.ivNovena);
        ivDecima = (ImageView) vista.findViewById(R.id.ivDecima);
        ivUndecima = (ImageView) vista.findViewById(R.id.ivUndecima);
        ivDuodecima = (ImageView) vista.findViewById(R.id.ivDuodecima);
    }
    private void cambiarTipoLetra(){
        Typeface miPropiaTypeFace = Typeface.createFromAsset(getContext().getAssets(), "font/CloisterBlack.ttf");
        txtPrimera.setTypeface(miPropiaTypeFace);
        txtSegunda.setTypeface(miPropiaTypeFace);
        txtTercera.setTypeface(miPropiaTypeFace);
        txtCuarta.setTypeface(miPropiaTypeFace);
        txtQuinta.setTypeface(miPropiaTypeFace);
        txtSexta.setTypeface(miPropiaTypeFace);
        txtSeptima.setTypeface(miPropiaTypeFace);
        txtOctava.setTypeface(miPropiaTypeFace);
        txtNovena.setTypeface(miPropiaTypeFace);
        txtDecima.setTypeface(miPropiaTypeFace);
        txtUndecima.setTypeface(miPropiaTypeFace);
        txtDuodecima.setTypeface(miPropiaTypeFace);
    }
    private void rellenarDatos(){
        try {
            lista.addAll(HabitacionDAO.buscarTodasLasHabitaciones(getContext()));
            txtPrimera.setText(lista.get(0).getNombre_habitacion());
            txtSegunda.setText(lista.get(1).getNombre_habitacion());
            txtTercera.setText(lista.get(2).getNombre_habitacion());
            txtCuarta.setText(lista.get(3).getNombre_habitacion());
            txtQuinta.setText(lista.get(4).getNombre_habitacion());
            txtSexta.setText(lista.get(5).getNombre_habitacion());
            txtSeptima.setText(lista.get(6).getNombre_habitacion());
            txtOctava.setText(lista.get(7).getNombre_habitacion());
            txtNovena.setText(lista.get(8).getNombre_habitacion());
            txtDecima.setText(lista.get(9).getNombre_habitacion());
            txtUndecima.setText(lista.get(10).getNombre_habitacion());
            txtDuodecima.setText(lista.get(11).getNombre_habitacion());

            ivPrimera.setImageBitmap(pasarBase64String(lista.get(0).getImagen1()));
            ivSegunda.setImageBitmap(pasarBase64String(lista.get(1).getImagen1()));
            ivTercera.setImageBitmap(pasarBase64String(lista.get(2).getImagen1()));
            ivCuarta.setImageBitmap(pasarBase64String(lista.get(3).getImagen1()));
            ivQuinta.setImageBitmap(pasarBase64String(lista.get(4).getImagen1()));
            ivSexta.setImageBitmap(pasarBase64String(lista.get(5).getImagen1()));
            ivSeptima.setImageBitmap(pasarBase64String(lista.get(6).getImagen1()));
            ivOctava.setImageBitmap(pasarBase64String(lista.get(7).getImagen1()));
            ivNovena.setImageBitmap(pasarBase64String(lista.get(8).getImagen1()));
            ivDecima.setImageBitmap(pasarBase64String(lista.get(9).getImagen1()));
            ivUndecima.setImageBitmap(pasarBase64String(lista.get(10).getImagen1()));
            ivDuodecima.setImageBitmap(pasarBase64String(lista.get(11).getImagen1()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private Bitmap pasarBase64String(String encodedImage){
        byte[] decodedString = Base64.decode(encodedImage, Base64.DEFAULT);
        Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
        return decodedByte;
    }
}
