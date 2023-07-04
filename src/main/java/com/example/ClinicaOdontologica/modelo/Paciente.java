package com.example.ClinicaOdontologica.modelo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;
@Entity
@Table(name="pacientes")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Para que se autogenere
    private Integer id;
    private String nombre;
    private String apellido;
    private Date fechaIngreso;
    private String dni;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "domicilio_id")
    private Domicilio domicilio;
    @OneToMany(mappedBy = "paciente")
    @JsonIgnore //Para que no entre en el loop
    private Set<Turno> turnos;

    //Constructor

    public Paciente(Integer id, String nombre, String apellido, Date fechaIngreso, String dni, Domicilio domicilio, Set<Turno> turnos) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaIngreso = fechaIngreso;
        this.dni = dni;
        this.domicilio = domicilio;
        this.turnos = turnos;
    }

    public Paciente(String nombre, String apellido, Date fechaIngreso, String dni, Domicilio domicilio, Set<Turno> turnos) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaIngreso = fechaIngreso;
        this.dni = dni;
        this.domicilio = domicilio;
        this.turnos = turnos;
    }
    public Paciente() {
    }

    //Getters y Setters

    public Set<Turno> getTurnos() {
        return turnos;
    }
    public void setTurnos(Set<Turno> turnos) {
        this.turnos = turnos;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public Date getFechaIngreso() {
        return fechaIngreso;
    }
    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
    public String getDni() {
        return dni;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }
    public Domicilio getDomicilio() {
        return domicilio;
    }
    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }
    //toString
    @Override
    public String toString() {
        return "Paciente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", fechaIngreso=" + fechaIngreso +
                ", dni='" + dni + '\'' +
                ", domicilio=" + domicilio +
                '}';
    }
}