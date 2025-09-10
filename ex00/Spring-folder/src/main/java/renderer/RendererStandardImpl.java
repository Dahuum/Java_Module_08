package renderer;

import preprocessor.PreProcessor;

public class RendererStandardImpl implements Renderer {
    
    private PreProcessor preProcessor;
    
    public RendererStandardImpl(PreProcessor preProcessor) {
        this.preProcessor = preProcessor;
    }
    
    @Override
    public void render(String message) {
        String res = preProcessor.process(message);
        System.out.println(res);
    }
}