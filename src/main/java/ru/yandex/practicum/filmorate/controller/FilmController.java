package ru.yandex.practicum.filmorate.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.filmorate.model.Film;
import ru.yandex.practicum.filmorate.service.FilmService;

import javax.validation.Valid;
import java.util.Collection;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping(value = "/films")
public class FilmController {

    private final FilmService filmService;

    @GetMapping
    public Collection<Film> getAllFilms() {
        return filmService.getAll();
    }

    @PostMapping
    public Film createFilm(@RequestBody @Valid Film film) {
        return filmService.create(film);
    }

    @PutMapping
    public Film updateFilm(@RequestBody @Valid Film film) {
        return filmService.update(film);
    }

    @GetMapping("/{id}")
    public Film getFilm(@PathVariable Integer id){
        return filmService.get(id);
    }

    @PutMapping("{id}/like/{userId}")
    public Film likeFilm(@PathVariable Integer id, @PathVariable Integer userId){
        return filmService.likeFilm(id, userId);
    }

    @DeleteMapping("{id}/like/{userId}")
    public  Film deleteLike(@PathVariable Integer id, @PathVariable Integer userId){
        return filmService.deleteLike(id, userId);
    }

    @GetMapping("/popular")
    public Collection<Film> getPopular(@RequestParam(defaultValue = "10") Integer count){
        return filmService.getPopular(count);
    }

}
