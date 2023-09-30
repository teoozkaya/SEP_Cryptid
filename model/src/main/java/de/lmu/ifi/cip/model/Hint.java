package de.lmu.ifi.cip.model;

import java.util.ArrayList;
import java.util.List;

/** Represents a hint in a game. */
public class Hint {
  private final List<String> hints;
  private String content;

  /**
   * Constructs a de.lmu.ifi.cip.model.Hint object with the given content.
   *
   * @param content The content of the hint.
   */
  public Hint(String content) {
    hints = new ArrayList<>();
    this.content = content;
    hints.add(("in der Wüste oder im Sumpf"));
    hints.add(("im Umkreis von 2 Feldern um ein Pumaterritorium"));
    hints.add(("im Umkreis von 3 Feldern um eine blaue Struktur"));
    hints.add(("nicht im Wald oder Sumpf"));
    hints.add(("im Umkreis von 3 Feldern um eine grüne Struktur"));
    hints.add(("im Umkreis von einem Feld um Wüste"));
    hints.add(("nicht in der Wüste oder im Sumpf"));
    hints.add(("im Wald oder Sumpf"));
    hints.add(("nicht im Wasser oder Sumpf"));
    hints.add(("nicht im Umkreis von 3 Feldern um eine schwarze Struktur"));
    hints.add(("im Umkreis von 2 Feldern um eine verlassene Hütte"));
    hints.add(("nicht im Umkreis von einem Feld um Wüste"));
    hints.add(("im Wald oder Wasser"));
    hints.add(("nicht im Umkreis von 3 Feldern um eine weiße Struktur"));
    hints.add(("nicht im Umkreis von einem Feld um ein Territorium"));
    hints.add(("im Umkreis von 2 Feldern um ein Bärenterritorium"));
    hints.add(("im Umkreis von einem Feld um Wasser"));
    hints.add(("nicht im Sumpf oder Gebirge"));
    hints.add(("im Umkreis von einem Feld um Gebirge"));
    hints.add(("nicht im Umkreis von einem Feld um Sumpf"));
    hints.add(("im Umkreis von 3 Feldern um eine schwarze Struktur"));
    hints.add(("nicht im Umkreis von 3 Feldern um eine grüne Struktur"));
    hints.add(("nicht im Wald oder in der Wüste"));
    hints.add(("im Umkreis von einem Feld um Sumpf"));
    hints.add(("nicht im Wald oder Gebirge"));
    hints.add(("nicht im Umkreis von 2 Feldern um ein Bärenterritorium"));
    hints.add(("im Wald oder Gebirge"));
    hints.add(("im Sumpf oder Gebirge"));
    hints.add(("nicht im Umkreis von 2 Feldern um ein Pumaterritorium"));
    hints.add(("nicht im Umkreis von 2 Feldern um einen Hinkelstein"));
    hints.add(("im Wasser oder Sumpf"));
    hints.add(("in der Wüste oder im Wasser"));
    hints.add(("im Umkreis von 2 Feldern um einen Hinkelstein"));
    hints.add(("im Wasser oder Gebirge"));
    hints.add(("nicht im Umkreis von 2 Feldern um eine verlassene Hütte"));
    hints.add(("nicht im Umkreis von einem Feld um Gebirge"));
    hints.add(("nicht in der Wüste oder im Gebirge"));
    hints.add(("im Umkreis von einem Feld um Wald"));
    hints.add(("im Umkreis von einem Feld um ein Territorium"));
    hints.add(("in der Wüste oder im Gebirge"));
    hints.add(("nicht in der Wüste oder im Wasser"));
    hints.add(("nicht im Umkreis von einem Feld um Wald"));
    hints.add(("nicht im Umkreis von 3 Feldern um eine blaue Struktur"));
    hints.add(("im Umkreis von 3 Feldern um eine weiße Struktur"));
    hints.add(("nicht im Umkreis von einem Feld um Wasser"));
    hints.add(("im Wald oder in der Wüste"));
    hints.add(("nicht im Wasser oder Gebirge"));
    hints.add(("nicht im Wald oder Wasser"));
  }

  /**
   * Returns the hint at the specified index.
   *
   * @param hintId The index of the hint.
   * @return The hint at the specified index.
   */
  public String getHint(int hintId) {
    return hints.get(hintId);
  }

  public String getHint() {
    return content;
  }
}
