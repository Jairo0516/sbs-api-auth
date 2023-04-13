package com.api.auth.util;

public final class Constants {

    public static final String MONTHS = "meses";
    public static final String DAYS = "dias";
    public static final String YEARS = "años";
    public static final String YEARS_WITHOUT = "anios";
    public static final String DAYS_ACCENT_MARK = "días";
    public static final String SUCCESS_CODE = "200";
    public static final String SUCCESS_MESSAGE = "Successful process";
    public static final String ERROR_CODE = "500";
    public static final String ERROR_MESSAGE = "Unsuccessful process";
    public static final String MESSAGE_ERROR = "Message Error: ";
    public static final String NOT_FOUND_CODE = "400";
    public static final String COMMA_SEPARATOR = ",";
    public static final String MESSAGE_LIST_EMPTY = "No results, empty List";
    public static final String MESSAGE_REGISTER_EXISTS = "Register already exists.";
    public static final String MESSAGE_REGISTER_NOT_FOUND = "Register no found.";

    /*Business*/
    public static final String PRE_QUOTATION_NO_FOUND = "Pre Quotation does not exist";
    public static final String MESSAGE_PRE_QUOTATIONS_NO_FOUND = "Pre Quotations not found";
    public static final String PRODUCT_PLAN_STRUCTURE_NO_FOUND = "Product Plan Structure does not exist";
    public static final String MESSAGE_PRODUCT_PLAN_STRUCTURES_NO_FOUND = "Product Plan Structures not found";
    public static final String PRODUCT_PLAN_STRUCTURE_UPDATED = "Product Plan Structure updated";
    public static final String PRODUCT_PLAN_STRUCTURE_CREATED = "Product Plan Structure created";

    public static final String MESSAGE_PRODUCT_LIFE_NO_FOUND = "Product Plan Structures not found";
    public static final String PRODUCT_LIFE_UPDATED = "Product Life updated";
    public static final String PRODUCT_LIFE_CREATED = "Product Life created";

    public static final String MESSAGE_PRODUCT_PLAN_LIFE_NO_FOUND = "Product Plan Life not found";
    public static final String PRODUCT_PLAN_LIFE_UPDATED = "Product Plan Life updated";
    public static final String PRODUCT_PLAN_LIFE_CREATED = "Product Plan Life created";

    public static final String MESSAGE_PRODUCT_STRUCTURES_NO_FOUND = "Product Structures not found";
    public static final String PRODUCT_STRUCTURE_UPDATED = "Product Structure updated";
    public static final String PRODUCT_STRUCTURE_CREATED = "Product Structure created";


    public static final String MESSAGE_PRODUCT_PDF_FILTERS_EMPTY= "All filters are empty. At least set a filter.";
    public static final String MESSAGE_PRODUCT_PDF_NO_FOUND = "Products PDF not found";
    public static final String PRODUCT_PDF_UPDATED = "Product PDF updated";
    public static final String PRODUCT_PDF_CREATED = "Product PDF created";
    public static final String POLICY_NOT_FOUND = "Policy Not Found";
    public static final String MESSAGE_PRODUCT_PLAN_NO_FOUND = "Product Plan not found";
    public static final String MESSAGE_PRODUCT_BRANCH_SPONSOR_EMPTY = "Product Plan Branch Sponsor is empty";


    /*Emission*/
    public static final String EMISSION_NO_FOUND = "Emission not found";

    /*validations messages*/
    public static final String VAL_FECHA_FORMATO_MESSAGE = "{validacion.field.Fecha.formato.message}";

    /*Patterns*/
    public static final String REGEX_DATE = "(^([0-2][0-9]|(3)[0-1])(\\/)(((0)[0-9])|((1)[0-2]))(\\/)\\d{4}$)?";
    public static final String REGEX_DATE_SECOND = "(^([0-2][0-9]|(3)[0-1])(--/)(((0)[0-9])|((1)[0-2]))(--/)--d{4}$)?";
    public static final String REGEX_DATE_TIME = "^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4} (2[0-3]|[01]?[0-9]):([0-5]?[0-9]):([0-5]?[0-9])$";
    public static final String REGEX_EMAIL_ADDRESS = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
    public static final String REGEX_ARRAY_IN =  "[0-9]+(,[0-9 ]+)+";


    public static final String MAX_NUM_DECIMAL_20_2 = "999999999999999999.99";

    public static final String MAX_NUM_DECIMAL_10_4 = "9999999999.9999";

    public static final String MAX_NUM_DECIMAL_9_4 = "999999999.9999";

    public static final String MAX_NUM_DECIMAL_22_2 = "9999999999999999999999.99";
    public static final String AUTHENTICATION_ERROR = "El nombre de usuario o la contraseña ingresada no coinciden con la información registrada en nuestro sistema. " +
            "El usuario ingresado podría estar desactivado en tal caso comuníquese con su administrador al correo soporte@sbs.co";
    public static final String USER_ALREADY_EXISTS = "El cliente ingresado ya existe en nuestro sistema.";
    public static final String ALREADY_EXISTS = "El registro ingresado ya existe en nuestro sistema.";
    public static final String DOES_NOT_EXISTS = "The record you want to update does not exist.";
    public static final String NOT_FOUND =  "There is no information for the requested query.";
    public static final String PERSON_NOT_FOUND = "The person entered does not exist in our system.";
    public static final String PROFILE_NOT_FOUND = "The associated profile does not exist.";

    public static final String APPCOMPONENT_NOT_FOUND = "The entered component does not exist in the table 'componente_app'";
    public static final String APPMODULE_NOT_FOUND = "The entered module does not exist in the table 'module_app'";
    public static final String RISKPOLICY_NOT_FOUND = "The entered riskNumber does not exist in the table 'policy_risk'";
    public static final String RISKPOLICYEV_NOT_FOUND = "The entered key (uniqueIdentifier, anniversary, eventNumber, riskNumber) does not exist in the table 'policy_risk_ev'";
    public static final String SUBMODULECODE_NOT_FOUND = "The entered subModuleCode does not exist in the table 'submodule_app'";
    public static final String APPLICATION_NOT_FOUND = "The entered applicationCode does not exist in the table 'application'";
    public static final String RISKTYPETP_NOT_FOUND = "The entered riskTypeCode does not exist in the table 'RISKTYPETP'";
    public static final String VEHICLE_NOT_FOUND = "The entered vehicleLicensePlate does not exist in the table 'vehicle'";
    public static final String AGENTTYPECODE_NOT_FOUND = "The entered AGENTTYPETP does not exist in the table 'agentTypeCode'";
    public static final String COVERAGECODE_NOT_FOUND = "The entered coveragecode does not exist in the table 'coverage'";
    public static final String PRODUCT_PLAN_STRUCTURE_NOT_FOUND = "The entered ProductCode,PlanCode,TypeRiskCode does not exist in the table 'product_structure_plan'";


    public static final String SUM_INSURED_POLICY_NOT_FOUND = "The sum insured asociated to the coverage does not exit";
    public static final String ERROR_LOADING = "The entered file did not complete the required structure.";
    public static final String ERROR_PROCESS = "The type of process entered does not exist in our system.";
    public static final String ERROR_FILE = "The entered file contains a different extension than csv, xls, xlsx.";

    public static final String ERROR_FILTERS = "Los filtros ingresados no cumplen con la especificación.";
    public static final String ERROR_POLICY_RISK = "No se encontro poliza riesgo para los párametros ingresados.";
    public static final String ERROR_POLICY_HEADER = "No se encontro poliza cabecera para los párametros ingresados.";
    public static final String ERROR_RISKS_PDF = "No se encontraron riesgos en la poliza para construir el PDF.";
    public static final String ERROR_MAIL_POLICY_RISK = "No se obtuvieron registros de poliza riesgo correo para el envío masivo.";
    public static final String ERROR_NEGATIVE_ANNIVERSARY = "Póliza con aniversario negativo, no tarifada, no genera PDF";
    public static final String ERROR_TEMPLATE_PRODUCT_PLAN = "Product Plan without Template PDF";
}
