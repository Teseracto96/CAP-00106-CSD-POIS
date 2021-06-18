Feature: Encontrar POI más cercano a la ubicación actual del usuario

    Scenario: Hay dos POIs disponibles
        Given la aplicacion está levantada
        When se recibe la ubicación del usuario
        Then se retorna POI más cercano