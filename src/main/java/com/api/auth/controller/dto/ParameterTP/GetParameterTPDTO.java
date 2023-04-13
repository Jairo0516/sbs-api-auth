package com.api.auth.controller.dto.ParameterTP;

import com.api.auth.controller.dto.General.GetResultDTO;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetParameterTPDTO  extends ParameterTPDTO{


    @ApiModelProperty(notes = "ResultadoConsulta")
    public GetResultDTO getResult;
}
