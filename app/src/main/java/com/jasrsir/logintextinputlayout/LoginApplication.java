package com.jasrsir.logintextinputlayout;

import android.app.Application;
import com.jasrsir.logintextinputlayout.model.Usuario;

/**
 * Esta clase está creada para guardar valores en la APP para el singleton
 * Para que se guarden los datos
 */

public class LoginApplication extends Application {
    //Esta aplicación va a guardar una entidad que es el USUARIO, ocn el nombre y contraseña
    private Usuario usuario;
    //Para este objeto mmodelo le hacemos las propiedades get y set
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }


    @Override
    public void onCreate() {
        super.onCreate();
    }


}
