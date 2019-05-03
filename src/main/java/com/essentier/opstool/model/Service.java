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

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@ToString
@SequenceGenerator(name="SERVICE_ID", sequenceName="SERVICE_ID_SEQ", allocationSize = 1)
public class Service {
	
	@Id
	@GeneratedValue(generator="SERVICE_ID", strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @NonNull
    private String name;
    
    @NotNull
    @NonNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "env_id")
    @ToString.Exclude
    private Env env;

    private String properties = "";

}
