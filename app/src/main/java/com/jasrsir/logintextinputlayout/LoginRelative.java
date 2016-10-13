package com.jasrsir.logintextinputlayout;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginRelative extends AppCompatActivity implements ILoginMvp.View {

    //TODO Vamos a ver cómo se hace más optiomizado que el LoginTable
    //TODO volvemos a crear las instancias de clase necesarias.
    private ILoginMvp.Presenter loginMvp;
    private EditText mEdtPassword;
    private EditText mEdtUser;
    private Button mBtnLogin;
    private TextInputLayout mtilPass;
    private TextInputLayout mtilUser;
    private final String TAG = "loginrelative";

    //El modelo vista presentador tenía una instancia de la vista, y en vez de llamar al método validar credenciales



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_relative);

        //El presentador tenía una referencia a la vista, y la vista es la activity THIS
        loginMvp = new LoginPresenter(this);
        mEdtUser = (EditText) findViewById(R.id.edtUser);
        mEdtUser.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mtilUser.setError(null);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        mEdtPassword = (EditText) findViewById(R.id.edtPassword);
        mEdtPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mtilPass.setError(null);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        mBtnLogin = (Button) findViewById(R.id.btnLogin);
        mtilPass = (TextInputLayout) findViewById(R.id.tilPass);
        mtilUser = (TextInputLayout) findViewById(R.id.tilUser);
        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginMvp.validateCredentials(mEdtUser.getText().toString(), mEdtPassword.getText().toString());
            }
        });

        //Comprobar la persistencia del objeto aplicación guardada anteriormente por el presentador.
        if (((LoginApplication)getApplicationContext()).getUsuario() != null) {
            Log.d(TAG,((LoginApplication)getApplicationContext()).getUsuario().toString());
        }
        Log.d(TAG,"Activity Finalizada");
    }

    @Override
    public void setMessageError(String messageError, int id) {
        //Toast.makeText(this, messageError, Toast.LENGTH_SHORT).show();
        switch (id) {
            case R.id.edtUser:
                mtilUser.setError(messageError);
                break;
            case R.id.edtPassword:
                mtilPass.setError(messageError);
                break;
        }

    }
    private void resetValues() {
        mEdtPassword.setText("");
        mEdtUser.setText("");
    }

    //TODO vamos a sobreescribir los métodos de la aplicación.


    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"Activity Finalizada");
    }
}
