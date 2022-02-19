# Проект по автоматизации тестирования для сайтов:

### UI - <a target="_blank" href="https://www.huddle.team/">https://www.huddle.team</a>
### API - <a target="_blank" href="https://reqres.in/">https://reqres.in</a>
____
## :pushpin: Используемые технологии и инструменты
![Java](https://github.com/vapolonov/vapolonov/blob/main/vasvap_java_logo.png "Java")&nbsp;&nbsp;
![IntelliJ IDEA](https://github.com/vapolonov/vapolonov/blob/main/vasvap_idea_logo.png "IntelliJ IDEA")&nbsp;&nbsp;
![SelenideJ IDEA](https://github.com/vapolonov/vapolonov/blob/main/vasvap_selenide_logo.png "Selenide")&nbsp;&nbsp;
![Gradle](https://github.com/vapolonov/vapolonov/blob/main/vasvap_gradle_logo.png "Gradle")&nbsp;&nbsp;
![JUnit5](https://github.com/vapolonov/vapolonov/blob/main/vasvap_junit5_logo.png "JUnit5")&nbsp;&nbsp;
![Allure Reports](https://github.com/vapolonov/vapolonov/blob/main/vasvap_allure_logo.png "Allure Reports")&nbsp;&nbsp;
![GitHub](https://github.com/vapolonov/vapolonov/blob/main/vasvap_github_logo.png "GitHub")&nbsp;&nbsp;
![Jenkins](https://github.com/vapolonov/vapolonov/blob/main/vasvap_jenkins_logo.png "Jenkins")&nbsp;&nbsp;
![Selenoid](https://github.com/vapolonov/vapolonov/blob/main/vasvap_selenoid_logo.png "Selenoid")&nbsp;&nbsp;
![Jira](https://github.com/vapolonov/vapolonov/blob/main/vasvap_jira_logo.png "Jira")&nbsp;&nbsp;
![Telegram](https://github.com/vapolonov/vapolonov/blob/main/vasvap_telegram_logo.png "Telegram")&nbsp;&nbsp;
____
> Автотесты написаны на ***`Java`*** с использованием фреймворка ***`Selenide`*** для UI-тестов и ***`REST-Assured`*** для API-тестов.
>
> Для сборки проекта используется ***`Gradle`***.
>
> ***`JUnit 5`*** используется как фреймворк для модульного тестирования.
>
> Запуск тестов выполняется из ***`Jenkins`***.
>
> ***`Selenoid`*** используется для запуска браузеров в контейнерах ***`Docker`***.
>
> ***`Allure Report`***, ***`Allure TestOps`***, ***`Jira`***, ***`Telegram Bot`*** используются для визуализации результатов тестирования.

## :rocket: Реализованы следующие проверки
### &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; UI
> :heavy_check_mark: Проверка заголовка главной страницы сайта
> 
> :heavy_check_mark: Лог консоли браузера на главной странице сайта не содержит ошибок
> 
> :heavy_check_mark: Успешная авторизация на сайте
> 
> :heavy_check_mark: Попытка авторизации на сайте без указания пароля
> 
> :heavy_check_mark: Попытка авторизации на сайте без указания логина и пароля
> 
> :heavy_check_mark: Переход на страницу 'Восстановление пароля'

### &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; API
> :heavy_check_mark: Регистрация пользователя с корректными данными
> 
> :heavy_check_mark: Проверка регистрации пользователя с некорректными данными
> 
> :heavy_check_mark: Создание нового пользователя
> 
> :heavy_check_mark: Получение данных существующего пользователя
> 
> :heavy_check_mark: Изменение данных пользователя
> 
> :heavy_check_mark: Удаление пользователя


## :computer: Запуск тестов из терминала

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; :arrow_down: Запуск тестов с заполненным remote.properties:

```bash
gradle clean test
```

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; :arrow_down: Запуск тестов без заполненного remote.properties:

```bash
gradle clean -DremoteDriverUrl=https://user1:1234@selenoid.autotests.cloud/wd/hub/ -DvideoStorage=https://selenoid.autotests.cloud/video/ -Dthreads=1 test
```

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; :arrow_down: Запуск тестов в несколько потоков (5):
```bash
gradle clean test -Dthreads=5
```

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; :arrow_down: Формирование отчета allure:
```bash
allure serve build/allure-results
```

## ![](https://github.com/vapolonov/vasvap_diploma/blob/main/img/vasvap_jenkins_logo.png)&nbsp; Запуск тестов в Jenkins


### :pushpin: Параметры сборки
```REPOSITORY (адрес исходников проекта на github.com)
BROWSER (браузер, по умолчанию chrome)
BROWSER_VERSION (версия браузера, по умолчанию 91.0)
BROWSER_SIZE (размер окна браузера, по умолчанию 1920x1080)
REMOTE_DRIVER_URL (url-адрес selenoid, по умолчанию selenoid.autotests.cloud)
TREADS (количество потоков, по умолчанию 5)
ALLURE_NOTIFICATIONS_VERSION (версия сервиса для отправки уведомлений в телеграм, по умолчанию 3.1.1)
```
![](https://github.com/vapolonov/vasvap_diploma/blob/main/img/vasvap_jenkins_param.png)
