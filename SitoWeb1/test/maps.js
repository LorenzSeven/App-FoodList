
/* ----------------------------- Mappa API FREE ----------------------------- */

let latitudine = 45.465454;
let longitudine = 9.186516;
const element = 3
const key = 'xjdraPl6Y15mqQVXy7HE';
let id = "map-1";
const source = new ol.source.TileJSON({
    url: `https://api.maptiler.com/maps/streets-v2/tiles.json?key=${key}`,
    tileSize: 512,
    crossOrigin: 'anonymous'
});

const attribution = new ol.control.Attribution({
    collapsible: false,
});

const map = new ol.Map({
    layers: [
        new ol.layer.Tile({
            source: source
        })
    ],
    controls: ol.control.defaults.defaults({ attribution: false }).extend([attribution]),
    target: 'map-1',
    view: new ol.View({
        constrainResolution: true,
        center: ol.proj.fromLonLat([longitudine, latitudine]),
        zoom: 14
    })
});


const map1 = new maptilersdk.Map({
    container: 'map-1', // container's id or the HTML element to render the map
    style: maptilersdk.MapStyle.STREETS,
    center: [longitudine, latitudine], // starting position [lng, lat]
    zoom: 9, // starting zoom
});

maptilersdk.config.apiKey = 'xjdraPl6Y15mqQVXy7HE';
const marker = new maptilersdk.Marker()
    .setLngLat([longitudine, latitudine])
    .addTo(map1);



//https://docs.maptiler.com/sdk-js/examples/default-marker/