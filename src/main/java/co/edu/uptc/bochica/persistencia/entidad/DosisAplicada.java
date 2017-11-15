package co.edu.uptc.bochica.persistencia.entidad;

import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "DosisAplicada")//, schema="${schema}")
@NamedQueries({
    @NamedQuery(name = "DosisAplicada.obtenerTodos", query = "select e from DosisAplicada e")
})
public class DosisAplicada {

    @Id
    //@Column(name = "Enfermedad_id")
    @GeneratedValue(generator = "DosisAplicadaGen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "DosisAplicadaGen", sequenceName = "DosisAplicada_SEQ", allocationSize = 1)
    private Long id;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private Date fecha;

    @ManyToOne (cascade = {}, fetch = javax.persistence.FetchType.EAGER)
    private Historial historial;

    @ManyToOne (cascade = {}, fetch = javax.persistence.FetchType.EAGER)
    private Dosis dosis;
    
    @OneToMany (cascade = {}, fetch = javax.persistence.FetchType.LAZY, mappedBy = "dosisAplicada")
    private List<Ubicacion> ubicacion;

    /**
     * @generated
     */
    public Date getFecha() {
        return this.fecha;
    }

    /**
     * @generated
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * @generated
     */
    public Dosis getDosis() {
        return this.dosis;
    }

    /**
     * @generated
     */
    public void setDosis(Dosis dosis) {
        this.dosis = dosis;
    }

    /**
     * @generated
     */
    public Historial getHistorial() {
        return this.historial;
    }

    /**
     * @generated
     */
    public void setHistorial(Historial historial) {
        this.historial = historial;
    }

    public List<Ubicacion> getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(List<Ubicacion> ubicacion) {
        this.ubicacion = ubicacion;
    }
    
    

}
