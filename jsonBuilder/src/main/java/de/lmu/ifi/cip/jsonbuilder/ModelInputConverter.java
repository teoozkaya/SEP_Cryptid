package de.lmu.ifi.cip.jsonbuilder;

import com.google.gson.Gson;
import de.lmu.ifi.cip.jsonbuilder.modelinput.AbortGame;
import de.lmu.ifi.cip.jsonbuilder.modelinput.AskField;
import de.lmu.ifi.cip.jsonbuilder.modelinput.ModelInput;
import de.lmu.ifi.cip.jsonbuilder.modelinput.PlaceCube;
import de.lmu.ifi.cip.jsonbuilder.modelinput.PlaceDisc;
import de.lmu.ifi.cip.jsonbuilder.modelinput.RestartGame;
import de.lmu.ifi.cip.jsonbuilder.modelinput.SearchField;
import de.lmu.ifi.cip.jsonbuilder.modelinput.StartGame;
import java.util.Map;

/** This class has the required methods to transfer the model changes to the server. */
public class ModelInputConverter {

  private static final Gson gson = new Gson();

  private static Map<String, Class<? extends ModelInput>> map =
      Map.of(
          "StartGame", StartGame.class,
          "SearchField", SearchField.class,
          "RestartGame", RestartGame.class,
          "PlaceDisc", PlaceDisc.class,
          "PlaceCube", PlaceCube.class,
          "AskField", AskField.class,
          "AbortGame", AbortGame.class);

  private record ModelInputWrapper(String name, String json) {}

  public static String toJson(ModelInput modelInput) {
    return gson.toJson(new ModelInputWrapper(modelInput.getName(), gson.toJson(modelInput)));
  }

  public static ModelInput fromJson(String json) {
    ModelInputWrapper wrapper = gson.fromJson(json, ModelInputWrapper.class);
    return gson.fromJson(wrapper.json, map.get(wrapper.name));
  }
}
