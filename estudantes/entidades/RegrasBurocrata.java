package estudantes.entidades;
import professor.entidades.CodigoCurso;
import professor.entidades.Processo;

/**
 * Centraliza as regras usadas pelo Burocrata para organizar
 * e despachar documentos.
 *
 * Esta classe não representa um tipo de documento.
 * Por isso, não herda de Documento nem de Processo.
 */
public class RegrasBurocrata {

    private RegrasBurocrata() {
    }

    /**
     * Verifica se o candidato pode ser adicionado ao processo.
     *
     * Deve verificar:
     * - processo e candidato não nulos;
     * - limite de 250 páginas;
     * - regra 1;
     * - regra 2;
     * - regra 4;
     * - regra 5;
     * - regra 6;
     * - regra 7.
     *
     *
     * A regra 3 pertence ao despacho e não à adição.
     */
    public static boolean podeAdicionar(Processo processo, Documento candidato) {
        throw new UnsupportedOperationException("Implementar");


    }

    /**
     * Verifica se o processo pode ser despachado.
     *
     * Deve garantir que:
     * - o processo não seja nulo;
     * - o processo não esteja vazio;
     * - o processo não contenha apenas Atas.
     */
    public static boolean podeDespachar(Processo processo) {
        throw new UnsupportedOperationException("Implementar");
    }

    /**
     * Regra 1:
     * não misturar documentos de graduação
     * com documentos de pós-graduação.
     */
    private static boolean respeitaRegra1Curso(Processo processo, Documento candidato) {

        boolean candidatoEhPos = ehPosGraduacao(candidato);

        for(Documento documento : processo.pegarCopiaDoProcesso()){

            boolean documentoEhPos = ehPosGraduacao(documento);

            if(candidatoEhPos != documentoEhPos){
                return false;
            }
        }
    }

    /**
     * Regra 2:
     * não misturar documentos administrativos
     * com documentos acadêmicos.
     *
     * Atas podem acompanhar qualquer categoria.
     */
    private static boolean respeitaRegra2TipoDocumento(
            Processo processo,
            Documento candidato
    ) {
        throw new UnsupportedOperationException("Implementar");
    }

    /**
     * Regra 4:
     * Portaria ou Edital válido com 100 páginas
     * ou mais deve ficar sozinho no processo.
     */
    private static boolean respeitaRegra4DocumentoSubstancial(
            Processo processo,
            Documento candidato
    ) {
        throw new UnsupportedOperationException("Implementar");
    }

    /**
     * Regra 5:
     * Circulares e Ofícios diferentes precisam
     * ter pelo menos um destinatário em comum.
     *
     * A interseção deve ser calculada considerando
     * todos os documentos desse tipo no processo.
     */
    private static boolean respeitaRegra5Destinatarios(
            Processo processo,
            Documento candidato
    ) {
        throw new UnsupportedOperationException("Implementar");
    }

    /**
     * Regra 6:
     * Diplomas só podem ser acompanhados por:
     * - Diplomas;
     * - Certificados;
     * - Atas.
     */
    private static boolean respeitaRegra6Diploma(
            Processo processo,
            Documento candidato
    ) {
        throw new UnsupportedOperationException("Implementar");
    }

    /**
     * Regra 7:
     * Atestados de categorias diferentes
     * não podem estar no mesmo processo.
     */
    private static boolean respeitaRegra7CategoriaAtestado(
            Processo processo,
            Documento candidato
    ) {
        throw new UnsupportedOperationException("Implementar");
    }


     //Verifica o limite máximo de 250 páginas.
    private static boolean respeitaLimiteDePaginas(Processo processo, Documento candidato) {
        return contarPaginasComCandidato(processo, candidato <= 250;

    }


    private static boolean contemApenasAtas(Processo processo) {

        if(processo.contarDocumentos() == 0){
            return false;
        }
        for(Documento doc : processo.pegarCopiaDoProcesso()){
            if(!ehAta(doc)){
                return false;
            }
        }
        return true;

    }

    private static int contarPaginasComCandidato(Processo processo, Documento candidato) {

        int totalPaginas = candidato.getPaginas();

        for (Documento doc : processo.pegarCopiaDoProcesso()){
            totalPaginas += doc.getPaginas();
        }

        return totalPaginas;
    }

    /**
     * Obtém os documentos atuais do processo e inclui
     * o candidato apenas em uma estrutura local de análise.
     *
     * Não deve alterar o processo real.
     */
    private static Documento[] obterDocumentosComCandidato(Processo processo, Documento candidato) {
        throw new UnsupportedOperationException("Implementar");
    }

    private static boolean ehPosGraduacao(Documento documento) {

        CodigoCurso codigo = documento.getCodigoCurso();

        return codigo == POS_GRADUACAO_COMPUTACAO ||
                codigo == POS_GRADUACAO_ENGENHARIA_ELETRICA ||
                codigo == POS_GRADUACAO_MICROELETRONICA;
    }

    private static boolean ehAdministrativo(Documento documento) {
        throw new UnsupportedOperationException("Implementar");
    }

    private static boolean ehAcademico(Documento documento) {
        throw new UnsupportedOperationException("Implementar");
    }

    private static boolean ehAta(Documento documento) {
        return documento instanceof Ata;
    }

    private static boolean ehDocumentoSubstancialValido(Documento documento) {
        if(!ehEditalouPortaria(documento)){
            return false;
        }
        Norma doc = (Norma) documento; //Faz documento ser tratado como Norma, para poder usar o atributo validade
        return doc.getPaginas() > 100 && doc.isValido();
    }

    private static boolean ehEditalouPortaria(Documento documento) {
        return documento instanceof Edital || documento instanceof Portaria;
    }

    private static boolean ehCircularOuOficio(Documento documento) {
        return documento instanceof Oficio ||  documento instanceof Circular;
    }

    private static boolean ehDiploma(Documento documento) {
        return documento instanceof Diploma;
    }

    private static boolean ehCertificado(Documento documento) {
        return documento instanceof Certificado
                && !(documento instanceof Diploma);
    }

    private static boolean ehAtestado(Documento documento) {
        return documento instanceof Atestado;
    }
}