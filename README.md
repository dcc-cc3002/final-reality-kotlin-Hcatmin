Final Reality
=============

![http://creativecommons.org/licenses/by/4.0/](https://i.creativecommons.org/l/by/4.0/88x31.png)

This work is licensed under a
[Creative Commons Attribution 4.0 International License](http://creativecommons.org/licenses/by/4.0/)

Context
-------

This project's goal is to create a (simplified) clone of _Final Fantasy_'s combat, a game developed
by [_Square Enix_](https://www.square-enix.com)
Broadly speaking for the combat the player has a group of characters to control and a group of
enemies controlled by the computer.

---

El primer problema de diseño que me hizo ruido fue en Weapon.kt. En esta parte del código, si 
se desea implementar otro tipo de arma (por ejemplo) se incurriría a modificar las clases actuales, 
y se estaría violando el Open Closed Principle.

En un inicio, sólo existe la clase Weapon, pero STAFF es de tipo mágico y tiene daño mágico.

Después de releer el enunciado, se consideró que todas las armas tienen el mismo comportamiento. 
En mi diagrama inicial, bajo esta lógica hice que MagicWeapon herede de Weapon pero ahora esto
no me parece del todo correcto. Aquí se aplicaría el Liskov Substitution Principle.