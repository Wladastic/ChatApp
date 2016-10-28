package com.wladik.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    String username = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button send_button = (Button) findViewById(R.id.send_button);
        Button call_button = (Button) findViewById(R.id.call_button);
        final Button login_button = (Button) findViewById(R.id.login_button);

        final TextView login_name = (TextView) findViewById(R.id.login_name);
        final TextView text_view = (TextView) findViewById(R.id.text_view);
        final EditText message_text = (EditText) findViewById(R.id.message_text);

/**
 * TODO: Add username_id that calculates out of the user's IP adress or IMEI
 *
 */

        send_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                /**
                 * TODO: add a function that adds the Text to the textfield.
                 */
                if(username.length() > 0) {
                    if (String.valueOf(message_text.getText()).length() > 0){
                        sendText(text_view, message_text, username);
                    }
                } else {
                    Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(intent);
                }

            }
        });

        login_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                /**
                 * TODO: make this get the username from LoginActivity.class!
                 * TODO: let the Client get a login token by the Server which is saved on the Server and only works in the hour/day it was created.
                 * TODO: or just use the device's imei or something....
                 */
                if(username.equals("")) {
                    username = "wlad";
                    login(username, login_name);
                    login_button.setText("Ausloggen");
                } else {
                    username = "";
                    login_name.setText("");
                }

                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);

            }

        });
    }
    private void login(String username, TextView login_name) {
        login_name.setText(username);
    }

    private void sendText(TextView text_view, EditText message_text, String username) {
        /**
         * TODO: Send the message to the server, reference to which user it is sent.
         * TODO: make a checker that does not allow more than 240 Characters, meaning message_text.length() must not exceed 240.
         *
         */
        String text_to_send = String.valueOf(message_text.getText());
        // this does nothing, just a test:
        String old_text_view = String.valueOf(text_view.getText());
        text_view.setText(( old_text_view+ "\n" + username +":: " + text_to_send));
        message_text.setText("");
    }
}
