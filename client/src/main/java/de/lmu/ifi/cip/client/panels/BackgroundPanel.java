package de.lmu.ifi.cip.client.panels;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.Image;
import javax.swing.JPanel;

/** BackgroundPanel creates a panel for the background images of the game. */
public class BackgroundPanel extends JPanel {

  private Image background;

  public BackgroundPanel(Image background) {
    this.background = background;
    setLayout(new GridBagLayout());
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    // g.drawImage(background, 0, 0, null); // image full size
    g.drawImage(background, 0, 0, getWidth(), getHeight(), null); // image scaled
  }

  @Override
  public Dimension getPreferredSize() {
    return new Dimension(background.getWidth(this), background.getHeight(this));
  }
}
