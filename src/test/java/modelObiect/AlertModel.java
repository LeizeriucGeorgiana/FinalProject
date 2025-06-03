package modelObiect;
import io.qameta.allure.internal.shadowed.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class AlertModel {

    private String prompValue;
    public String getPrompValue() {
        return prompValue;
    }
    public void setPrompValue(String prompValue) {this.prompValue = prompValue;}
    //Constructorul citește fișierul JSON specificat de calea jsonFilePath și va  popula automat obiectul PracticeFormModel cu valorile din fișier.
    //Utilizarea readerForUpdating() permite ca obiectul curent (this) să fie actualizat, în loc să creeze un obiect complet nou.
    //readValue(new File(jsonFilePath)): este metoda care efectiv citește fișierul JSON și îl deserializa într-un obiect Java.
    // În acest caz, fișierul JSON este specificat de calea jsonFilePath, care este transformată într-un obiect File (prin new File(jsonFilePath)).

    public AlertModel(String jsonFilePath){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.readerForUpdating(this).readValue(new File(jsonFilePath));
        } catch (IOException e) {
            throw new RuntimeException("Failed to load JSON file: " + jsonFilePath, e);
        }
    }


}

