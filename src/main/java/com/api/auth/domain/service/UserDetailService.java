package com.api.auth.domain.service;

import com.api.auth.controller.dto.UserApp.GetUserAppDto;
import com.api.auth.controller.dto.UserApp.UserAppDTO;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserDetailService {

  UserAppDTO loadUserByUsername(String userName, Integer app) throws UsernameNotFoundException;

  GetUserAppDto getUserApp(Integer applicationCode, Integer userCode) throws Exception;

}
