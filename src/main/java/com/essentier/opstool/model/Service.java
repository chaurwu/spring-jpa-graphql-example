package com.essentier.opstool.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
@SequenceGenerator(name="SERVICE_ID", sequenceName="SERVICE_ID_SEQ", allocationSize = 1)
public class Service {
	
	@Id
	@GeneratedValue(generator="SERVICE_ID", strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private String name;
    
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "env_id")
    private Env env;

}
