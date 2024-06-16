
package com.qlcnnh.entity;

/**
 *
 * @author T14
 */
public class KyHanSTK {

    @Override
    public String toString() {
        return valueKyHan;
    }

    private int idKyHan;
    private String valueKyHan;
    
    public int getIdKyHan() {
        return idKyHan;
    }

    public void setIdKyHan(int idKyHan) {
        this.idKyHan = idKyHan;
    }

    public String getValueKyHan() {
        return valueKyHan;
    }

    public void setValueKyHan(String valueKyHan) {
        this.valueKyHan = valueKyHan;
    }
   
}
