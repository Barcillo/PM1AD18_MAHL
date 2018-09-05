package herrera.martin.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends Activity {
    EditText txtusuario, txtpass;
    Button btnboton;
    TextView titulo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        txtusuario = findViewById(R.id.TxtUsuario);
        txtpass = findViewById(R.id.TxtPassword);
        btnboton =findViewById(R.id.btnLogin);
        titulo=findViewById(R.id.TxtTitulo);

        btnboton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent respuesta = new Intent();
                respuesta.putExtra("usuario",txtusuario.getText().toString());
                respuesta.putExtra("pass",txtpass.getText().toString());
                setResult(MainActivity.LOGIN_INTENT_CODE,respuesta);
                finish();
            }
        });
    }
}
