package preprocessor;

public class PreProcessorToUpperImpl implements PreProcessor {
    
    @Override
    public String process(String message) {
        return message.toUpperCase();
    }
}