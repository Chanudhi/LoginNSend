package edu.cinec.thursday;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText usernameEditText, passwordEditText;
    Button loginButton, clearButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI elements
        usernameEditText = findViewById(R.id.username);
        passwordEditText = findViewById(R.id.password);
        loginButton = findViewById(R.id.login_button);
        clearButton = findViewById(R.id.clear_button);

        // Login Button Click Listener
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Validate username and password (simple check for demo)
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                if (username.equals("user") && password.equals("123")) {
                    // Successful login - redirect to MessageActivity
                    Intent intent = new Intent(MainActivity.this, Message.class);  // Use Message class name
                    startActivity(intent);
                } else {
                    // Show invalid credentials toast
                    Toast.makeText(MainActivity.this, "Invalid credentials", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Clear Button Click Listener
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usernameEditText.setText("");
                passwordEditText.setText("");
            }
        });
    }
}
