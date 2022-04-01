# Getting Started

Для работы нужна java 17. СУБД PostgreSQL 14.

В БД создать структуру и вставить данные. См. файлы в паке sql.

Создать файл с настройками application.properties

```properties
spring.datasource.url=jdbc:postgresql://ХОСТ:ПОРТ/ИМЯ_БД
spring.datasource.username=ПОЛЬЗАК_БД
spring.datasource.password=ПАРОЛЬ
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQL10Dialect
spring.jpa.hibernate.naming.implicit-strategy=org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl
spring.jpa.properties.hibernate.current_session_context_class=org.springframework.orm.hibernate5.SpringSessionContext
```

При запуске передать путь к папке с файлом настроек через параметр `--spring.config.location=file:/home/user/demo/`

## Сборка

```shell
./mvnw clean package
```

## Запуск
```shell
java -jar demo-0.0.1-SNAPSHOT.jar --spring.config.location=file:/home/user/demo/
```

## Использование
Открыть в браузере адрес [http://localhost:8080/status](http://localhost:8080/status)

Запрос попадёт на встроенный http-сервер, сервер посмотрит на путь `/status` поищет java класс и метод, 
который назначен этому пути (REST ресурс) и http методу (при вводе адреса в браузер всегда GET метод). 
Код выполнится, результат преобразуется в http ответ и браузер покажет его. Тут результат не html, а просто json.
