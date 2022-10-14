import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {

        Map<String, String> aluno = new HashMap<>();
        Map<String, String> aluno2 = new HashMap<>();

        aluno.put("Nome", "Marcelo");
        aluno.put("Idade", "10");
        aluno.put("Media", "Muito bom");
        aluno.put("Turma", "5º 5");

        aluno2.put("Nome", "Marcelinho");
        aluno2.put("Idade", "9");
        aluno2.put("Media", "Bom");
        aluno2.put("Turma", "4º B");

        /*System.out.println(aluno.entrySet());
        System.out.println(aluno.keySet());
        System.out.println(aluno.values());

        System.out.println(aluno2.entrySet());
        System.out.println(aluno2.keySet());
        System.out.println(aluno2.values());*/

        List<Map<String, String>> alunos = new ArrayList<>();
        alunos.add(aluno);
        alunos.add(aluno2);

        System.out.println(alunos);
    }
}
