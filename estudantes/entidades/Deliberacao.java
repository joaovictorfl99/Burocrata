package estudantes.entidades;
import professor.entidades.CodigoCurso;
import java.util.Objects;

public abstract class Deliberacao extends DocumentoAdministrativo {
    private String texto;


    public Deliberacao(String criador, CodigoCurso codigoCurso, int paginas, String texto){
        super(criador, codigoCurso, paginas);
        this.texto = texto;
    }

    public String getTexto(){
        return texto;
    }


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

    @Override
    public int hashCode(){
        return Objects.hash(super.hashCode(), texto);
    }
}