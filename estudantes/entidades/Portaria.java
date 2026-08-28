package estudantes.entidades;
import professor.entidades.CodigoCurso;
import java.util.Objects;

public class Portaria extends Norma {
    private int anoInicio;

    // Construtor
    public Portaria(String criador, CodigoCurso codigoCurso, int paginas, int numero, boolean valido, String texto, int anoInicio){
        super(criador, codigoCurso, paginas, numero, valido, texto);
        this.anoInicio = anoInicio;
    }

    // Getter, caso necessário
    public int getAnoInicio(){
        return anoInicio;
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

        Portaria outraPortaria = (Portaria) objeto;

        return anoInicio == outraPortaria.anoInicio;

    }
    // hashCode
    @Override
    public int hashCode(){
        return Objects.hash(super.hashCode(), anoInicio);
    }
}
