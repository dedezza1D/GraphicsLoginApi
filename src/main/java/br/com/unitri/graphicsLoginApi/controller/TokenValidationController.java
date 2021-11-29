package br.com.unitri.graphicsLoginApi.controller;

import br.com.unitri.graphicsLoginApi.models.GraphicUser;
import br.com.unitri.graphicsLoginApi.models.dto.request.UserRequest;
import br.com.unitri.graphicsLoginApi.models.dto.response.UserResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class TokenValidationController {
        @PersistenceContext
        private EntityManager manager;


    }

