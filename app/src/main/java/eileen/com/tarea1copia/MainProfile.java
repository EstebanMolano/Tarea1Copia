package eileen.com.tarea1copia;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.MenuItem;

public class MainProfile extends FragmentActivity {

    private FragmentA fragmentA;
    private FragmentB fragmentB;
    private FragmentC fragmentC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_profile);
         fragmentA = new FragmentA();
         fragmentB = new FragmentB();
        fragmentC = new FragmentC();

        BottomNavigationView naviagtion = findViewById(R.id.navigation);
        naviagtion.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem menuItem) {
                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                switch (menuItem.getItemId()){

                    case R.id.menubar_home:
                        transaction.replace(R.id.contenido, fragmentA);
                        transaction.commit();
                        break;
                    case R.id.menubar_notificaciones:
                        break;
                    case R.id.menubar_feed:
                        break;

                }
            }
        });
    }
}
