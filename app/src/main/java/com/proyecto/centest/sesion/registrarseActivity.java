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

public class registrarseActivity extends AppCompatActivity {

    //Textos, botones y firebaseauth
    private EditText EditTextUsuario, EditTextEmail, EditTextContraseña;
    private Button botonRegistro, google_button;
    private FirebaseAuth mAuth; //Autorización de Firebase

    //Variables
    private String usuario = "";
    private String email = "";
    private String contraseña = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) { //Main

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);

        mAuth = FirebaseAuth.getInstance(); //Creamos la instancia para el firebase

        //Aqui inicia sesion automaticamente si ya se hizo con anterioridad
        if (mAuth.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(), sesionIniciadaActivity.class));
            finish();
        }

        //Conexion entre el boton de la interfaz y el nombre que se le da en el codigo
        EditTextEmail = findViewById(R.id.editTextEmail);
        EditTextContraseña = findViewById(R.id.editTextContraseña);
        botonRegistro = findViewById(R.id.botonRegistro);

        //La accion que realiza el boton de registro
        botonRegistro.setOnClickListener(new View.OnClickListener(){

            public void onClick (View view){

                //Aquí al darle al botón va a obtener los datos que están en los campos
                email = EditTextEmail.getText().toString().trim();
                contraseña = EditTextContraseña.getText().toString().trim();

                if(TextUtils.isEmpty(email)){ //Si la caja del email esta vacia mostrará un error
                    EditTextEmail.setError("Se necesita el email");
                    return;
                }

                else if (TextUtils.isEmpty(contraseña)){ //Si la caja de la contraseña esta vacia mostrará un error
                    EditTextContraseña.setError("Se necesita una contraseña");
                    return;
                }

                else if (contraseña.length() < 6){ //Si la caja de la contraseña tiene menos de 6 dígitos mostrará un error
                    EditTextContraseña.setError("La contraseña debe tener 6 caracteres mínimo");
                }

                    mAuth.createUserWithEmailAndPassword(email, contraseña).addOnCompleteListener(new OnCompleteListener<AuthResult>() { //Aqui se crear el usuario y la contraseña mediante firebase

                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if (task.isSuccessful()){
                                Toast.makeText(registrarseActivity.this, "Usuario creado correctamente", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getApplicationContext(), sesionIniciadaActivity.class));
                            }

                            else{ //Si hay un error
                                Toast.makeText(registrarseActivity.this, "Error en el registro" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
            }
        });
    }
}
