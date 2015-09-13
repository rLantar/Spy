package lantar.spy.login;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import lantar.spy.R;
import lantar.spy.api.HandlerResult;
import lantar.spy.api.UserAPI;
import lantar.spy.entity.Spy;
import lantar.spy.utils.Constants;

/**
 * Created by Lantar on 07.09.2015.
 */
public class NewSpyActivity extends ActionBarActivity {

    EditText fio;
    EditText email;
    EditText pass;
    EditText phone;
    EditText url;
    Button complite;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_spy);

        progressBar = (ProgressBar) findViewById(R.id.ns_progressBar);
        email = (EditText) findViewById(R.id.ns_email);
        fio = (EditText) findViewById(R.id.ns_fio);
        pass = (EditText) findViewById(R.id.ns_pass);
        phone = (EditText) findViewById(R.id.ns_phone);
        url = (EditText) findViewById(R.id.ns_url);
        complite = (Button) findViewById(R.id.ns_btnCreate);


        complite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createUser();
            }
        });

    }

    private boolean allFildFull() {
        if (TextUtils.isEmpty(fio.getText()) || TextUtils.isEmpty(email.getText()) || TextUtils.isEmpty(pass.getText()) ||
                TextUtils.isEmpty(phone.getText()) || TextUtils.isEmpty(url.getText())) {
            Toast.makeText(getApplicationContext(),
                    this.getString(R.string.fild_is_emputy),
                    Toast.LENGTH_SHORT).show();
            return false;
        } else {
            return true;
        }

    }

    private void createUser(){
        if (allFildFull()){
            Spy spy = new Spy();
            spy.setEmail(email.getText().toString());
            spy.setPass(pass.getText().toString());
            spy.setPhone(phone.getText().toString());
            spy.setFio(fio.getText().toString());
            spy.setUrl(url.getText().toString());
            spy.setRole(Constants.USER_ROLE_SPY);

            UserAPI userAPI = new UserAPI(registeryHandler);
            userAPI.create(spy);

            complite.setEnabled(false);
            progressBar.setVisibility(ProgressBar.VISIBLE);

        }
    }

    private Handler registeryHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (HandlerResult.valueOf(msg.what)) {
                case OK:
                    UserAPI.logOut();
                    Toast.makeText(NewSpyActivity.this,NewSpyActivity.this.getText(R.string.registery_done),Toast.LENGTH_SHORT).show();
                    Intent mainActivityIntent = new Intent(NewSpyActivity.this, LoginActivity.class);
                    startActivity(mainActivityIntent);
                    finish();
                    progressBar.setVisibility(ProgressBar.GONE);
                    complite.setEnabled(true);
                    break;
                case ERROR:
                    complite.setEnabled(true);
                    Toast.makeText(NewSpyActivity.this,NewSpyActivity.this.getText(R.string.registery_error),Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(ProgressBar.GONE);
                    break;
                case WRONG_EMAIL:
                    complite.setEnabled(true);
                    Toast.makeText(NewSpyActivity.this,NewSpyActivity.this.getText(R.string.bad_email),Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(ProgressBar.GONE);
                    break;
                case EMAIL_EXISTS:
                    complite.setEnabled(true);
                    Toast.makeText(NewSpyActivity.this,NewSpyActivity.this.getText(R.string.email_exists),Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(ProgressBar.GONE);
                    break;
                default:
                    complite.setEnabled(true);
                    break;
            }
        }

    };
}
