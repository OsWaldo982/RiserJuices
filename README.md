# RiserJuices

Mod moderno de Minecraft Java Edition creado con Kotlin JVM, Fabric Loader, Fabric API, Fabric Language Kotlin, Fabric Loom y Gradle Kotlin DSL.

RiserJuices convierte Minecraft en una base para agricultura frutal, jugos y bebidas con efectos utiles. La version 1.7.0 expande el primer limonero con una coleccion nueva de frutas: uvas, naranja, manzana verde, coco, pina, frutilla, arandanos, platano, cerezas y mango. Cada fruta tiene item, bloque cultivable, textura 64x64, receta de bebida, traducciones y efecto jugable.

## Creditos

- Creador: DitoxSoft
- Colaborador / ayudante: Fixxs
- Motor del mod: Fabric + Kotlin

## Contenido 1.7.0

Disponible ahora:

- Limoneros naturales con madera completa tipo vanilla.
- Limonada con `Haste I` durante 60 segundos.
- Uvas y jugo de uva con regeneracion corta.
- Vino con fuerza breve; si bebes otro mientras el efecto sigue activo, recibes nausea.
- Naranja y jugo de naranja con resistencia al fuego corta.
- Manzana verde y sidra con velocidad.
- Coco y agua de coco con saturacion.
- Pina, mango y jugo tropical con velocidad y hambre ligera como balance.
- Frutilla y batido de frutilla con regeneracion muy corta.
- Arandanos y smoothie azul con vision nocturna.
- Platano y batido de platano con prisa minera y saturacion.
- Cerezas y jugo de cereza con suerte.
- Mango y jugo de mango con absorcion.
- Frutas nuevas generadas naturalmente en biomas adecuados.
- Bloques cultivables para todas las frutas nuevas, cosechables con click derecho cuando estan maduros.
- Texturas nuevas en 64x64 para frutas, bebidas y cultivos.

Planeado para futuras versiones:

- Arboles grandes con madera propia para cada fruta principal.
- Nuevas variantes de madera frutal.
- Cocinas, exprimidores y estaciones de crafteo.
- Mas recetas, comidas compuestas y progresion de granjas.
- Mas frutas, bebidas raras y efectos especiales.

## Donde encontrar cada fruta

Las frutas nuevas aparecen de forma natural segun corresponde: las frutas de arbol salen en arboles, las uvas en viñas, la frutilla y el arandano en arbustos, y la pina en una planta baja tropical. Las hojas frutales pueden soltar fruta y brotes; las plantas, viñas y arbustos se pueden cosechar con click derecho cuando estan maduros. Despues de conseguir la primera fruta o brote, puedes replantar y armar una granja.

- `Lemon`: en limoneros naturales de bosques, junglas, planicies y praderas.
- `Grapes`: parras silvestres en bosques, planicies y praderas.
- `Grapes`: tambien pueden aparecer cerca de biomas con aldeas, y en cofres de casas de aldea como uvas o parras para iniciar una granja.
- `Orange`: arboles de naranjo en bosques, sabanas, planicies y praderas.
- `Green Apple`: arboles de manzano verde en bosques, planicies y praderas.
- `Coconut`: palmeras de coco con tronco propio en playas y desiertos.
- `Pineapple`: plantas tropicales en junglas, playas y sabanas.
- `Strawberry`: arbustos en planicies, praderas y bosques.
- `Blueberries`: arbustos en taigas y bosques.
- `Banana`: bananeros con tallo propio en junglas.
- `Cherries`: arboles de cerezo frutal en cherry grove, flower forest y praderas.
- `Mango`: arboles de mango en junglas y sabanas.

## Herramientas necesarias

- IntelliJ IDEA Community 2025.3 o superior.
- JDK 25, requerido por Minecraft 26.1.x.
- Git opcional.

Si Gradle dice que `JAVA_HOME` es invalido, apunta `JAVA_HOME` a un JDK 25. En este equipo el build compila con `C:\Program Files\Apache NetBeans\jdk`.

El wrapper de Windows intenta usar automaticamente ese JDK local si existe, para que `.\gradlew.bat build` funcione aunque `java.exe` no este en el `PATH`.

## Versiones configuradas

Las versiones principales estan en `gradle.properties`.

- Minecraft: `26.1.2`
- Fabric Loader: `0.19.2`
- Fabric API: `0.149.0+26.1.2`
- Fabric Language Kotlin: `1.13.11+kotlin.2.3.21`
- Fabric Loom: `1.16.2`
- Kotlin JVM: `2.3.21`
- Version del mod: `1.7.0`

Para actualizar, revisa Fabric Develop o Fabric Template Generator: https://fabricmc.net/develop

Nota: Minecraft 26.1+ ya no usa Yarn mappings porque el juego moderno viene sin ofuscacion. La propiedad `yarn_mappings` queda documentada para proyectos antiguos, pero este build no la usa.

## Ejecutar y compilar

En Windows:

```powershell
.\gradlew.bat runClient
.\gradlew.bat build
```

Si IntelliJ marca errores falsos como `Unresolved reference kotlin`, `implementation`, `minecraft` o `Cannot access java.lang.StringBuilder`, casi siempre es un problema de sincronizacion/JDK del IDE, no del mod. Revisa:

1. `File > Project Structure > Project SDK`: usa JDK 25.
2. `Settings > Build Tools > Gradle > Gradle JVM`: usa JDK 25.
3. Pulsa `Reload All Gradle Projects`.
4. Si sigue rojo, usa `File > Invalidate Caches`.

En Linux/macOS:

```bash
./gradlew runClient
./gradlew build
```

El `.jar` final queda en:

```text
build/libs/RiserJuices.jar
```

## Instalar en el launcher normal

Para probar fuera de IntelliJ, la carpeta `mods` de tu instancia Fabric debe tener estos jars:

- `RiserJuices.jar`
- `fabric-api-0.149.0+26.1.2.jar`
- `fabric-language-kotlin-1.13.11+kotlin.2.3.21.jar`

Puedes preparar esa carpeta automaticamente con:

```powershell
.\gradlew.bat prepareMinecraftMods
```

Luego copia el contenido de:

```text
build/minecraft-mods/
```

a la carpeta `mods` de tu instancia de Minecraft. Si Fabric muestra `requires any version of fabric-language-kotlin, which is missing`, falta exactamente `fabric-language-kotlin` en esa carpeta.

## Recetas principales

Las bebidas usan recetas shapeless para que no tengas que ordenar los ingredientes en posiciones exactas. Puedes poner las frutas juntas en un solo stack.

- `2 Lemon + 1 Sugar + 1 Glass Bottle = 1 Lemonade`
- `2 Grapes + 1 Sugar + 1 Glass Bottle = 1 Grape Juice`
- `3 Grapes + 1 Sugar + 1 Glass Bottle = 1 Wine`
- `2 Orange + 1 Sugar + 1 Glass Bottle = 1 Orange Juice`
- `2 Green Apple + 1 Sugar + 1 Glass Bottle = 1 Cider`
- `2 Coconut + 1 Sugar + 1 Glass Bottle = 1 Coconut Water`
- `2 Pineapple + 1 Mango + 1 Sugar + 1 Glass Bottle = 1 Tropical Juice`
- `2 Strawberry + 1 Milk Bucket + 1 Sugar + 1 Glass Bottle = 1 Strawberry Smoothie`
- `2 Blueberries + 1 Milk Bucket + 1 Sugar + 1 Glass Bottle = 1 Blueberry Smoothie`
- `2 Banana + 1 Milk Bucket + 1 Sugar + 1 Glass Bottle = 1 Banana Smoothie`
- `2 Cherries + 1 Sugar + 1 Glass Bottle = 1 Cherry Juice`
- `2 Mango + 1 Sugar + 1 Glass Bottle = 1 Mango Juice`

Cada fruta nueva tambien se puede convertir en su bloque cultivable desde una receta shapeless simple.

## Estructura principal

- `src/main/kotlin/com/ditoxsoft/ditoxfirstmod/DitoxFirstMod.kt`: entrypoint principal.
- `src/main/kotlin/com/ditoxsoft/ditoxfirstmod/client/DitoxFirstModClient.kt`: entrypoint cliente.
- `src/main/kotlin/com/ditoxsoft/ditoxfirstmod/item/ModItems.kt`: items, comidas, bebidas y efectos.
- `src/main/kotlin/com/ditoxsoft/ditoxfirstmod/item/WineItem.kt`: comportamiento especial del vino.
- `src/main/kotlin/com/ditoxsoft/ditoxfirstmod/block/ModBlocks.kt`: bloques, block items, compostaje e inflamabilidad.
- `src/main/kotlin/com/ditoxsoft/ditoxfirstmod/block/FruitCropBlock.kt`: bloque base reutilizable para cultivos frutales.
- `src/main/kotlin/com/ditoxsoft/ditoxfirstmod/entity/ModEntityTypes.kt`: entidades del mod, por ahora el bote de limonero.
- `src/main/kotlin/com/ditoxsoft/ditoxfirstmod/world/ModWorldGeneration.kt`: generacion natural de limoneros y frutas silvestres.
- `src/main/resources/fabric.mod.json`: metadata y dependencias Fabric.

## Assets y datos

- Texturas de items: `src/main/resources/assets/ditox_first_mod/textures/item/`
- Texturas de bloques: `src/main/resources/assets/ditox_first_mod/textures/block/`
- Textura de bote: `src/main/resources/assets/ditox_first_mod/textures/entity/boat/lemon.png`
- Modelos de items: `src/main/resources/assets/ditox_first_mod/models/item/`
- Modelos de bloques: `src/main/resources/assets/ditox_first_mod/models/block/`
- Client item definitions: `src/main/resources/assets/ditox_first_mod/items/`
- Blockstates: `src/main/resources/assets/ditox_first_mod/blockstates/`
- Traducciones: `src/main/resources/assets/ditox_first_mod/lang/`
- Recetas: `src/main/resources/data/ditox_first_mod/recipe/`
- Loot tables: `src/main/resources/data/ditox_first_mod/loot_table/`
- Worldgen: `src/main/resources/data/ditox_first_mod/worldgen/`
- Tags vanilla extendidos: `src/main/resources/data/minecraft/tags/`

Las texturas base de bloques e items estan dibujadas a 64x64. La textura de entidad del bote conserva su formato especial de Minecraft en 128x64 porque el modelo del bote usa ese layout UV.

## Agregar la siguiente fruta

1. Agrega el item base y la bebida en `ModItems.kt`.
2. Agrega el cultivo o bloque frutal en `ModBlocks.kt`.
3. Agrega ambos a la pestana creativa en `ModItemGroups.kt`.
4. Registra la receta especial en `ModJuiceRecipes`, dentro de `JuiceRecipeDefinition.kt`.
5. Crea modelos, client item definitions, blockstates, loot table y textura 64x64.
6. Agrega traducciones en `en_us.json` y `es_cl.json`.
7. Si debe aparecer naturalmente, agrega `configured_feature`, `placed_feature` y registralo en `ModWorldGeneration.kt`.

## Cambiar modid, nombre o paquete

- Mod ID: cambia `ditox_first_mod` en `DitoxFirstMod.kt`, `fabric.mod.json`, rutas dentro de `assets/` y `data/`, y claves de traduccion.
- Nombre visible: cambia `name` en `fabric.mod.json`.
- Paquete Kotlin: mueve `com.ditoxsoft.ditoxfirstmod` y actualiza los `entrypoints` de `fabric.mod.json`.
