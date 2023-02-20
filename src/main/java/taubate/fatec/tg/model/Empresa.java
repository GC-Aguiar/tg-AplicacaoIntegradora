package taubate.fatec.tg.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_empresa")
public class Empresa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EMP_CODIGO")
	private Integer codigo;
	@Column(name = "EMP_DESCRICAO", length = 80, nullable = false)
	private String descricao;
	@Column(name = "EMP_CNPJ", length = 14, nullable = false)
	private Integer cnpj;
	@Column(name = "EMP_EMAIL", length = 80, nullable = false)
	private String email;
	@Column(name = "EMP_PREPOSTO", length = 80, nullable = false)
	private String preposto;
	
	@Column(name = "EMP_DATA_CADASTRO", nullable = false)
	private Date dataCadastro;
	@Column(name = "USU_CODIGO_CADASTRO", nullable = false)
	private Integer usuarioCadastro;
	@Column(name = "EMP_DATA_ALTERACAO", nullable = false)
	private Date dataAlteracao;
	@Column(name = "USU_CODIGO_ALTERACAO",nullable = false)
	private Integer usuarioAlteracao;

}
