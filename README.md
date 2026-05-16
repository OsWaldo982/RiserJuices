# RiserJuices

Mod moderno de Minecraft Java Edition con Kotlin JVM, Fabric Loader, Fabric API, Fabric Language Kotlin, Fabric Loom y Gradle Kotlin DSL.

RiserJuices es un mod de frutas, arboles y bebidas para Minecraft moderno. La primera version empieza con el limonero: aparece naturalmente en el mundo, sus hojas pueden soltar limones, los limones se usan para preparar limonada y la limonada da Prisa Minera durante 1 minuto. La madera del limonero ya tiene familia completa tipo vanilla: troncos, madera, troncos sin corteza, tablones, escaleras, losas, vallas, puertas, trampillas, botones, placas de presion y bote.

La vision del mod es crecer mas alla del limon: futuras versiones agregaran mas frutas, nuevos arboles, jugos, comidas, recetas, crafteos especiales y sistemas de progreso alrededor de la agricultura y la cocina.

## Creditos

- Creador: DitoxSoft
- Colaborador / ayudante: Fixxs
- Motor del mod: Fabric + Kotlin

## Estado actual y futuro

Disponible ahora:

- Limoneros generados naturalmente en el mundo.
- Limones, limonada y efecto de Prisa Minera.
- Familia completa de madera de limonero.
- Bote, puertas, trampillas, vallas, escaleras, losas y bloques decorativos de limonero.

Planeado para futuras versiones:

- Mas frutas con sus propios arboles.
- Nuevos jugos y bebidas con efectos utiles.
- Mas recetas de cocina y crafteos especiales.
- Mas bloques decorativos y funcionales para granjas, cocinas y huertos.
- Mejor progresion para convertir RiserJuices en un mod completo de frutas y bebidas.

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

## Gameplay actual

- `Lemon Tree`: arbol nuevo generado en bosques, junglas, praderas y planicies.
- `Lemon Log`: tronco propio del limonero, inflamable, minable con hacha y strippeable con click derecho de hacha.
- `Lemon Wood Family`: variantes de madera compatibles con recetas vanilla de madera.
- `Lemon Leaves`: hojas propias con limones dibujados; sueltan brotes, sticks y limones con probabilidad tipo hojas de roble/manzana.
- `Lemon Sapling`: brote plantable que crece con bonemeal usando el mismo feature del limonero.
- `Lemon Boat`: bote propio con textura de madera de limonero.
- `Lemon`: comida simple y compostable.
- `Lemonade`: bebida en botella. Da `Haste I` durante 60 segundos y devuelve una botella de vidrio.

Receta de limonada:

```text
2 Lemon + 1 Sugar + 1 Glass Bottle = 1 Lemonade
```

Los 2 limones pueden estar juntos en un solo stack dentro de una casilla de la mesa de crafteo.

Recetas de madera:

- `1 Lemon Log/Wood/Stripped Log/Stripped Wood = 4 Lemon Planks`
- `Lemon Planks` funciona en la receta vanilla de palos porque esta en `minecraft:planks`.
- `Lemon Planks` crea escaleras, losas, vallas, puertas, trampillas, botones, placas de presion y bote con los patrones vanilla.

## Estructura principal

- `src/main/kotlin/com/ditoxsoft/ditoxfirstmod/DitoxFirstMod.kt`: entrypoint principal.
- `src/main/kotlin/com/ditoxsoft/ditoxfirstmod/client/DitoxFirstModClient.kt`: entrypoint cliente.
- `src/main/kotlin/com/ditoxsoft/ditoxfirstmod/item/ModItems.kt`: items y alimentos.
- `src/main/kotlin/com/ditoxsoft/ditoxfirstmod/block/ModBlocks.kt`: bloques, block items, compostaje e inflamabilidad.
- `src/main/kotlin/com/ditoxsoft/ditoxfirstmod/entity/ModEntityTypes.kt`: entidades del mod, por ahora el bote de limonero.
- `src/main/kotlin/com/ditoxsoft/ditoxfirstmod/world/ModWorldGeneration.kt`: generacion natural del limonero.
- `src/main/resources/fabric.mod.json`: metadata y dependencias Fabric.

## Assets del limonero

- Texturas de items: `src/main/resources/assets/ditox_first_mod/textures/item/`
- Texturas de bloques: `src/main/resources/assets/ditox_first_mod/textures/block/`
- Textura de bote en entidad: `src/main/resources/assets/ditox_first_mod/textures/entity/boat/lemon.png`
- Modelos de items: `src/main/resources/assets/ditox_first_mod/models/item/`
- Modelos de bloques: `src/main/resources/assets/ditox_first_mod/models/block/`
- Client item definitions: `src/main/resources/assets/ditox_first_mod/items/`
- Blockstates: `src/main/resources/assets/ditox_first_mod/blockstates/`
- Traducciones: `src/main/resources/assets/ditox_first_mod/lang/`

Las texturas base de bloques e items estan dibujadas a 64x64 para tener mas detalle que el placeholder inicial. La textura de entidad del bote conserva su formato especial de Minecraft en 128x64 porque el modelo del bote usa ese layout UV.

## Datos del mundo

- Recetas modernas: `src/main/resources/data/ditox_first_mod/recipe/`
- Loot tables: `src/main/resources/data/ditox_first_mod/loot_table/`
- Worldgen configured features: `src/main/resources/data/ditox_first_mod/worldgen/configured_feature/`
- Worldgen placed features: `src/main/resources/data/ditox_first_mod/worldgen/placed_feature/`
- Tags vanilla extendidos: `src/main/resources/data/minecraft/tags/`

## Agregar el siguiente item

1. Crea una constante en `ModItems.kt` usando `register("tu_item", ::Item, Item.Properties())`.
2. Agrega el item a `ModItemGroups.kt`.
3. Agrega traducciones en `en_us.json` y `es_cl.json`.
4. Crea `models/item/tu_item.json`, `items/tu_item.json` y `textures/item/tu_item.png`.

## Agregar el siguiente bloque

1. Crea una constante en `ModBlocks.kt` usando `register(...)`.
2. Agrega el bloque a `ModItemGroups.kt`.
3. Agrega traducciones en los archivos `lang`.
4. Crea modelo, blockstate, client item y textura.
5. Si debe aparecer en el mundo, agrega un `configured_feature`, un `placed_feature` y registralo en `ModWorldGeneration.kt`.

## Escalar a mas frutas

La idea del proyecto es que limon sea solo la primera fruta. Para mantener el mod ordenado:

- Items comestibles y bebidas van en `ModItems.kt`.
- Recetas especiales de jugos van en `ModJuiceRecipes`, dentro de `JuiceRecipeDefinition.kt`.
- El mixin de crafteo ya no esta amarrado solo a limonada; busca la bebida en `ModJuiceRecipes`.
- Familias de madera nuevas deben seguir el patron actual de `ModBlocks.kt`: tronco, madera, tronco sin corteza, madera sin corteza, tablones y variantes vanilla.
- Cada fruta nueva debe tener sus assets bajo `assets/ditox_first_mod/` y sus datos bajo `data/ditox_first_mod/`.

## Cambiar modid, nombre o paquete

- Mod ID: cambia `ditox_first_mod` en `DitoxFirstMod.kt`, `fabric.mod.json`, rutas dentro de `assets/` y `data/`, y claves de traduccion.
- Nombre visible: cambia `name` en `fabric.mod.json`.
- Paquete Kotlin: mueve `com.ditoxsoft.ditoxfirstmod` y actualiza los `entrypoints` de `fabric.mod.json`.
