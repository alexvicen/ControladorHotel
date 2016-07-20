package com.multimedia.aes.controladorhotel.fragment;


import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.multimedia.aes.controladorhotel.R;
import com.multimedia.aes.controladorhotel.nucleo.Habitacion;

public class FragmentHotel extends Fragment implements View.OnClickListener {

    private View vista;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        vista = inflater.inflate(R.layout.fragment_hotel, container, false);
        LinearLayout llPrimero, llSegundo, llTercero, llCuarto, llQuinto, llSexto;
        TextView txtPrimera, txtSegunda, txtTercera, txtCuarta, txtQuinta, txtSexta;
        Typeface miPropiaTypeFace = Typeface.createFromAsset(getContext().getAssets(), "font/CloisterBlack.ttf");

        llPrimero = (LinearLayout) vista.findViewById(R.id.llPrimero);
        llSegundo = (LinearLayout) vista.findViewById(R.id.llSegundo);
        llTercero = (LinearLayout) vista.findViewById(R.id.llTercero);
        llCuarto = (LinearLayout) vista.findViewById(R.id.llCuarto);
        llQuinto = (LinearLayout) vista.findViewById(R.id.llQuinto);
        llSexto = (LinearLayout) vista.findViewById(R.id.llSexto);

        txtPrimera = (TextView) vista.findViewById(R.id.txtPrimera);
        txtSegunda = (TextView) vista.findViewById(R.id.txtSegunda);
        txtTercera = (TextView) vista.findViewById(R.id.txtTercera);
        txtCuarta = (TextView) vista.findViewById(R.id.txtCuarta);
        txtQuinta = (TextView) vista.findViewById(R.id.txtQuinta);
        txtSexta = (TextView) vista.findViewById(R.id.txtSexta);

        llPrimero.setOnClickListener(this);
        llSegundo.setOnClickListener(this);
        llTercero.setOnClickListener(this);
        llCuarto.setOnClickListener(this);
        llQuinto.setOnClickListener(this);
        llSexto.setOnClickListener(this);


        txtPrimera.setTypeface(miPropiaTypeFace);
        txtSegunda.setTypeface(miPropiaTypeFace);
        txtTercera.setTypeface(miPropiaTypeFace);
        txtCuarta.setTypeface(miPropiaTypeFace);
        txtQuinta.setTypeface(miPropiaTypeFace);
        txtSexta.setTypeface(miPropiaTypeFace);
        return vista;
    }

    @Override
    public void onClick(View view) {
        Intent i = new Intent(getContext(), Habitacion.class);
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
}
