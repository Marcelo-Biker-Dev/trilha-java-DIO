import com.treinamento.bootcamp.Bootcamp;
import com.treinamento.bootcamp.Curso;
import com.treinamento.bootcamp.Dev;
import com.treinamento.bootcamp.Mentoria;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Curso curso1 = new Curso();
        curso1.setTitulo("curso Java básico");
        curso1.setDescricao("Aprenda conceitos de programação com a linguagem Java");
        curso1.setCargaHoraria(8);

        Curso curso2 = new Curso();
        curso2.setTitulo("curso Java intermediário");
        curso2.setDescricao("Aprenda a utilizar as coleções Java e a tratar as Exceptions");
        curso2.setCargaHoraria(4);

        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo("mentoria de Java");
        mentoria.setDescricao("Aprenda na prática conceitos avançados de programação Java");
        mentoria.setData(LocalDate.now());

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Java Developer");
        bootcamp.setDescricao("Desenvolva habilidades de programação Web com a linguagem Java");
        bootcamp.getConteudos().add(curso1);
        bootcamp.getConteudos().add(curso2);
        bootcamp.getConteudos().add(mentoria);

        Dev dev1 = new Dev();
        dev1.setNome("Chico");
        dev1.inscreverBootcamp(bootcamp);
        System.out.println(dev1.getNome() + " está inscrito em: " + dev1.getConteudosInscritos());
        //dev1.progredir();
        //dev1.progredir();
        //System.out.println("-");
        //System.out.println(dev1.getNome() + " está inscrito em: " + dev1.getConteudosInscritos());
        System.out.println(dev1.getNome() + " está inscrito em: " + dev1.getConteudosConcluidos());
        System.out.println("XP:" + dev1.calcularTotalXp());

        System.out.println("=====*=====*=====*=====*=====");

        Dev dev2 = new Dev();
        dev2.setNome("Tião");
        dev2.inscreverBootcamp(bootcamp);
        System.out.println(dev2.getNome() + " está inscrito em: "  + dev2.getConteudosInscritos());
        dev2.progredir();
        dev2.progredir();
        dev2.progredir();
        System.out.println("-");
        System.out.println(dev2.getNome() + " está inscrito em: " + dev2.getConteudosInscritos());
        System.out.println(dev2.getNome() + " está inscrito em: " + dev2.getConteudosConcluidos());
        System.out.println("XP:" + dev2.calcularTotalXp());

    }

}
