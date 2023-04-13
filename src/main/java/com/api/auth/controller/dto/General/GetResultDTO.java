package com.api.auth.controller.dto.General;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetResultDTO {

    @ApiModelProperty(notes = "Resultado consulta")
    private Integer resultCode;

    @ApiModelProperty(notes = "Mensaje_Informativo")
    private String message;

    public GetResultDTO(Integer resultCode) {
        this.resultCode = resultCode;

        switch (resultCode) {
            case 1: {
                message = "Query Result.";
                break;
            }
            case 2: {
                message = "No information was found with the parameters entered.";
                break;
            }
            case 3: {
                message = "The registered information is duplicated.";
                break;
            }
        }
    }


}
