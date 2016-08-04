package com.multimedia.aes.controladorhotel.fragment;
import android.annotation.TargetApi;
import android.graphics.Typeface;
import android.os.Build;
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
    private TextView txt00, txt01, txt02, txt03, txt04, txt05, txt06, txt07, txt10, txt11, txt12, txt13,
            txt14, txt15, txt16, txt17, txt20, txt21, txt22, txt23, txt24, txt25, txt26, txt27, txt30,
            txt31, txt32, txt33, txt34, txt35, txt36, txt37, txt40, txt41, txt42, txt43, txt44, txt45,
            txt46, txt47, txt50, txt51, txt52, txt53, txt54, txt55, txt56, txt57, txt60, txt61, txt62,
            txt63, txt64, txt65, txt66, txt67, txt70, txt71, txt72, txt73, txt74, txt75, txt76, txt77,
            txt80, txt81, txt82, txt83, txt84, txt85, txt86, txt87, txt90, txt91, txt92, txt93, txt94,
            txt95, txt96, txt97, txt100, txt101, txt102, txt103, txt104, txt105, txt106, txt107, txt110,
            txt111, txt112, txt113, txt114, txt115, txt116, txt117;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        vista = inflater.inflate(R.layout.fragment_reservar, container, false);
        inicializarVariables();
        cambiarTipoLetra();
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
    private void inicializarVariables(){
        dpFecha = (DatePicker) vista.findViewById(R.id.dpFecha);
        txtFecha = (TextView) vista.findViewById(R.id.txtFecha);
        txtDia1 = (TextView) vista.findViewById(R.id.txtDia1);
        txtDia2 = (TextView) vista.findViewById(R.id.txtDia2);
        txtDia3 = (TextView) vista.findViewById(R.id.txtDia3);
        txtDia4 = (TextView) vista.findViewById(R.id.txtDia4);
        txtDia5 = (TextView) vista.findViewById(R.id.txtDia5);
        txtDia6 = (TextView) vista.findViewById(R.id.txtDia6);
        txtDia7 = (TextView) vista.findViewById(R.id.txtDia7);
        txt00 = (TextView) vista.findViewById(R.id.txt00);
        txt01 = (TextView) vista.findViewById(R.id.txt01);
        txt02 = (TextView) vista.findViewById(R.id.txt02);
        txt03 = (TextView) vista.findViewById(R.id.txt03);
        txt04 = (TextView) vista.findViewById(R.id.txt04);
        txt05 = (TextView) vista.findViewById(R.id.txt05);
        txt06 = (TextView) vista.findViewById(R.id.txt06);
        txt07 = (TextView) vista.findViewById(R.id.txt07);
        txt10 = (TextView) vista.findViewById(R.id.txt10);
        txt11 = (TextView) vista.findViewById(R.id.txt11);
        txt12 = (TextView) vista.findViewById(R.id.txt12);
        txt13 = (TextView) vista.findViewById(R.id.txt13);
        txt14 = (TextView) vista.findViewById(R.id.txt14);
        txt15 = (TextView) vista.findViewById(R.id.txt15);
        txt16 = (TextView) vista.findViewById(R.id.txt16);
        txt17 = (TextView) vista.findViewById(R.id.txt17);
        txt20 = (TextView) vista.findViewById(R.id.txt20);
        txt21 = (TextView) vista.findViewById(R.id.txt21);
        txt22 = (TextView) vista.findViewById(R.id.txt22);
        txt23 = (TextView) vista.findViewById(R.id.txt23);
        txt24 = (TextView) vista.findViewById(R.id.txt24);
        txt25 = (TextView) vista.findViewById(R.id.txt25);
        txt26 = (TextView) vista.findViewById(R.id.txt26);
        txt27 = (TextView) vista.findViewById(R.id.txt27);
        txt30 = (TextView) vista.findViewById(R.id.txt30);
        txt31 = (TextView) vista.findViewById(R.id.txt31);
        txt32 = (TextView) vista.findViewById(R.id.txt32);
        txt33 = (TextView) vista.findViewById(R.id.txt33);
        txt34 = (TextView) vista.findViewById(R.id.txt34);
        txt35 = (TextView) vista.findViewById(R.id.txt35);
        txt36 = (TextView) vista.findViewById(R.id.txt36);
        txt37 = (TextView) vista.findViewById(R.id.txt37);
        txt40 = (TextView) vista.findViewById(R.id.txt40);
        txt41 = (TextView) vista.findViewById(R.id.txt41);
        txt42 = (TextView) vista.findViewById(R.id.txt42);
        txt43 = (TextView) vista.findViewById(R.id.txt43);
        txt44 = (TextView) vista.findViewById(R.id.txt44);
        txt45 = (TextView) vista.findViewById(R.id.txt45);
        txt46 = (TextView) vista.findViewById(R.id.txt46);
        txt47 = (TextView) vista.findViewById(R.id.txt47);
        txt50 = (TextView) vista.findViewById(R.id.txt50);
        txt51 = (TextView) vista.findViewById(R.id.txt51);
        txt52 = (TextView) vista.findViewById(R.id.txt52);
        txt53 = (TextView) vista.findViewById(R.id.txt53);
        txt54 = (TextView) vista.findViewById(R.id.txt54);
        txt55 = (TextView) vista.findViewById(R.id.txt55);
        txt56 = (TextView) vista.findViewById(R.id.txt56);
        txt57 = (TextView) vista.findViewById(R.id.txt57);
        txt60 = (TextView) vista.findViewById(R.id.txt60);
        txt61 = (TextView) vista.findViewById(R.id.txt61);
        txt62 = (TextView) vista.findViewById(R.id.txt62);
        txt63 = (TextView) vista.findViewById(R.id.txt63);
        txt64 = (TextView) vista.findViewById(R.id.txt64);
        txt65 = (TextView) vista.findViewById(R.id.txt65);
        txt66 = (TextView) vista.findViewById(R.id.txt66);
        txt67 = (TextView) vista.findViewById(R.id.txt67);
        txt70 = (TextView) vista.findViewById(R.id.txt70);
        txt71 = (TextView) vista.findViewById(R.id.txt71);
        txt72 = (TextView) vista.findViewById(R.id.txt72);
        txt73 = (TextView) vista.findViewById(R.id.txt73);
        txt74 = (TextView) vista.findViewById(R.id.txt74);
        txt75 = (TextView) vista.findViewById(R.id.txt75);
        txt76 = (TextView) vista.findViewById(R.id.txt76);
        txt77 = (TextView) vista.findViewById(R.id.txt77);
        txt80 = (TextView) vista.findViewById(R.id.txt80);
        txt81 = (TextView) vista.findViewById(R.id.txt81);
        txt82 = (TextView) vista.findViewById(R.id.txt82);
        txt83 = (TextView) vista.findViewById(R.id.txt83);
        txt84 = (TextView) vista.findViewById(R.id.txt84);
        txt85 = (TextView) vista.findViewById(R.id.txt85);
        txt86 = (TextView) vista.findViewById(R.id.txt86);
        txt87 = (TextView) vista.findViewById(R.id.txt87);
        txt90 = (TextView) vista.findViewById(R.id.txt90);
        txt91 = (TextView) vista.findViewById(R.id.txt91);
        txt92 = (TextView) vista.findViewById(R.id.txt92);
        txt93 = (TextView) vista.findViewById(R.id.txt93);
        txt94 = (TextView) vista.findViewById(R.id.txt94);
        txt95 = (TextView) vista.findViewById(R.id.txt95);
        txt96 = (TextView) vista.findViewById(R.id.txt96);
        txt97 = (TextView) vista.findViewById(R.id.txt97);
        txt100 = (TextView) vista.findViewById(R.id.txt100);
        txt101 = (TextView) vista.findViewById(R.id.txt101);
        txt102 = (TextView) vista.findViewById(R.id.txt102);
        txt103 = (TextView) vista.findViewById(R.id.txt103);
        txt104 = (TextView) vista.findViewById(R.id.txt104);
        txt105 = (TextView) vista.findViewById(R.id.txt105);
        txt106 = (TextView) vista.findViewById(R.id.txt106);
        txt107 = (TextView) vista.findViewById(R.id.txt107);
        txt110 = (TextView) vista.findViewById(R.id.txt110);
        txt111 = (TextView) vista.findViewById(R.id.txt111);
        txt112 = (TextView) vista.findViewById(R.id.txt112);
        txt113 = (TextView) vista.findViewById(R.id.txt113);
        txt114 = (TextView) vista.findViewById(R.id.txt114);
        txt115 = (TextView) vista.findViewById(R.id.txt115);
        txt116 = (TextView) vista.findViewById(R.id.txt116);
        txt117 = (TextView) vista.findViewById(R.id.txt117);
    }
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
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
                txt06.setElevation(1);
                txt16.setElevation(1);
                txt26.setElevation(1);
                txt36.setElevation(1);
                txt46.setElevation(1);
                txt56.setElevation(1);
                txt66.setElevation(1);
                txt76.setElevation(1);
                txt86.setElevation(1);
                txt96.setElevation(1);
                txt106.setElevation(1);
                txt116.setElevation(1);
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
        txtDia1.setText(semana[0]+"\n"+"LUNES");
        txtDia2.setText(semana[1]+"\n"+"MARTES");
        txtDia3.setText(semana[2]+"\n"+"MIERCOLES");
        txtDia4.setText(semana[3]+"\n"+"JUEVES");
        txtDia5.setText(semana[4]+"\n"+"VIERNES");
        txtDia6.setText(semana[5]+"\n"+"SABADO");
        txtDia7.setText(semana[6]+"\n"+"DOMINGO");
        txtFecha.setText(d.getDay()+"/"+d.getMonth()+"/"+d.getYear());
    }
    private void cambiarTipoLetra(){
        Typeface miPropiaTypeFace = Typeface.createFromAsset(getContext().getAssets(), "font/CloisterBlack.ttf");
        txtFecha.setTypeface(miPropiaTypeFace);
        txtDia1.setTypeface(miPropiaTypeFace);
        txtDia2.setTypeface(miPropiaTypeFace);
        txtDia3.setTypeface(miPropiaTypeFace);
        txtDia4.setTypeface(miPropiaTypeFace);
        txtDia5.setTypeface(miPropiaTypeFace);
        txtDia6.setTypeface(miPropiaTypeFace);
        txtDia7.setTypeface(miPropiaTypeFace);
        txt00.setTypeface(miPropiaTypeFace);
        txt01.setTypeface(miPropiaTypeFace);
        txt02.setTypeface(miPropiaTypeFace);
        txt03.setTypeface(miPropiaTypeFace);
        txt04.setTypeface(miPropiaTypeFace);
        txt05.setTypeface(miPropiaTypeFace);
        txt06.setTypeface(miPropiaTypeFace);
        txt07.setTypeface(miPropiaTypeFace);
        txt10.setTypeface(miPropiaTypeFace);
        txt11.setTypeface(miPropiaTypeFace);
        txt12.setTypeface(miPropiaTypeFace);
        txt13.setTypeface(miPropiaTypeFace);
        txt14.setTypeface(miPropiaTypeFace);
        txt15.setTypeface(miPropiaTypeFace);
        txt16.setTypeface(miPropiaTypeFace);
        txt17.setTypeface(miPropiaTypeFace);
        txt20.setTypeface(miPropiaTypeFace);
        txt21.setTypeface(miPropiaTypeFace);
        txt22.setTypeface(miPropiaTypeFace);
        txt23.setTypeface(miPropiaTypeFace);
        txt24.setTypeface(miPropiaTypeFace);
        txt25.setTypeface(miPropiaTypeFace);
        txt26.setTypeface(miPropiaTypeFace);
        txt27.setTypeface(miPropiaTypeFace);
        txt30.setTypeface(miPropiaTypeFace);
        txt31.setTypeface(miPropiaTypeFace);
        txt32.setTypeface(miPropiaTypeFace);
        txt33.setTypeface(miPropiaTypeFace);
        txt34.setTypeface(miPropiaTypeFace);
        txt35.setTypeface(miPropiaTypeFace);
        txt36.setTypeface(miPropiaTypeFace);
        txt37.setTypeface(miPropiaTypeFace);
        txt40.setTypeface(miPropiaTypeFace);
        txt41.setTypeface(miPropiaTypeFace);
        txt42.setTypeface(miPropiaTypeFace);
        txt43.setTypeface(miPropiaTypeFace);
        txt44.setTypeface(miPropiaTypeFace);
        txt45.setTypeface(miPropiaTypeFace);
        txt46.setTypeface(miPropiaTypeFace);
        txt47.setTypeface(miPropiaTypeFace);
        txt50.setTypeface(miPropiaTypeFace);
        txt51.setTypeface(miPropiaTypeFace);
        txt52.setTypeface(miPropiaTypeFace);
        txt53.setTypeface(miPropiaTypeFace);
        txt54.setTypeface(miPropiaTypeFace);
        txt55.setTypeface(miPropiaTypeFace);
        txt56.setTypeface(miPropiaTypeFace);
        txt57.setTypeface(miPropiaTypeFace);
        txt60.setTypeface(miPropiaTypeFace);
        txt61.setTypeface(miPropiaTypeFace);
        txt62.setTypeface(miPropiaTypeFace);
        txt63.setTypeface(miPropiaTypeFace);
        txt64.setTypeface(miPropiaTypeFace);
        txt65.setTypeface(miPropiaTypeFace);
        txt66.setTypeface(miPropiaTypeFace);
        txt67.setTypeface(miPropiaTypeFace);
        txt70.setTypeface(miPropiaTypeFace);
        txt71.setTypeface(miPropiaTypeFace);
        txt72.setTypeface(miPropiaTypeFace);
        txt73.setTypeface(miPropiaTypeFace);
        txt74.setTypeface(miPropiaTypeFace);
        txt75.setTypeface(miPropiaTypeFace);
        txt76.setTypeface(miPropiaTypeFace);
        txt77.setTypeface(miPropiaTypeFace);
        txt80.setTypeface(miPropiaTypeFace);
        txt81.setTypeface(miPropiaTypeFace);
        txt82.setTypeface(miPropiaTypeFace);
        txt83.setTypeface(miPropiaTypeFace);
        txt84.setTypeface(miPropiaTypeFace);
        txt85.setTypeface(miPropiaTypeFace);
        txt86.setTypeface(miPropiaTypeFace);
        txt87.setTypeface(miPropiaTypeFace);
        txt90.setTypeface(miPropiaTypeFace);
        txt91.setTypeface(miPropiaTypeFace);
        txt92.setTypeface(miPropiaTypeFace);
        txt93.setTypeface(miPropiaTypeFace);
        txt94.setTypeface(miPropiaTypeFace);
        txt95.setTypeface(miPropiaTypeFace);
        txt96.setTypeface(miPropiaTypeFace);
        txt97.setTypeface(miPropiaTypeFace);
        txt100.setTypeface(miPropiaTypeFace);
        txt101.setTypeface(miPropiaTypeFace);
        txt102.setTypeface(miPropiaTypeFace);
        txt103.setTypeface(miPropiaTypeFace);
        txt104.setTypeface(miPropiaTypeFace);
        txt105.setTypeface(miPropiaTypeFace);
        txt106.setTypeface(miPropiaTypeFace);
        txt107.setTypeface(miPropiaTypeFace);
        txt110.setTypeface(miPropiaTypeFace);
        txt111.setTypeface(miPropiaTypeFace);
        txt112.setTypeface(miPropiaTypeFace);
        txt113.setTypeface(miPropiaTypeFace);
        txt114.setTypeface(miPropiaTypeFace);
        txt115.setTypeface(miPropiaTypeFace);
        txt116.setTypeface(miPropiaTypeFace);
        txt117.setTypeface(miPropiaTypeFace);
    }
}
