package taubate.fatec.tg.model;

import java.sql.Date;
import java.util.Objects;

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
	private String cnpj;
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
	
	
	
	public Empresa() {
		
	}


	@Override
	public int hashCode() {
		return Objects.hash(cnpj, codigo, dataAlteracao, dataCadastro, descricao, email, preposto, usuarioAlteracao,
				usuarioCadastro);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empresa other = (Empresa) obj;
		return Objects.equals(cnpj, other.cnpj) && Objects.equals(codigo, other.codigo)
				&& Objects.equals(dataAlteracao, other.dataAlteracao)
				&& Objects.equals(dataCadastro, other.dataCadastro) && Objects.equals(descricao, other.descricao)
				&& Objects.equals(email, other.email) && Objects.equals(preposto, other.preposto)
				&& Objects.equals(usuarioAlteracao, other.usuarioAlteracao)
				&& Objects.equals(usuarioCadastro, other.usuarioCadastro);
	}



	@Override
	public String toString() {
		return "Empresa [codigo=" + codigo + ", descricao=" + descricao + ", cnpj=" + cnpj + ", email=" + email
				+ ", preposto=" + preposto + ", dataCadastro=" + dataCadastro + ", usuarioCadastro=" + usuarioCadastro
				+ ", dataAlteracao=" + dataAlteracao + ", usuarioAlteracao=" + usuarioAlteracao + "]";
	}



	public Integer getCodigo() {
		return codigo;
	}



	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}



	public String getDescricao() {
		return descricao;
	}



	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}



	public String getCnpj() {
		return cnpj;
	}



	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPreposto() {
		return preposto;
	}



	public void setPreposto(String preposto) {
		this.preposto = preposto;
	}



	public Date getDataCadastro() {
		return dataCadastro;
	}



	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}



	public Integer getUsuarioCadastro() {
		return usuarioCadastro;
	}



	public void setUsuarioCadastro(Integer usuarioCadastro) {
		this.usuarioCadastro = usuarioCadastro;
	}



	public Date getDataAlteracao() {
		return dataAlteracao;
	}



	public void setDataAlteracao(Date dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}



	public Integer getUsuarioAlteracao() {
		return usuarioAlteracao;
	}



	public void setUsuarioAlteracao(Integer usuarioAlteracao) {
		this.usuarioAlteracao = usuarioAlteracao;
	}
	

}
