# simuladorAlcancia
Simulador de una alcancia de monedaas

Se simula una alcancia de monedas, la cual permite agregar monedas de 50, 100, 200, 500 y 1000

EndPoints 

#### POST /alcancia 
Recibe en el body el valor a agregar, si la denominación no está en las mencionadas anteriormente 

Se lanza mensaje 'La moneda/denominacion no es permitida en la alcancia'

#### GET /totalDinero
Retorna el total agregado hasta el momento

## GET /contarMonedasPorDenominacion/denominacion  -> Donde denominacion es el valor de la moneda a contar

regresa el numero de monedas por denominación


