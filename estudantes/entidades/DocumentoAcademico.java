package estudantes.entidades;

public abstract class DocumentoAcademico extends Documento {
    private long autenticacao;

    // Construtor
    public DocumentoAcademico(String criador, professor.entidades.CodigoCurso codigoCurso, int paginas, long autenticacao) {
        super(criador, codigoCurso, paginas);
        this.autenticacao = autenticacao;
    }
    // Getter, caso necessário
    public long getAutenticacao() {
        return autenticacao;
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
        DocumentoAcademico that = (DocumentoAcademico) objeto;
        return autenticacao == that.autenticacao;
    }
    // hashCode
    @Override
    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), autenticacao);
    }
}