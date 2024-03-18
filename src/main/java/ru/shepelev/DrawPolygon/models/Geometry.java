package ru.shepelev.DrawPolygon.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Geometry {
    private String type;
    private List<List<List<Double>>> coordinates;

    public List<List<Double>> getCoordinates() {return coordinates.get(0);}
}
