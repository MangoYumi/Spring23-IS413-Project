package proj.ContactBook;

import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ContactBookView {
    private final ContactBookModel contactBook;
    private final TableView<Contact> table = new TableView<>();

    public ContactBookView(ContactBookModel contactBook) {
        this.contactBook = contactBook;
    }

    public void createAndShowGUI(Stage stage) {
        Scene scene = new Scene(new Group());

        // implementation of stylesheet
        scene.getStylesheets().add(getClass().getResource("DarkTheme.css").toExternalForm());

        stage.setTitle("IS413 Project Contact Book");
        stage.setWidth(1000);
        stage.setHeight(600);

        final Label label = new Label("Contact Book");
        label.setFont(new Font("Arial", 20));

        table.setEditable(true);

        TableColumn<Contact, String> fName = new TableColumn<>("First Name");
        fName.setMinWidth(100);
        fName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        fName.setCellFactory(TextFieldTableCell.forTableColumn());
        fName.setOnEditCommit(event ->
                event.getTableView().getItems().get(event.getTablePosition().getRow())
                        .setFirstName(event.getNewValue())
        );

        TableColumn<Contact, String> lName = new TableColumn<>("Last Name");
        lName.setMinWidth(100);
        lName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        lName.setCellFactory(TextFieldTableCell.forTableColumn());
        lName.setOnEditCommit(event ->
                event.getTableView().getItems().get(event.getTablePosition().getRow())
                        .setLastName(event.getNewValue())
        );

        TableColumn<Contact, String> phnCell = new TableColumn<>("Contact Number");
        phnCell.setMinWidth(100);
        phnCell.setCellValueFactory(new PropertyValueFactory<>("phoneCell"));
        phnCell.setCellFactory(TextFieldTableCell.forTableColumn());
        phnCell.setOnEditCommit(event ->
                event.getTableView().getItems().get(event.getTablePosition().getRow())
                        .setPhoneCell(event.getNewValue())
        );

        TableColumn<Contact, String> conAdd = new TableColumn<>("Contact Address");
        conAdd.setMinWidth(100);
        conAdd.setCellValueFactory(new PropertyValueFactory<>("address"));
        conAdd.setCellFactory(TextFieldTableCell.forTableColumn());
        conAdd.setOnEditCommit(event ->
                event.getTableView().getItems().get(event.getTablePosition().getRow())
                        .setAddress(event.getNewValue())
        );

        TableColumn<Contact, String> primaryEmail = new TableColumn<>("Primary Email");
        primaryEmail.setMinWidth(200);
        primaryEmail.setCellValueFactory(new PropertyValueFactory<>("emailPrimary"));
        primaryEmail.setCellFactory(TextFieldTableCell.forTableColumn());
        primaryEmail.setOnEditCommit(event ->
                event.getTableView().getItems().get(event.getTablePosition().getRow())
                        .setEmailPrimary(event.getNewValue())
        );

        TableColumn<Contact, String> secondaryEmail = new TableColumn<>("Secondary Email");
        secondaryEmail.setMinWidth(200);
        secondaryEmail.setCellValueFactory(new PropertyValueFactory<>("emailSecondary"));
        secondaryEmail.setCellFactory(TextFieldTableCell.forTableColumn());
        secondaryEmail.setOnEditCommit(event ->
                event.getTableView().getItems().get(event.getTablePosition().getRow())
                        .setEmailSecondary(event.getNewValue())
        );

        table.setItems(contactBook.getData());
        table.getColumns().addAll(fName, lName, phnCell, conAdd, primaryEmail, secondaryEmail);

        final TextField addFName = new TextField();
        addFName.setPromptText("First Name");
        addFName.setMaxWidth(fName.getPrefWidth() + 15);

        final TextField addLName = new TextField();
        addLName.setPromptText("Last Name");
        addLName.setMaxWidth(lName.getPrefWidth() + 15);

        final TextField addConNum = new TextField();
        addConNum.setMaxWidth(phnCell.getPrefWidth() + 28);
        addConNum.setPromptText("Phone Number");

        final TextField addConAdd = new TextField();
        addConAdd.setMaxWidth(conAdd.getPrefWidth() + 28);
        addConAdd.setPromptText("Address");

        final TextField addPrimaryEmail = new TextField();
        addPrimaryEmail.setMaxWidth(primaryEmail.getPrefWidth() + 15);
        addPrimaryEmail.setPromptText("Primary Email");

        final TextField addSecondaryEmail = new TextField();
        addSecondaryEmail.setMaxWidth(secondaryEmail.getPrefWidth() + 28);
        addSecondaryEmail.setPromptText("Secondary Email");

        final Button addButton = new Button("Add");
        addButton.setOnAction(e -> {
            contactBook.addPerson(new Contact(
                    addFName.getText(),
                    addLName.getText(),
                    addConNum.getText(),
                    addConAdd.getText(),
                    addPrimaryEmail.getText(),
                    addSecondaryEmail.getText()));

                    addFName.clear();
                    addLName.clear();
                    addConNum.clear();
                    addConAdd.clear();
                    addPrimaryEmail.clear();
                    addSecondaryEmail.clear();
        });

        final Button deleteButton = new Button("Delete");
        deleteButton.setOnAction(e -> {
            Contact selectedContact = table.getSelectionModel().getSelectedItem();
            if (selectedContact != null) {
                contactBook.removePerson(selectedContact);
            }
        });

        HBox hb = new HBox(addFName, addLName, addConNum, addConAdd, addPrimaryEmail, addSecondaryEmail, addButton, deleteButton);
        hb.setSpacing(3);

        VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table, hb);

        ((Group) scene.getRoot()).getChildren().addAll(vbox);

        stage.setScene(scene);
        stage.show();
    }
}
