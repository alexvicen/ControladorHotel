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

public class FragmentReservar extends Fragment implements View.OnClickListener {

    private View vista;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        vista = inflater.inflate(R.layout.fragment_reservar, container, false);
        LinearLayout ll1Reserva,ll2Reserva,ll3Reserva,ll4Reserva,ll5Reserva,ll6Reserva,ll7Reserva,ll8Reserva;
        TextView txt1Reserva,txt2Reserva,txt3Reserva,txt4Reserva,txt5Reserva,txt6Reserva,txt7Reserva,txt8Reserva,txtDisponible,txtOcupada,txtReservada;
        ImageView iv1Reserva,iv2Reserva,iv3Reserva,iv4Reserva,iv5Reserva,iv6Reserva,iv7Reserva,iv8Reserva;
        Typeface miPropiaTypeFace = Typeface.createFromAsset(getContext().getAssets(), "font/CloisterBlack.ttf");

        ll1Reserva = (LinearLayout) vista.findViewById(R.id.ll1Reserva);
        ll2Reserva = (LinearLayout) vista.findViewById(R.id.ll2Reserva);
        ll3Reserva = (LinearLayout) vista.findViewById(R.id.ll3Reserva);
        ll4Reserva = (LinearLayout) vista.findViewById(R.id.ll4Reserva);
        ll5Reserva = (LinearLayout) vista.findViewById(R.id.ll5Reserva);
        ll6Reserva = (LinearLayout) vista.findViewById(R.id.ll6Reserva);
        ll7Reserva = (LinearLayout) vista.findViewById(R.id.ll7Reserva);
        ll8Reserva = (LinearLayout) vista.findViewById(R.id.ll8Reserva);

        txt1Reserva = (TextView) vista.findViewById(R.id.txt1Reserva);
        txt2Reserva = (TextView) vista.findViewById(R.id.txt2Reserva);
        txt3Reserva = (TextView) vista.findViewById(R.id.txt3Reserva);
        txt4Reserva = (TextView) vista.findViewById(R.id.txt4Reserva);
        txt5Reserva = (TextView) vista.findViewById(R.id.txt5Reserva);
        txt6Reserva = (TextView) vista.findViewById(R.id.txt6Reserva);
        txt7Reserva = (TextView) vista.findViewById(R.id.txt7Reserva);
        txt8Reserva = (TextView) vista.findViewById(R.id.txt8Reserva);
        txtDisponible = (TextView) vista.findViewById(R.id.txtDisponible);
        txtOcupada = (TextView) vista.findViewById(R.id.txtOcupada);
        txtReservada = (TextView) vista.findViewById(R.id.txtReservada);

        iv1Reserva = (ImageView) vista.findViewById(R.id.iv1Reserva);
        iv2Reserva = (ImageView) vista.findViewById(R.id.iv2Reserva);
        iv3Reserva = (ImageView) vista.findViewById(R.id.iv3Reserva);
        iv4Reserva = (ImageView) vista.findViewById(R.id.iv4Reserva);
        iv5Reserva = (ImageView) vista.findViewById(R.id.iv5Reserva);
        iv6Reserva = (ImageView) vista.findViewById(R.id.iv6Reserva);
        iv7Reserva = (ImageView) vista.findViewById(R.id.iv7Reserva);
        iv8Reserva = (ImageView) vista.findViewById(R.id.iv8Reserva);

        txt1Reserva.setTypeface(miPropiaTypeFace);
        txt2Reserva.setTypeface(miPropiaTypeFace);
        txt3Reserva.setTypeface(miPropiaTypeFace);
        txt4Reserva .setTypeface(miPropiaTypeFace);
        txt5Reserva .setTypeface(miPropiaTypeFace);
        txt6Reserva .setTypeface(miPropiaTypeFace);
        txt7Reserva .setTypeface(miPropiaTypeFace);
        txt8Reserva .setTypeface(miPropiaTypeFace);
        txtDisponible.setTypeface(miPropiaTypeFace);
        txtOcupada .setTypeface(miPropiaTypeFace);
        txtReservada.setTypeface(miPropiaTypeFace);

        ll1Reserva.setOnClickListener(this);
        ll2Reserva.setOnClickListener(this);
        ll3Reserva.setOnClickListener(this);
        ll4Reserva.setOnClickListener(this);
        ll5Reserva.setOnClickListener(this);
        ll6Reserva.setOnClickListener(this);
        ll7Reserva.setOnClickListener(this);
        ll8Reserva.setOnClickListener(this);

        return vista;
    }

    @Override
    public void onClick(View view) {

        if (view.getId()==R.id.ll1Reserva){

        }else if (view.getId()==R.id.ll2Reserva){

        }else if (view.getId()==R.id.ll3Reserva){

        }else if (view.getId()==R.id.ll4Reserva){

        }else if (view.getId()==R.id.ll5Reserva){

        }else if (view.getId()==R.id.ll6Reserva){

        }else if (view.getId()==R.id.ll7Reserva){

        }else if (view.getId()==R.id.ll8Reserva){

        }

    }
}
