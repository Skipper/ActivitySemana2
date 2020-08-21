package primerproyecto.unam.aplicacinactivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class confirmacionDeDatos extends AppCompatActivity {

    @BindView(R.id.tv_nombre_contacto)
    TextView tvNombreContacto;
    @BindView(R.id.tv_Fecha_Contacto)
    TextView tvFechaContacto;
    @BindView(R.id.tv_Telefono_Contacto)
    TextView tvTelefonoContacto;
    @BindView(R.id.tv_Email_Contacto)
    TextView tvEmailContacto;
    @BindView(R.id.tv_Descripcion_Contacto)
    TextView tvDescripcionContacto;
    @BindView(R.id.btn_Editar_Datos)
    Button btnEditarDatos;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmacion_de_datos);
        ButterKnife.bind(this);

        Bundle parametros = this.getIntent().getExtras();

        if (parametros != null) {
            String nombre_recopilado = parametros.getString(getResources().getString(R.string.pnombre));
            String fecha_recopilado = parametros.getString(getResources().getString(R.string.pfecha));
            String telefono_recopilado = parametros.getString(getResources().getString(R.string.ptelefono));
            String email_recopilado = parametros.getString(getResources().getString(R.string.pemail));
            String descripcion_recopilado = parametros.getString(getResources().getString(R.string.pdescripcion));

            tvNombreContacto.setText(nombre_recopilado);
            tvFechaContacto.setText(fecha_recopilado);
            tvTelefonoContacto.setText(telefono_recopilado);
            tvEmailContacto.setText(email_recopilado);
            tvDescripcionContacto.setText(descripcion_recopilado);


/*            String nombre = parametros.getString(getResources().getString(R.string.pnombre)); // Nombre

            String telefono = parametros.getString(getResources().getString(R.string.ptelefono)); // telefono
            String email = parametros.getString(getResources().getString(R.string.pemail)); // Email
            String descripcion = parametros.getString(getResources().getString(R.string.pemail)); // Descripción

            tvNombreContacto.setText(nombre);
            tvTelefonoContacto.setText(telefono);
            tvEmailContacto.setText(email);
 */
        }


    }

    @OnClick(R.id.btn_Editar_Datos)
    public void onClick() {
        String NombreContacto = tvNombreContacto.getText().toString();
        //String FechaContacto = tvFechaContacto.getText().toString();
        String TelefonoContacto = tvTelefonoContacto.getText().toString();
        String EmailContacto = tvEmailContacto.getText().toString();
        String DescripcionContacto = tvDescripcionContacto.getText().toString();

        Intent intencion = new Intent(confirmacionDeDatos.this, MainActivity.class);

        Bundle bundle = new Bundle();

        bundle.putString(getResources().getString(R.string.pnombre), NombreContacto);
        //bundle.putString(getResources().getString(R.string.pfecha), FechaContacto);
        bundle.putString(getResources().getString(R.string.ptelefono), TelefonoContacto);
        bundle.putString(getResources().getString(R.string.pemail), EmailContacto);
        bundle.putString(getResources().getString(R.string.pdescripcion), DescripcionContacto);

        startActivity(intencion);
    }
}