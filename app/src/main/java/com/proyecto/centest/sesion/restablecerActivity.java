package com.proyecto.centest.sesion;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.proyecto.centest.R;

public class restablecerActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    private EditText emailRestablecer;
    private Button botonRegistro;

    private ProgressDialog mDialog;

    private String email = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restablecer);

        mAuth = FirebaseAuth.getInstance();
        mDialog = new ProgressDialog(this);

        emailRestablecer = (EditText) findViewById(R.id.editTextRestablecer);
        botonRegistro = (Button) findViewById(R.id.botonRestablecer);

        botonRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                email = emailRestablecer.getText().toString().trim();

                if (!email.isEmpty()){
                    mDialog.setMessage("Espere un momento");
                    mDialog.setCanceledOnTouchOutside(false);
                    mDialog.show();
                    resetPassword();
                }

                else {
                    Toast.makeText(restablecerActivity.this, "Debes ingresar el email", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void resetPassword() {

        mAuth.setLanguageCode("es");
        mAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {

                if (task.isSuccessful()){
                    Toast.makeText(restablecerActivity.this, "Se ha enviado un correo para restablecer la contrasena", Toast.LENGTH_SHORT).show();
                }

                else{
                    Toast.makeText(restablecerActivity.this, "No se pudo enviar el correo de reestablecer contrasena", Toast.LENGTH_SHORT).show();
                }

                mDialog.dismiss();
            }
        });
    }
}