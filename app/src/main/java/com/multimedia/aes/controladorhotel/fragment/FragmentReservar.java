package com.multimedia.aes.controladorhotel.fragment;


import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
        return vista;
    }

    @Override
    public void onClick(View view) {
    }
}
