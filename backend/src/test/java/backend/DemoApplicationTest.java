package backend;

import backend.service.UserService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Alle Tests werden über diese Testklasse mit einem einzigen Aufruf
 * durch Maven gestartet.
 */
public class DemoApplicationTest {

    private final UserService userService = new UserService();

    /**
     * Schritt 1 der Aufgabe:
     * Ein Test für bestehendes Verhalten.
     */
    @Test
    void shouldReturnDefaultWelcomeMessage() {
        assertEquals("Hallo Benutzer!", userService.getWelcomeMessage());
    }

    /**
     * Schritt 2/3 der Aufgabe:
     * Neuer Test für eine neue Funktionalität.
     * Dieser Test wäre zuerst fehlgeschlagen, solange die Methode
     * getPersonalWelcomeMessage(...) noch nicht implementiert war.
     */
    @Test
    void shouldReturnPersonalWelcomeMessage() {
        assertEquals("Hallo Dusan!", userService.getPersonalWelcomeMessage("Dusan"));
    }

    /**
     * Zusätzliche sinnvolle Erweiterung:
     * Eine Task-Zusammenfassung mit Titel und Erfassungsdatum.
     */
    @Test
    void shouldCreateTaskSummaryWithTitleAndDate() {
        String result = userService.createTaskSummary("Backend erweitern", "2025-01-15");

        assertEquals("Task: Backend erweitern | Erfasst am: 2025-01-15", result);
    }

    /**
     * Negativtest:
     * Leerer Titel ist ungültig und muss eine Exception auslösen.
     */
    @Test
    void shouldThrowExceptionWhenTaskTitleIsEmpty() {
        assertThrows(IllegalArgumentException.class,
                () -> userService.createTaskSummary("", "2025-01-15"));
    }
}
