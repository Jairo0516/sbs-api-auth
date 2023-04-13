package com.api.auth.domain.service.impl;

import com.api.auth.controller.dto.General.GetResultDTO;
import com.api.auth.controller.dto.UserApp.GetUserAppDto;
import com.api.auth.controller.dto.UserApp.UserAppDTO;
import com.api.auth.domain.repository.UserAppRepository;
import com.api.auth.domain.builder.ObjectBuilder;
import com.api.auth.domain.entity.UserApp;
import com.api.auth.domain.service.UserDetailService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Service
@CrossOrigin
public class UserDetailsService implements UserDetailService {


    @Autowired
    private UserAppRepository userAppRepository;

    @Autowired
    private ObjectBuilder objectBuilder;

    @Override
    public UserAppDTO loadUserByUsername(String userName, Integer app) throws UsernameNotFoundException {
        UserAppDTO userDto = null;
        try {
            List<UserApp> userApps = userAppRepository.loginUserApp(userName, app);
            if (userApps.size() > 0) {
                userDto = objectBuilder.map(userApps.get(0), UserAppDTO.class);
            }
        } catch (Exception e) {
            System.out.println("Error al obtener usuario: " + e.getMessage());
        }
        return userDto;
    }

    @Override
    public GetUserAppDto getUserApp(Integer applicationCode, Integer userCode) {
        GetResultDTO getResultDTO;
        GetUserAppDto getUserAppDto = new GetUserAppDto();

        try {

            UserApp userApp = userAppRepository.findUserAppByApplicationCodeAndUserCode(applicationCode, userCode);

            if (userApp == null) {
              new GetUserAppDto().getGetResult();
              new GetResultDTO(2);
            } else {
                getUserAppDto = objectBuilder.map(userApp, GetUserAppDto.class);
            }

        } catch (Exception e) {
            new GetUserAppDto().getGetResult();
            getResultDTO = new GetResultDTO(2);
            getResultDTO.setMessage(e.getMessage());
        }
        return getUserAppDto;
    }
}
