package br.com.rv.algafood.api.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import br.com.rv.algafood.domain.model.Cozinha;
import lombok.Data;
import lombok.NonNull;

@JacksonXmlRootElement(localName="cozinhas")
@Data
public class CozinhasXmlWrapper {
	@JacksonXmlElementWrapper(useWrapping=false)
	@JsonProperty("cozinha")
	@NonNull
	private List<Cozinha> cozinhas;
}
