package edu.cinec.thursday;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.telephony.SmsManager;

import androidx.appcompat.app.AppCompatActivity;

public class Message extends AppCompatActivity {

    EditText mobileNumberEditText, messageEditText;
    Button sendButton, exitButton, clearButtonMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        // Initialize UI elements
        mobileNumberEditText = findViewById(R.id.mobile_number);
        messageEditText = findViewById(R.id.message);
        sendButton = findViewById(R.id.send_button);
        exitButton = findViewById(R.id.exit_button);
        clearButtonMessage = findViewById(R.id.clear_button_message);

        // Send Button Click Listener
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mobileNumber = mobileNumberEditText.getText().toString();
                String message = messageEditText.getText().toString();

                if (mobileNumber.isEmpty() || message.isEmpty()) {
                    // Show a message if fields are empty
                    Toast.makeText(Message.this, "Please enter mobile number and message", Toast.LENGTH_SHORT).show();
                } else {
                    try {
                        // Get an instance of SmsManager and send the message
                        SmsManager smsManager = SmsManager.getDefault();
                        smsManager.sendTextMessage(mobileNumber, null, message, null, null);

                        // Show a message that SMS is sent
                        Toast.makeText(Message.this, "Message Sent", Toast.LENGTH_SHORT).show();
                    } catch (Exception e) {
                        // Handle exception (e.g., permission issues)
                        Toast.makeText(Message.this, "Failed to send message. Please try again.", Toast.LENGTH_SHORT).show();
                        e.printStackTrace();
                    }
                }
            }
        });

        // Exit Button Click Listener
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Close the activity
            }
        });

        // Clear Button Click Listener
        clearButtonMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mobileNumberEditText.setText("");
                messageEditText.setText("");
            }
        });
    }
}
