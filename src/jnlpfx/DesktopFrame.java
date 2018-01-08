package jnlpfx;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TreeItem;
import javafx.stage.Stage;

public class DesktopFrame extends Application {

  /**
   * {@inheritDoc}
   */
  @Override
  public void start(Stage stage) throws Exception {
    Scene scene = new Scene(createRoot(), 1000, 700);
    stage.setTitle("Example");
    stage.setScene(scene);
    stage.show();
  }

  private Parent createRoot() {
    SplitPane pane = new SplitPane();
    pane.getItems().add(new TextArea());
    pane.getItems().add(new TextArea());
    return pane;
  }

}
