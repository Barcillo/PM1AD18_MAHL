package herrera.martin.calculadora;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    // variables para operaciones
    String cadena ="";
    boolean punto = false;
    double numero1 =0;
    double numero2 =0;
    double resultado = 0;
    String operacion ="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // variable de los botones
        final Button btuno = (Button) findViewById(R.id.Uno);
        final Button btdos = (Button) findViewById(R.id.Dos);
        final Button bttre = (Button) findViewById(R.id.Tres);
        final Button btcuatro = (Button) findViewById(R.id.Cuatro);
        final Button btcinco = (Button) findViewById(R.id.Cinco);
        final Button btseis = (Button) findViewById(R.id.Seis);
        final Button btsiete = (Button) findViewById(R.id.Siete);
        final Button btocho = (Button) findViewById(R.id.Ocho);
        final Button btnueve = (Button) findViewById(R.id.Nueve);
        final Button btcero = (Button) findViewById(R.id.Cero);
        final Button btdiv = (Button) findViewById(R.id.Div);
        final Button btpor = (Button) findViewById(R.id.Multiplicacion);
        final Button btmas = (Button) findViewById(R.id.mas);
        final Button btmenos = (Button) findViewById(R.id.menos);
        final Button btpunto = (Button) findViewById(R.id.Punto);
        final Button btborrartodo = (Button) findViewById(R.id.Borrar);
        final Button btborrar1 = (Button) findViewById(R.id.Bor1);
        final Button btborraractual = (Button) findViewById(R.id.BorrAct);
        final Button btnigual = (Button) findViewById(R.id.Igual);

        // variable de texto
        final TextView texto = (TextView) findViewById(R.id.Etiqueta);

        // evento de los numeros
        btuno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                texto.setText(texto.getText()+ "1");
            }
        });
        btdos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                texto.setText(texto.getText()+ "2");
            }
        });
        bttre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                texto.setText(texto.getText()+ "3");
            }
        });
        btcuatro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                texto.setText(texto.getText()+ "4");
            }
        });
        btcinco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                texto.setText(texto.getText()+ "5");
            }
        });
        btseis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                texto.setText(texto.getText()+ "6");
            }
        });
        btsiete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                texto.setText(texto.getText()+ "7");
            }
        });
        btocho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                texto.setText(texto.getText()+ "8");
            }
        });
        btnueve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                texto.setText(texto.getText()+ "9");
            }
        });
        btcero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                texto.setText(texto.getText()+ "0");
            }
        });

        btpunto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                texto.setText(texto.getText()+ ".");
            }
        });

        // evento signos
        try {
            btmas.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(texto.getText().length() > 0) {
                        numero1 = Double.parseDouble((String) texto.getText());
                        operacion = "+";
                        texto.setText("");

                    }
                }
            });
            btmenos.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(texto.getText().length() > 0) {
                        numero1 = Double.parseDouble((String) texto.getText());
                        operacion = "-";
                        texto.setText("");
                    }
                }
            });
            btpor.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(texto.getText().length() > 0) {
                        numero1 = Double.parseDouble((String) texto.getText());
                        operacion = "*";
                        texto.setText("");
                    }
                }
            });
            btdiv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(texto.getText().length() > 0 && (Integer.parseInt((String) texto.getText())) >0 ) {
                        numero1 = Double.parseDouble((String) texto.getText());
                        operacion = "/";
                        texto.setText("");
                    }
                }
            });
            btnigual.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    numero2 = Double.parseDouble((String) texto.getText());
                    resultado = opera(operacion);
                    texto.setText(resultado +"");
                }
            });
        }catch (Exception x){
            //Toast.makeText()
            cadena = "";
            numero2 =0;
            numero1=0;
            operacion = "";
        }

        btborrartodo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numero2 = 0;
                numero1 = 0;
                resultado = 0;
                texto.setText("");
            }
        });
        btborraractual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                texto.setText("");
            }
        });
        btborrar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cadena= (String) texto.getText();
                int tam = cadena.length();
                texto.setText(cadena.substring(0,tam-1));
            }
        });
    }


    public double opera(String signo){
    try {
        switch (signo){
            case "+":
                resultado = numero1 + numero2;
                break;
            case "-":
                resultado = numero1 - numero2;
                break;
            case "/":
                resultado = numero1 / numero2;
                break;
            case "*":
                resultado = numero1 * numero2;
                break;
        }
    }catch (Exception e){
        cadena = "";
        numero2 =0;
        numero1=0;
        operacion = "";
    }

    return resultado;
    }

}
