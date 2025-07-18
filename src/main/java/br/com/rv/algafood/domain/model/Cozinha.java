
package br.com.rv.algafood.domain.model;


import com.fasterxml.jackson.annotation.JsonRootName;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.EqualsAndHashCode;

//@JsonRootName("gastronomia")
@JsonRootName("cozinha")
@Data
@Entity
public class Cozinha {	
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private Long id;
	
	//@JsonProperty("titulo")
	//@JsonIgnore
	@Column(nullable=false)
	private String nome;
	
}
