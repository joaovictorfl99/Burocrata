package estudantes.entidades;
import professor.entidades.CodigoCurso;
import java.util.Objects;

public class Oficio extends Deliberacao {
    private String destinatario;

    // Construtor
    public Oficio(String criador, CodigoCurso codigoCurso, int paginas, String texto, String destinatario){
        super(criador, codigoCurso, paginas, texto);
        this.destinatario = destinatario;
    }
    // Getter, caso necessário
    public String getDestinatario(){
        return destinatario;
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

        Oficio outroOficio = (Oficio) objeto;

        return Objects.equals(destinatario, outroOficio.destinatario);
    }
    // hashCode
    @Override
    public int hashCode(){
        return Objects.hash(super.hashCode(), destinatario);
    }
}
