package estudantes.entidades;

public class Plano extends DocumentoAcademico {
    private String responsavel;
    private String[] planejamento;

    // Construtor
    public Plano(String criador, professor.entidades.CodigoCurso codigoCurso, int paginas, long autenticacao, String responsavel, String[] planejamento) {
        super(criador, codigoCurso, paginas, autenticacao);
        this.responsavel = responsavel;
        this.planejamento = planejamento;
    }
    // Getters necessários
    public String getResponsavel() {
        return responsavel;
    }
    public String[] getPlanejamento() {
        return planejamento;
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
        Plano plano = (Plano) objeto;
        if (!java.util.Objects.equals(responsavel, plano.responsavel)) {
            return false;
        }
        if (planejamento.length != plano.planejamento.length) {
            return false;
        }
        for (int i = 0; i < planejamento.length; i++) {
            if (!java.util.Objects.equals(planejamento[i], plano.planejamento[i])) {
                return false;
            }
        }
        return true;
    }
    // hashCode
    @Override
    public int hashCode() {
        int result = java.util.Objects.hash(super.hashCode(), responsavel);
        result = 31 * result + java.util.Arrays.hashCode(planejamento);
        return result;
    }
}
