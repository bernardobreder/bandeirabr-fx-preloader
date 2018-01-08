package jnlpfx;

import com.sun.javafx.application.LauncherImpl;

public class Main {

  public static void main(String[] args) {
    LauncherImpl.launchApplication(MyApplication.class, MyPreloader.class,
      args);
  }

}
