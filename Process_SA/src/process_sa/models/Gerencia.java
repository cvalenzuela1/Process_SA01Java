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
public class Gerencia {
    int id_gerencia;
    String gerencia;
    String id_subgerencia;
    String id_departamento;

    public String getId_departamento() {
        return id_departamento;
    }

    public void setId_departamento(String id_departamento) {
        this.id_departamento = id_departamento;
    }

    public int getId_gerencia() {
        return id_gerencia;
    }

    public void setId_gerencia(int id_gerencia) {
        this.id_gerencia = id_gerencia;
    }

    public String getGerencia() {
        return gerencia;
    }

    public void setGerencia(String gerencia) {
        this.gerencia = gerencia;
    }

    public String getId_subgerencia() {
        return id_subgerencia;
    }

    public void setId_subgerencia(String id_subgerencia) {
        this.id_subgerencia = id_subgerencia;
    }
    
}
