package com.api.auth.controller.dto.ParameterTP;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.Date;


@Data
@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ParameterTPDTO {

    @NotNull
    @ApiModelProperty(notes = "codigo_producto", required = true)
    private Integer productCode;

    @NotNull
    @ApiModelProperty(notes =  "codigo_plan", required = true)
    private Integer planCode;

    @NotNull
    @ApiModelProperty(notes =  "codigo_parametro", required = true)
    private Integer parameterCode;

    @NotNull
    @ApiModelProperty(notes =  "descripcion_parametro")
    private String parameterDescription;

    @ApiModelProperty(notes =  "activo")
    private Boolean active;

    @ApiModelProperty(notes =  "descripcion_parametro1")
    private String parameterDescription1;

    @ApiModelProperty(notes =  "valor_parametro1")
    private String valueDescription1;

    @ApiModelProperty(notes =  "descripcion_parametro2")
    private String parameterDescription2;

    @ApiModelProperty(notes =  "valor_parametro2")
    private String valueDescription2;


    @ApiModelProperty(notes =  "descripcion_parametro3")
    private String parameterDescription3;

    @ApiModelProperty(notes =  "valor_parametro3")
    private String valueDescription3;


    @ApiModelProperty(notes =  "descripcion_parametro4")
    private String parameterDescription4;

    @ApiModelProperty(notes =  "valor_parametro4")
    private String valueDescription4;



    @ApiModelProperty(notes =  "descripcion_parametro5")
    private String parameterDescription5;

    @ApiModelProperty(notes = "valor_parametro5")
    private String valueDescription5;

    @ApiModelProperty(notes =  "descripcion_parametro6")
    private String parameterDescription6;

    @ApiModelProperty(notes = "valor_parametro6")
    private String valueDescription6;

    @ApiModelProperty(notes =  "descripcion_parametro7")
    private String parameterDescription7;

    @ApiModelProperty(notes = "valor_parametro7")
    private String valueDescription7;


    @ApiModelProperty(notes =  "fecha_alta")
    private Date highDate;

    @ApiModelProperty(notes =  "fecha_modificacion")
    private Date modificationDate;


//    @ApiModelProperty(notes = "json_test")
//    private String jsonTest;

}
