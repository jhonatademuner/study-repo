package com.jhonataplt.eletriccarapp.data

import com.jhonataplt.eletriccarapp.domain.Car

object CarFactory {

    val list = listOf<Car>(
        Car(
            1,
            "R$ 230.000,00",
            "100 kWh",
            "408 cv",
            "80 min",
            "www.google.com.br"
            ),
        Car(
            2,
            "R$ 230.000,00",
            "100 kWh",
            "408 cv",
            "80 min",
            "www.google.com.br"
        ),
        Car(
            3,
            "R$ 230.000,00",
            "100 kWh",
            "408 cv",
            "80 min",
            "www.google.com.br"
        ),
        )

}