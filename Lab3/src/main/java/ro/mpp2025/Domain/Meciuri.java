package ro.mpp2025.Domain;

import java.util.Objects;

public class Meciuri extends Entity <Integer>{

    private Echipe idEchipaA;
    private Echipe idEchipaB;
    private String nume_meci;
    private String nr_loc;
    private Integer pret;

    public Meciuri(Echipe idEchipaA , Echipe idEchipaB, String nume_meci, String nr_loc, Integer pret) {
        this.idEchipaA = idEchipaA;
        this.idEchipaB = idEchipaB;
        this.nume_meci = nume_meci;
        this.nr_loc = nr_loc;
        this.pret = pret;
    }

    public Echipe getIdEchipaA() {
        return idEchipaA;
    }
    public void setIdEchipaA(Echipe idEchipaA) {
        this.idEchipaA = idEchipaA;

    }
    public Echipe getIdEchipaB() {
        return idEchipaB;
    }
    public void setIdEchipaB(Echipe idEchipaB) {
        this.idEchipaB = idEchipaB;
    }
    public String getNume_meci() {
        return nume_meci;
    }
    public void setNume_meci(String nume_meci) {
        this.nume_meci = nume_meci;
    }
    public String getNr_loc() {
        return nr_loc;
    }
    public void setNr_loc(String nr_loc) {
        this.nr_loc = nr_loc;
    }
    public Integer getPret() {
        return pret;
    }
    public void setPret(Integer pret) {
        this.pret = pret;
    }

    @Override
    public String toString() {
        return "Meciuri {" +
                "idEchipaA='" + idEchipaA + '\'' +
                "idEchipaB='" + idEchipaB + '\'' +
                "nume_meci='" + nume_meci + '\'' +
                "nr_loc='" + nr_loc + '\'' +
                "pret='" + pret + '\'';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Meciuri that = (Meciuri) o;
        return Objects.equals(idEchipaA, that.idEchipaA) && Objects.equals(idEchipaB , that.idEchipaB) && Objects.equals(nume_meci , that.nume_meci) && Objects.equals(nr_loc , that.nr_loc) && Objects.equals(pret , that.pret);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), idEchipaA , idEchipaB , nume_meci , nr_loc , pret);
    }
}
