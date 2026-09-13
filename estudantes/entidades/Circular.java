package estudantes.entidades;
import professor.entidades.CodigoCurso;


import java.util.Arrays;
import java.util.Objects;

public class Circular extends Deliberacao {
    private String[] destinatarios;


    public Circular(String criador, CodigoCurso codigoCurso, int paginas, String texto, String[] destinatarios){
        super(criador, codigoCurso, paginas, texto);
        this.destinatarios = destinatarios;
    }

    public String[] getDestinatarios(){
        return destinatarios;
    }


    @Override
    public boolean equals(Object objeto){
        if(this == objeto){
            return true;
        }
        if(!super.equals(objeto)){
            return false;
        }

        Circular outraCircular = (Circular) objeto;

        return Arrays.equals(destinatarios, outraCircular.destinatarios);
    }

    @Override
    public int hashCode(){
        return Objects.hash(super.hashCode(), Arrays.hashCode(destinatarios));
    }
}