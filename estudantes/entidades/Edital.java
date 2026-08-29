package estudantes.entidades;

import professor.entidades.CodigoCurso;

import java.util.Arrays;
import java.util.Objects;

public class Edital extends Norma {
    private String[] responsaveis;

    // Construtor
    public Edital(String criador, CodigoCurso codigoCurso, int paginas, int numero, boolean valido, String texto, String[] responsaveis){
        super(criador, codigoCurso, paginas, numero, valido, texto);
        this.responsaveis = responsaveis;
    }

    // Getter, caso necessário
    public String[] getResponsaveis(){
        return responsaveis;
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

        Edital outroEdital = (Edital) objeto;

        return Arrays.equals(responsaveis, outroEdital.responsaveis);

    }
    // hashCode
    @Override
    public int hashCode(){
        return Objects.hash(super.hashCode(), Arrays.hashCode(responsaveis));
    }
}