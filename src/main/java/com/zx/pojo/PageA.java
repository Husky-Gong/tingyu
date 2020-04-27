package com.zx.pojo;

import java.io.Serializable;
import java.util.List;

public class PageA<T> implements Serializable {

    private List<T>  rows;

    private   long  total;

    public PageA(){}

    public PageA(List<T> rows, long total) {
        this.rows = rows;
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "PageA{" +
                "rows=" + rows +
                ", total=" + total +
                '}';
    }
}
