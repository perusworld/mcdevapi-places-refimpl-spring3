# Mastercard Developer API - Places - Reference Implementation - Angular/Spring 3.x #
Spring 3.x/Maven/Angular based reference implementation of Mastercard Developer API - Places 

## [Demo](https://perusworld.github.io/mcdevapi-places-refimpl-web/) ##

## Requirements ##
1. JDK 1.7+
1. Maven
1. Bower
   

## Setup Client App (optional if you want to host the sample client app) ##
This setups up the same client app that is being used in [Mastercard Developer API - Places - Reference Implementation - Angular/Express](https://github.com/perusworld/mcdevapi-places-refimpl-web)

```bash
git submodule init
git submodule update
cd  src/main/webapp/WEB-INF/ref-html
bower install
```

## Run with Remote Debug ##
```bash
set MAVEN_OPTS=-Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=8000
mvn -Djetty.http.port=3000 -Dmastercard.api.p12.path="file:///C:/path-to-p12-file" -Dmastercard.api.consumer.key="api-key" jetty:run
```

## Package War ##
```bash
mvn clean package
```

## Test App ##
Open browser and goto [http://localhost:3000](http://localhost:3000)

## Test REST APIs -cURL ##
### Query Merchant Category Codes ###
```bash
curl -X POST -H "Content-Type: application/json" -H "Cache-Control: no-cache" -d '{
	"isMCC": "true"
}' "http://localhost:3000/mcc"
```

### Query Merchant Industries ###
```bash
curl -X POST -H "Content-Type: application/json" -H "Cache-Control: no-cache" -d '{
	"isInd": "true"
}' "http://localhost:3000/industries"
```

### Query detailed information on merchants using distance/state/country sent as part of JSON post ###
```bash
curl -X POST -H "Content-Type: application/json" -H "Cache-Control: no-cache" -d '{
    "pageLength": 100,
    "countryCode": "USA",
    "pageOffset": 0,
    "radiusSearch": false,
    "unit": "m",
    "distance": 15,
    "stateProvidenceCode": "AZ"
}' "http://localhost:3000/poi"
```

### Query a geo-coordinate, latitude and longitude, point for a specified address location ###
```bash
curl -X POST -H "Content-Type: application/json" -H "Cache-Control: no-cache" -d '{
    "cityName": "O FALLON",
    "countryCode": "USA",
    "postalCode": "63368",
    "addressLine1": "2254 HIGHWAY K"
}' "http://localhost:3000/geo"
```
