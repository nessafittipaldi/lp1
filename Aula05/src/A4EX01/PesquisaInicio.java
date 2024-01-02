package A4EX01;

public class PesquisaInicio extends Pesquisa {
    @Override
    public final String buscarString(String cadeiaCaracteres) {
        if (texto.startsWith(cadeiaCaracteres)) {
            return "O texto contém " + cadeiaCaracteres + " no início";
        } else {
            return "O texto não contém " + cadeiaCaracteres + " no início";
        }
    }
}
