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
@Table(name = "tbl_bairro")
public class Bairro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BAI_CODIGO")
	private Integer codigo;
	
	@Column(name = "BAI_DESCR", length = 40, nullable = false)
	private String descricao;
	
	@Column(name = "BAI_REGIAO", length = 20, nullable = false)
	private String regiao;
	
	@Column(name = "BAI_DATA_CADASTRO", nullable = false)
	private Date dataCadastro;
	@Column(name = "USU_CODIGO_CADASTRO", nullable = false)
	private Integer usuarioCadastro;
	@Column(name = "BAI_DATA_ALTERACAO", nullable = false)
	private Date dataAlteracao;
	@Column(name = "USU_CODIGO_ALTERACAO",nullable = false)
	private Integer usuarioAlteracao;
	@Override
	
	
	
	
	public String toString() {
		return "Bairro [codigo=" + codigo + ", descricao=" + descricao + ", regiao=" + regiao + ", dataCadastro="
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
	public String getRegiao() {
		return regiao;
	}
	public void setRegiao(String regiao) {
		this.regiao = regiao;
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
	@Override
	public int hashCode() {
		return Objects.hash(codigo, dataAlteracao, dataCadastro, descricao, regiao, usuarioAlteracao, usuarioCadastro);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bairro other = (Bairro) obj;
		return Objects.equals(codigo, other.codigo) && Objects.equals(dataAlteracao, other.dataAlteracao)
				&& Objects.equals(dataCadastro, other.dataCadastro) && Objects.equals(descricao, other.descricao)
				&& Objects.equals(regiao, other.regiao) && Objects.equals(usuarioAlteracao, other.usuarioAlteracao)
				&& Objects.equals(usuarioCadastro, other.usuarioCadastro);
	}
	public Bairro() {
		
		
	}
	
	

}
