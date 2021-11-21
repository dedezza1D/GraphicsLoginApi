package br.com.unitri.graphicsLoginApi.controller;

import br.com.unitri.graphicsLoginApi.models.dto.request.LoginRequest;
import br.com.unitri.graphicsLoginApi.security.TokenManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping( "/api/auth" )
public class UserAuthenticationController {

    private AuthenticationManager authManager;
    private TokenManager tokenManager;

    public UserAuthenticationController (AuthenticationManager authManager , TokenManager tokenManager) {
        this.authManager = authManager;
        this.tokenManager = tokenManager;
    }

    private static final Logger log = LoggerFactory
            .getLogger(UserAuthenticationController.class);

    @PostMapping( consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<String> authenticate (@RequestBody @Valid LoginRequest request ) {
        UsernamePasswordAuthenticationToken authenticationToken = request.build();
        try {
            Authentication authentication = authManager.authenticate(authenticationToken);
            String jwt = tokenManager.generateToken(authentication);
            return ResponseEntity.ok(jwt);
        } catch (AuthenticationException e) {
            log.error("[Autenticacao] {}" , e);
            return ResponseEntity.badRequest().build();
        }
    }
}
