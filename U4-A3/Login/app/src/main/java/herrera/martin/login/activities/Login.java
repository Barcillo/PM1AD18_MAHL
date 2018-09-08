package herrera.martin.login.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import herrera.martin.login.R;
import herrera.martin.login.daos.UsuariosDao;
import herrera.martin.login.models.Usuario;

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

        btnboton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UsuariosDao udao = new UsuariosDao();
                boolean resultado = udao.usuarioExist(new Usuario(txtusuario.getText().toString(),
                        txtpass.getText().toString()));

                Intent respuesta = new Intent();

                respuesta.putExtra("resultado",resultado);
                respuesta.putExtra("pass",txtpass.getText().toString());
                setResult(MainActivity.LOGIN_INTENT_CODE,respuesta);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {

    }
}
