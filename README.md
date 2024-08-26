# user-api.APITest-testing-dating-app

# Проект по автоматизированному тестированию API

## Описание

Этот проект демонстрирует автоматизированное тестирование API с использованием Java, Rest Assured и TestNG. В проекте реализованы тесты для проверки ответов API в различных сценариях, таких как получение пользователей по полу и обработка некорректных параметров.

## Структура Проекта

- `src/test/java`
    - `api`
        - `ApiClient.java` - Методы для взаимодействия с API-эндпоинтами.
        - `ApiTest.java` - Тестовые случаи для API-эндпоинтов.
- `src/test/resources`
    - `schemas`
        - `getUserGender.json` - JSON-схема для валидации ответа API `getUserByGender`.

## Пр prerequisites

- Java 11 или выше
- Maven 3.6.0 или выше
- IDE (например, IntelliJ IDEA, Eclipse)

## Установка

1. **Клонируйте Репозиторий**

   ```bash
   git clone <URL-репозитория>
   cd <директория-репозитория>
