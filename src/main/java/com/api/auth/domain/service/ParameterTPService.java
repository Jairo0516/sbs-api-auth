package com.api.auth.domain.service;


import com.api.auth.controller.dto.ParameterTP.GetParameterTPDTO;
import com.api.auth.domain.entity.ParameterTP;

public interface ParameterTPService {

    GetParameterTPDTO getParameterTPByDescription(String parameterDescription) throws Exception;

  ParameterTP getParameterTPByProductCodeAndPlanCodeAndParameterCode(Integer productCode, Integer planCode, Integer parameterCode) throws Exception;
}
