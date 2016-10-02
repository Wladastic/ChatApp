package com.wladik.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button send_button = (Button) findViewById(R.id.send_button);
        Button call_button = (Button) findViewById(R.id.call_button);
        final TextView text_view = (TextView) findViewById(R.id.text_view);

        text_view.setText("");
        send_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                /**
                 * TODO: add a function that adds the Text to the textfield.
                 */
                sendText(text_view);
            }

    });
    }
    private void sendText(TextView text_view) {

        String text_to_send = "new text";
        // this does nothing, just a test:
        text_view.setText(text_to_send);

    }





}
