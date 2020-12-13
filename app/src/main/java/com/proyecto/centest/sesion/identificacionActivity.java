package com.proyecto.centest.sesion;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.proyecto.centest.R;

public class identificacionActivity extends AppCompatActivity {

    //Cajas de texto, boton y firebaseauth
    private EditText EditTextEmailIdentificacion;
    private EditText EditTextContrasenaIdentificacion;

    private Button botonInicio;
    private Button botonRegistro;
    private Button restablecer;
    private Button localizacion;

    FirebaseAuth mAuth;

    //Variables
    private String emailIdent = "";
    private String contrasenaIdent = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) { //Main
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_identificacion);

        mAuth = FirebaseAuth.getInstance(); //Instancia de firebase

        if (mAuth.getCurrentUser() != null) { //Si el usuario ya ha iniciado sesion te mandará a la sesion iniciada directamente
            startActivity(new Intent(getApplicationContext(), sesionIniciadaActivity.class));
            finish();
        }

        botonRegistro = (Button) findViewById(R.id.botonRegistroTo); //Este botón te manda a la clase de registro
        botonRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intencion1 = new Intent(view.getContext(), registrarseActivity.class);
                startActivity(intencion1);
            }
        });

        restablecer = (Button) findViewById(R.id.restablcerButton);
        restablecer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intencion2 = new Intent(view.getContext(), restablecerActivity.class);
                startActivity(intencion2);
            }
        });

        //Enlace entre las cajas de texto y botones de la interfaz y el código
        EditTextEmailIdentificacion = (EditText) findViewById(R.id.editTextEmailIdent);
        EditTextContrasenaIdentificacion = (EditText) findViewById(R.id.editTextContrasenaIdent);
        botonInicio = (Button) findViewById(R.id.botonInicio);

        botonInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Obtiene el texto eliminando los espacios que haya por delante y por detrás
                emailIdent = EditTextEmailIdentificacion.getText().toString().trim();
                contrasenaIdent = EditTextContrasenaIdentificacion.getText().toString().trim();

                if(TextUtils.isEmpty(emailIdent)){ //Si el email está vacio dará un error
                    EditTextEmailIdentificacion.setError("El email está vacío");
                    return;
                }

                else if(TextUtils.isEmpty(contrasenaIdent)){ //Si la contrasena está vacía dará un error
                    EditTextContrasenaIdentificacion.setError("La contrasena está vacía");
                    return;
                }

               else {
                    mAuth.signInWithEmailAndPassword(emailIdent, contrasenaIdent).addOnCompleteListener(new OnCompleteListener<AuthResult>() { //Inicio de sesion mediante el usuario y la contrasena con firebase

                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if (task.isSuccessful()) { //Si la tarea funciona correctamente te pasara a sesion iniciada
                                Toast.makeText(identificacionActivity.this, "Inicio de sesión correcto", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getApplicationContext(), sesionIniciadaActivity.class));
                            }

                            else { //Si hay un error al iniciar sesion
                                Toast.makeText(identificacionActivity.this, "Fallo al iniciar sesión", Toast.LENGTH_SHORT).show();
                            }

                        }
                    });
                }
            }
        });
    }
}