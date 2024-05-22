package com.proyectoIngles.adjetivosFormas.Model;

public class Adjective {
    private int id;
    private String adjective;
    private String comparative;
    private String superlative;
    private String exampleComparative;
    private String exampleSuperlative;

    // Constructor con todos los argumentos
    public Adjective(int id, String adjective, String comparative, String superlative, String exampleComparative, String exampleSuperlative) {
        this.id = id;
        this.adjective = adjective;
        this.comparative = comparative;
        this.superlative = superlative;
        this.exampleComparative = exampleComparative;
        this.exampleSuperlative = exampleSuperlative;
    }

    // Constructor sin argumentos
    public Adjective() {
    }

    // Getters y setters
    public String getAdjective() {
        return adjective;
    }

    public void setAdjective(String adjective) {
        this.adjective = adjective;
    }

    public String getComparative() {
        return comparative;
    }

    public void setComparative(String comparative) {
        this.comparative = comparative;
    }

    public String getSuperlative() {
        return superlative;
    }

    public void setSuperlative(String superlative) {
        this.superlative = superlative;
    }

    public String getExampleComparative() {
        return exampleComparative;
    }

    public void setExampleComparative(String exampleComparative) {
        this.exampleComparative = exampleComparative;
    }

    public String getExampleSuperlative() {
        return exampleSuperlative;
    }

    public void setExampleSuperlative(String exampleSuperlative) {
        this.exampleSuperlative = exampleSuperlative;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
