package br.com.unitri.graphicsLoginApi.models;

public class CleanPassword {
    private String passwordPlainText;

    public CleanPassword ( String passwordPlainText ) {
        this.passwordPlainText = passwordPlainText;
    }

    public String getPasswordPlainText () {
        return passwordPlainText;
    }
}
