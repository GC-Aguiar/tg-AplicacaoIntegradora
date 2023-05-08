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
@Table(name = "tbl_cidade")
public class Cidade {

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY) //Não deve ser gerado automaticamente
	@Column(name = "CID_CODIGO")
	private Integer codigo;
	@Column(name = "CID_DESCRICAO", length = 80, nullable = false)
	private String descricao;
	@Column(name = "UF_CODIGO", length = 13, nullable = false)
	private Integer ufCodigo;
	
	@Column(name = "CID_DATA_CADASTRO", nullable = false)
	private Date dataCadastro;
	@Column(name = "USU_CODIGO_CADASTRO", nullable = false)
	private Integer usuarioCadastro;
	@Column(name = "CID_DATA_ALTERACAO", nullable = false)
	private Date dataAlteracao;
	@Column(name = "USU_CODIGO_ALTERACAO",nullable = false)
	private Integer usuarioAlteracao;
	
	public Cidade() {
		
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo, dataAlteracao, dataCadastro, descricao, ufCodigo, usuarioAlteracao,
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
		Cidade other = (Cidade) obj;
		return Objects.equals(codigo, other.codigo) && Objects.equals(dataAlteracao, other.dataAlteracao)
				&& Objects.equals(dataCadastro, other.dataCadastro) && Objects.equals(descricao, other.descricao)
				&& Objects.equals(ufCodigo, other.ufCodigo) && Objects.equals(usuarioAlteracao, other.usuarioAlteracao)
				&& Objects.equals(usuarioCadastro, other.usuarioCadastro);
	}

	@Override
	public String toString() {
		return "Cidade [codigo=" + codigo + ", descricao=" + descricao + ", ufCodigo=" + ufCodigo + ", dataCadastro="
				+ dataCadastro + ", usuarioCadastro=" + usuarioCadastro + ", dataAlteracao=" + dataAlteracao
				+ ", usuarioAlteracao=" + usuarioAlteracao + "]";
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

	public Integer getUfCodigo() {
		return ufCodigo;
	}

	public void setUfCodigo(Integer ufCodigo) {
		this.ufCodigo = ufCodigo;
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
