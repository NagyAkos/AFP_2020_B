# Rendszerterv
## 01. A rendszer célja
A rendszer célja egy szabad idős portál létrehozása amelyhez bárhol bárki bármikor hozzáférhet. Az oldal kinézete egy színes figyelemfelkeltő felület lesz. A rendszer kinézete miatt egyszerűen kezelhető lesz.Mivel jelenleg csak weboldal keszul ezert sem androidos sem IOS es alkalmazas nem fog keszulni, de mivel celunk egy egyszeruen attekintheto oldal letrehozasa, ami minimalis eroforrasokat hasznal igy nincs is tervben kulon applkiacio letrehozasa. 

## 02. Projektterv
**Rendelkezésre álló szoftvererőforrások:**
- Windows 10 operációs rendszer
- WAMP szerver
- Sublime Text 3 IDE
- MySQL localhost szerver  
**Rendelkezésre álló hardvererőforrások:**
- Fejenként legalább egy IBM PC 8 vagy 16 GB RAM-mal, 1 TB SSD vagy HDD tárhellyel, i5-ös vagy i7-es processzorral  
**Rendelkezésre álló idő, ütemterv:**
- Funkcionális és követelményspecifikáció: 1. hét
- Rendszerterv: 2. hét
- Alapprojekt kialakítása és szükséges anyagok (szövegek, képek) összegyűjtése, adatbázisok létrehozása: 3. hét
- Főbb funkciók és autentikáció kidolgozása: 4. hét
- Stílus, megfelelő struktúra kialakítása: 5. hét
- Tesztelés: 6. hét  
**Projekt szerepkörök, felelősségek:**
- Az információs oldalak kialakításáért felel: Pelle Marcell
- A sporttal kapcsolatos szolgáltatások és információk fejlesztése: Dohányos Patrik
- A szabadidős tartalmak és funkciók fejlesztése: Perge Zsolt
- A közérdekű szolgáltatások kategóriájába tartozó aloldalak fejlesztése: Faragó Zsófia
- A főoldal kialakítása, menühierarchia, navigáció: Faragó Zsófia

## 3 Uzleti folyamatok modellje

A celunk egy olyan portal letrehozasa melynek segitsegevel az emberek valtoztatni tudnak az unalmas mindennapjaikon.

Uzleti szereplok:

-Szolgaltatast nyujto cegek, akik megjelennek az oldalon
-Latogatok
-Adminok

Uzleti folyamatok:
- A latogatok elerhetik az osszes aloldalt, minden megjelenitett informaciot, regisztralas nelkul bongeszhetnek es olvashatnak
- Az adminok publikaljak es szerkesztik az aloldalakat. Barmilyen dolog miatt hozza fernek akar informacio hozzaadasa vagy torlese

## 4 Követelménylista

A rendszer fejlesztese HTML/CSS valamint esetlegesen JavaScript segitesegevel tortenik A weboldal felepitese HTML, a stilusa CSS-sel fog megvalosulni. A weboldal hasznalatahoz eleg lesz egy egyszeru bongeszo.

## 5 Funkcionalis terv

Renszerszereplok: Adminok, Latogatok
Mivel az oldal egy gyujtoi portal, igy nincs szukseg tobb felhasznalora, csak az aminok akik publikalni tudnak es egyszeru olvasok akiknek nem kell regisztralni.

Rendszerhasznalati eset
Admin: Teljes hozzaferesz az egesz rendszerhez, ezaltal barmilyen aloldalt, informaciot megjelenithetnek vagy epp elrejthetnek.
Latogato: A portal osszes megjelentitett aloldalat elerik, ezaltal szabadon bongeszhetnek

Menuhierarchia:
Bejelentkezes: Csak az adminok reszere
Fooldal: Az osszes aloldal kulon kulon megjelenitve. 
		 Az aloldalak felosztasa mind egyedi csak az adott oldalhoz kapcsolodik. (Informacio, Elerhetosegek stb.)

## 6 Fizikai kornyezet
A portal csakis web platformra keszul
A portal kezi kodolassal irodik
A weboldal eleresehez csak egy atlagos bongeszora van szukseg
	Ezaltal barhonnan elerheto, operacios rendszertol es bongeszotol fuggetlenul
Az oldal fejlesztese HTML/CSS, JavaScript es PHP segitsegevel tortenik.

Fejlesztoi eszkozok:
	Szoveg -es forraskodszerkesztok: Visual Studio Code, Notepad++, Sublime text stb, kedv szerint barmelyik
	Weboldal: HTML + CSS + JavaScript + PHP
	Adatbazis: MySQL	

## 07. Architekturális terv
A rendszerhez szükség van egy adatbázis szerverre, ebben az esetben MySql-t használunk. A kliens oldali programokat egy php alapú REST api szolgálja ki, ez csatlakozik az adatbázis szerverhez. A kliensekkel JSON objektumokkal kommunikál.	

## 08. Adatbázisterv


## 09. Implementációs terv

Web: A webes felület HTML, PHP, CSS valamis Javascript nyelven készül. Minél átláthatóbban, elkülönítettebben fogunk dolgozni, a projekt átláthatósága miatt. Adatbázishoz SQL rendszert használunk az adatbázisterv pont szerint.
