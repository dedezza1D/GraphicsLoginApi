package br.com.unitri.graphicsLoginApi.models.dto.response;

import br.com.unitri.graphicsLoginApi.models.GraphicUser;

import java.time.LocalDateTime;

public class UserResponse {
    private String email;
    private LocalDateTime registerDate;

    public UserResponse() {
    }

    public UserResponse(GraphicUser user) {
        this.email = user.getLogin();
        this.registerDate = user.getRegisterDate();
    }

    public String getEmail() {
        return email;
    }

    public LocalDateTime getDataCadastro() {
        return registerDate;
    }
}
