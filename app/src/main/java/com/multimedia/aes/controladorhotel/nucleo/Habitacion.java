package com.multimedia.aes.controladorhotel.nucleo;

import android.graphics.Typeface;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import com.multimedia.aes.controladorhotel.R;

public class Habitacion extends AppCompatActivity implements View.OnClickListener {
    private ImageSwitcher iswHabitacion;
    private Button btnSiguiente,btnAnterior;
    private TextView txt1,txt2;
    private int imageSwitcherImages[] = {R.drawable.img1, R.drawable.img2, R.drawable.img3, R.drawable.img4, R.drawable.img5, R.drawable.img6,};
    private int switcherImage = imageSwitcherImages.length;
    private int counter = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.habitacion);
        btnAnterior=(Button)findViewById(R.id.btnAnterior);
        btnSiguiente=(Button)findViewById(R.id.btnSiguiente);
        txt1 = (TextView)findViewById(R.id.txt1);
        txt2 = (TextView)findViewById(R.id.txt2);
        btnAnterior.setOnClickListener(this);
        btnSiguiente.setOnClickListener(this);
        iswHabitacion=(ImageSwitcher)findViewById(R.id.iswHabitacion);
        iswHabitacion.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView switcherImageView = new ImageView(getApplicationContext());
                switcherImageView.setLayoutParams(new ImageSwitcher.LayoutParams(
                        ActionBar.LayoutParams.FILL_PARENT, ActionBar.LayoutParams.FILL_PARENT
                ));
                switcherImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                switcherImageView.setImageResource(R.drawable.img1);
                return switcherImageView;
            }
        });
        Typeface miPropiaTypeFace = Typeface.createFromAsset(getAssets(), "font/CloisterBlack.ttf");
        txt1.setTypeface(miPropiaTypeFace);
        txt2.setTypeface(miPropiaTypeFace);
    }

    @Override
    public void onClick(View view) {
        if (view.getId()==R.id.btnAnterior){
            if (counter == 0){
                counter = switcherImage-1;
            }else{
                counter--;
            }
            Animation animationOut = AnimationUtils.loadAnimation(this, R.anim.slide_out_right);
            Animation animationIn = AnimationUtils.loadAnimation(this, R.anim.slide_in_right);
            iswHabitacion.setOutAnimation(animationOut);
            iswHabitacion.setInAnimation(animationIn);
            iswHabitacion.setImageResource(imageSwitcherImages[counter]);
        }else if (view.getId()==R.id.btnSiguiente){
            if (counter == switcherImage-1){
                counter = 0;
            }else {
                counter++;
            }
            Animation animationOut = AnimationUtils.loadAnimation(this, R.anim.slide_out_left);
            Animation animationIn = AnimationUtils.loadAnimation(this, R.anim.slide_in_left);
            iswHabitacion.setOutAnimation(animationOut);
            iswHabitacion.setInAnimation(animationIn);
            iswHabitacion.setImageResource(imageSwitcherImages[counter]);
        }
    }
}
