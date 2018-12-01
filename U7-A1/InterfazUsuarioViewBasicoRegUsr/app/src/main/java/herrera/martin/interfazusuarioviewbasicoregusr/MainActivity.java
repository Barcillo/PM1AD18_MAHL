package herrera.martin.interfazusuarioviewbasicoregusr;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import  android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import  android.widget.TimePicker;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    static TextView txtHoraNacimeinto, txtFechaNacimiento;
    TextView txtUsername,txtPassword,txtNombre;
    CheckBox chkJava, chkDotNet,chkPython;
    RadioButton rdMasculin, rdFemenino;
    Switch swNotificacionesl;
    ToggleButton tgPublicidad;
    Spinner spOrigen;
    ImageButton btnHoraNacimiento,btnFechaNacimiento;
    Button btnGuardar;
    static int year,month,date,hrs,min;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnHoraNacimiento = (ImageButton)findViewById(R.id.ib_calenHoraNacimiento);
        btnFechaNacimiento = (ImageButton)findViewById(R.id.ib_calenFechaNacimiento);
        txtFechaNacimiento=(TextView)findViewById(R.id.tv_fechaNacimiento);
        txtHoraNacimeinto=(TextView)findViewById(R.id.tv_horaNacimiento);
        btnGuardar=(Button)findViewById(R.id.btn_guardar);
        txtUsername=(TextView)findViewById(R.id.et_username);
        txtPassword=(TextView)findViewById(R.id.et_password);
        txtNombre=(TextView)findViewById(R.id.et_nombre);
        chkJava=(CheckBox)findViewById(R.id.cb_java);
        chkDotNet=(CheckBox)findViewById(R.id.cb_dotnet);
        chkPython=(CheckBox)findViewById(R.id.cb_python);
        rdMasculin=(RadioButton)findViewById(R.id.rd_Masculino);
        rdFemenino=(RadioButton)findViewById(R.id.rd_Femenino);
        swNotificacionesl=(Switch)findViewById(R.id.sw_notificaciones);
        tgPublicidad=(ToggleButton)findViewById(R.id.tg_publicidad);
        spOrigen=(Spinner)findViewById(R.id.sp_origen);

        btnHoraNacimiento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment newFragment = new TimePickerFragment();
                newFragment.show(getFragmentManager(),"timePicker");
            }
        });

        btnFechaNacimiento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment newFragment = new DatePickerFragment();
                newFragment.show(getFragmentManager(), "DatePicker");
            }
        });

        btnGuardar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                dialogo();
            }
        });
    }

    public void dialogo(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.Guardar);
        builder.setMessage(R.string.se_guarda);
        builder.setPositiveButton(R.string.OK, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                Usuario objUsr=new Usuario();
                objUsr.setUsername(txtUsername.getText().toString());
                objUsr.setPassword(txtPassword.getText().toString());
                objUsr.setNombre(txtNombre.getText().toString());

                String tecnologias = "";
                tecnologias +=(chkDotNet.isChecked())?".NET;":"";
                tecnologias +=(chkJava.isChecked())?"JAVA;":"";
                tecnologias +=(chkPython.isChecked())?"PHYTON;":"";
                objUsr.setTecnologias(tecnologias);

                objUsr.setGenero((rdFemenino.isChecked())?"FEMENINO":"MASCULIO");

                objUsr.setNotificaciones(swNotificacionesl.isChecked());
                objUsr.setPublicidad(tgPublicidad.isChecked());
                objUsr.setIes_origen(spOrigen.getSelectedItem().toString());
                objUsr.setFechaHoraNacimiento(new Date(year,month,date,hrs,min));

                String FILENAME="Usuario_file.txt";
                String datos=objUsr.toString();
                try {
                    FileOutputStream fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
                    OutputStreamWriter writer= new OutputStreamWriter(fos);
                    writer.write(datos);
                    //PrintWriter pw=new PrintWriter(writer);
                    // pw.println(datos);
                    writer.close();
                }catch (FileNotFoundException e){
                    e.printStackTrace();
                }catch (IOException e){
                    e.printStackTrace();
                }

                try {
                    FileInputStream fis=openFileInput(FILENAME);
                    InputStreamReader reader = new InputStreamReader(fis);
                    BufferedReader br= new BufferedReader(reader);
                    String datosFile= br.readLine();
                    br.close();
                    fis.close();
                    Toast.makeText(MainActivity.this,"Datos: "+datosFile,Toast.LENGTH_LONG).show();
                }catch (Exception ex){

                }

                //Toast.makeText(MainActivity.this,"Se guardo el usuario: "+objUsr.toString(),Toast.LENGTH_LONG).show();

            }
        });
        builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this,"Ha elegido no guardar el registro",Toast.LENGTH_LONG).show();
            }
        });
        Dialog dialog= builder.create();
        dialog.show();
    }

    public static class TimePickerFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener{

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            final Calendar c= Calendar.getInstance();
            int hour= c.get(Calendar.HOUR_OF_DAY);
            int minute = c.get(Calendar.MINUTE);

            return new TimePickerDialog(getActivity(), this, hour, minute,
                    DateFormat.is24HourFormat(getActivity()));
        }

        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            //Programar nuestro código en respuesta a que se seleccionó hora
            //horaNacimeinto= String.format("%02d:%02d",hourOfDay,minute);
            hrs= hourOfDay;
            min=minute;
            txtHoraNacimeinto.setText("Hora: "+hourOfDay + " Minuto:"+minute);
        }
    }

    public  static  class DatePickerFragment extends DialogFragment
            implements DatePickerDialog.OnDateSetListener{

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            final Calendar c= Calendar.getInstance();
            int year= c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        @Override
        public void onDateSet(DatePicker view, int y, int m, int d) {
            // Do something with the date chosen by the user
            year=y;
            month=m+1;
            date=d;
            txtFechaNacimiento.setText("Dia: "+date + " Mes:"+month+" Año:"+year);
        }
    }
}