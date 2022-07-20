Основные логеры:
- Logback
        Написан создателем Log4j, как его продолжение. Работает с SLF4J. Почему лучше, чем Log4j:
            1. Выше производительность, меньше занимает памяти;
            2. Хорошее покрытие тестами;
            3. Автоархивирование старых лог-файлов;
            4. Работают с контейнерами сервлетов Jetty или Tomcat;
- SLF4J (Bridging)

- Log4j2
    Log4j2 API features not available in SLF4J:
        1. Message API позволяет логировать объекты (через наследование интерфейса);
        2. Поддержка лямбд: logger.trace("Some operation returned {}", () -> expensiveOperation());
        3. ThreadContext(ClosableThreadContext)
        4. Кастомные уровни логирования;
        5. garbage-free - "is partially implemented by reusing objects in ThreadLocal fields,
            and partially by reusing buffers when converting text to bytes"
        6.  Анбоксинг без создания промежуточных объектов


- java.util.logging (вне конкурса):
        1. Основная концепция - логирование это исключение, а не норма;
        2. Нет аппндеров из коробки;
        3. Низкая производительность в т.ч. за счет генерации ошибки для трейсинга класса
            и метода по умолчанию;
        4. There are known classloading issues with Java Util Logging that cause problems when running
            from an 'executable jar'. We reccomended that you avoid it when running from an 'executable jar'
            if at all possible. (https://docs.spring.io/spring-boot/docs/current/reference/html/spring-boot-features.html#boot-features-logging)

- Log4j (вне конкурса):
        1. Конкатенирует строки


Lombok:
@Log4j2
    private static final org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager.getLogger(LogExapmle.class);

@Slf4j
     private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(LogExapmle.class);