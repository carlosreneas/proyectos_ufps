package co.edu.ufps.proyectos.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProyectosJurado {
    @Id
    @ManyToOne
    @JoinColumn(name = "proyecto_id")
    private Proyecto proyecto;

    @Id
    @ManyToOne
    @JoinColumn(name = "jurado_id")
    private Jurado jurado;

    private Double nota;

    @Lob
    private String observaciones;
}