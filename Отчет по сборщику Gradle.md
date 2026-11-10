
_Что такое система сборки?

**Gradle** — это современная система автоматизации сборки, которая управляет всем жизненным циклом проекта. Она берет на себя компиляцию кода, автоматическое скачивание и управление внешними библиотеками (зависимостями), запуск тестов и упаковку готового приложения в JAR-архив.

Главные отличия `gradle build` от классического `javac`:

**Масштаб и автоматизация.** Утилита `javac` — это просто компилятор, который переводит отдельные файлы `.java` в байт-код `.class`. Она не умеет скачивать библиотеки, запускать тесты или собирать JAR-файлы. `gradle build` — это целый конвейер, который выполняет все эти шаги автоматически одной командой.

**Управление зависимостями.** При использовании `javac` вам приходится вручную скачивать файлы сторонних би[^1]блиотек и прописывать к ним длинные пути через флаг `-classpath`. Gradle делает это сам на основе коротких записей в файле конфигурации.

**Инкрементальная сборка.** Если вы изменили один файл из ста, `javac` при обычном вызове будет заново компилировать всё. Gradle видит, какие файлы не менялись, и пропускает их обработку, что экономит время при больших объемах кода.

_Часть практической работы_
```
gradle --version

Gradle 9.7.1

Build time:    2026-08-19 14:16:09 UTC
Revision:      92f0512e7f06d84621afba191f75e265363890cf

Kotlin:        2.4.0
Groovy:        4.0.32
Ant:           Apache Ant(TM) version 1.10.17 compiled on April 6 2026
Launcher JVM:  25.0.4.1 (Eclipse Adoptium 25.0.4.1+1-LTS)
Daemon JVM:    C:\Program Files\Eclipse Adoptium\jdk-25.0.4.101-hotspot (no Daemon JVM specified, using current Java home)
OS:            Windows 10 10.0 amd64
```

После установки системы сборки Gradle проверяем на исправность командой: gradle --version

Создаем новый проект с системой сборки Gradle в редакторе кода IntelliJ IDEA![](file:///C:/Users/AACE~1/AppData/Local/Temp/lu11528n2fte.tmp/lu11528n2fto_tmp_9fc439b3.png)

Компиляция проекта происходит по команде gradle build
```
gradle build

Starting a Gradle Daemon, 1 incompatible and 1 stopped Daemons could not be reused, use --status for details
[###########....] 78% EXECUTING [4s]

BUILD SUCCESSFUL in 11s
7 actionable tasks: 7 executed
Consider enabling configuration cache to spee

```

``
Запуск основной программы — gradle run
```
gradle run

> Task :run
Введите аргументы:
x =
[###y = ####....] 75% EXECUTING [6s]
[#######z = ....] 75% EXECUTING [7s]
[###########a = 9,60818; b = 1,27501
BUILD SUCCESSFUL in 8s
2 actionable tasks: 1 executed, 1 up-to-date
Consider enabling configuration cache
```

Но чтобы сборщик убрал индикаторы (для удобства пользователя можно использовать команду gradle run --console=plain  
Эта команда убирает [##] и индикатор времени
```
gradle run --console=plain
> Task :compileJava UP-TO-DATE
> Task :processResources NO-SOURCE
> Task :classes UP-TO-DATE

> Task :run
Введите аргументы:
x = 1
y = 2
z = 3
a = 16,81432; b = 3,84678
BUILD SUCCESSFUL in 5s
2 actionable tasks: 1 executed, 1 up-to-date
Consider enabling configuration cache to speed up 
```

_Файловая система проекта с системой сборки Gradle_

![640](file:///C:/Users/AACE~1/AppData/Local/Temp/lu11528n2fte.tmp/lu11528n2fto_tmp_24a58538.png) 
Ветвь проекта src делиться на main и test

main/java – папка, которая хранит packege проекта, то есть основной класс программы и различные модули для работы основной программы

test/java – папка которая хранит папку с классом/java файлом который связан с тестированием методов из main/java

```
Файл build.gradle служит главным скриптом сборки и содержит инструкции по подключению плагинов, настройки версии Java и списки зависимостей.
```

[Задание](https://github.com/VetrovSV/OOP/blob/master/plans/tasks_java.md)
