package edu.bsu.cs445.archdemo;

import com.google.common.base.Preconditions;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.List;

public class SearchPane extends VBox {

    @FXML
    @SuppressWarnings("unused") // This field is used by FXML, so suppress the warning
    private TextField searchField;

    @FXML
    @SuppressWarnings("unused") // This field is used by FXML, so suppress the warning
    private Button searchButton;

    @FXML
    @SuppressWarnings("unused") // This field is used by FXML, so suppress the warning
    private Label resultCount;

    @FXML
    @SuppressWarnings("unused") // This field is used by FXML, so suppress the warning
    private HBox searchHBox;

    @FXML
    @SuppressWarnings("unused") // This field is used by FXML, so suppress the warning
    private VBox resultBox;

    private final ArtifactRecordCollection collection;

    SearchPane(ArtifactRecordCollection collection) {
        this.collection = Preconditions.checkNotNull(collection);
        URL fxmlUrl = getClass().getResource("searchPane.fxml");
        Preconditions.checkNotNull(fxmlUrl, "Fxml asset location is not specified correctly.");
        FXMLLoader loader = new FXMLLoader(fxmlUrl);
        loader.setRoot(this);
        loader.setController(this);
        try {
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @SuppressWarnings("unused") // This method is actually used via searchPane.fxml.
    @FXML
    public void search() {
        Preconditions.checkNotNull(collection, "The collection should already be in memory");
        searchHBox.setDisable(true);
        String searchTerm = searchField.getText();
        List<ArtifactRecord> records = collection.searchTitles(searchTerm);
        resultBox.getChildren().clear();
        if (records.size() > 0) {
            ArtifactRecord record = records.get(0);
            resultBox.getChildren().add(new ArtifactView(record));
        }
        resultCount.setText(String.valueOf(records.size()));
        searchHBox.setDisable(false);
    }

}
