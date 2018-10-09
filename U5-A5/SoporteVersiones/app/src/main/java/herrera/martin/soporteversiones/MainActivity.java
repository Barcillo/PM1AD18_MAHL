package herrera.martin.soporteversiones;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int versionSDK = android.os.Build.VERSION.SDK_INT;

        Toast.makeText(MainActivity.this,"Versión: "+versionSDK, Toast.LENGTH_LONG).show();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            //para versiones con android 8.0 o superior.
            Toast.makeText(MainActivity.this,"Tú Android esta actualizado", Toast.LENGTH_LONG).show();
        } else{
            //para versiones inferiores a android 8.0.
            Toast.makeText(MainActivity.this,"Tú android ya esta viejo", Toast.LENGTH_LONG).show();
        }

    }
}
