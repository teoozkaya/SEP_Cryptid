package de.lmu.ifi.cip.jsonbuilder;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.typeadapters.RuntimeTypeAdapterFactory;
import de.lmu.ifi.cip.model.Cube;
import de.lmu.ifi.cip.model.Disc;
import de.lmu.ifi.cip.model.Placeable;
import de.lmu.ifi.cip.model.events.GameEvent;
import de.lmu.ifi.cip.model.events.GameForfeitEvent;
import de.lmu.ifi.cip.model.events.GameLoseEvent;
import de.lmu.ifi.cip.model.events.GameStartEvent;
import de.lmu.ifi.cip.model.events.GameWonEvent;
import de.lmu.ifi.cip.model.events.HintEvent;
import de.lmu.ifi.cip.model.events.ItemPlacedEvent;
import de.lmu.ifi.cip.model.events.PlayerChangeAnswerEvent;
import de.lmu.ifi.cip.model.events.PlayerChangeEvent;
import de.lmu.ifi.cip.model.events.PlayerChangeReactionEvent;
import de.lmu.ifi.cip.model.events.WrongMoveEvent;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** this class implements the main class for the jsonBuilder. */
public class JsonBuilder {

  static final RuntimeTypeAdapterFactory<Placeable> typeFactory =
      RuntimeTypeAdapterFactory.of(Placeable.class)
          .registerSubtype(Disc.class)
          .registerSubtype(Cube.class);
  private static final Gson gson =
      new GsonBuilder().registerTypeAdapterFactory(typeFactory).create();

  private static final List<Class<? extends GameEvent>> eventList =
      List.of(
          GameForfeitEvent.class,
          GameLoseEvent.class,
          GameStartEvent.class,
          GameWonEvent.class,
          ItemPlacedEvent.class,
          PlayerChangeAnswerEvent.class,
          PlayerChangeEvent.class,
          PlayerChangeReactionEvent.class,
          HintEvent.class,
          WrongMoveEvent.class);

  // Finally , maps the name of an event to the event class
  static final Map<String, Class<? extends GameEvent>> NAME_TO_CLASS;

  static {
    // Here the map is built
    NAME_TO_CLASS = new HashMap<>();
    eventList.forEach(clazz -> NAME_TO_CLASS.put(clazz.getSimpleName(), clazz));
  }

  // This is where the map is built
  private record GameEventWrapper(String name, String json) {}

  public static String toJson(GameEvent gameEvent) {
    return gson.toJson(new GameEventWrapper(gameEvent.getName(), gson.toJson(gameEvent)));
  }

  public static GameEvent fromJson(String json) {
    GameEventWrapper wrapper = gson.fromJson(json, GameEventWrapper.class);
    return gson.fromJson(wrapper.json, NAME_TO_CLASS.get(wrapper.name));
  }
}
