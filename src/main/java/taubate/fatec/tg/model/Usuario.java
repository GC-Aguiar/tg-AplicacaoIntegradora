package taubate.fatec.tg.model;

import java.sql.Date;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "tbl_usuario")
public class Usuario implements UserDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Verificar erros no insert do MariaDB
	@Column(name = "USU_CODIGO")
	private Integer codigo;
	@Column(name = "USU_NOME", length = 80, nullable = false)
	private String nome;
	@Column(name = "USU_LOGIN", length = 20, nullable = false)
	private String login;
	@Column(name = "USU_SENHA", length = 256, nullable = false)
	private String senha;
	@Column(name = "USU_STATUS", length = 12, nullable = false)
	private String status;
	@Column(name = "PER_COD", nullable = false)
	private String codigoPerfil; // Alterado para string para utilizar no GrantedAuthority
	@Column(name = "SIS_CODIGO", nullable = false)
	private Integer codigoSistema;
	@Column(name = "USU_DATA_CADASTRO", nullable = false)
	private Date dataCadastro;
	@Column(name = "USU_CODIGO_CADASTRO", nullable = false)
	private Integer usuarioCadastro;
	@Column(name = "USU_DATA_ALTERACAO", nullable = false)
	private Date dataAlteracao;
	@Column(name = "USU_CODIGO_ALTERACAO",nullable = false)
	private Integer usuarioAlteracao; 
	
	@Transient
	private List<String> roles;	
	
	
	public Usuario() {

	}

	public Usuario(String login) {
		this.login = login;
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

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCodigoPerfil() {
		return codigoPerfil;
	}

	public void setCodigoPerfil(String codigoPerfil) {
		this.codigoPerfil = codigoPerfil;
	}

	public Integer getCodigoSistema() {
		return codigoSistema;
	}

	public void setCodigoSistema(Integer codigoSistema) {
		this.codigoSistema = codigoSistema;
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

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo, codigoPerfil, codigoSistema, dataAlteracao, dataCadastro, login, nome, roles, senha,
				status, usuarioAlteracao, usuarioCadastro);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(codigo, other.codigo) && Objects.equals(codigoPerfil, other.codigoPerfil)
				&& Objects.equals(codigoSistema, other.codigoSistema)
				&& Objects.equals(dataAlteracao, other.dataAlteracao)
				&& Objects.equals(dataCadastro, other.dataCadastro) && Objects.equals(login, other.login)
				&& Objects.equals(nome, other.nome) && Objects.equals(roles, other.roles)
				&& Objects.equals(senha, other.senha) && Objects.equals(status, other.status)
				&& Objects.equals(usuarioAlteracao, other.usuarioAlteracao)
				&& Objects.equals(usuarioCadastro, other.usuarioCadastro);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(new SimpleGrantedAuthority(login));
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.senha;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.login;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}	

}
