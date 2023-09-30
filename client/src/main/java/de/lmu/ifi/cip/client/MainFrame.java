package de.lmu.ifi.cip.client;

import de.lmu.ifi.cip.client.panels.BuildPanel;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/** Creates a Main Frame, which the different Panels can register during runtime. */
public class MainFrame {
  /**
   * An enum that represents the names of the different panels that can be invoked during the game.
   */
  public enum PanelName {
    BUILD,
    CREATION,
    GAME,
    RULES,
    LOBBY
  }

  private final Set<PanelName> alreadyCreatedPanels;
  private final JFrame frame;
  private final CardLayout cardLayout;

  private static MainFrame instance;

  private MainFrame() {
    alreadyCreatedPanels = new HashSet<>();
    frame = new JFrame("Cryptid");

    cardLayout = new CardLayout();

    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    Dimension minimumSize = new Dimension(1210, 737);
    frame.setMinimumSize(minimumSize);
    frame.setResizable(true);
    frame.setSize(960, 540);
    frame.addWindowListener(
        new WindowAdapter() {
          @Override
          public void windowClosed(WindowEvent e) {
            super.windowClosed(e);
            System.exit(0);
          }
        });

    frame.setContentPane(new JPanel(cardLayout));
    frame.add(new BuildPanel(), PanelName.BUILD.name());
    alreadyCreatedPanels.add(PanelName.BUILD);
    try {
      UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
    } catch (Exception e) {
      e.printStackTrace();
    }
    frame.setVisible(true);
  }

  /**
   * method that gets an instance of the MainFrame. If there is currently no instance a new instance
   * is created
   *
   * @return an instance of the MainFrame
   */
  public static MainFrame getInstance() {
    if (instance == null) {
      instance = new MainFrame();
    }
    return instance;
  }

  public static JFrame getFrame() {
    return getInstance().frame;
  }

  /**
   * Registers a new panel with the given name. Be aware that registering a new panel with the same
   * name as an old panel will override the old panel. This method will always execute in the Swing
   * Main Thread.
   *
   * @param panel {@link PanelName} of the new panel
   * @param jpanel the new {@link JPanel}
   */
  public static void register(PanelName panel, JPanel jpanel) {
    SwingUtilities.invokeLater(
        () -> {
          getFrame().add(jpanel, panel.name());
          instance.alreadyCreatedPanels.add(panel);
        });
  }

  /**
   * Switches to an already registered (see {@link #register(PanelName, JPanel)}) JPanel. This
   * method will silently fail if no panel is available with the given {@link PanelName}. It will
   * always execute in the Swing Main Thread.
   *
   * @param panel {@link PanelName} of the to be shown JPanel
   */
  public static void switchTo(PanelName panel) {
    SwingUtilities.invokeLater(
        () -> {
          getInstance().cardLayout.show(getFrame().getContentPane(), panel.name());
        });
  }
}
