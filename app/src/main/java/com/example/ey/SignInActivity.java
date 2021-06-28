package com.example.ey;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.rengwuxian.materialedittext.MaterialEditText;

public class SignInActivity extends AppCompatActivity {

    ImageView buttonSignIn, buttonReg, buttonStart, buttonMore;;
    EditText loginField, passwordField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrate);

        UserBaseHelper databaseHelper;

        buttonSignIn = (ImageView) findViewById(R.id.sign_in_button);
        buttonStart = (ImageView) findViewById(R.id.start_button);
        buttonReg = (ImageView) findViewById(R.id.reg_button);
        buttonMore = (ImageView) findViewById(R.id.reg_button);
        loginField = (EditText) findViewById(R.id.loginField);
        passwordField = (EditText) findViewById(R.id.passwordField);


        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignInActivity.this, CategoryActivity.class);
                startActivity(intent);
            }
        });
        buttonMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignInActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        databaseHelper = new UserBaseHelper(SignInActivity.this);

        buttonSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isExist = databaseHelper.checkUserExist(loginField.getText().toString(), passwordField.getText().toString());

                if(isExist){
                    Intent intent = new Intent(SignInActivity.this, CategoryActivity.class);
                    intent.putExtra("username", loginField.getText().toString());
                    startActivity(intent);
                } else {
                    passwordField.setText(null);
                    Toast.makeText(SignInActivity.this, "Ошибка входа. Неверное имя пользователя или пароль.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        buttonReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*MaterialEditText login = (MaterialEditText) findViewById(R.id.loginField);
*/
            }
        });

        buttonSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignInActivity.this, PDFVeiewActivity.class);
                startActivity(intent);
            }
        });


    }

}