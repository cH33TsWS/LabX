package com.cp.labx.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="samples")
public class Sample {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "sample_id", nullable = false, updatable = false)
	private Long id;
	
	private String name;
	
	@ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "sample_type_id", nullable = false)
    private SampleType sampleType;
	
	@ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

}
