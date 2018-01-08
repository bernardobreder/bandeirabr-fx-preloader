package jnlpfx;

import javafx.application.Preloader;
import javafx.application.Preloader.StateChangeNotification.Type;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

// https://blog.codecentric.de/en/2015/09/javafx-how-to-easily-implement-application-preloader-2/
public class MyPreloader extends Preloader {

  private Stage stage;

  private ProgressBar bar;

  /**
   * {@inheritDoc}
   */
  @Override
  public void init() throws Exception {
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void start(Stage stage) throws Exception {
    this.stage = stage;

    VBox loading = new VBox(20);
    loading.setMaxWidth(Region.USE_PREF_SIZE);
    loading.setMaxHeight(Region.USE_PREF_SIZE);
    loading.getChildren().add(bar = new ProgressBar(0.0));
    loading.getChildren().add(new Label("Please wait..."));

    BorderPane root = new BorderPane(loading);
    Scene scene = new Scene(root);

    stage.setWidth(200);
    stage.setHeight(100);
    stage.setScene(scene);
    stage.show();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void handleApplicationNotification(PreloaderNotification info) {
    if (info instanceof ProgressNotification) {
      ProgressNotification notification = (ProgressNotification) info;
      bar.setProgress(notification.getProgress());
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void handleStateChangeNotification(StateChangeNotification state) {
    if (state.getType() == Type.BEFORE_LOAD) {
    }
    else if (state.getType() == Type.BEFORE_INIT) {
    }
    else if (state.getType() == Type.BEFORE_START) {
      stage.close();
    }
  }
}