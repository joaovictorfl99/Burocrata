package estudantes.entidades;

import professor.entidades.CodigoCurso;

import java.util.Objects;

public abstract class Documento {
    private String criador;
    private CodigoCurso codigoCurso;
    private int paginas;

    // Construtor completo
    public Documento(String criador, CodigoCurso codigoCurso, int paginas){
        this.criador = criador;
        this.codigoCurso = codigoCurso;
        this.paginas = paginas;
    }

    // Getters necessários
    public String getCriador(){return criador;}

    public CodigoCurso getCodigoCurso(){return codigoCurso;}

    public int getPaginas(){return paginas;}


    // hashCode
    @Override
    public int hashCode() {

        return Objects.hash(codigoCurso, criador, paginas);
    }


    @Override
    public boolean equals(Object objeto) {

        if (this == objeto){
            return true;
        }

        if (objeto == null || getClass() != objeto.getClass()){
            return false;
        }

        Documento outroDoc = (Documento) objeto;

        return paginas == outroDoc.paginas && codigoCurso == outroDoc.codigoCurso && Objects.equals(criador, outroDoc.criador);
    }


}