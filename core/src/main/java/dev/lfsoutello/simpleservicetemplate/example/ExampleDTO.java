package dev.lfsoutello.simpleservicetemplate.example;

public class ExampleDTO {
    private final Long id;
    private final String text;

    public ExampleDTO(Example example) {
        id = example.getId();
        text = example.getText();
    }

    public Long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "ExampleDTO{" +
                "id=" + id +
                ", text='" + text + '\'' +
                '}';
    }
}
