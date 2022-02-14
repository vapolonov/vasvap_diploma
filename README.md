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
> В данном проекте автотесты написаны на Java с использованием фреймворка Selenide для UI-тестов и REST-Assured для API-тестов.
>
> Для сборки проекта используется Gradle.
>
> JUnit 5 используется как фреймворк для модульного тестирования.
>
> Запуск тестов выполняется из Jenkins.
>
> Selenoid используется для запуска браузеров в контейнерах Docker.
>
> Allure Report, Allure TestOps, Jira, Telegram Bot используются для визуализации результатов тестирования.

## 🚀 Реализованы следующие проверки
> Проверка заголовка главной страницы сайта
> Лог консоли браузера на главной странице сайта не содержит ошибок
> Успешная авторизация на сайте
> Попытка авторизации на сайте без указания пароля
> Попытка авторизации на сайте без указания логина и пароля
> Переход на страницу 'Восстановление пароля'

### For run remote tests need fill remote.properties or to pass value:

* browser (default chrome)
* browserVersion (default 89.0)
* browserSize (default 1920x1080)
* browserMobileView (mobile device name, for example iPhone X)
* remoteDriverUrl (url address from selenoid or grid)
* videoStorage (url address where you should get video)
* threads (number of threads)


Run tests with filled remote.properties:
```bash
gradle clean test
```

Run tests with not filled remote.properties:
```bash
gradle clean -DremoteDriverUrl=https://%s:%s@selenoid.autotests.cloud/wd/hub/ -DvideoStorage=https://selenoid.autotests.cloud/video/ -Dthreads=1 test
```

Serve report:
```bash
allure serve build/allure-results
```


###### For further development there are some example tests in src/test/java/cloud.autotests/tests/demowebshop
* remove @Disabled("...") annotation to run tests
```bash
gradle clean demowebshop
```

:heart: <a target="_blank" href="https://qa.guru">qa.guru</a><br/>
:blue_heart: <a target="_blank" href="https://t.me/qa_automation">t.me/qa_automation</a>
