package estudantes.entidades;
import professor.entidades.CodigoCurso;
import javax.print.attribute.standard.DocumentName;
import java.util.Objects;

public abstract class Deliberacao extends DocumentoAdministrativo {
    private String texto;

    // Construtor
    public Deliberacao(String criador, CodigoCurso codigoCurso, int paginas, String texto){
        super(criador, codigoCurso, paginas);
        this.texto = texto;
    }
    // Getter, caso necessário
    public String getTexto(){
        return texto;
    }

    // equals
    @Override
    public boolean equals(Object objeto){
        if(this == objeto){
            return true;
        }
        if(!super.equals(objeto)){
            return false;
        }

        Deliberacao outraDeliberacao = (Deliberacao) objeto;

        return Objects.equals(texto, outraDeliberacao.texto);
    }
    // hashCode
    @Override
    public int hashcode(Object objeto){
        return Objects.hash(super.hashCode(), texto);
    }
}