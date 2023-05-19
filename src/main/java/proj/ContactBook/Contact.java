package proj.ContactBook;

import javafx.beans.property.SimpleStringProperty;

public class Contact
{
    private final SimpleStringProperty firstName = new SimpleStringProperty("");
    private final SimpleStringProperty lastName = new SimpleStringProperty("");
    private final SimpleStringProperty phoneCell = new SimpleStringProperty("");
    private final SimpleStringProperty address = new SimpleStringProperty("");
    private final SimpleStringProperty emailPrimary = new SimpleStringProperty("");
    private final SimpleStringProperty emailSecondary = new SimpleStringProperty("");

    public Contact ()
    {
        this("", "", "", "","", "");
    }

    public Contact (String firstName, String lastName, String phoneCell, String address, String emailPrimary, String emailSecondary)
    {
        setFirstName(firstName);
        setLastName(lastName);
        setPhoneCell(phoneCell);
        setAddress(address);
        setEmailPrimary(emailPrimary);
        setEmailSecondary(emailSecondary);
    }

    public String getFirstName()
    {
        return firstName.get();
    }
    public void setFirstName(String fName)
    {
        firstName.set(fName);
    }

    public String getLastName()
    {
        return lastName.get();
    }
    public void setLastName(String lName)
    {
        lastName.set(lName);
    }

    public String getPhoneCell()
    {
        return phoneCell.get();
    }
    public void setPhoneCell(String phoneNum)
    {
        phoneCell.set(phoneNum);
    }

    public String getAddress()
    {
        return address.get();
    }
    public void setAddress(String add)
    {
        address.set(add);
    }

    public String getEmailPrimary()
    {
        return emailPrimary.get();
    }
    public void setEmailPrimary(String pEmail)
    {
        emailPrimary.set(pEmail);
    }

    public String getEmailSecondary()
    {
        return emailSecondary.get();
    }
    public void setEmailSecondary(String sEmail)
    {
        emailSecondary.set(sEmail);
    }
}
