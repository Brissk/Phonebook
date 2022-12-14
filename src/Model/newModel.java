package Model;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import Model.Storage.Json;
import Model.Storage.MyCsv;
import Model.Storage.Storage;

public class newModel implements IModel {
    Phonebook pb1;
    Storage st;

    public newModel(String s) throws IOException {
        pb1 = new Phonebook(223);
        if (s == "json")
            st = new Json();
        else if (s == "csv")
            st = new MyCsv();
    }

    @Override
    public Phonebook fillPhonebook(String data) {

        ContactBuilder builder = new ContactBuilder();
        pb1.contacts.add(builder.setId(1).setName("Fedor").setPhoneNumber("88005553535").createContact());
        pb1.contacts.add(builder.setId(2).setName("Mike").setPhoneNumber("88005523535").createContact());
        pb1.contacts.add(builder.setId(3).setName("Nik").setPhoneNumber("88005551535").createContact());
        pb1.contacts.add(builder.setId(4).setName("Andrew").setPhoneNumber("88035553535").createContact());
        return pb1;
    }

    @Override
    public String getPhonebook() {
        return pb1.viewAll();
    }

    @Override
    public void myExport() throws IOException {
        st.myExport(pb1);
    }

    @Override
    public void myImport() throws ParseException, IOException {
        st.myImport(pb1);
    }

    @Override
    public ArrayList<Contact> getcontactList() {
        return pb1.contacts;
    }

}