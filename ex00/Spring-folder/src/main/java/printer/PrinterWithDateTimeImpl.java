package printer;

import renderer.Renderer;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PrinterWithDateTimeImpl implements Printer {
    
    private Renderer renderer;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    
    public PrinterWithDateTimeImpl(Renderer renderer) {
        this.renderer = renderer;
    }
    
    @Override
    public void print(String message) {
        String currentTime = LocalDateTime.now().format(formatter);
        String res = "[" + currentTime + "] " + message;
        renderer.render(res);
    }
}