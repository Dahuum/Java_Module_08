import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import preprocessor.PreProcessorToUpperImpl;
import preprocessor.PreProcessorToLowerImpl;
import renderer.RendererErrImpl;
import renderer.RendererStandardImpl;
import printer.PrinterWithPrefixImpl;
import printer.PrinterWithDateTimeImpl;
import printer.Printer;

public class Main {
    public static void main (String [] args) {
        try {
            /* Test bla spring, ✨ spring wla zebi ✨ */
            PreProcessorToUpperImpl preProcessorToUpper = new PreProcessorToUpperImpl();
            RendererErrImpl rendererErr = new RendererErrImpl(preProcessorToUpper);
            PrinterWithPrefixImpl printerWithPrefix = new PrinterWithPrefixImpl(rendererErr);
            printerWithPrefix.setPrefix("PREFIX");
            printerWithPrefix.print("hello!");
            
            /* aji nchoufou daba had spid dial spring */
            try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml")) {
                Printer printer = context.getBean("printerWithDateTime", Printer.class);
                printer.print("Hello!"); /* ?✨ */
            } catch (Exception e) { System.err.println(e.getMessage()); }
            
        }
        catch (Exception e) { System.err.println(e.getMessage()); }
    }
}