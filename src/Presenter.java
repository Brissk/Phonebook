import java.io.IOException;

import Model.*;
import UI.*;

public class Presenter {
    IModel m;
    IView v;

    public Presenter(IModel m, IView v)   {
        this.m = m;
        this.v = v;
    }

    public void button1Click() {
        m.fillPhonebook(v.getData());
    }

    public void button2Click() {
        v.printPhonebook(m.getPhonebook());
    }

    /**
     * Export data
     * @throws IOException
     */
    public void button3Click() throws IOException {
        m.myExport();
    }

    public void button4Click() throws IOException {
//        m.myImport();
    }
}