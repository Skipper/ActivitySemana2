package primerproyecto.unam.aplicacinactivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tiet_Nombre_Contacto)
    TextInputEditText tietNombreContacto;
    @BindView(R.id.dp_Fecha_Nacimiento)
    DatePicker dpFechaNacimiento;
    @BindView(R.id.tiet_Telefono_Contacto)
    TextInputEditText tietTelefonoContacto;
    @BindView(R.id.tiet_Email_Contacto)
    TextInputEditText tietEmailContacto;
    @BindView(R.id.tiet_Descripcion_Contacto)
    TextInputEditText tietDescripcionContacto;
    @BindView(R.id.btn_siguiente)
    Button btnSiguiente;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Bundle parametros = this.getIntent().getExtras();

        if (parametros != null) {
            String nombre_recopilado = parametros.getString(getResources().getString(R.string.pnombre));
            String fecha_recopilado = parametros.getString(getResources().getString(R.string.pfecha));
            String telefono_recopilado = parametros.getString(getResources().getString(R.string.ptelefono));
            String email_recopilado = parametros.getString(getResources().getString(R.string.pemail));
            String descripcion_recopilado = parametros.getString(getResources().getString(R.string.pdescripcion));

            tietNombreContacto.setText(nombre_recopilado);
            //dpFechaNacimiento.setText(fecha_recopilado);
            tietTelefonoContacto.setText(telefono_recopilado);
            tietEmailContacto.setText(email_recopilado);
            tietDescripcionContacto.setText(descripcion_recopilado);
        }
    }

    @OnClick(R.id.btn_siguiente)
    public void onClick() {
        String NombreContacto = tietNombreContacto.getText().toString();

        String TelefonoContacto = tietTelefonoContacto.getText().toString();
        String EmailContacto = tietEmailContacto.getText().toString();
        String DescripcionContacto = tietDescripcionContacto.getText().toString();

        Intent intencion = new Intent(MainActivity.this, confirmacionDeDatos.class);


        Bundle bundle = new Bundle();
        // Variables
        bundle.putString(getResources().getString(R.string.pnombre), NombreContacto);

        /*dpFechaNacimiento.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int i, int i1, int i2) {
                String anho = dpFechaNacimiento.getYear();

            }
        });*/

        /*DatePicker datePicker = (DatePicker) findViewById(R.id.dp_Fecha_Nacimiento);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        datePicker.init(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), new DatePicker.OnDateChangedListener() {

            @Override
            public void onDateChanged(DatePicker datePicker, int year, int month, int dayOfMonth) {
                Log.d("Date", "Year=" + year + " Month=" + (month + 1) + " day=" + dayOfMonth);
            }
        });*/

        /*dpFechaNacimiento.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int year, int month, int dayOfMonth) {
                Toast.makeText(MainActivity.this, "Año: "+year, Toast.LENGTH_SHORT).show();
                Log.d("Date", "Year=" + year + " Month=" + (month + 1) + " day=" + dayOfMonth);
            }
        });*/



        /*tietEmailContacto.setText(
                String.valueOf(dpFechaNacimiento.getDayOfMonth()+ "-"+
                        String.valueOf(dpFechaNacimiento.getMonth()+ "-" +
                            String.valueOf(dpFechaNacimiento.getYear())
                        )
                )
        );*/
        String fecha_Nacimiento;
        String day = String.valueOf(dpFechaNacimiento.getDayOfMonth());
        String month = String.valueOf(dpFechaNacimiento.getMonth()+1);
        String year = String.valueOf(dpFechaNacimiento.getYear());
        fecha_Nacimiento = day+"-"+month+"-"+year;

        bundle.putString(getResources().getString(R.string.pfecha), fecha_Nacimiento);
        bundle.putString(getResources().getString(R.string.ptelefono), TelefonoContacto);
        bundle.putString(getResources().getString(R.string.pemail), EmailContacto);
        bundle.putString(getResources().getString(R.string.pdescripcion), DescripcionContacto);

        intencion.putExtras(bundle);

        startActivity(intencion);
    }

}