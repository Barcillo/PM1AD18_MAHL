package herrera.martin.usobasicodefragments;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnFragmentoA = (Button) findViewById(R.id.btnfragmentoA);
        btnFragmentoA.setOnClickListener(new View.OnClickListener() {
            FragmentA fragmentA = new FragmentA();

            @Override
            public void onClick(View v) {
                getSupportFragmentManager()
                        .beginTransaction().setTransition(FragmentTransaction.TRANSIT_ENTER_MASK)
                        .replace(R.id.contenedor, new FragmentA())
                        .commit();
            }
        });



        Button btnFragmentoB = (Button) findViewById(R.id.btnfragmentoB);
        btnFragmentoB.setOnClickListener(new View.OnClickListener() {
            FragmentB fragmentB = new FragmentB();

            @Override
            public void onClick(View v) {
                getSupportFragmentManager()
                        .beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                        .replace(R.id.contenedor, new FragmentB())
                        .commit();
            }
        });
    }
}
