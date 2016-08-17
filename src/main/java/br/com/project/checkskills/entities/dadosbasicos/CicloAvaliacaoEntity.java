/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.project.checkskills.entities.dadosbasicos;

import java.util.Date;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.stereotype.Component;

import br.com.project.checkskills.utils.BaseEntity;

/**
 *
 * @author luana
 */
@Entity
@Table(name = "TB_CICLO_AVALIACAO")
@AttributeOverride(name = "id", column = @Column(name = "ID_CICLO_AVALIACAO"))
@Component(value="cicloAvaliacaoEntity")
public class CicloAvaliacaoEntity extends BaseEntity<Long> {
    private static final long serialVersionUID = 1L;

    
    @Column(name = "NOME_CICLO")
    private String nomeCiclo;
    
    @Column(name = "DESCRICAO")
    private String descricao;
    
    @Basic(optional = false)
    @Column(name = "DATA_INICIO")
    @Temporal(TemporalType.DATE)
    private Date dataInicio;
    
    @Basic(optional = false)
    @Column(name = "DATE_FIM")
    @Temporal(TemporalType.DATE)
    private Date dateFim;
    
    @Basic(optional = false)
    @Column(name = "STATUS")
    private boolean status;
   
}
