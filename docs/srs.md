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

![alt text](https://github.com/NagyAkos/AFP_2020_B/tree/master/docs/usecase.png)

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
| F1 | Adatbázis        | Az adatbázis tárolja a rendszer által használt összes adatot. Foglalások   és vendégek adatainak kiírása. |
| F2 | Dátumválasztó    | Legördülő ablak, ahol kilehet választani a dátumot, és meglehet nézni   hogy melyik foglalt vagy sem.    |
| F3 | Szállásfogaló    | Kis ablak, ahol megtudjuk adni a foglaló adatait, szállás módját.                                         |
| F4 | Térképgeneráló   | Kigenerálja a kemping térképét, az F2-ben választott dátumon. (Zöld a   szabad, Piros a foglalt)         |
| F5 | Foglalás törlése | Az előre lefoglalt hely felszabadítása (lejárt foglalásokat is).                                         |
| F6 | Számlagenerálás  | A szálláson eltöltött idő alapján a számla legenerálása.                                                 |


