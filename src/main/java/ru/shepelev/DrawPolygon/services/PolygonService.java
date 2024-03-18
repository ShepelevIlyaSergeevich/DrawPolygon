package ru.shepelev.DrawPolygon.services;

import org.springframework.stereotype.Service;
import ru.shepelev.DrawPolygon.models.Geometry;

import java.util.List;

@Service
public class PolygonService {

    public void printCoordinates(Geometry geometry) {
        List<List<Double>> coordinates = geometry.getCoordinates();
        for (List<Double> point : coordinates) {
            System.out.print(point.get(0) + " : ");
            System.out.println(point.get(1) + ",");
        }
    }
}
