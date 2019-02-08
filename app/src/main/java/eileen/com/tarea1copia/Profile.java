package eileen.com.tarea1copia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.widget.Button;

public class Profile extends AppCompatActivity {

    private RelativeLayout root_profile;
    private Button btn_salir_profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        root_profile = findViewById(R.id.profile_root);
        btn_salir_profile= findViewById(R.id.btn_salir_profile);

        root_profile.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event){
                float Xini=0;
                float Yini=0;
                switch(event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        btn_salir_profile.setText(event.getX() + "," +event.getY());
                        Xini=event.getX();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        btn_salir_profile.setText(event.getX() + "," +event.getY());
                        break;
                    case MotionEvent.ACTION_UP:


                        Yini=event.getX();
                        float deltax =Yini-Xini;
                        if(deltax>500){
                            Intent i = new Intent(Profile.this,MainProfile.class
                            );
                            startActivity(i);
                        }

                        if(deltax<-500){
                            finish();
                        }

                        btn_salir_profile.setText(event.getX() + "," +event.getY());
                        break;
                }

                return false;
            }
        });

        Intent datos = getIntent();
        String nombre =datos.getExtras().getString("nombre");
        String contra =datos.getExtras().getString("contra");

        Toast.makeText(this, nombre+" "+ contra, Toast.LENGTH_SHORT).show();
    }
}
