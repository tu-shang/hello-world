# Lernjournal – TDD Backend Aufgabe

## Ausgangslage
Das bestehende Projekt enthielt bereits ein einfaches Frontend und ein kleines
Backend, aber noch keine Teststruktur. Ziel dieser Aufgabe war es, das Backend
mit Test Driven Development weiterzuentwickeln.

## Vorgehen
Zuerst wurde das Projekt in eine Maven-Struktur überführt. Danach wurde mit
JUnit 5 eine Testklasse erstellt, damit alle Tests mit `mvn test` ausgeführt
werden können.

Anschliessend wurde zuerst ein Test für bestehendes Verhalten geschrieben.
Danach wurde nach TDD ein neuer Test für eine neue Funktionalität erstellt.
Dieser Test hätte ohne Implementierung nicht bestanden.

Nach dem Schreiben des Tests wurde der Produktivcode so erweitert, dass sowohl
die bisherigen als auch die neuen Tests erfolgreich sind.

Zum Schluss wurde der Code aufgeräumt und durch Kommentare verständlicher
gemacht. Zusätzlich wurden sinnvolle Validierungen eingebaut.

## Was ich gelernt habe
Ich habe gelernt, dass TDD nicht bedeutet, einfach nur Tests nachträglich
hinzuzufügen, sondern dass zuerst das gewünschte Verhalten als Test beschrieben
wird. Erst danach wird der Code implementiert.

Ausserdem habe ich gelernt, wie man:
- JUnit 5 in ein Maven-Projekt integriert
- Tests mit `mvn test` ausführt
- positives und negatives Verhalten testet
- Code nach dem Bestehen der Tests refaktoriert

## Fazit
Durch die Tests ist das Backend robuster geworden. Fehler können schneller
erkannt werden, und Änderungen lassen sich sicherer durchführen.
