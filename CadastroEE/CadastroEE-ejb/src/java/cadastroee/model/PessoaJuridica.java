/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastroee.model;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;

/**
 *
 * @author danie
 */
@Entity
@Table(name = "pessoa_juridica")
@NamedQueries({
    @NamedQuery(name = "PessoaJuridica.findAll", query = "SELECT p FROM PessoaJuridica p")})
public class PessoaJuridica implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "cnpj")
    private Character cnpj;
    @Column(name = "razao_social")
    private Character razaoSocial;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo")
    private Integer codigo;

    public PessoaJuridica() {
    }

    public PessoaJuridica(Integer codigo) {
        this.codigo = codigo;
    }

    public Character getCnpj() {
        return cnpj;
    }

    public void setCnpj(Character cnpj) {
        this.cnpj = cnpj;
    }

    public Character getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(Character razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PessoaJuridica)) {
            return false;
        }
        PessoaJuridica other = (PessoaJuridica) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cadastroee.model.PessoaJuridica[ codigo=" + codigo + " ]";
    }
    
}
