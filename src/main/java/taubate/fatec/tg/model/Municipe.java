package taubate.fatec.tg.model;

import java.sql.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;


@Entity
@Table(name = "tbl_municipe")
public class Municipe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MUN_CODIGO")
	private Integer codigo;
	
	@Column(name = "MUN_NOME", length = 80, nullable = false)
	private String nome;
	@Column(name = "MUN_TELEFONE", length = 13, nullable = false)
	private String telefone;
	@Column(name = "MUN_NOME_SOCIAL", length = 80)
	private String nomeSocial;
	@Column(name = "MUN_CPF", length = 11)
	private String cpf;
	@Column(name = "MUN_NOME_MAE", length = 80, nullable = false)
	private String nomeMae;
	@Column(name = "MUN_DATA_NASCIMENTO", nullable = false)
	private Date dataNascimento;
	@Column(name = "MUN_SEXO", length = 9, nullable = false)
	private String sexo;
	@Column(name = "MUN_CODIGO_OCUPACAO")
	private Integer codigoOcupacao;
	@Column(name = "MUN_TIPO_LOGRADOURO", length = 40, nullable = false)
	private String tipoLogradouro;
	@Column(name = "MUN_LOGRADOURO", length = 80, nullable = false)
	private String logradouro;
	@Column(name = "MUN_NUMERO_LOGRADOURO", nullable = false)
	private Integer numeroLogradouro;
	@Column(name = "MUN_COMPLEMENTO", length = 20)
	private String complemento;
	@Column(name = "BAI_CODIGO", nullable = false)
	private Integer codigoBairro;
	@Column(name = "MUN_CEP", length = 8, nullable = false)
	private String cep;
	@Column(name = "CID_COD", nullable = false)
	private Integer codigoCidade;
	@Column(name = "MUN_ANO_OBITO")
	private Date anoObito;
	@Column(name = "MUN_NACIONALIDADE", length = 20, nullable = false)
	private String nacionalidade;
	@Column(name = "CID_COD_NASCIMENTO", nullable = false)
	private Integer cidadeNascimento;
	
	@Column(name = "MUN_SOLICITA_EXCLUSAO", columnDefinition = "BOOLEAN")
	//@Type(type = "org.hibernate.type.NumericBooleanType")
	private boolean solicitaExclusao;
	
	@Column(name = "MUN_DATA_CADASTRO", nullable = false)
	private Date dataCadastro;
	@Column(name = "USU_CODIGO_CADASTRO", nullable = false)
	private Integer usuarioCadastro;
	@Column(name = "MUN_DATA_ALTERACAO", nullable = false)
	private Date dataAlteracao;
	@Column(name = "USU_CODIGO_ALTERACAO",nullable = false)
	private Integer usuarioAlteracao;
	
	
	
	
	public Municipe() {
		
	}

	@Override
	public int hashCode() {
		return Objects.hash(anoObito, cep, cidadeNascimento, codigo, codigoBairro, codigoCidade, codigoOcupacao,
				complemento, cpf, dataAlteracao, dataCadastro, dataNascimento, logradouro, nacionalidade, nome, nomeMae,
				nomeSocial, numeroLogradouro, sexo, solicitaExclusao, telefone, tipoLogradouro, usuarioAlteracao,
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
		Municipe other = (Municipe) obj;
		return Objects.equals(anoObito, other.anoObito) && Objects.equals(cep, other.cep)
				&& Objects.equals(cidadeNascimento, other.cidadeNascimento) && Objects.equals(codigo, other.codigo)
				&& Objects.equals(codigoBairro, other.codigoBairro) && Objects.equals(codigoCidade, other.codigoCidade)
				&& Objects.equals(codigoOcupacao, other.codigoOcupacao)
				&& Objects.equals(complemento, other.complemento) && Objects.equals(cpf, other.cpf)
				&& Objects.equals(dataAlteracao, other.dataAlteracao)
				&& Objects.equals(dataCadastro, other.dataCadastro)
				&& Objects.equals(dataNascimento, other.dataNascimento) && Objects.equals(logradouro, other.logradouro)
				&& Objects.equals(nacionalidade, other.nacionalidade) && Objects.equals(nome, other.nome)
				&& Objects.equals(nomeMae, other.nomeMae) && Objects.equals(nomeSocial, other.nomeSocial)
				&& Objects.equals(numeroLogradouro, other.numeroLogradouro) && Objects.equals(sexo, other.sexo)
				&& solicitaExclusao == other.solicitaExclusao && Objects.equals(telefone, other.telefone)
				&& Objects.equals(tipoLogradouro, other.tipoLogradouro)
				&& Objects.equals(usuarioAlteracao, other.usuarioAlteracao)
				&& Objects.equals(usuarioCadastro, other.usuarioCadastro);
	}


	@Override
	public String toString() {
		return "Municipe [codigo=" + codigo + ", nome=" + nome + ", telefone=" + telefone + ", nomeSocial=" + nomeSocial
				+ ", cpf=" + cpf + ", nomeMae=" + nomeMae + ", dataNascimento=" + dataNascimento + ", sexo=" + sexo
				+ ", codigoOcupacao=" + codigoOcupacao + ", tipoLogradouro=" + tipoLogradouro + ", logradouro="
				+ logradouro + ", numeroLogradouro=" + numeroLogradouro + ", complemento=" + complemento
				+ ", codigoBairro=" + codigoBairro + ", cep=" + cep + ", codigoCidade=" + codigoCidade + ", anoObito="
				+ anoObito + ", nacionalidade=" + nacionalidade + ", cidadeNascimento=" + cidadeNascimento
				+ ", solicitaExclusao=" + solicitaExclusao + ", dataCadastro=" + dataCadastro + ", usuarioCadastro="
				+ usuarioCadastro + ", dataAlteracao=" + dataAlteracao + ", usuarioAlteracao=" + usuarioAlteracao + "]";
	}


	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getNomeSocial() {
		return nomeSocial;
	}
	public void setNomeSocial(String nomeSocial) {
		this.nomeSocial = nomeSocial;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNomeMae() {
		return nomeMae;
	}
	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public Integer getCodigoOcupacao() {
		return codigoOcupacao;
	}
	public void setCodigoOcupacao(Integer codigoOcupacao) {
		this.codigoOcupacao = codigoOcupacao;
	}
	public String getTipoLogradouro() {
		return tipoLogradouro;
	}
	public void setTipoLogradouro(String tipoLogradouro) {
		this.tipoLogradouro = tipoLogradouro;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public Integer getNumeroLogradouro() {
		return numeroLogradouro;
	}
	public void setNumeroLogradouro(Integer numeroLogradouro) {
		this.numeroLogradouro = numeroLogradouro;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public Integer getCodigoBairro() {
		return codigoBairro;
	}
	public void setCodigoBairro(Integer codigoBairro) {
		this.codigoBairro = codigoBairro;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public Integer getCodigoCidade() {
		return codigoCidade;
	}
	public void setCodigoCidade(Integer codigoCidade) {
		this.codigoCidade = codigoCidade;
	}
	public Date getAnoObito() {
		return anoObito;
	}
	public void setAnoObito(Date anoObito) {
		this.anoObito = anoObito;
	}
	public String getNacionalidade() {
		return nacionalidade;
	}
	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}
	public Integer getCidadeNascimento() {
		return cidadeNascimento;
	}
	public void setCidadeNascimento(Integer cidadeNascimento) {
		this.cidadeNascimento = cidadeNascimento;
	}
	public boolean isSolicitaExclusao() {
		return solicitaExclusao;
	}
	public void setSolicitaExclusao(boolean solicitaExclusao) {
		this.solicitaExclusao = solicitaExclusao;
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
