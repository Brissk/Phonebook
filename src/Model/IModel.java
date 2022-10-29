package Model;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

public interface IModel {
    public Phonebook fillPhonebook(String data);
    public String getPhonebook();
    public void myImport() throws ParseException, IOException;
    public void myExport() throws IOException;
    public ArrayList<Contact> getcontactList();
}