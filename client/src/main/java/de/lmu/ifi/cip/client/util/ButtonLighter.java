package de.lmu.ifi.cip.client.util;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.Timer;

/** Class for ButtonLighter that makes buttons glow when mouse is on the button. */
public class ButtonLighter {
  /**
   * Function for creating mouse adapters.
   *
   * @param button Variable for buttons.
   * @return mouseAdapter
   */
  public static java.awt.event.MouseAdapter buttonLight(JButton button) {

    MouseAdapter mouseAdapter =
        new java.awt.event.MouseAdapter() {
          private final Color defaultColor = Color.getHSBColor(0.33f, 0.8f, 0.5f);
          private final Color hoverColor = new Color(255, 190, 0);
          private final int animationDelay = 10;
          private final int animationSteps = 10;
          private Timer timer;
          private float[] defaultHsb =
              Color.RGBtoHSB(
                  defaultColor.getRed(), defaultColor.getGreen(), defaultColor.getBlue(), null);
          private float[] hoverHsb =
              Color.RGBtoHSB(
                  hoverColor.getRed(), hoverColor.getGreen(), hoverColor.getBlue(), null);
          private float[] currentHsb = Arrays.copyOf(defaultHsb, 3);

          public void mouseEntered(java.awt.event.MouseEvent evt) {
            if (timer != null && timer.isRunning()) {
              timer.stop();
            }

            timer =
                new Timer(
                    animationDelay,
                    new ActionListener() {
                      int stepCount = 0;

                      @Override
                      public void actionPerformed(ActionEvent e) {
                        float[] newHsb = new float[3];
                        for (int i = 0; i < 3; i++) {
                          newHsb[i] =
                              interpolate(
                                  defaultHsb[i], hoverHsb[i], stepCount / (float) animationSteps);
                        }

                        currentHsb = newHsb;
                        button.setBackground(
                            Color.getHSBColor(currentHsb[0], currentHsb[1], currentHsb[2]));

                        stepCount++;
                        if (stepCount > animationSteps) {
                          ((Timer) e.getSource()).stop();
                        }
                      }
                    });

            timer.start();
          }

          public void mouseExited(java.awt.event.MouseEvent evt) {
            if (timer != null && timer.isRunning()) {
              timer.stop();
            }

            timer =
                new Timer(
                    animationDelay,
                    new ActionListener() {
                      int stepCount = animationSteps;

                      @Override
                      public void actionPerformed(ActionEvent e) {
                        float[] newHsb = new float[3];
                        for (int i = 0; i < 3; i++) {
                          newHsb[i] =
                              interpolate(
                                  hoverHsb[i], defaultHsb[i], stepCount / (float) animationSteps);
                        }

                        currentHsb = newHsb;
                        button.setBackground(
                            Color.getHSBColor(currentHsb[0], currentHsb[1], currentHsb[2]));

                        stepCount--;
                        if (stepCount < 0) {
                          ((Timer) e.getSource()).stop();
                          button.setBackground(defaultColor);
                        }
                      }
                    });

            timer.start();
          }

          private float interpolate(float start, float end, float fraction) {
            return start + (end - start) * fraction;
          }
        };
    return mouseAdapter;
  }
}
