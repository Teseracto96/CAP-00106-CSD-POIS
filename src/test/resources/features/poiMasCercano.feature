Feature: Encontrar POI más cercano a la ubicación actual del usuario

    Scenario: Hay dos POIs disponibles y retornamos el más cercano
        Given que existe la ubicación "Pollo Feliz Restaurant" en latitud 27.92398 y longitud -110.88695
        And   que existe la ubicación "Tacos Don chuy" en latitud 27.92791 y longitud -110.89115
        And   que existe la ubicación del usuario en latitud 27.92795 y longitud -110.88903
        When se consulta el POI más cercano a la ubicación del usuario
        Then recibe la respuesta con codigo de estado 200 y contenido
        """
        {
            "nombre": "Tacos Don chuy",
            "longitud" : -110.89115,
            "latitud" : 27.92791,
            "descripcion" : ""
        }
        """


    Scenario: Hay dos POIs disponibles y retornamos el más cercano
        Given que existe la ubicación "Pollo Feliz Restaurant" en latitud 27.92398 y longitud -110.88695
        And   que existe la ubicación "Tacos Don chuy" en latitud 27.92791 y longitud -110.89115
        And   que existe la ubicación del usuario en latitud 27.92399 y longitud -110.88696
        When se consulta el POI más cercano a la ubicación del usuario
        Then recibe la respuesta con codigo de estado 200 y contenido
        """
        {
            "nombre": "Pollo Feliz Restaurant",
            "longitud" : -110.88695,
            "latitud" : 27.92398,
            "descripcion" : ""
        }
        """


