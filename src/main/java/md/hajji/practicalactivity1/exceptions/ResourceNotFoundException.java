package md.hajji.practicalactivity1.exceptions;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String resource){
        super("Resource not found: " + resource);
    }
}
