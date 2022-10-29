import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import Model.newModel;
import UI.ConsoleView;


public class Program {
    public static void main(String[] args) throws IOException, IOException {
        Presenter p = new Presenter(new newModel(), new ConsoleView());
        p.button1Click(); // Заполнить телефонную книгу
        p.button2Click(); // Вывести телефонную книгу
        p.button3Click(); // Экспортировать телефонную книгу

    }
}
