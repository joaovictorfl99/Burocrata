package estudantes.entidades;
import professor.entidades.CodigoCurso;

public abstract class DocumentoAdministrativo extends Documento {
    // Construtor que repassa os dados para Documento
    public DocumentoAdministrativo(String criador, CodigoCurso codigoCurso, int paginas) {
        super(criador, codigoCurso, paginas);
    }

    @Override
    public boolean equals(Object objeto) {
        return super.equals(objeto);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}