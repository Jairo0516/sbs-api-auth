package com.api.auth.controller;

import com.api.auth.controller.dto.UserApp.UserAppDTO;
import com.api.auth.config.security.JWTUtil;
import com.api.auth.controller.dto.keycloak.KeycloakSessionDTO;
import com.api.auth.controller.dto.keycloak.KeycloakSessionsResponse;
import com.api.auth.controller.dto.security.AuthenticationRequest;
import com.api.auth.controller.dto.security.AuthenticationResponse;
import com.api.auth.controller.dto.security.CheckTokenResponse;
import com.api.auth.domain.service.KeycloakSessionService;
import com.api.auth.domain.service.impl.AuthUserDetailsService;
import com.api.auth.domain.service.impl.UserDetailsService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import java.util.List;

@CrossOrigin(origins= "*" , allowedHeaders = "*")
@RestController
@RequestMapping("api/v1/sbs/authentication")
@Api(tags = "Authentication")
public class AuthenticationController {
  @Autowired
  private UserDetailsService userDetailsService;

  @Autowired
  private AuthUserDetailsService authUserDetailsService;

  @Autowired
  private JWTUtil jwtUtil;

  @Autowired
  private KeycloakSessionService keycloakSessionService;

  @PostMapping("/auth")
  public ResponseEntity<AuthenticationResponse> createToken(@RequestBody AuthenticationRequest authenticationRequest) {

    HttpStatus status;
    String jwt = "";
    try {
      UserAppDTO userDetail = userDetailsService.loadUserByUsername(authenticationRequest.getUser(), authenticationRequest.getApp());
      if(userDetail != null){
        jwt = jwtUtil.generateTokenApp(userDetail);
        status = HttpStatus.OK;
      }else{
        status = HttpStatus.FORBIDDEN;
      }
    } catch (BadCredentialsException badCredentialsException) {
      status = HttpStatus.FORBIDDEN;
    }

    return new ResponseEntity<>(new AuthenticationResponse(jwt), status);
  }

  @PostMapping("/check-token")
  @ApiOperation(value = "Check token", authorizations = { @Authorization(value="JWT") })
  public ResponseEntity<CheckTokenResponse> checkToken(
          HttpServletRequest httpServletRequest,
          @AuthenticationPrincipal UserDetails userDetails
  )  {
    boolean valid;
    HttpStatus status = HttpStatus.FORBIDDEN;
    String token = httpServletRequest.getHeader("Authorization").substring(7); // Get token;
    valid = jwtUtil.validateToken(token, userDetails); // Check token is valid.
    if(valid) status = HttpStatus.OK;
    return new ResponseEntity<>(new CheckTokenResponse().builder().valid(valid).build(), status);
  }

  @GetMapping("/sessions/keycloak")
  public ResponseEntity<KeycloakSessionsResponse> getSessionsKeycloak(@Param(value = "id") String id) {
    HttpStatus status;
    List<KeycloakSessionDTO> sessions = null;
    try {
      sessions = keycloakSessionService.getSessions(id);
      status = HttpStatus.OK;
    } catch (BadCredentialsException badCredentialsException) {
      status = HttpStatus.FORBIDDEN;
    }
    return new ResponseEntity<>(new KeycloakSessionsResponse(sessions), status);
  }




}
