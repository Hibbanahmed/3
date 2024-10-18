package com.example.trustpassplus;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class PasswordListActivity extends AppCompatActivity {

    private ListView listViewPasswords;
    private List<Password> passwordList;
    private DatabaseReference databasePasswords;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_list);

        firebaseAuth = FirebaseAuth.getInstance();
        String userId = firebaseAuth.getCurrentUser().getUid();
        databasePasswords = FirebaseDatabase.getInstance().getReference("passwords").child(userId);

        listViewPasswords = findViewById(R.id.listViewPasswords);
        passwordList = new ArrayList<>();

        FloatingActionButton fabAddPassword = findViewById(R.id.fabAddPassword);
        fabAddPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PasswordListActivity.this, AddPasswordActivity.class);
                startActivity(intent);
            }
        });
        loadPasswords();
    }


    private void loadPasswords() {
        databasePasswords.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                passwordList.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Password password = snapshot.getValue(Password.class);
                    passwordList.add(password);
                }
                // TODO: Create and set adapter for listViewPasswords
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Handle possible errors.
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_logout) {
            firebaseAuth.signOut();
            startActivity(new Intent(this, LoginActivity.class));
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}