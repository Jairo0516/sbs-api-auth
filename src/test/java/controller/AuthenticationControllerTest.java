package controller;

import com.api.auth.config.security.JWTUtil;
import com.api.auth.controller.AuthenticationController;
import com.api.auth.controller.dto.UserApp.UserAppDTO;
import com.api.auth.controller.dto.security.AuthenticationRequest;
import com.api.auth.controller.dto.security.AuthenticationResponse;
import com.api.auth.domain.service.KeycloakSessionService;
import com.api.auth.domain.service.impl.AuthUserDetailsService;
import com.api.auth.domain.service.impl.UserDetailsService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

@RunWith(MockitoJUnitRunner.class)
public class AuthenticationControllerTest {

    @Mock
    UserDetailsService userDetailsService;

    @Mock
    JWTUtil jwtUtil;

    @Mock
    KeycloakSessionService keycloakSessionService;

    @Mock
    AuthUserDetailsService authUserDetailsService;

    @InjectMocks
    AuthenticationController authenticationController;

    String credentialsName = "CARLOS";

    @Before
    public void setUp() {
        UserAppDTO userDetail = new UserAppDTO();
        userDetail.setUser(credentialsName);
        Mockito.when(userDetailsService.loadUserByUsername(credentialsName, 1)).thenReturn(userDetail);
    }

    /*
    * Succesful authentication test
    * */
    @Test
    public void createToken() {
        AuthenticationRequest authenticationRequest = new AuthenticationRequest();
        authenticationRequest.setUser(credentialsName);
        authenticationRequest.setApp(1);
        ResponseEntity<AuthenticationResponse> response = authenticationController.createToken(authenticationRequest);
        Assert.assertEquals(200, response.getStatusCode().value());
    }
    /*
     * Check forbidden authentication test
     * */
    @Test
    public void authenticationError() {
        AuthenticationRequest authenticationRequest = new AuthenticationRequest();
        authenticationRequest.setUser("NOT VALID USERNAME");
        authenticationRequest.setApp(1);
        ResponseEntity<AuthenticationResponse> response = authenticationController.createToken(authenticationRequest);
        Assert.assertEquals(403, response.getStatusCode().value());
    }
}
