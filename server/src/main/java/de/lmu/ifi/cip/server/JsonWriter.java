package de.lmu.ifi.cip.server;

import de.lmu.ifi.cip.jsonbuilder.JsonBuilder;
import de.lmu.ifi.cip.model.events.GameEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.SwingUtilities;

/**
 * This class receives the outgoing model communication, handles the conversion to Json and
 * initiates the sending operation.
 */
public class JsonWriter implements PropertyChangeListener {
  private PlayerHandler playerHandler;

  public JsonWriter(PlayerHandler playerHandler) {
    this.playerHandler = playerHandler;
  }

  @Override
  public void propertyChange(PropertyChangeEvent event) {
    SwingUtilities.invokeLater(
        new Runnable() {
          @Override
          public void run() {
            handleModelUpdate(event);
          }
        });
  }

  private void handleModelUpdate(PropertyChangeEvent event) {
    Object changeEvent = event.getNewValue();
    if (changeEvent instanceof GameEvent gameEvent) {
      playerHandler.broadcast(JsonBuilder.toJson(gameEvent), gameEvent.getPlayerIds());
    }
  }
}
