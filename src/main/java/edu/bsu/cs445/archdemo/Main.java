package edu.bsu.cs445.archdemo;

import com.google.common.base.Preconditions;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.concurrent.CompletableFuture;

public class Main extends Application {

    private ArtifactRecordCollection collection;

    @Override
    public void start(Stage primaryStage) {
        createInitialScene(primaryStage);
        JaxbParser parser = JaxbParser.create();
        InputStream owsleyStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("owsley.xml");
        CompletableFuture.runAsync(() -> collection = parser.parse(owsleyStream))
                .thenRun(() -> Platform.runLater(() -> {
                            SearchPane searchPane = new SearchPane(collection);
                            Scene searchPaneScene = new Scene(searchPane);
                            primaryStage.setScene(searchPaneScene);
                        }
                ));
    }

    private void createInitialScene(Stage stage) {
        Parent root;
        try {
            URL url = getClass().getResource("loading.fxml");
            Preconditions.checkNotNull(url, "Cannot load fxml resource");
            root = FXMLLoader.load(url);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Scene scene = new Scene(root);
        stage.setTitle("Naive DOMA Search");
        stage.setScene(scene);
        stage.show();
    }
}
