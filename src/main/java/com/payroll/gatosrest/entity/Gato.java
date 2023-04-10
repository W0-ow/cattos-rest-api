package com.payroll.gatosrest.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Gato {
    private @Id
    @GeneratedValue Long id;
    private String name;
    private Boolean isFluffy;

    public Gato() {
    }

    public Gato(String name, Boolean isFluffy) {
        this.name = name;
        this.isFluffy = isFluffy;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getFluffy() {
        return isFluffy;
    }

    public void setFluffy(Boolean fluffy) {
        isFluffy = fluffy;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;
        if (!(obj instanceof Gato)) return false;
        Gato gato = (Gato) obj;

        return Objects.equals(this.id, gato.id) && Objects.equals(this.name, gato.name) && Objects.equals(this.isFluffy, gato.isFluffy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.isFluffy);
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + this.id + ", name='" + this.name + '\'' + ", isFluffy='" + this.isFluffy + '\'' + '}';
    }
}
