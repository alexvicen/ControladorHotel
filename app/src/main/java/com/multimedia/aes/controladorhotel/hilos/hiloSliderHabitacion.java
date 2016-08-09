package com.multimedia.aes.controladorhotel.hilos;

import android.app.Activity;
import android.os.AsyncTask;

import com.multimedia.aes.controladorhotel.nucleo.Habitaciones;

public class HiloSliderHabitacion extends AsyncTask<Void,Void,Void>{
    private Activity activity;

    public HiloSliderHabitacion(Activity activity) {
        this.activity = activity;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        while (((Habitaciones)activity).isPlay()) {
            try {
                Thread.sleep(5000);
                publishProgress();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
        ((Habitaciones)activity).pasarSiguiente();
    }
}
