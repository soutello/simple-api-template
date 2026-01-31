package dev.lfsoutello.simpleservicetemplate.example;

public class ExampleForm {
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "ExampleForm{" +
                "text='" + text + '\'' +
                '}';
    }
}
