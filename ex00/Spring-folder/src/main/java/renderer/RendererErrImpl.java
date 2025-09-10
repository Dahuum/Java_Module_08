package renderer;

import preprocessor.PreProcessor;

public class RendererErrImpl implements Renderer {
    
    private PreProcessor preProcessor;
    
    public RendererErrImpl(PreProcessor preProcessor) {
        this.preProcessor = preProcessor;
    }
    
    @Override
    public void render(String message) {
        String res = preProcessor.process(message);
        System.err.println(res);
    }
}