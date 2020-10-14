# Rendszerterv
## A rendszer célja

A rendszer célja hogy legyen a kemping recepciósnak egy rendszere ahol végigtudja majd követni a foglalásokat. 

## Projektterv

Projekt munkások és felelősségek:

 - Backend:
  Szabó Gergely Gyula
  , Ligárt Ádám
  
 - Frontend:
  Nagy Ákos
  , Karaba Márk

## Üzleti folyamatok modellje

![alt text](https://github.com/NagyAkos/AFP_2020_B/blob/%232_system_requirement_specification/docs/usecase.PNG)

## Követelmények

Funkcionális követelmények:

A recepciós számára követelmény:
A recepciós veszi fel az adatokat, ő rendel az emberekhez az azonosítót.
A recepciós kérheti le a fizetési adatokat, egyéb információkat beleértve hogy ki mivel kempingezik (sátor,lakókocsi).
A recepciós le tudja kérni hogy melyik nap melyik hely elérhető és milyen időintervallumban.

## Funkcionális terv

- Dátumválasztó
- Térkép(Zöld ha szabad (lelehet foglalni egy kattintással), piros ha foglalt, hány napig foglalt/szabad)
- funkcionális táblázat

| Id | Név              | Leírás                                                                                                   |
|----|------------------|----------------------------------------------------------------------------------------------------------|
| F1 | Foglalások    | Kilistázza a foglalt vagy szabad helyeket, a hozzá tartozó dátummal.   |
| F2 | Szállásfogaló    | Kis ablak, ahol megtudjuk adni a foglaló adatait, szállás módját.                                         |
| F3 | Térképgeneráló   | Kigenerálja a kemping térképét egy adott időpontra. A térképen megjelenik az adott napon foglalt vagy szabad kemping helyek és a hozzá tartozó id.       |
| F4 | Foglalás törlése | Az előre lefoglalt hely felszabadítása (lejárt foglalásokat is).                                         |
| F5 | Számlagenerálás  | A szálláson eltöltött idő alapján a számla legenerálása.                                                 |


##Adatstruktúra
| Id | Leírás                                                                                   |
|----|------------------------------------------------------------------------------------------|
| F1 | UUID:   ID, String: GuestName,String: PaymentMethod, int: CampingID, Date:   ReserveDate |
| F2 | String: GuestName, Bool: CampingStyle(true = caravan / false = tent), Bool:   Electricity    |
| F3 | Date: ChosenDate, int: CampingID, Bool: Reserved                           |
| F4 | UUID: ID (foglalás id) -> törlés funkció                                                 |
| F5 | UUID: ID (foglalás id), Uint: Balance -> végösszeg   