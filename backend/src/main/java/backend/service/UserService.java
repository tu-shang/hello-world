package backend.service;

/**
 * Ein einfacher Service für Backend-Funktionen.
 * Die Methoden wurden so umgesetzt, dass sie gut mit Unit-Tests
 * geprüft werden können.
 */
public class UserService {

    /**
     * Gibt eine allgemeine Begrüssung zurück.
     *
     * @return Standard-Begrüssung
     */
    public String getWelcomeMessage() {
        return "Hallo Benutzer!";
    }

    /**
     * Gibt eine personalisierte Begrüssung zurück.
     * Bei leerem Namen wird die Standard-Begrüssung verwendet.
     *
     * @param name Name des Benutzers
     * @return Begrüssungstext
     */
    public String getPersonalWelcomeMessage(String name) {
        if (name == null || name.trim().isEmpty()) {
            return getWelcomeMessage();
        }

        return "Hallo " + name.trim() + "!";
    }

    /**
     * Erstellt eine kurze Zusammenfassung für eine Task.
     *
     * @param title Titel der Aufgabe
     * @param createdDate Erfassungsdatum als String
     * @return formatierte Zusammenfassung
     */
    public String createTaskSummary(String title, String createdDate) {
        validateTitle(title);
        validateCreatedDate(createdDate);

        return "Task: " + title.trim() + " | Erfasst am: " + createdDate.trim();
    }

    private void validateTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Titel darf nicht leer sein.");
        }
    }

    private void validateCreatedDate(String createdDate) {
        if (createdDate == null || createdDate.trim().isEmpty()) {
            throw new IllegalArgumentException("Erfassungsdatum darf nicht leer sein.");
        }
    }
}
