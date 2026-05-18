# Opdracht: Home automation

Beschouw de startcode (in `starter_code.py`). Het maakt deel uit van een implementatie van een nieuw domoticasysteem dat we ontwikkelen.

In deze applicatie kunnen we momenteel drie soorten apparaten toevoegen: `Lamp`, `Heating` en `WashingMachine`.

Deze drie klassen hebben een aantal zaken gemeen:

- fields:
  - `name`: de specifieke naam van het toestel
  - `location`: een `Location`-object dat aangeeft waar het apparaat zich in huis bevindt
  - `energy_consumption`: hoeveel watt dit apparaat verbruikt
- methods/properties:
  - `is_on`: geeft True terug als het toestel aan staat, anders False
  - `turn_on`: zet het toestel aan
  - `turn_off`: zet het toestel uit

Maar ze hebben ook enkele verschillen:

### Lamp

- Heeft een `brightness`-niveau (0–100).
- Bij inschakelen wordt de `brightness` ingesteld op 100.
- Bij uitschakelen wordt de `brightness` ingesteld op 0.

### Heating

- Heeft een `temperature`-instelling.
- Heeft een `preferred_temperature`-instelling, de standaardwaarde is 20 °C.
- Bij inschakelen wordt de `temperature` ingesteld op de waarde van de `preferred_temperature`.
- Bij uitschakelen wordt de `temperature` ingesteld op 0.

### WashingMachine

- Heeft een eenvoudige status `is_on` (True/False).
- Bij inschakelen wordt de `is_on` ingesteld op `True`.
- Bij uitschakelen wordt de `is_on` ingesteld op `False`.

## Kopieer de code

Maak een kopie van de startcode in `student.py`. Implementeer alle volgende vragen in dit bestand.

## Vraag 1: Refactor de code

Hoewel de apparaten specifiek gedrag vertonen, delen ze ook gemeenschappelijke kenmerken en methoden.

Maak een nieuwe abstracte klasse `Device` die als blauwdruk dient voor alle apparaattypen. Laat de bestaande apparaten van deze `Device`-klasse overerven. Deze gedeelde klasse moet alle functionaliteit bevatten die identiek is voor alle apparaten.

Waar van toepassing, gebruik abstracte methoden of properties om af te dwingen dat elke subklasse zijn eigen implementatie levert voor gedrag dat verschilt.

> Tip: In het bestand `example_usage.py` vind je voorbeeldgebruik van deze klassen. Gebruik dit voorbeeld om na te gaan of je wijzigingen de werking van de applicatie niet breken.

## Vraag 2: Het `HomeAutomation`-systeem

Maak een klasse `HomeAutomation` aan die alle apparaten bijhoudt die aan het systeem zijn toegevoegd.

Voeg hieraan ten minste de volgende methoden toe:
- `add_device(device)` – voegt een nieuw `Device`-object toe aan het systeem.
- `turn_on_all()` – schakelt alle apparaten in.
- `turn_off_all()` – schakelt alle apparaten uit.
- `get_status()` - geeft een string terug met informatie over alle `Device`-objecten in het systeem

## Question 3: Comparing devices

Wanneer we een exemplaar van een `Device`-object vergelijken met een ander `Device`-object, willen we het energieverbruik van beide apparaten vergelijken. Zorg ervoor dat je ten minste de volgende functionaliteiten implementeert:

```
kitchen = Location("kitchen", 0)
lamp1 = Lamp("lamp_1", kitchen, 100)
lamp2 = Lamp("lamp_2", kitchen, 100)

print(lamp1 > lamp2)
print(lamp1 < lamp2)
print(lamp1 == lamp2)
```

output:
```
False
False
True
```

## Vraag 4: Functies van hogere orde en lambda's

Breid de klasse HomeAutomation uit met de volgende methoden. Maak daarbij gebruik van **list comprehensions** en **lambda-expressies**:

- een methode `filter(self,condition)` voor de klasse `HomeAutomation` die een lijst retourneert met de `Device`-items, gefilterd op de gegeven `condition`.
- een methode `filter_by_location(self, location)` die een lijst retourneert met de `Device`-items, waarbij de locatie van het `Device`-item moet overeenkomen met de gegeven `location`. Maak hierin gebruik van de eerder gemaakte `filter(self,condition)`.
- een methode `filter_by_energy_consumption(self, energy_consumption)`, waarbij het energieverbruik van het `Device`-item gelijk aan of lager moet zijn dan het gegeven `energy_consumption`. Maak hierin gebruik van de eerder gemaakte `filter(self,condition)`.

## Vraag 5: testen

In het `tests.py`-bestand, schrijf tests voor de constructor van de klasse `Heating` die het volgende bevatten:
- minstens één succesvolle creatie van een `Heating`-object
- test alle mogelijke uitzonderingen met behulp van een geparametriseerde test.