package com.api.auth.domain.service.impl;


import com.api.auth.controller.dto.General.GetResultDTO;
import com.api.auth.domain.repository.ParameterTPRepository;
import com.api.auth.controller.dto.ParameterTP.GetParameterTPDTO;
import com.api.auth.domain.builder.ObjectBuilder;
import com.api.auth.domain.entity.ParameterTP;
import com.api.auth.domain.service.ParameterTPService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ParameterTPServiceImpl implements ParameterTPService {

    @Autowired
    private ParameterTPRepository parameterTPRepository;


    @Autowired
    private ObjectBuilder objectBuilder;

    @Override
    public GetParameterTPDTO getParameterTPByDescription(String parameterDescription) throws Exception {

        ParameterTP parameterTP = parameterTPRepository.getParameterTPByParameterDescription(parameterDescription);

        GetParameterTPDTO getParameterTPDTO;
        GetResultDTO getResultDTO;

        if (parameterTP == null) {
            getParameterTPDTO= new GetParameterTPDTO();
            getResultDTO = new GetResultDTO(2);
        } else {
            getParameterTPDTO = objectBuilder.map(parameterTP, GetParameterTPDTO.class);
            getResultDTO = new GetResultDTO(1);
        }

        getParameterTPDTO.setGetResult(getResultDTO);
        return  getParameterTPDTO;
    }

  @Override
  public ParameterTP getParameterTPByProductCodeAndPlanCodeAndParameterCode(Integer productCode, Integer planCode, Integer parameterCode) throws Exception {
    return  parameterTPRepository.getParameterTPByProductCodeAndPlanCodeAndParameterCode(productCode, planCode, parameterCode);
  }


}
