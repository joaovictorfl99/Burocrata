package estudantes.entidades;

public class Diploma extends Certificado {
    private String habilitacao;


    public Diploma(String criador, professor.entidades.CodigoCurso codigoCurso, int paginas, long autenticacao, String estudante, long matricula, String descricao, String habilitacao) {
        super(criador, codigoCurso, paginas, autenticacao, estudante, matricula, descricao);
        this.habilitacao = habilitacao;
    }


    public String getHabilitacao() {
        return habilitacao;
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
        Diploma that = (Diploma) objeto;
        return java.util.Objects.equals(habilitacao, that.habilitacao);
    }


    @Override
    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), habilitacao);
    }
}