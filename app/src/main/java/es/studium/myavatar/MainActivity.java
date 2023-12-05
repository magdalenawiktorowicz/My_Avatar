package es.studium.myavatar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    FragmentManager fm = getSupportFragmentManager();
    FragmentTransaction ft;
    Fragment fragment1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragment1 = fm.findFragmentByTag("fragment1");
        if (fragment1 == null) {
            // iniciar el primer fragment (el botón para generar el avatar)
            fragment1 = new Fragment1();
            ft = fm.beginTransaction();
            // añadir el fragment al contenedor
            ft.add(R.id.fragmentContainerView, fragment1, "fragment1").commit();
        }
    }
}