package br.com.unitri.graphicsLoginApi.models.dto.response;

public class AuthenticationResponse {

    private String jwt;
    private Long userId;

    public AuthenticationResponse(String jwt, Long userId) {
        this.jwt = jwt;
        this.userId = userId;
    }

    public String getJwt() {
        return jwt;
    }

    public Long getUserId() {
        return userId;
    }
}
