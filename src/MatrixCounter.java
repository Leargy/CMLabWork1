import instructions.ConsoleRead;
import instructions.FileRead;
import service.ConsolePrompter;
import service.Invoker;
import service.TotalCommander;


public class MatrixCounter {
    private static TotalCommander totalCommander = new TotalCommander();
    private static Invoker invoker = new ConsolePrompter(System.out, System.in);

    static {
        invoker.setCommand(FileRead.NAME, new FileRead(totalCommander));
        invoker.setCommand(ConsoleRead.NAME, new ConsoleRead(totalCommander));
    }


    public static void main(String[] args) {

        System.out.println("Доступные команды: \n" + FileRead.NAME + ", " + ConsoleRead.NAME + ", exit\n");

        System.out.println("Шаблон заполнения файла и/или консольного ввода:");

        System.out.println("n e M");
        System.out.println("X11 X12 Xn B1\nXn1 Xn2 Xnn Bn");

        while (true) {

            invoker.scan();
//            while (invoker.scan());
        }
    }
}