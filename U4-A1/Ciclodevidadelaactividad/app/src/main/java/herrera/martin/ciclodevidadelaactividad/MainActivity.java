package herrera.martin.ciclodevidadelaactividad;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
TextView txtState;
Button btBprimario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btBprimario=(Button)findViewById(R.id.btnprimario);
        btBprimario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,ActividadSecundaria.class));
            }
        });
        txtState = (TextView) findViewById(R.id.STATE);
        txtState.setMovementMethod(new ScrollingMovementMethod());

        Toast.makeText(this, "On Create", Toast.LENGTH_SHORT).show();
        Log.d("STATE", "oncreate");
        txtState.setText(txtState.getText()+"\n OnCreate");
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        txtState = (TextView) findViewById(R.id.STATE);
        txtState.setMovementMethod(new ScrollingMovementMethod());
        Toast.makeText(this, "On Restart", Toast.LENGTH_SHORT).show();
        Log.d("STATE", "onrestart");
        txtState.setText(txtState.getText()+"\n OnRestart");
    }
    @Override
    protected void onResume() {
        super.onResume();
        txtState = (TextView) findViewById(R.id.STATE);
        txtState.setMovementMethod(new ScrollingMovementMethod());
        Toast.makeText(this, "On Reume", Toast.LENGTH_SHORT).show();
        Log.d("STATE", "onresume");
        txtState.setText(txtState.getText()+"\n OnResume");
    }
    @Override
    protected void onPause() {
        super.onPause();
        txtState = (TextView) findViewById(R.id.STATE);
        txtState.setMovementMethod(new ScrollingMovementMethod());
        Toast.makeText(this, "On Pause", Toast.LENGTH_SHORT).show();
        Log.d("STATE", "onpause");
        txtState.setText(txtState.getText()+"\n OnPause");
    }
    @Override
    protected void onStart() {
        super.onStart();
        txtState = (TextView) findViewById(R.id.STATE);
        txtState.setMovementMethod(new ScrollingMovementMethod());
        Toast.makeText(this, "On Start", Toast.LENGTH_SHORT).show();
        Log.d("STATE", "onstart");
        txtState.setText(txtState.getText()+"\n OnStart");
    }
    @Override
    protected void onStop() {
        super.onStop();
        txtState = (TextView) findViewById(R.id.STATE);
        txtState.setMovementMethod(new ScrollingMovementMethod());
        Toast.makeText(this, "On Stop", Toast.LENGTH_SHORT).show();
        Log.d("STATE", "onstop");
        txtState.setText(txtState.getText()+"\n OnStop");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        txtState = (TextView) findViewById(R.id.STATE);
        txtState.setMovementMethod(new ScrollingMovementMethod());
        Toast.makeText(this, "On Destroy", Toast.LENGTH_SHORT).show();
        Log.d("STATE", "ondestroy");
        txtState.setText(txtState.getText()+"\n OnDestroy");
    }
}
