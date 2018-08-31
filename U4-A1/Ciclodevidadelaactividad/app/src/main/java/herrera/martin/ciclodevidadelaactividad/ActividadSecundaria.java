package herrera.martin.ciclodevidadelaactividad;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ActividadSecundaria extends Activity {
    TextView txtState;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantallasecundaria);

        txtState = (TextView) findViewById(R.id.STATE);
        txtState.setMovementMethod(new ScrollingMovementMethod());

        Toast.makeText(this, "On Create", Toast.LENGTH_SHORT).show();
        Log.d("STATE", "oncreate");
        txtState.setText(txtState.getText()+"\n OnCreate");
    }

    public void clickBotonPrincipal(View view) {
        startActivity(new Intent(ActividadSecundaria.this,MainActivity.class));
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        TextView txtState = (TextView) findViewById(R.id.STATE);
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
