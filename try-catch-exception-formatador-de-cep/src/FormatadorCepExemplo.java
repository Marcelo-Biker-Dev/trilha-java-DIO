public class FormatadorCepExemplo {
    public static void main(String[] args) {
        
        try {
            String cepFormatado = formatarCep("28.890-046");
            System.out.println(cepFormatado);
        } catch (CepInvalidoException e) {
            // TODO Auto-generated catch block
            //e.printStackTrace();
            System.out.println("Apenas os oito números do CEP são permitidos");
        }

    }

    static String formatarCep(String cep) throws CepInvalidoException {
        if (cep.length() != 8) {
            throw new CepInvalidoException();
        }

        //simulando um CEP formatado
        return "28890-046";
    }
}
