package com.example.demo.dto;

public class DataSimpleDto {
    private Integer data;
    private String inDate;
    private String datatype;

    public DataSimpleDto() {
    }

    public DataSimpleDto(Integer data, String inDate, String datatype) {
        this.data = data;
        this.inDate = inDate;
        this.datatype = datatype;
    }

    @Override
    public String toString() {
        return "DepartmentDataDto{" +
                "dato=" + data +
                ", fecha='" + inDate + '\'' +
                ", tipoDeDato='" + datatype + '\'' +
                '}';
    }

    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }

    public String getInDate() {
        return inDate;
    }

    public void setInDate(String inDate) {
        this.inDate = inDate;
    }

    public String getDatatype() {
        return datatype;
    }

    public void setDatatype(String datatype) {
        this.datatype = datatype;
    }


}
