package com.multimedia.aes.controladorhotel.fragment;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.TextView;

import com.multimedia.aes.controladorhotel.R;

import java.util.Calendar;
import java.util.Date;

public class FragmentReservar extends Fragment{

    private View vista;
    private DatePicker dpFecha;
    private String[] semana = new String[7];
    private TextView txtFecha, txtDia1, txtDia2, txtDia3, txtDia4, txtDia5, txtDia6, txtDia7;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        vista = inflater.inflate(R.layout.fragment_reservar, container, false);
        Typeface miPropiaTypeFace = Typeface.createFromAsset(getContext().getAssets(), "font/CloisterBlack.ttf");
        dpFecha = (DatePicker) vista.findViewById(R.id.dpFecha);
        txtFecha = (TextView) vista.findViewById(R.id.txtFecha);
        txtDia1 = (TextView) vista.findViewById(R.id.txtDia1);
        txtDia2 = (TextView) vista.findViewById(R.id.txtDia2);
        txtDia3 = (TextView) vista.findViewById(R.id.txtDia3);
        txtDia4 = (TextView) vista.findViewById(R.id.txtDia4);
        txtDia5 = (TextView) vista.findViewById(R.id.txtDia5);
        txtDia6 = (TextView) vista.findViewById(R.id.txtDia6);
        txtDia7 = (TextView) vista.findViewById(R.id.txtDia7);
        txtFecha.setTypeface(miPropiaTypeFace);
        txtDia1.setTypeface(miPropiaTypeFace);
        txtDia2.setTypeface(miPropiaTypeFace);
        txtDia3.setTypeface(miPropiaTypeFace);
        txtDia4.setTypeface(miPropiaTypeFace);
        txtDia5.setTypeface(miPropiaTypeFace);
        txtDia6.setTypeface(miPropiaTypeFace);
        txtDia7.setTypeface(miPropiaTypeFace);
        Date date = new Date(dpFecha.getYear(),dpFecha.getMonth(),dpFecha.getDayOfMonth());
        cambiarSemana(date);
        dpFecha.init(dpFecha.getYear(), dpFecha.getMonth(), dpFecha.getDayOfMonth(), new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int i, int i1, int i2) {
                Date d = new Date(datePicker.getYear(),datePicker.getMonth(),datePicker.getDayOfMonth());
                cambiarSemana(d);
            }
        });

        return vista;
    }

    private void cambiarSemana(Date d){
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        switch (c.get(Calendar.DAY_OF_WEEK)){
            case 1:
                int a = -5;
                for (int j = 0;j<semana.length;j++){
                    c.setTime(d);
                    c.add(Calendar.DATE,a);
                    semana[j] = String.valueOf(c.get(Calendar.DAY_OF_MONTH));
                    a++;
                }
                break;
            case 2:
                a = -6;
                for (int j = 0;j<7;j++){
                    c.setTime(d);
                    c.add(Calendar.DATE,a);
                    semana[j] = String.valueOf(c.get(Calendar.DAY_OF_MONTH));
                    a++;
                }
                break;
            case 3:
                a = 0;
                for (int j = 0;j<7;j++){
                    c.setTime(d);
                    c.add(Calendar.DATE,a);
                    semana[j] = String.valueOf(c.get(Calendar.DAY_OF_MONTH));
                    a++;
                }
                break;
            case 4:
                a = -1;
                for (int j = 0;j<7;j++){
                    c.setTime(d);
                    c.add(Calendar.DATE,a);
                    semana[j] = String.valueOf(c.get(Calendar.DAY_OF_MONTH));
                    a++;
                }
                break;
            case 5:
                a = -2;
                for (int j = 0;j<7;j++){
                    c.setTime(d);
                    c.add(Calendar.DATE,a);
                    semana[j] = String.valueOf(c.get(Calendar.DAY_OF_MONTH));
                    a++;
                }
                break;
            case 6:
                a = -3;
                for (int j = 0;j<7;j++){
                    c.setTime(d);
                    c.add(Calendar.DATE,a);
                    semana[j] = String.valueOf(c.get(Calendar.DAY_OF_MONTH));
                    a++;
                }
                break;
            case 7:
                a = -4;
                for (int j = 0;j<7;j++){
                    c.setTime(d);
                    c.add(Calendar.DATE,a);
                    semana[j] = String.valueOf(c.get(Calendar.DAY_OF_MONTH));
                    a++;
                }
                break;
        }
        txtDia1.setText(semana[0]);
        txtDia2.setText(semana[1]);
        txtDia3.setText(semana[2]);
        txtDia4.setText(semana[3]);
        txtDia5.setText(semana[4]);
        txtDia6.setText(semana[5]);
        txtDia7.setText(semana[6]);
        txtFecha.setText(d.getDay()+"/"+d.getMonth()+"/"+d.getYear());
    }

}
