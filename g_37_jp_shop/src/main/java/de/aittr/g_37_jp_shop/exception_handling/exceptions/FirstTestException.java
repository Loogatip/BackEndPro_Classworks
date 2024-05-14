package de.aittr.g_37_jp_shop.exception_handling.exceptions;

public class FirstTestException extends RuntimeException{

    // 1 СПОСОБ обработки искльчений
    // ПЛЮС - позволяет точечно настроить обработку исключения применительно
    //        к данному конкретному контроллеру, в случае, если нам требуется
    //        разная логика обработки того же самого исключения в разных контроллерах
    // МИНУС - если нам не требуется разной логики обработки ошибки для разных
    //         контроллеров, такой обработчик придется писать в каждом контроллере

    public FirstTestException() {
    }
    public FirstTestException(String message) {
        super(message);
    }
    public FirstTestException(String message, Throwable cause) {
        super(message, cause);
    }
}
