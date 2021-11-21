package br.com.unitri.graphicsLoginApi.models.dto.request;

import br.com.unitri.graphicsLoginApi.models.CleanPassword;
import br.com.unitri.graphicsLoginApi.models.GraphicUser;
import br.com.unitri.graphicsLoginApi.validations.UniqueValue;
import org.hibernate.validator.constraints.Length;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class UserRequest {
    @Email
    @NotBlank
    @UniqueValue(domainClass = GraphicUser.class, fieldName = "login")
    private String login;
    @NotBlank @Length(min = 6)
    private String password;

    public UserRequest(@Email @NotBlank String login, @NotBlank @Length(min = 6) String password) {
        Assert.isTrue(StringUtils.hasLength(login) , "login não pode ser em branco");
        Assert.isTrue(StringUtils.hasLength(password), "senha não pode estar em branco");
        Assert.isTrue(password.length() >= 6, "senha precisa de no mínimo 6 caracteres");
        this.login = login;
        this.password = password;
    }

    public GraphicUser convert(){
        return new GraphicUser(login, new CleanPassword(password));
    }
}
