package lantar.spy.login;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import lantar.spy.R;
import lantar.spy.api.HandlerResult;
import lantar.spy.api.UserAPI;

/**
 * Created by Lantar on 07.09.2015.
 */
public class ForgotPassActivity extends ActionBarActivity {

    EditText textEmail;
    Button btnSendEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_pass);

        textEmail = (EditText) findViewById(R.id.afp_email);
        btnSendEmail = (Button) findViewById(R.id.afp_btnSend);

        btnSendEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserAPI userAPI = new UserAPI(forgotPasswordHandler);
                userAPI.sentPassword(textEmail.getText().toString());

            }
        });
    }

    @SuppressLint("HandlerLeak")
    private Handler forgotPasswordHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            switch (HandlerResult.valueOf(msg.what)) {
                case OK:
                    Toast.makeText(ForgotPassActivity.this, ForgotPassActivity.this.getString(R.string.manual_send),
                            Toast.LENGTH_LONG).show();
                    break;
                case ERROR:
                    Toast.makeText(ForgotPassActivity.this, ForgotPassActivity.this.getString(R.string.bad_email),
                            Toast.LENGTH_SHORT).show();
                default:
                    break;
            }
        }

    };
}
