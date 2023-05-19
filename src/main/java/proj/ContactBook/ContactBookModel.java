package proj.ContactBook;

import proj.ContactBook.Contact;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ContactBookModel
{
    private final ObservableList<Contact> data = FXCollections.observableArrayList(
            new Contact("Whitney", "Baird", "5305101920", "66 Vine St. Gastonia, NC 28052", "stembo@snapboosting.com", "nhc8487@maill.dev"),
            new Contact("Madeleine", "Wallace", "7068817391", "674 Boston Dr. Hudsonville, MI 49426", "liz3070@bdredemptionservices.com", "wegadevil666@alertslit.top"),
            new Contact("Olin", "Snow", "9703683827", "9605 Sheffield Drive Indiana, PA 15701", "ramandeepsromi@postimel.com", "anf4187@yonaki.xyz"),
            new Contact("Nicholas", "Sanchez", "5820185022", "8263 School Road Summerfield, FL 34491", "dinarapsatarov@realedoewcenter.com", "muhammettm89@changaji.com"),
            new Contact("Manuela", "Bond", "6720840884", "9099 Grand St. Paramus, NJ 07652", "scales2669@quequeremos.com", "slp72004@sharkslasers.com"));


    public ObservableList<Contact> getData() {
        return data;
    }

    public void addPerson(Contact contact) {
        data.add(contact);
    }

    public void removePerson(Contact contact) {
        data.remove(contact);
    }

}
