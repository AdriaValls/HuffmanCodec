Ejercicio:

Implementaremos en Java un codificador Huffmann de propósito general. Debe cumplir las siguientes especificaciones.

• Formato de entrada de datos:
• Tabla de símbolos originales: una estructura de datos 2xN que contenga N parejas de “símbolo” y su correspondiente probabilidad (en %).
• Formato de salida de datos:
• Tabla de traducción Huffmann: una estructura de datos 2xN que contenga N parejas en las que se indique el “símbolo original” y el nuevo código Huffmann asignado.
• Los códigos Huffmann serán binarios y se codificarán como una String binaria constituida por caracteres “1” y cero “0”.
Tareas:

a) Implementad el codificador Huffman descrito anteriormente y comprobad que el programa genera correctamente códigos Huffman válidos para el siguiente conjunto de símbolos (usados en el ejercicio anterior).
diamante = 30% ; K = 20% ; Q = 20% ; J = 15% ; 10 = 10% ; 9 = 5%

b) Modificad el programa para que a partir de una tabla de símbolos originales, sea capaz de traducir al código Huffman correspondiente un mensaje cualquiera que contenga únicamente ese conjunto de símbolos originales.
c) Generad ahora una secuencia larga y aleatoria que contenga los símbolos del apartado a) y codificadla en Huffmann mediante el algoritmo implementado en el apartado b). Ayuda: Podéis generar bits aleatorios con Math.round(Math.random()), pero aseguraos que los símbolos aparecen con la frecuencia/probabilidad prevista en la tabla de símbolos originales; si no, evidentemente la compresión no funcionará.
d) Ejecutad el programa con diversas secuencias aleatorias, suficientemente largas (>1000 símbolos). ¿Qué factor de compresión alcanzáis? ¿Qué relación tiene éste con la entropía calculada teóricamente para el conjunto de símbolos del apartado a)?