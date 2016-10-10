package com.jasrsir.loginrelative;

/**
 * Created by Jasrsir on 6/10/16.
 * Modelo Vista Presentador
 * Creación de una Interfaz COMPUESTA por 2 interfaces
 * las variables declaradas en una interfaz son public static final
 */
public interface ILoginMvp {


    int PASSWORD_DIGIT = 1;
    int PASSWORD_CASE = 2;
    int PASSWORD_LENGTH = 3;
    int DATA_EMPTY = 4;

    interface View{
        public void setMessageError(String error, int id);
    }


    interface Presenter{
        public void validateCredentials(String user, String pass);
    }
}
