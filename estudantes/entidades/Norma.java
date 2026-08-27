package estudantes.entidades;
import professor.entidades.CodigoCurso;

import java.util.Objects;

public class Norma extends DocumentoAdministrativo {
    private int numero;
    private boolean valido;
    private String texto;

    // Construtor
    public Norma(String criador, CodigoCurso codigoCurso, int paginas, int numero, boolean valido, String texto) {
        super(criador, codigoCurso, paginas);

        this.numero = numero;
        this.valido = valido;
        this.texto = texto;
    }
    // Getters necessários
    public int getNumero(){
        return numero;
    }

    public boolean getValido(){
        return valido;
    }

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

        Norma outraNorma = (Norma) objeto;

        return numero == outraNorma.numero && valido == outraNorma.valido && Objects.equals(texto, outraNorma.texto);
    }
    // hashCode
    @Override
    public int hashcode(){
        return Objects.hash(super.hashCode(), numero, valido, texto);
    }
}