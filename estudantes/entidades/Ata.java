package estudantes.entidades;

import professor.entidades.CodigoCurso;
import java.util.Objects;
import java.util.Arrays;

public class Ata extends Documento {
    private int numero;
    private String texto;
    private String[] presentes;


    // Construtor
    public Ata(String criador, CodigoCurso codigoCurso, int paginas, int numero, String texto, String[] presentes) {
        super(criador, codigoCurso, paginas);
        this.numero = numero;
        this.texto = texto;
        this.presentes = presentes;
    }


    // Getters necessários
    public int getNumero() {
        return numero;
    }
    public String getTexto() {
        return texto;
    }
    public String[] getPresentes() {
        return presentes;
    }


    // equals
    @Override
    public boolean equals(Object objeto) {
        if (this == objeto){
            return true;
        }
        if (objeto == null || getClass() != objeto.getClass()){
            return false;
        }
        if (!super.equals(objeto)){
            return false;
        }

        Ata ata = (Ata) objeto;

        if (numero != ata.numero){
            return false;
        }
        if (!Objects.equals(texto, ata.texto)){
            return false;
        }
        if (presentes.length != ata.presentes.length){
            return false;
        }
        for (int i = 0; i < presentes.length; i++){
            if (!Objects.equals(presentes[i], ata.presentes[i])){
                return false;
            }
        }
        return true;
    }


    // hashCode
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), numero, texto, Arrays.hashCode(presentes));
    }
}