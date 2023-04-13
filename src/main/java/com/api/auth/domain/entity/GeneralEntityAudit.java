package com.api.auth.domain.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
@Data
public class GeneralEntityAudit {
    @Column(name = "fecha_alta", updatable = false)
    private Date highDate;

    @Column(name = "fecha_modificacion")
    private Date modificationDate;
}
