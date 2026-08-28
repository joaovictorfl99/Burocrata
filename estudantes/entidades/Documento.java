package estudantes.entidades;

import professor.entidades.CodigoCurso;

import java.util.Objects;

/**
 * Classe que representa um documento genérico.
 * <br><br>
 * <strong>Seu trabalho começa aqui...</strong>
 *
 * @author coloque os nomes dos autores aqui
 */

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
        // Retornar um hash gerado com os mesmos atributos:
        return Objects.hash(codigoCurso, criador, paginas);
    }


    @Override
    public boolean equals(Object objeto) {
        // 1. Verificar se objeto e this são a mesma referência.
        if (this == objeto){
            return true;
        }
        // 2. Verificar se objeto é null ou se pertence à mesma classe.
        if (objeto == null || getClass() != objeto.getClass()){
            return false;
        }
        // 3. Converter objeto para Documento.
        Documento outroDoc = (Documento) objeto;

        // 4. Comparar:
        //    - paginas usando ==
        //    - codigoCurso usando ==
        //    - criador usando Objects.equals(...)
        return paginas == outroDoc.paginas && codigoCurso == outroDoc.codigoCurso && Objects.equals(criador, outroDoc.criador);
    }


}