package co.edu.uptc.bochica.persistencia.entidad;

import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "Historial")//, schema="${schema}")
@NamedQueries({
    @NamedQuery(name = "Historial.obtenerTodos", query = "select e from Historial e")
})
public class Historial {

    
    @Id
    //@Column(name = "Enfermedad_id")
    @GeneratedValue(generator = "HistorialGen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "HistorialGen", sequenceName = "Historial_SEQ", allocationSize = 1)
    private Long id;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private Date fechaCreacion;

    @OneToOne (cascade = {}, fetch = javax.persistence.FetchType.EAGER, mappedBy = "historial")
    private Persona persona;
    
    @OneToMany (cascade = {}, fetch = javax.persistence.FetchType.LAZY, mappedBy = "historial")
    private List<DosisAplicada> dosisAplicadas;

    /**
     * @generated
     */
    public Date getFechaCreacion() {
        return this.fechaCreacion;
    }

    /**
     * @generated
     */
    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    /**
     * @generated
     */
    public Persona getPersona() {
        return this.persona;
    }

    /**
     * @generated
     */
    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public List<DosisAplicada> getDosisAplicadas() {
        return dosisAplicadas;
    }

    public void setDosisAplicadas(List<DosisAplicada> dosisAplicadas) {
        this.dosisAplicadas = dosisAplicadas;
    }

    
    
}
