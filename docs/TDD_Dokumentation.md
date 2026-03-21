# Dokumentation der Schritte

## 1. Projekt für Unit-Tests vorbereitet
Zuerst wurde das bestehende Projekt in eine saubere Maven-Struktur überführt.  
Dafür wurden `src/main/java` und `src/test/java` erstellt sowie eine `pom.xml`
mit JUnit 5 ergänzt.

## 2. Bestehendes Verhalten getestet
Als erster Test wurde geprüft, ob der Service die Standard-Begrüssung
`Hallo Benutzer!` zurückgibt. Dieser Test beschreibt bereits vorhandenes
oder erwartetes Grundverhalten.

## 3. Neues Verhalten per TDD ergänzt
Danach wurde ein neuer Test für eine personalisierte Begrüssung geschrieben:
`getPersonalWelcomeMessage("Dusan")` soll `Hallo Dusan!` zurückgeben.

Dieser Test wäre vor der Implementierung fehlgeschlagen. Anschliessend wurde
der Code mit minimalem Aufwand ergänzt, bis der Test bestanden hat.

## 4. Zweite sinnvolle Erweiterung
Zusätzlich wurde eine Methode `createTaskSummary(...)` eingeführt.
Sie erstellt eine formatierte Zusammenfassung mit Titel und Erfassungsdatum.

Dafür wurden ebenfalls Tests geschrieben:
- erfolgreicher Fall
- ungültiger Fall mit leerem Titel

## 5. Refactoring
Der Code wurde anschliessend aufgeräumt:
- sprechende Methodennamen
- kleine private Validierungsmethoden
- Kommentare für bessere Verständlichkeit

## 6. Testdurchlauf
Alle Tests können mit einem einzigen Befehl ausgeführt werden:

```bash
mvn test
```

Alle Tests liegen in:
`src/test/java/backend/DemoApplicationTest.java`

## 7. Git / GitLab oder GitHub aktualisieren
Vor dem Push sollte zuerst der aktuelle Stand geholt werden:

```bash
git checkout main
git pull
```

Dann auf eigenem Branch arbeiten:

```bash
git checkout -b feature/tdd-backend-extension
```

Danach Änderungen committen und pushen:

```bash
git add .
git commit -m "Add TDD tests and backend service extension"
git push -u origin feature/tdd-backend-extension
```

Wenn andere Teammitglieder fast dieselben Änderungen gemacht haben:
- zuerst `git pull`
- Konflikte prüfen
- Änderungen sinnvoll zusammenführen
- erst danach wieder pushen

## 8. Ergebnis
Das Backend wurde funktional erweitert und gleichzeitig testbar gemacht.
Die Aufgabe erfüllt damit:
- Unit-Tests vorhanden
- TDD angewendet
- alle Tests laufen mit einem Klick bzw. einem Maven-Aufruf
- Code bleibt verständlich und einfach
