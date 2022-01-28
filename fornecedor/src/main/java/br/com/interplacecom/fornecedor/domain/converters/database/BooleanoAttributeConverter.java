package br.com.interplacecom.fornecedor.domain.converters.database;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import br.com.interplacecom.fornecedor.domain.enumerators.Booleano;

@Converter
public class BooleanoAttributeConverter implements AttributeConverter<Booleano, Integer> {
	
	  @Override
	    public Integer convertToDatabaseColumn(Booleano attribute) {
	        return attribute.getOpcao();
	    }

	    @Override
	    public Booleano convertToEntityAttribute(Integer dbData) {
	        return Booleano.getByOpcao(dbData);
	    }

}