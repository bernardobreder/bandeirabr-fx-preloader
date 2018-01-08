package jnlpfx;

import javafx.application.Application;
import javafx.application.Preloader.ProgressNotification;
import javafx.stage.Stage;

public class MyApplication extends Application {

  /**
   * {@inheritDoc}
   */
  @Override
  public void init() throws Exception {
    for (int n = 0; n <= 100; n++) {
      Thread.sleep(100);
      double value = n / 100.f;
      this.notifyPreloader(new ProgressNotification(value));
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void start(Stage stage) throws Exception {
    Class<?> loadClass = getClass().getClassLoader().loadClass(
      DesktopFrame.class.getName());
    Object frame = loadClass.newInstance();
    loadClass.getMethod("init").invoke(frame);
    loadClass.getMethod("start", Stage.class).invoke(frame, stage);
  }
}