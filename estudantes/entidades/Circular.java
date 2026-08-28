package estudantes.entidades;
import professor.entidades.CodigoCurso;

import java.lang.reflect.Array;
import java.util.Objects;

public class Circular extends Deliberacao {
    private String[] destinatarios;

    // Construtor
    public Circular(String criador, CodigoCurso codigoCurso, int paginas, String texto, String[] destinatarios){
        super(criador, codigoCurso, paginas, texto);
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

        return Array.equals(destinatarios, outraCircular.destinatarios);
    }
    // hashCode
    @Override
    public int hashCode(){
        return Objects.hash(super.hashCode(), destinatarios);
    }
}