package estudantes.entidades;

public class Historico extends Registro {
    private double coeficiente;
    private String[] componentes;

    // Construtor
    public Historico(String criador, professor.entidades.CodigoCurso codigoCurso, int paginas, long autenticacao, String estudante, long matricula, double coeficiente, String[] componentes) {
        super(criador, codigoCurso, paginas, autenticacao, estudante, matricula);
        this.coeficiente = coeficiente;
        this.componentes = componentes;
    }

    // Getters necessários
    public double getCoeficiente() {
        return coeficiente;
    }
    public String[] getComponentes() {
        return componentes;
    }

    // equals
    @Override
    public boolean equals(Object objeto) {
        if (this == objeto) {
            return true;
        }
        if (objeto == null || getClass() != objeto.getClass()) {
            return false;
        }
        if (!super.equals(objeto)) {
            return false;
        }
        Historico historico = (Historico) objeto;
        if (Double.compare(historico.coeficiente, coeficiente) != 0) {
            return false;
        }
        if (componentes.length != historico.componentes.length) {
            return false;
        }
        for (int i = 0; i < componentes.length; i++) {
            if (!java.util.Objects.equals(componentes[i], historico.componentes[i])) {
                return false;
            }
        }
        return true;
    }

    // hashCode
    @Override
    public int hashCode() {
        int result = java.util.Objects.hash(super.hashCode(), coeficiente);
        result = 31 * result + java.util.Arrays.hashCode(componentes);
        return result;
    }
}