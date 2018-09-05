package herrera.martin.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    public static final int LOGIN_INTENT_CODE = 20;
    public static final int ALUMNOS_INTENT_CODE = 25;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent loginIntent = new Intent(MainActivity.this,Login.class);
        //loginIntent.putExtra();
        startActivityForResult(loginIntent,LOGIN_INTENT_CODE);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode==LOGIN_INTENT_CODE){
            // Programar lo que hay que hacer cuando regrese el usuario y contraseña
            String user = data.getStringExtra("usuario");
            String pass= data.getStringExtra("pass");
            Toast.makeText(this,"usuario: "+user+"   "+"password: "+pass,Toast.LENGTH_LONG).show();
            //TextView texto =findViewById(R.Main)
        }
    }
}
