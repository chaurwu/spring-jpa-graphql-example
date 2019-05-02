package com.essentier.opstool.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name="ENV_ID", sequenceName="ENV_ID_SEQ", allocationSize = 1)
public class Env {
	

	@Id
    @GeneratedValue(generator="ENV_ID", strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @NonNull
    private String name;
    
    private String properties = "";
}
