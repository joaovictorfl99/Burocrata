package estudantes.entidades;

public abstract class DocumentoAcademico extends Documento {
    private long autenticacao;


    public DocumentoAcademico(String criador, professor.entidades.CodigoCurso codigoCurso, int paginas, long autenticacao) {
        super(criador, codigoCurso, paginas);
        this.autenticacao = autenticacao;
    }

    public long getAutenticacao() {
        return autenticacao;
    }

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

    @Override
    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), autenticacao);
    }
}