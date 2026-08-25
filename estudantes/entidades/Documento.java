package estudantes.entidades;

import professor.entidades.CodigoCurso;

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

    // equals
    import java.util.Objects;

    @Override
    public boolean equals(Object objeto) {
        // 1. Verificar se objeto e this são a mesma referência.


        // 2. Verificar se objeto é null.

        // 3. Verificar se objeto pertence à mesma classe.

        // 4. Converter objeto para Documento.

        // 5. Comparar:
        //    - paginas usando ==
        //    - codigoCurso usando ==
        //    - criador usando Objects.equals(...)
    }

    // hashCode
    @Override
    public int hashCode() {
        // Retornar um hash gerado com os mesmos atributos:
        // criador, codigoCurso e paginas
    }

}


 //   this == objeto
 //   objeto == null
 //   getClass() != objeto.getClass()
 //   Documento outro = (Documento) objeto
 //   paginas == outro.paginas
 //   codigoCurso == outro.codigoCurso
 //   Objects.equals(criador, outro.criador)
 //   Objects.hash(criador, codigoCurso, paginas)