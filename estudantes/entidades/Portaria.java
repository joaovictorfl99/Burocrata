package estudantes.entidades;
import professor.entidades.CodigoCurso;
import java.util.Objects;

public class Portaria extends Norma {
    private int anoInicio;


    public Portaria(String criador, CodigoCurso codigoCurso, int paginas, int numero, boolean valido, String texto, int anoInicio){
        super(criador, codigoCurso, paginas, numero, valido, texto);
        this.anoInicio = anoInicio;
    }


    public int getAnoInicio(){
        return anoInicio;
    }


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

    @Override
    public int hashCode(){
        return Objects.hash(super.hashCode(), anoInicio);
    }
}
