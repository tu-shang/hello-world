# Hello World – TDD Backend Erweiterung

Dieses Projekt wurde für die SQ-Aufgabe mit **Test Driven Development (TDD)** erweitert.

## Projektstruktur

- `frontend/` enthält die einfache HTML-Seite
- `src/main/java/backend/` enthält den Backend-Code
- `src/test/java/backend/` enthält die Unit-Tests
- `docs/` enthält Dokumentation und Lernjournal

## Backend-Funktionalität

Die Klasse `UserService` bietet aktuell drei Funktionen:

1. `getWelcomeMessage()`
2. `getPersonalWelcomeMessage(String name)`
3. `createTaskSummary(String title, String createdDate)`

## Tests ausführen

Im Projektordner:

```bash
mvn test
```

Dadurch werden alle Tests aus `src/test/java/backend/DemoApplicationTest.java` ausgeführt.

## TDD-Idee

Die Aufgabe wurde nach dem Prinzip **Red → Green → Refactor** gelöst:

1. Test schreiben
2. Test schlägt fehl
3. Minimalen Code ergänzen
4. Code aufräumen


CI-Test Branch test-pipeline
