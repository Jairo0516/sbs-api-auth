package com.api.auth.domain.repository;


import com.api.auth.domain.entity.ParameterTP;
import com.api.auth.domain.entity.ParameterTPKey;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ParameterTPRepository extends CrudRepository<ParameterTP, ParameterTPKey> {

    ParameterTP getParameterTPByProductCodeAndPlanCodeAndParameterCode(Integer productCode, Integer planCode, Integer parameterCode) throws Exception;

    ParameterTP getParameterTPByParameterDescription(String parameterDescription) throws Exception;

}
