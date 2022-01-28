package br.com.interplacecom.fornecedor.domain;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.interplacecom.fornecedor.domain.configuration.AuditBaseEntity;
import br.com.interplacecom.fornecedor.domain.converters.database.BooleanoAttributeConverter;
import br.com.interplacecom.fornecedor.domain.enumerators.Booleano;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class InfoFornecedor  extends AuditBaseEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
    @Column(name = "cnpj")
    private String cnpj;
    
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "estado")
	private String estado;
	
	@Column(name = "endereco")
	private String endereco;
	
    @Convert(converter = BooleanoAttributeConverter.class)
    @Builder.Default
    @Column(name = "status")
    private Booleano status = Booleano.SIM;
    
    @Convert(converter = BooleanoAttributeConverter.class)
    @Builder.Default
    @Column(name = "is_admin")
    private Booleano isAdmin = Booleano.NAO;
	
}
