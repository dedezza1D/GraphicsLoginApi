package br.com.unitri.graphicsLoginApi.controller;

import br.com.unitri.graphicsLoginApi.models.GraphicUser;
import br.com.unitri.graphicsLoginApi.models.dto.request.UserRequest;
import br.com.unitri.graphicsLoginApi.models.dto.response.UserResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping
    @Transactional
    public ResponseEntity<UserResponse> save(@RequestBody @Valid UserRequest userRequest){
        GraphicUser user = userRequest.convert();
        manager.persist(user);
        return ResponseEntity.ok(new UserResponse(user));
    }
}
