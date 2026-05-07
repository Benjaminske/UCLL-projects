package be.ucll.controller;

import be.ucll.model.Pony;
import be.ucll.service.PonyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import be.ucll.repository.PonyRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/pony")
public class PonyController {

    private PonyService ponyService;

    @Autowired
    public PonyController(PonyService ponyService) {
        this.ponyService = ponyService;
    }

//    @PutMapping("{name}")
//    public Pony updatePony(@PathVariable String name, @RequestBody Pony newDataForExistingPony) {
//        return ponyService.updatePony(name, newDataForExistingPony);
//    }
//
//    @PostMapping
//    public void addPony(@Valid @RequestBody Pony pony) {
//        ponyService.addPony(pony);
//    }
//
    @GetMapping
    public Object getAllPonies(@RequestParam(value = "name", required = false) String name) {
//        if (name == null)
            return ponyService.getAllPonies();
//        else
//            return ponyService.findPonyByName(name);
    }
//
    @GetMapping("{ponyName}")
    public Pony findPonyByName(@PathVariable String ponyName) {
        return ponyService.findPonyByName(ponyName).orElseThrow(()->new RuntimeException("No pony found"));
    }

//    @GetMapping("{ponyAge}")
//    public Pony findPonyByAge(@PathVariable int ponyAge) {
//        return null;
//    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({RuntimeException.class})
    public Map<String, String> handleRuntimeException(RuntimeException exc) {
        Map<String, String> errors = new HashMap<>();
        errors.put("error", exc.getMessage());
        return errors;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public Map<String, String> handleMethodArgumentNotValidException (MethodArgumentNotValidException exc) {
        Map<String, String> errors = new HashMap<>();
        for(FieldError error : exc.getFieldErrors()) {
            errors.put(error.getField(), error.getDefaultMessage());
        }
        return errors;
    }

}
