package br.com.agenda.details.telephone;

public class Telephone {
    private Long id;
    private String ddd;
    private Long number;

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }
}
