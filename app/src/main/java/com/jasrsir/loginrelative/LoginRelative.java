package com.jasrsir.loginrelative;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginRelative extends AppCompatActivity implements ILoginMvp.View {

    //TODO Vamos a ver cómo se hace más optiomizado que el LoginTable
    //TODO volvemos a crear las instancias de clase necesarias.
    private ILoginMvp.Presenter loginMvp;
    private EditText mEdtPassword;
    private EditText mEdtUser;
    private Button mBtnOk;
    private Button mBtnCancel;

    private final String TAG = "loginrelative";

    //El modelo vista presentador tenía una instancia de la vista, y en vez de llamar al método validar credenciales



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_relative);

        //El presentador tenía una referencia a la vista, y la vista es la activity THIS
        loginMvp = new LoginPresenter(this);
        mEdtUser = (EditText) findViewById(R.id.edtUser);
        mEdtPassword = (EditText) findViewById(R.id.edtPassword);
        mBtnOk = (Button) findViewById(R.id.btnOk);
        mBtnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginMvp.validateCredentials(mEdtUser.getText().toString(), mEdtPassword.getText().toString());
            }
        });

        mBtnCancel = (Button) findViewById(R.id.btnCancel);
        mBtnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetValues();
            }
        });

        //Comprobar la persistencia del objeto aplicación guardada anteriormente por el presentador.
        if (((LoginApplication)getApplicationContext()).getUsuario() != null) {
            Log.d(TAG,((LoginApplication)getApplicationContext()).getUsuario().toString());
        }
    }

    @Override
    public void setMessageError(String messageError) {
        Toast.makeText(this, messageError, Toast.LENGTH_SHORT).show();
    }

    private void resetValues() {
        mEdtPassword.setText("");
        mEdtUser.setText("");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"Activity Finalizada");
    }
}
