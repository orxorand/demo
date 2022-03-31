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