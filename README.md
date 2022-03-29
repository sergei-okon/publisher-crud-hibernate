# publisher-crud

Необходимо реализовать консольное CRUD приложение, которое взаимодействует с БД и позволяет выполнять все CRUD операции над сущностями:

Writer(id, name, List<Post> posts)

Post(id, content, List<Tag> tags, 

PostStatus status)

Tag(id, name)

PostStatus (enum ACTIVE, DELETED)

Требования:

Все CRUD операции для каждой из сущностей

Придерживаться подхода MVC

Для сборки проекта использовать Maven

Для взаимодействия с БД - Hibernate

Для конфигурирования Hibernate - аннотации

Инициализация БД должна быть реализована с помощью flyway

Сервисный слой приложения должен быть покрыт юнит тестами (junit + mockito)

Результатом выполнения задания должен быть репозиторий на github. 

Технологии: Java, PostgreSQL, Hibernate, Flyway, Maven.