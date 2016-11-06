package org.horaapps.leafpic.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.horaapps.leafpic.R;

public class Commons extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commons);

        Button btnLogin = (Button) findViewById(R.id.loginButton);
        final TextView tvUsername = (TextView) findViewById(R.id.loginUsername);
        final TextView tvPass = (TextView) findViewById(R.id.loginPassword);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tvUsername.getText().length() > 0 && tvPass.getText().length() > 0){
                    Toast.makeText(Commons.this,"Success!",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(Commons.this,"Please enter username and password.",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}