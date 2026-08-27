package estudantes.entidades;
import professor.entidades.CodigoCurso;
import java.util.Objects;

public class Circular extends Deliberacao {
    private String[] destinatarios;

    // Construtor
    public Circular(String criador, CodigoCurso codigoCurso, int paginas, String texto, String[] destinatarios){
        super(criador, codigoCurso, paginas);
        this.destinatarios = destinatarios;
    }
    // Getter, caso necessário
    public String[] getDestinatarios(){
        return destinatarios;
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

        Circular outraCircular = (Circular) objeto;

        return Objects.equals(destinatarios, outraCircular.destinatarios);
    }
    // hashCode
    @Override
    public int hashcode(Object objeto){
        return Objects.hash(super.hashCode(), destinatarios);
    }
}