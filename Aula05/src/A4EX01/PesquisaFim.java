package A4EX01;

public class PesquisaFim extends Pesquisa {
    @Override
    public final String buscarString(String cadeiaCaracteres) {
        if (texto.endsWith(cadeiaCaracteres)) {
            return "O texto contém " + cadeiaCaracteres + " no fim";
        } else {
            return "O texto não contém " + cadeiaCaracteres + " no fim";
        }
    }
}
