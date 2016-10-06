package com.example.user.manigbas;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.regex.Pattern;

public class LoginScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
        final EditText emailValidate = (EditText) findViewById(R.id.emailEditText);
        final EditText passwordFormat = (EditText) findViewById(R.id.passwordEditTxt);
        final Button button = (Button) findViewById(R.id.loginBtn);
        final TextView showBtn = (TextView) findViewById(R.id.toggleTxt);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email = emailValidate.getText().toString();
                final String password = passwordFormat.getText().toString();
                if (validate(email) && password.length() >= 8) {
                    Toast.makeText(getApplicationContext(), "Login Successful!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginScreen.this, Quadrant.class);
                    startActivity(intent);
                }
                if (!validate(email) || password.length() < 8) {
                    if(!validate(email)){
                        Toast.makeText(getApplicationContext(), "Invalid E-mail Address!", Toast.LENGTH_SHORT).show();
                    }
                    if(password.length()<8){
                        Toast.makeText(getApplicationContext(), "Invalid Password!", Toast.LENGTH_SHORT).show();
                    }
                }
                if (!validate(email) && password.length() < 8)
                    Toast.makeText(getApplicationContext(), "Invalid E-Mail or Password!", Toast.LENGTH_SHORT).show();
            }
        });
        showBtn.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event){
                switch ( event.getAction() ) {

                    case MotionEvent.ACTION_DOWN:
                        EditText pText=(EditText)findViewById(R.id.passwordEditTxt);
                        pText.setInputType(InputType.TYPE_CLASS_TEXT);
                        break;
                    case MotionEvent.ACTION_UP:
                        EditText aText=(EditText)findViewById(R.id.passwordEditTxt);
                        aText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                        break;
                }
                return true;
            }

        });
    }
    private boolean validate(String email){

        return Pattern.compile("^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"
                + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|"
                + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$").matcher(email).matches();
    }

}
