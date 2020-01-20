# hello-world
## Цель
Создать простой пример на java (spring-boot-starter-web, spring-boot-starter-data-jpa) и javascript (reactjs)

## Описание функционала

Представлен виртуальный пульт управления устройствами. Изначально есть список устройств и пульт с постоянные кнопками "On/Off" "Vol+" "Vol-" "Undo". Можно выбирать устройство из списка для управления, и добавлять кнопки с новыми командами.

### Управление из web
При запуске программы поднимается встроенный web-сервер, единственная страница доступна по адресу http://localhost:8080/
Устройства со своими значениями показаны таблицей, под которой пуль с постоянными кнопками, и 

### Управление из командной строки
При запуске программы одновременно становится доступна командная строка, help покажет все доступные команды, можно выполнить все те же действия что и в web.

## Сборка из командной строки

Загрузка
git clone https://github.com/martinezdm/hello-world

Создание исполняемого файла
./mvnw clean install -DskipTests

## Запуск
Перед запуском исполняемого файла или тестов следует указать доступ к базе, например
export SPRING_DATASOURCE_URL="jdbc:postgresql://localhost/db"
export SPRING_DATASOURCE_USERNAME="user"
export SPRING_DATASOURCE_PASSWORD="pass"

./target/demo-0.0.1-SNAPSHOT.jar

## Тесты
./mvnw test
