package com.multimedia.aes.controladorhotel.nucleo;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import com.multimedia.aes.controladorhotel.R;

public class Habitacion extends AppCompatActivity implements View.OnClickListener {
    private ImageSwitcher iswHabitacion;
    private Button btnSiguiente,btnAnterior;
    int imageSwitcherImages[] = {R.drawable.img1, R.drawable.img2, R.drawable.img3, R.drawable.img4, R.drawable.img5, R.drawable.img6,};
    int switcherImage = imageSwitcherImages.length;
    int counter = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.habitacion);
        btnAnterior=(Button)findViewById(R.id.btnAnterior);
        btnSiguiente=(Button)findViewById(R.id.btnSiguiente);
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
                //switcherImageView.setMaxHeight(100);
                return switcherImageView;
            }
        });
        Animation animationOut = AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right);
        Animation animationIn = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);

        iswHabitacion.setOutAnimation(animationOut);
        iswHabitacion.setInAnimation(animationIn);
    }

    @Override
    public void onClick(View view) {
        if (view.getId()==R.id.btnAnterior){
            if (counter == 0){
                counter = switcherImage;
            }else{
                counter--;
            }
            iswHabitacion.setImageResource(imageSwitcherImages[counter]);
        }else if (view.getId()==R.id.btnSiguiente){
            if (counter == switcherImage){
                counter = 0;
            }else {
                counter++;
            }

            iswHabitacion.setImageResource(imageSwitcherImages[counter]);
        }
    }
}
