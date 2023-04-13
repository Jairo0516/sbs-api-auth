package com.api.auth.domain.service;


import com.api.auth.controller.dto.keycloak.KeycloakSessionDTO;

import java.util.List;

public interface KeycloakSessionService {


  List<KeycloakSessionDTO> getSessions(String id);
}
