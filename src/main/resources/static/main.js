const url = 'http://localhost:8080';
const xhr = new XMLHttpRequest();
var currentId = 1;

const raster = new ol.layer.Tile({
  source: new ol.source.OSM(),
});

const source = new ol.source.Vector({
    format: new ol.format.GeoJSON(),
    wrapX: false
});

const vector = new ol.layer.Vector({
  source: source,
});

const map = new ol.Map({
  layers: [raster, vector],
  target: 'map',
  view: new ol.View({
    center: [0, 0],
    zoom: 1,
  }),
});



let draw; // global so we can remove it later
function addInteraction() {
    draw = new ol.interaction.Draw({
      source: source,
      type: 'Polygon',
    });
    draw.on('drawend', function(event) {
        event.feature.setId(currentId);
        currentId++;
        var geojson = new ol.format.GeoJSON().writeFeature(event.feature);
        xhr.open('POST', url, false);
        xhr.setRequestHeader("Content-Type", "application/json");
        xhr.send(geojson);
        console.log(geojson);
        if (xhr.status != 200) {
          // обработать ошибку
          console.log( xhr.status + ': ' + xhr.statusText ); // пример вывода: 404: Not Found
        } else {
          // вывести результат
          console.log( xhr.responseText ); // responseText -- текст ответа.
        }
    });
    map.addInteraction(draw);
}

addInteraction();