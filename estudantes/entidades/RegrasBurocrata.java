package estudantes.entidades;
import professor.entidades.CodigoCurso;
import professor.entidades.Processo;


public class RegrasBurocrata {

    private RegrasBurocrata() {
    }


    public static boolean podeAdicionar(Processo processo, Documento candidato) {
        if(processo == null || candidato == null){
            return false;
        }
        else if(!respeitaLimiteDePaginas(processo,candidato)){
            return false;
        }
        else if(!respeitaRegra1Curso(processo,candidato)){
            return false;
        }
        else if(!respeitaRegra2TipoDocumento(processo,candidato)){
            return false;
        }
        else if(!respeitaRegra4DocumentoSubstancial(processo,candidato)){
            return false;
        }
        else if(!respeitaRegra5Destinatarios(processo,candidato)){
            return false;
        }
        else if(!respeitaRegra6Diploma(processo,candidato)){
            return false;
        }
        else if(!respeitaRegra7CategoriaAtestado(processo,candidato)){
            return false;
        }
       
       return true;

    }

    public static boolean podeDespachar(Processo processo) {
        if(processo == null){
            return false;
        }
        else if (processo.contarDocumentos() == 0){
            return false;
        }
        else if(contemApenasAtas(processo)){
            return false;
        }
        return true;
    }


    private static boolean respeitaRegra1Curso(Processo processo, Documento candidato) {

        boolean candidatoEhPos = ehPosGraduacao(candidato);

        for(Documento documento : processo.pegarCopiaDoProcesso()){

            boolean documentoEhPos = ehPosGraduacao(documento);

            if(candidatoEhPos != documentoEhPos){
                return false;
            }
        }
        return true;
    }

    private static boolean respeitaRegra2TipoDocumento(Processo processo, Documento candidato) {

        if(ehAta(candidato)){
            return true;
        }

        boolean candidatoEhDocAdm = ehAdministrativo(candidato);

        for(Documento documento : processo.pegarCopiaDoProcesso()){

            if(ehAta(documento)){
                continue;
            }

            boolean docEhDocAdm = ehAdministrativo(documento);

            if(candidatoEhDocAdm != docEhDocAdm){
                return false;
            }
        }
        return true;
    }

    private static boolean respeitaRegra4DocumentoSubstancial(Processo processo, Documento candidato) {

        if(ehDocumentoSubstancialValido(candidato)){
            return processo.contarDocumentos() == 0;
        }

        for(Documento documento : processo.pegarCopiaDoProcesso()){

            if(ehDocumentoSubstancialValido(documento)){
                return false;
            }
        }
        return true;
    }

private static boolean respeitaRegra5Destinatarios(Processo processo, Documento candidato) {

    if (!ehCircularOuOficio(candidato)) {
        return true;
    }

    Documento[] documentos = processo.pegarCopiaDoProcesso();
    boolean temCircularOuOficio = false;

    for (Documento documento : documentos) {
        if (ehCircularOuOficio(documento)) {
            temCircularOuOficio = true;
            break;
        }
    }

    if (!temCircularOuOficio) {
        return true;
    }

    String[] destinatarios;

    if (candidato instanceof Circular) {
        destinatarios = ((Circular) candidato).getDestinatarios();
    }
    else {
        destinatarios = new String[] {
            ((Oficio) candidato).getDestinatario()
        };
    }

    for (String nome : destinatarios) {
        boolean presenteEmTodos = true;

        for (Documento documento : documentos) {
            if (ehCircularOuOficio(documento)
                    && !temDestinatario(documento, nome)) {
                presenteEmTodos = false;
                break;
            }
        }

        if (presenteEmTodos) {
            return true;
        }
    }

    return false;
}

private static boolean temDestinatario(
        Documento documento, String nome) {

    if (nome == null) {
        return false;
    }

    if (documento instanceof Oficio) {
        Oficio oficio = (Oficio) documento;
        return nome.equals(oficio.getDestinatario());
    }

    if (documento instanceof Circular) {
        Circular circular = (Circular) documento;

        for (String destinatario : circular.getDestinatarios()) {
            if (nome.equals(destinatario)) {
                return true;
            }
        }
    }

    return false;
}

    private static boolean respeitaRegra6Diploma(Processo processo, Documento candidato) {
        if(ehDiploma(candidato)){
            for(Documento documento : processo.pegarCopiaDoProcesso()){
                if(!ehDiploma(documento) && !ehCertificado(documento) && !ehAta(documento)){
                    return false;
                }
            }
        }
        else if(!ehCertificado(candidato) && !ehAta(candidato)){
            for(Documento documento : processo.pegarCopiaDoProcesso()){
                if(ehDiploma(documento)){
                    return false;
                }
            }
        }
        return true;
    }

private static boolean respeitaRegra7CategoriaAtestado(Processo processo, Documento candidato) {
    
    if (!ehAtestado(candidato)) {
        return true;
    }

    Atestado atestadoCandidato = (Atestado) candidato;
    String categoriaCandidato = atestadoCandidato.getCategoria();

    for (Documento documento : processo.pegarCopiaDoProcesso()) {
        if (ehAtestado(documento)) {
            Atestado outroAtestado = (Atestado) documento;
            String outraCategoria = outroAtestado.getCategoria();

            if (categoriaCandidato == null) {
                if (outraCategoria != null) {
                    return false;
                }
            }
            else if (!categoriaCandidato.equals(outraCategoria)) {
                return false;
            }
        }
    }

    return true;
}

    private static boolean respeitaLimiteDePaginas(Processo processo, Documento candidato) {
        return contarPaginasComCandidato(processo, candidato) <= 250;

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

    private static boolean ehPosGraduacao(Documento documento) {

        CodigoCurso codigo = documento.getCodigoCurso();

        return codigo == CodigoCurso.POS_GRADUACAO_COMPUTACAO ||
                codigo == CodigoCurso.POS_GRADUACAO_ENGENHARIA_ELETRICA ||
                codigo == CodigoCurso.POS_GRADUACAO_MICROELETRONICA;
    }

    private static boolean ehAdministrativo(Documento documento) {
        return documento instanceof DocumentoAdministrativo;
    }

    private static boolean ehAcademico(Documento documento) {

        return documento instanceof DocumentoAcademico;
    }

    private static boolean ehAta(Documento documento) {

        return documento instanceof Ata;
    }

    private static boolean ehDocumentoSubstancial(Documento documento) {
        if(!ehEditalouPortaria(documento)){
            return false;
        }
        return documento.getPaginas() >= 100;
    }

    private static boolean ehDocumentoSubstancialValido(Documento documento) {
        if(!ehDocumentoSubstancial(documento)){
            return false;
        }
        Norma doc = (Norma) documento; //Faz documento ser tratado como Norma, para poder usar o atributo validade
        return doc.isValido();
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