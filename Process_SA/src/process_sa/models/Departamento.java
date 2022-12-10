/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package process_sa.models;

/**
 *
 * @author cvale
 */
public class Departamento {
    int id_departamento;
    String departamento;
    String id_gerencia;

    public int getId_departamento() {
        return id_departamento;
    }

    public void setId_departamento(int id_departamento) {
        this.id_departamento = id_departamento;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getId_gerencia() {
        return id_gerencia;
    }

    public void setId_gerencia(String id_gerencia) {
        this.id_gerencia = id_gerencia;
    }
       
}
