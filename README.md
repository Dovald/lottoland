# Prueba técnica para Lottoland creada por Fernando Garcia Doval

La prueba consiste en crear una aplicación web que implemente el juego del piedra, papel y tijeras.
Los detalles y el enunciado de la prueba se pueden encontrar en *lottoland/src/main/resources/LottolandChallenge.txt*

## Tecnologías utilizadas:

- Java 11
- Spring
- Angular
- Kafka
- Docker
- JUnit
- Jacoco

## Forma de despliegue:

1. Descomprimir el fichero *lottoland.zip*
2. Acceder a *lottoland/compose*
3. Ejecutar `docker-compose up --build -d` (Se necesita tener configurado docker-compose)
4. Esperar a que todo se cargue y arranque
5. Acceder desde un navegador web a http://localhost

## Explicación de la interfaz

La aplicación está escuchando en el puerto 80 así que al acceder nos redirigirá automáticamente a la ventana del juego.
Hay una barra de navegación en la parte superior de la pantalla donde se podrá alternar entre las dos vistas. (Janken Game y Global Stats)
En Janken Game dispondremos de un contador que mostrará el numero de partidas jugadas por ese usuario en esa sesión de juego.
Una tabla con los resultados de las partidas jugadas durante la sesión de juego, las jugadas están ordenadas de arriba a abajo por antigüedad.
Un botón para realizar una partida.
Un botón para reiniciar la sesión de juego.
Cuando se reinicia la sesión de juego el contador pasará a valer 0 y se borraran todos los registros de la tabla.
En Global Stats tendremos una ventana donde se mostrarán las estadísticas globales del juego Janken realizadas por todos los usuarios desde el arranque de la aplicación.

## Estructura de ficheros de la prueba técnica

En la raíz de la carpeta *lottoland* tendremos el archivo *pom.xml* y las carpetas *src* y *target* correspondientes al proyecto maven para la parte del back-end
En la carpeta *lottoland/lottoland-frontend* tendremos el proyecto de Angular utilizado para la parte del front-end
En la carpeta *lottoland/compose* se encuentran los Dockerfile, el *docker-compose.yml* y los proyectos empaquetados de la parte back y front para su despliegue

## Comandos

- Generar informe de test y cobertura de código (en *lottoland*)(Salida en *lottoland/target/site/jacoco/index.html*)(Salida en *lottoland/target/surefire-reports/*)
`mvn test`
`mvn jacoco:report`
- Compilar la parte de backend (en *lottoland*)(Salida en *lottoland/target/lottoland-1.0.0-spring-boot.jar*)
`mvn package`
- Compilar la parte del frontend (en lottoland/lottoland-frontend)(Salida en *lottoland/lottoland-frontend/dist/*)
`ng build`

## Explicación de las decisiones tomadas y aclaraciones

- Toda referencia al juego de piedra, papel y tijeras se ha cambiado por la palabra Janken, Janken es como se llama al juego en japones y resulta mas sencillo de tratar al ser una sola palabra.
- El proyecto se ha empezado a desarrollar desde la parte del backend usando una metodología API FIRST, el swagger utiliza OpenAPI 3.0 y se encuentra en *lottoland/src/main/resources/openapi.yaml* y se puede visualizar copiando y pegando su contenido en https://editor.swagger.io/ 
- Tras un análisis de requisitos se distinguen dos módulos principales, un modulo de juegos (Janken) y un modulo de estadísticas (Stats). Esto aunque se vé bien reflejado en el swagger ya que no hay acoplamiento entre los módulos, se ha realizado todo el backend dentro del mismo proyecto maven por rapidez y simplicidad en la entrega.
- Para la creación del controlador he usado swagger-codegen. (https://github.com/swagger-api/swagger-codegen) 
- Se puede atacar directamente al backend en http://localhost:8088/lottoland/swagger-ui/index.html cuando el docker-compose del proyecto está activo.
- Para el paso de información entre los módulos se ha usado kafka siendo el modulo de juegos el productor y el modulo de estadísticas el consumidor.
- Para el mapeo entre DTO y las entidades se ha usado modelmapper (https://modelmapper.org/)
- Se usa un manejador de excepciones global para capturar y devolver la única excepción contemplada es la API consiste en llamar a los métodos pasandoles un ID de sesión invalido.
- Se realizan tests básicos unitarios sobre los DTO y las entidades usando la librería de google beanmatchers para subir cobertura de código.
- Los test de integración se realizan sin mockear nada, con un kafka embebido para probar todos los end2end posibles.
- Aunque soy un desarrollador 100% backend he trabajado en una parte frontend usando Angular, aquí no voy a poder justificar mis acciones ya que están basadas en documentación, tutoriales online y mi intuición.
- Para poder simular distintos usuarios y cumplir el requisito de que cada usuario tiene su propia sesión de juego, lo que he hecho ha sido que al acceder a la web se genera un ID se sesión aleatorio desde el frontend que es el que luego se le pasa al backend en todas las llamadas.
- Abriendo varias pestañas simultaneas se puede simular el uso concurrente de varios usuarios de la aplicación.

## Puntos de mejora

- Dividir el back en dos proyectos distintos, esto es sencillo ya que los archivos no tienen acoplamiento, aunque no se ha hecho por falta de tiempo.
- Haber enfocado el desarrollo usando en vez de API FIRST una metodología de DDD o TDD.
- Mejorar el refresco de las tablas en el frontend mediante websockets y no llamadas periódicas.
- Todos aquellos puntos de mejora del frontend que desconozco al ser una tecnología con la cual no estoy familiarizado.