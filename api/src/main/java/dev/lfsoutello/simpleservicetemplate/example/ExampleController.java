package dev.lfsoutello.simpleservicetemplate.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/example")
public class ExampleController {
    public static final Logger log = LoggerFactory.getLogger(ExampleController.class);
    private final ExampleService exampleService;

    public ExampleController(ExampleService exampleService) {
        this.exampleService = exampleService;
    }

    @PostMapping
    public ResponseEntity<ExampleDTO> create(@RequestBody ExampleForm body) {
        log.info("[ExampleController] m=create, body={}", body);
        return ResponseEntity.ok(exampleService.create(body.getText()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExampleDTO> read(@PathVariable Long id) {
        log.info("[ExampleController] m=read, id={}", id);
        return ResponseEntity.ok(exampleService.read(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExampleDTO> update(@PathVariable Long id, @RequestBody ExampleForm body) {
        log.info("[ExampleController] m=update, id={}, body={}", id, body);
        return ResponseEntity.ok(exampleService.update(id, body.getText()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        log.info("[ExampleController] m=delete, id={}", id);
        exampleService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
