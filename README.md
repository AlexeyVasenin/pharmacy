# Контрольная работа Васенин Алексей

Необходимо разработать CRUD backend сервис "online
аптека".

***
Сервис состоит из Rest приложения и базы данных.
***

Сервис хранит следующую информацию:

1. Препарат/лекарство (название, короткое описание в виде
   произвольного текста, список ингредиентов, категории, страна производства)
2. Страна производства
3. Ингредиенты
4. Категории (например, кардиология, первая помощь, гигиена)

***

Сервис должен выполнять следующие функции:

1. Добавление препарата
2. Редактирование препарата
3. Получение полного списка препаратов
4. Поиск препарата по названию и/или описанию и / или категории
   и/или стране производства и/или ингредиентам
5. Получение полного списка стран-производителей
6. Получение полного списка ингредиентов

***

Приложение должно быть разработано с использованием Spring Boot, в
качестве базы можно использовать Postgres