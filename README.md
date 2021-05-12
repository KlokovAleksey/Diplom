### Ссылки на документацию:
* [План тестирования](https://github.com/KlokovAleksey/Diplom)
* [Отчёт по итогам тестирования]()
* [Отчёт по итогам тестирования]()

### Тестирование сервиса покупки тура с помощью двух спопсобов:
1.  Обычная оплата по дебетовой карте
2.  Выдача кредита по данным банковской карты

### Процедура запуска авто-тестов:
1. склонировать репозиторий,выполнив в терминале команду: ```git clone``` [<ссылка_репозитория>](https://github.com/KlokovAleksey/Diplom.git)
2. запустить Docker Toolbox
3. запустить контейнеры,выполнив в терминале команду ```docker-compose up -d```
4. запустить sut командой:
*  для MySQL: ```java -Dspring.datasource.url=jdbc:mysql://192.168.99.100:3306/app -jar ./artifacts/aqa-shop.jar```
*  для PostgreSQL: ```java -Dspring.datasource.url=jdbc:postgresql://192.168.99.100:5432/app -jar ./artifacts/aqa-shop.jar```
5. запустить тесты командой:
* для MySQL: ```gradlew -Dspring.datasource.url=jdbc:mysql://192.168.99.100:3306/app clean test```
* для PostgreSQL: ```gradlew -Dspring.datasource.url=jdbc:postgresql://192.168.99.100:5432/app clean test```
6. создать отчёт командой: ```gradle allureReport```
7. просмотреть отчёт выполнив команду: ```gradle allureServe```