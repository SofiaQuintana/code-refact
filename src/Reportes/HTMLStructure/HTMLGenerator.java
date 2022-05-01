/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reportes.HTMLStructure;

/**
 *
 * @author zofia-px
 * @param <T>
 */
public interface HTMLGenerator<T> {
    public String getTableHeader();
    public String getTableRows(T instruction);
}
