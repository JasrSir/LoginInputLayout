package com.jasrsir.loginrelative;

import android.content.Context;
import android.text.TextUtils;

import com.jasrsir.loginrelative.model.Usuario;

/**
 * Created by Jasrsir on 6/10/16.
 * Creamos una clase Presentador. En el MVP el presentador debe tener un objeto de la vista
 */

public class LoginPresenter implements ILoginMvp.Presenter {

    private ILoginMvp.View vista;

    public LoginPresenter(ILoginMvp.View view) {
        this.vista = view;
    }

    //El presentador NO devuelve nada a la vista, lo modifica y pasa
    //Obtenemos el recursoi
    @Override
    public void validateCredentials(String user, String pass) {
        if (TextUtils.isEmpty(user) || TextUtils.isEmpty(pass)) {
            vista.setMessageError(((Context)vista).getResources().getString(R.string.data_empty));
        } else if (!pass.matches("^.{0,}([0-9])+.{0,}$")) {
            vista.setMessageError(((Context)vista).getResources().getString(R.string.password_digit));
        } else if (!pass.matches("^.+[a-zA-Z]+.+$")) {
            vista.setMessageError(((Context)vista).getResources().getString(R.string.password_case));
        } else if (pass.length() < 8) {
            vista.setMessageError(((Context) vista).getResources().getString(R.string.password_length));
        } else {
            //Guardar el usuario en la clase Application, lo hacre el presentador
            //Hacemos un up-cast y luego un down-cast

            ((LoginApplication)((Context)vista).getApplicationContext()).setUsuario(new Usuario(user,pass));
        }
    }
}
