# TAKE
Projekt TAKE

Projekt dzieli sie na trzy czesci:

	1. client		Projekt z aplikacja klienta
	2. dbconnection	Projekt z polaczeniem z baza
	3. restapi		Projekt z API 
	
Projekt (1) zajmuje sie aplikacja klienta, czyli frontend albo jakas aplikacja w swingu z javy ktora ladnie przedstawia dane i pozwala sie klientowi wygodnie porozumiewac z baza.

Projekt (2) zajmuje sie polaczeniem z baza danych. Wszystkie sprawy zwiazane z baza, ich tworzeniem i zarzadzaniem znajduja sie tutaj - czyli tutaj testujemy, jakie powinny byc adnotacje, jakie pola itd.

Projekt (3) to implementacja metod get/put/post/delete. Zawiera połączenie z bazą tak jak (2) ale nie modyfikuje jej.

Część do zrobienia na najbliższe zajęcia (15 maja) to:
- Sprawienie żeby baza działała (trzeba potestować żeby sprawdzić)
- REST api

Obecnie zrobiona część:

- Adnotacje działają, ale jest problem z wypełnianiem wektorów wartościami (wartości pokazujące się w bazie nie wydają mi się poprawne).