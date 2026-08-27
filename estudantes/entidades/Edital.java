package estudantes.entidades;

import professor.entidades.CodigoCurso;

import java.util.Objects;

public class Edital extends Norma {
    private String[] responsaveis;

    // Construtor
    public Edital(String criador, CodigoCurso codigoCurso, int paginas, int numero, boolean valido, String texto, String[] responsaveis){
        super(criador, codigoCurso, paginas, valido, texto);
        this.responsaveis = responsaveis;
    }

    // Getter, caso necessário
    public int getResponsaveis(){
        return responsaveis;
    }

    // equals
    @Override
    public boolean equals(Objects objeto){
        if(this == objeto){
            return true;
        }

        if(!super.equals(objeto)){
            return false;
        }

        Edital outroEdital = (Edital) objeto;

        return Objects.equals(responsaveis, outroEdital.responsaveis);

    }
    // hashCode
    @Override
    public int hashcode(Objects objects){
        return Objects.hash(super.hashCode(), responsaveis);
    }
}