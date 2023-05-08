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
@Table(name = "tbl_sistema_externo")
public class SistemaExterno {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SIS_CODIGO")
	private Integer codigo;
	
	@Column(name = "SIS_DESCRICAO", length = 80, nullable = false)
	private String descricao;
	@Column(name = "EMP_CODIGO", nullable = false)
	private Integer empCodigo;
	@Column(name = "SIS_STATUS", length = 12, nullable = false)
	private String status;
	@Column(name = "SIS_EMAIL", length = 80, nullable = false)
	private String email;
	@Column(name = "SIS_PREPOSTO", length = 80, nullable = false)
	private String preposto;
	
	@Column(name = "SIS_DATA_CADASTRO", nullable = false)
	private Date dataCadastro;
	@Column(name = "USU_CODIGO_CADASTRO", nullable = false)
	private Integer usuarioCadastro;
	@Column(name = "SIS_DATA_ALTERACAO", nullable = false)
	private Date dataAlteracao;
	@Column(name = "USU_CODIGO_ALTERACAO",nullable = false)
	private Integer usuarioAlteracao;
	
	public SistemaExterno() {
		
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo, dataAlteracao, dataCadastro, descricao, email, empCodigo, preposto, status,
				usuarioAlteracao, usuarioCadastro);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SistemaExterno other = (SistemaExterno) obj;
		return Objects.equals(codigo, other.codigo) && Objects.equals(dataAlteracao, other.dataAlteracao)
				&& Objects.equals(dataCadastro, other.dataCadastro) && Objects.equals(descricao, other.descricao)
				&& Objects.equals(email, other.email) && Objects.equals(empCodigo, other.empCodigo)
				&& Objects.equals(preposto, other.preposto) && Objects.equals(status, other.status)
				&& Objects.equals(usuarioAlteracao, other.usuarioAlteracao)
				&& Objects.equals(usuarioCadastro, other.usuarioCadastro);
	}

	@Override
	public String toString() {
		return "SistemaExterno [codigo=" + codigo + ", descricao=" + descricao + ", empCodigo=" + empCodigo
				+ ", status=" + status + ", email=" + email + ", preposto=" + preposto + ", dataCadastro="
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

	public Integer getEmpCodigo() {
		return empCodigo;
	}

	public void setEmpCodigo(Integer empCodigo) {
		this.empCodigo = empCodigo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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
