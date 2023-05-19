package proj.ContactBook;

import javafx.application.Application;
import javafx.stage.Stage;

public class ContactBookController extends Application
{

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage stage)
    {
        ContactBookModel contactBookModel = new ContactBookModel();
        ContactBookView contactBookView = new ContactBookView(contactBookModel);
        contactBookView.createAndShowGUI(stage);
    }
}
