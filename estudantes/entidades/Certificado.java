package estudantes.entidades;

public class Certificado extends Registro {
    private String descricao;

    // Construtor
    public Certificado(String criador, professor.entidades.CodigoCurso codigoCurso, int paginas, long autenticacao, String estudante, long matricula, String descricao) {
        super(criador, codigoCurso, paginas, autenticacao, estudante, matricula);
        this.descricao = descricao;
    }

    // Getter, caso necessário
    public String getDescricao() {
        return descricao;
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
        Certificado that = (Certificado) objeto;
        return java.util.Objects.equals(descricao, that.descricao);
    }

    // hashCode
    @Override
    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), descricao);
    }
}