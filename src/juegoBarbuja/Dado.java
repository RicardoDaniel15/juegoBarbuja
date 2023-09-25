package juegoBarbuja;

public class Dado {
    private int numDado;

    public Dado(int numDado) {
        this.numDado = numDado;
    }

    public int getNumDado() {
        return numDado;
    }

    public void setNumDado(int numDado) {
        this.numDado = numDado;
    }

    @Override
    public String toString() {
        return String.format("Dado: %d",this.numDado);
    }
}
