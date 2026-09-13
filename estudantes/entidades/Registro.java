package estudantes.entidades;

public abstract class Registro extends DocumentoAcademico {
    private String estudante;
    private long matricula;


    public Registro(String criador, professor.entidades.CodigoCurso codigoCurso, int paginas, long autenticacao, String estudante, long matricula) {
        super(criador, codigoCurso, paginas, autenticacao);
        this.estudante = estudante;
        this.matricula = matricula;
    }

    public String getEstudante() {
        return estudante;
    }
    public long getMatricula() {
        return matricula;
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
        Registro that = (Registro) objeto;
        return matricula == that.matricula && java.util.Objects.equals(estudante, that.estudante);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), estudante, matricula);
    }
}