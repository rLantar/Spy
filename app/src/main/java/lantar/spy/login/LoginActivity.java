package lantar.spy.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseUser;

import lantar.spy.R;
import lantar.spy.api.HandlerResult;
import lantar.spy.api.UserAPI;
import lantar.spy.spy.MainActivity;

/**
 * Created by Lantar on 07.09.2015.
 */
public class LoginActivity extends Activity{

    EditText email;
    EditText pass;
    Button login;
    Button registery;
    Button forgotPass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = (EditText) findViewById(R.id.la_email);
        pass = (EditText) findViewById(R.id.la_pass);
        login = (Button) findViewById(R.id.la_btnLogin);
        registery = (Button) findViewById(R.id.la_btnNew);
//        forgotPass = (Button) findViewById(R.id.la_btnForgot);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserAPI userAPI = new UserAPI(loginHandler);
                userAPI.login(email.getText().toString(), pass.getText().toString());
            }
        });

        registery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startRegistery = new Intent(LoginActivity.this,NewSpyActivity.class);
                startActivity(startRegistery);
            }
        });

//        forgotPass.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent startForgot = new Intent(LoginActivity.this,ForgotActivity.class);
//                startActivity(startForgot);
//            }
//        });

        if(ParseUser.getCurrentUser() != null){
            startMainActivity();
        }

    }

    private void startMainActivity(){
        Intent mainActivityIntent = new Intent(this,MainActivity.class);
        startActivity(mainActivityIntent);
        finish();
    }




    private Handler loginHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            switch (HandlerResult.valueOf(msg.what)) {
                case OK:
                    startMainActivity();
                    break;
                case ERROR:
                    Toast.makeText(getApplicationContext(),
                            LoginActivity.this.getString(R.string.incorect_login),
                            Toast.LENGTH_SHORT).show();
                    login.setEnabled(true);
                    break;
                default:
                    break;
            }
        }

    };
}
