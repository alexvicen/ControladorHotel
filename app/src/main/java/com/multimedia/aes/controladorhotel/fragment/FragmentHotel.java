package com.multimedia.aes.controladorhotel.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.multimedia.aes.controladorhotel.R;
import com.multimedia.aes.controladorhotel.nucleo.Habitacion;

public class FragmentHotel extends Fragment implements View.OnClickListener {

    private View vista;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        vista = inflater.inflate(R.layout.fragment_hotel, container, false);
        LinearLayout llPrimero, llSegundo, llTercero, llCuarto, llQuinto, llSexto;
        llPrimero = (LinearLayout) vista.findViewById(R.id.llPrimero);
        llSegundo = (LinearLayout) vista.findViewById(R.id.llSegundo);
        llTercero = (LinearLayout) vista.findViewById(R.id.llTercero);
        llCuarto = (LinearLayout) vista.findViewById(R.id.llCuarto);
        llQuinto = (LinearLayout) vista.findViewById(R.id.llQuinto);
        llSexto = (LinearLayout) vista.findViewById(R.id.llSexto);
        llPrimero.setOnClickListener(this);
        llSegundo.setOnClickListener(this);
        llTercero.setOnClickListener(this);
        llCuarto.setOnClickListener(this);
        llQuinto.setOnClickListener(this);
        llSexto.setOnClickListener(this);

        return vista;
    }

    @Override
    public void onClick(View view) {
        Intent i = new Intent(getContext(), Habitacion.class);
        getContext().startActivity(i);
    }
}
