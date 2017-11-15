package co.edu.uptc.bochica.persistencia.entidad;

import co.edu.uptc.bochica.persistencia.entidad.Vacuna;
import java.util.List;
import javax.persistence.*;


@Entity
@Table(name = "Dosis")//, schema="${schema}")
@NamedQueries({
    @NamedQuery(name = "Dosis.obtenerTodos", query = "select e from Dosis e")
})
public class Dosis {

    @Id
    //@Column(name = "Enfermedad_id")
    @GeneratedValue(generator = "DosisGen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "DosisGen", sequenceName = "Dosis_SEQ", allocationSize = 1)
    private Long id;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private Integer valorTiempo;

    private String unidadTiempo;

    @ManyToOne (cascade = {}, fetch = javax.persistence.FetchType.EAGER)
    private Vacuna vacuna;
    
    @OneToMany (cascade = {}, fetch = javax.persistence.FetchType.LAZY, mappedBy = "dosis")
    private List<DosisAplicada> dosisAplicadas;

    public Integer getValorTiempo() {
        return this.valorTiempo;
    }

    /**
     * @generated
     */
    public void setValorTiempo(Integer valorTiempo) {
        this.valorTiempo = valorTiempo;
    }

    /**
     * @generated
     */
    public String getUnidadTiempo() {
        return this.unidadTiempo;
    }

    /**
     * @generated
     */
    public void setUnidadTiempo(String unidadTiempo) {
        this.unidadTiempo = unidadTiempo;
    }

    /**
     * @generated
     */
    public Vacuna getVacuna() {
        return this.vacuna;
    }

    /**
     * @generated
     */
    public void setVacuna(Vacuna vacuna) {
        this.vacuna = vacuna;
    }

    public List<DosisAplicada> getDosisAplicadas() {
        return dosisAplicadas;
    }

    public void setDosisAplicadas(List<DosisAplicada> dosisAplicadas) {
        this.dosisAplicadas = dosisAplicadas;
    }

    
    
}
