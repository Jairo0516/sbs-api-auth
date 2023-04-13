package com.api.auth.domain.service.impl;

import com.api.auth.SbsAuthApplication;
import com.api.auth.controller.dto.ParameterTP.ParameterTPDTO;
import com.api.auth.controller.dto.keycloak.KeycloakSessionDTO;
import com.api.auth.controller.dto.keycloak.KeycloakTokenDTO;
import com.api.auth.domain.builder.ObjectBuilder;
import com.api.auth.domain.entity.ParameterTP;
import com.api.auth.domain.service.KeycloakSessionService;
import com.api.auth.domain.service.ParameterTPService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class KeycloakSessionImpl implements KeycloakSessionService {


  @Autowired
  private ParameterTPService parameterTPService;

  @Autowired
  private ObjectBuilder objectBuilder;

  private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(SbsAuthApplication.class);

  @Override
  public List<KeycloakSessionDTO> getSessions(String id) {
    List<KeycloakSessionDTO> responseSessions = new ArrayList<>();
    RestTemplate restTemplate = new RestTemplate();
    String postUrl = "";
    HttpHeaders headers = new HttpHeaders();
    try {
      ParameterTP getParameterTP = parameterTPService.getParameterTPByProductCodeAndPlanCodeAndParameterCode(0, 0, 3);
      ParameterTPDTO parameterTP = objectBuilder.map(getParameterTP, ParameterTPDTO.class);
      KeycloakTokenDTO keycloakToken = getToken(parameterTP);
      if(keycloakToken == null || keycloakToken.getAccess_token() == null){
        throw new Exception();
      }
      headers.setBearerAuth(keycloakToken.getAccess_token());
      //URL SESSIONS
      postUrl = parameterTP.getValueDescription6();
      String replaceUrl = postUrl.replace("?", id);
      HttpEntity<String> entity = new HttpEntity<>(headers);
      ResponseEntity<KeycloakSessionDTO[]> data = restTemplate.exchange(replaceUrl, HttpMethod.GET, entity, KeycloakSessionDTO[].class);
      int responseCode = data.getStatusCodeValue();
      if (responseCode != 200) {
        throw new Exception();
      }
      responseSessions =  List.of(data.getBody());
    } catch (Exception e) {
      LOGGER.info("Error al obtener las sesiones de KEYCLOAK: "+ e.getMessage());
    }
    return responseSessions;
  }


  private KeycloakTokenDTO getToken(ParameterTPDTO parameterTP) {
    KeycloakTokenDTO keycloakToken = null;
    RestTemplate restTemplate = new RestTemplate();
    String postUrl = "";
    HttpHeaders headers = new HttpHeaders();
    try {
      headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
      postUrl = parameterTP.getValueDescription5();
      MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
      map.add(parameterTP.getParameterDescription1(), parameterTP.getValueDescription1());
      map.add(parameterTP.getParameterDescription2(), parameterTP.getValueDescription2());
      map.add(parameterTP.getParameterDescription3(), parameterTP.getValueDescription3());
      map.add(parameterTP.getParameterDescription4(), parameterTP.getValueDescription4());
      HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(map, headers);
      ResponseEntity<Object> data = restTemplate.exchange(postUrl, HttpMethod.POST, entity, Object.class);
      int responseCode = data.getStatusCodeValue();
      if (responseCode != 200) {
        throw new Exception();
      }
      Object response = data.getBody();
      keycloakToken = objectBuilder.map(response, KeycloakTokenDTO.class);
    } catch (Exception e) {
      LOGGER.info("Error al obtener token de KEYCLOAK: "+ e.getMessage());
    }
    return keycloakToken;
  }



}
