package com.multimedia.aes.controladorhotel.nucleo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import com.multimedia.aes.controladorhotel.R;
import com.multimedia.aes.controladorhotel.daos.HabitacionDAO;
import com.multimedia.aes.controladorhotel.entidades.Habitacion;

import java.sql.SQLException;

public class Habitaciones extends AppCompatActivity implements View.OnClickListener, View.OnTouchListener {
    private ImageSwitcher iswHabitacion;
    private Button btnSiguiente,btnAnterior;
    private TextView txt1,txt2;
    private Bitmap imageSwitcherImages[] = new Bitmap[6];
    private int switcherImage = imageSwitcherImages.length;
    private int counter = 0;
    private int hab;
    private Habitacion habitacion;
    private float firstTouchX;
    private float firstTouchY;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.habitacion);
        hab = getIntent().getIntExtra("habitacion",0);
        try {
            habitacion = HabitacionDAO.buscarHabitacionPorId(this,hab);
            imageSwitcherImages[0]= pasarBase64String(habitacion.getImagen1());
            imageSwitcherImages[1]= pasarBase64String(habitacion.getImagen2());
            imageSwitcherImages[2]= pasarBase64String(habitacion.getImagen3());
            imageSwitcherImages[3]= pasarBase64String(habitacion.getImagen4());
            imageSwitcherImages[4]= pasarBase64String(habitacion.getImagen5());
            imageSwitcherImages[5]= pasarBase64String(habitacion.getImagen6());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        btnAnterior=(Button)findViewById(R.id.btnAnterior);
        btnSiguiente=(Button)findViewById(R.id.btnSiguiente);
        txt1 = (TextView)findViewById(R.id.txt1);
        txt2 = (TextView)findViewById(R.id.txt2);
        btnAnterior.setOnClickListener(this);
        btnSiguiente.setOnClickListener(this);
        iswHabitacion=(ImageSwitcher)findViewById(R.id.iswHabitacion);
        iswHabitacion.setOnTouchListener(this);
        iswHabitacion.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView switcherImageView = new ImageView(getApplicationContext());
                switcherImageView.setLayoutParams(new ImageSwitcher.LayoutParams(
                        ActionBar.LayoutParams.FILL_PARENT, ActionBar.LayoutParams.FILL_PARENT
                ));
                switcherImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                switcherImageView.setImageBitmap(imageSwitcherImages[0]);
                return switcherImageView;
            }
        });
        Typeface miPropiaTypeFace = Typeface.createFromAsset(getAssets(), "font/CloisterBlack.ttf");
        txt1.setTypeface(miPropiaTypeFace);
        txt2.setTypeface(miPropiaTypeFace);
        txt1.setText(habitacion.getNombre_habitacion());
        txt2.setText(habitacion.getDescripcion());
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
            Drawable drawable = new BitmapDrawable(getResources(), imageSwitcherImages[counter]);
            iswHabitacion.setImageDrawable(drawable);
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
            Drawable drawable = new BitmapDrawable(getResources(), imageSwitcherImages[counter]);
            iswHabitacion.setImageDrawable(drawable);
        }
    }
    private Bitmap pasarBase64String(String encodedImage){
        byte[] decodedString = Base64.decode(encodedImage, Base64.DEFAULT);
        Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
        return decodedByte;
    }

    @Override
    public boolean onTouch(View view, MotionEvent event) {
        switch(event.getAction()){
            case MotionEvent.ACTION_DOWN:
                //Aqui guardas en una variable privada de clase las coordenadas del primer toque:
                firstTouchX = event.getX();
                firstTouchY = event.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                //Aqui ya podemos determinar los tipos de movimientos:
                if(firstTouchX > event.getX()){
                    if (counter == switcherImage-1){
                        counter = 0;
                    }else {
                        counter++;
                    }
                    Animation animationOut = AnimationUtils.loadAnimation(this, R.anim.slide_out_left);
                    Animation animationIn = AnimationUtils.loadAnimation(this, R.anim.slide_in_left);
                    iswHabitacion.setOutAnimation(animationOut);
                    iswHabitacion.setInAnimation(animationIn);
                    Drawable drawable = new BitmapDrawable(getResources(), imageSwitcherImages[counter]);
                    iswHabitacion.setImageDrawable(drawable);
                }else{
                    if (counter == 0){
                        counter = switcherImage-1;
                    }else{
                        counter--;
                    }
                    Animation animationOut = AnimationUtils.loadAnimation(this, R.anim.slide_out_right);
                    Animation animationIn = AnimationUtils.loadAnimation(this, R.anim.slide_in_right);
                    iswHabitacion.setOutAnimation(animationOut);
                    iswHabitacion.setInAnimation(animationIn);
                    Drawable drawable = new BitmapDrawable(getResources(), imageSwitcherImages[counter]);
                    iswHabitacion.setImageDrawable(drawable);
                }
                if(firstTouchY > event.getY()){
                    //Hacia arriba
                }else{
                    //Hacia abajo
                }
                break;
        }
        return true;
    }
}
