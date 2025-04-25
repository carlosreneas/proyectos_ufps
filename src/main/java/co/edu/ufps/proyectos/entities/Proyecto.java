package co.edu.ufps.proyectos.entities;

import java.time.Instant;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @ManyToOne
    @JoinColumn(name = "area_id")
    private Area area;

    @ManyToOne
    @JoinColumn(name = "estado_id")
    private Estado estado;

    @Lob
    private String resumen;

    private String archivoPdf;

    @ManyToOne
    @JoinColumn(name = "director_id")
    private Director director;

    private Instant fechaRegistro;

    @ManyToMany
    @JoinTable(
      name = "proyecto_alumno", 
      joinColumns = @JoinColumn(name = "proyecto_id"), 
      inverseJoinColumns = @JoinColumn(name = "alumno_id"))
    private List<Alumno> alumnos;

    @OneToMany(mappedBy = "proyecto")
    private List<HistorialEstado> historialEstados;

    @OneToMany(mappedBy = "proyecto")
    private List<ProyectosJurado> proyectosJurados;
}











