package springboot.injectannotations;

public class AnimalEvent {

    private String content;

    public AnimalEvent(final String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
