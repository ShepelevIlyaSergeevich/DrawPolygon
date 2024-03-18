package ru.shepelev.DrawPolygon.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.shepelev.DrawPolygon.models.Feature;
import ru.shepelev.DrawPolygon.services.PolygonService;

@RestController
@AllArgsConstructor
public class PolygonController {

    private final PolygonService polygonService;

    @PostMapping
    public ResponseEntity<String> sendPolygon(@RequestBody Feature feature) {
        polygonService.printCoordinates(feature.getGeometry());
        return new ResponseEntity<>("The polygon coordinates were obtained", HttpStatus.OK);
    }
}
