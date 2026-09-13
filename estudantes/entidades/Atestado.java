package estudantes.entidades;

public class Atestado extends Registro {
    private String descricao;
    private String categoria;

    // Construtor
    public Atestado(String criador, professor.entidades.CodigoCurso codigoCurso, int paginas, long autenticacao, String estudante, long matricula, String descricao, String categoria) {
        super(criador, codigoCurso, paginas, autenticacao, estudante, matricula);
        this.descricao = descricao;
        this.categoria = categoria;
    }

    // getCategoria()
    public String getCategoria() {
        return categoria;
    }
    // getDescricao()
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
        Atestado that = (Atestado) objeto;
        return java.util.Objects.equals(descricao, that.descricao) && java.util.Objects.equals(categoria, that.categoria);
    }

    // hashCode
    @Override
    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), descricao, categoria);
    }
}
