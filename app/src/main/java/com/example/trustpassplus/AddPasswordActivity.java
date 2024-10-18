package com.example.trustpassplus;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddPasswordActivity extends AppCompatActivity {

    private EditText editTextTitle, editTextUsername, editTextPassword;
    private Button buttonAddPassword;
    private DatabaseReference databasePasswords;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_password);

        firebaseAuth = FirebaseAuth.getInstance();
        String userId = firebaseAuth.getCurrentUser().getUid();
        databasePasswords = FirebaseDatabase.getInstance().getReference("passwords").child(userId);

        editTextTitle = findViewById(R.id.editTextTitle);
        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonAddPassword = findViewById(R.id.buttonAddPassword);

        buttonAddPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addPassword();
            }
        });
    }

    private void addPassword() {
        String title = editTextTitle.getText().toString().trim();
        String username = editTextUsername.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        if (title.isEmpty() || username.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        String id = databasePasswords.push().getKey();
        Password newPassword = new Password(title, username, password);

        databasePasswords.child(id).setValue(newPassword);

        Toast.makeText(this, "Password added successfully", Toast.LENGTH_SHORT).show();
        finish();
    }
}