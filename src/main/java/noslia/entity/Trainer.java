/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package noslia.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Panos
 */
@Entity
@Table(name = "trainer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Trainer.findAll", query = "SELECT t FROM Trainer t")
    , @NamedQuery(name = "Trainer.findByTid", query = "SELECT t FROM Trainer t WHERE t.tid = :tid")
    , @NamedQuery(name = "Trainer.findByTname", query = "SELECT t FROM Trainer t WHERE t.tname = :tname")
    , @NamedQuery(name = "Trainer.findByTlname", query = "SELECT t FROM Trainer t WHERE t.tlname = :tlname")
    , @NamedQuery(name = "Trainer.findByDob", query = "SELECT t FROM Trainer t WHERE t.dob = :dob")
    , @NamedQuery(name = "Trainer.findByTsubject", query = "SELECT t FROM Trainer t WHERE t.tsubject = :tsubject")})
public class Trainer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tid")
    private Integer tid;
    @Size(max = 45)
    @Column(name = "tname")
    private String tname;
    @Size(max = 45)
    @Column(name = "tlname")
    private String tlname;
    @Size(max = 45)
    @Column(name = "dob")
    private String dob;
    @Size(max = 45)
    @Column(name = "tsubject")
    private String tsubject;

    public Trainer() {
    }

    public Trainer(Integer tid) {
        this.tid = tid;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getTlname() {
        return tlname;
    }

    public void setTlname(String tlname) {
        this.tlname = tlname;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getTsubject() {
        return tsubject;
    }

    public void setTsubject(String tsubject) {
        this.tsubject = tsubject;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tid != null ? tid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Trainer)) {
            return false;
        }
        Trainer other = (Trainer) object;
        if ((this.tid == null && other.tid != null) || (this.tid != null && !this.tid.equals(other.tid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "noslia.entity.Trainer[ tid=" + tid + " ]";
    }
    
}
