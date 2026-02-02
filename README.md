# Evaluador de Expresiones Postfix
## Hoja de Trabajo No. 2 - CC2016

### Descripción del Proyecto
Este proyecto implementa un evaluador de expresiones en notación postfix (notación polaca inversa) utilizando una pila (stack) como estructura de datos principal.

### Estructura del Proyecto

#### Interfaces (ADTs)
1. **IStack<T>** - Interfaz genérica para la pila
   - `push(T value)`: Agrega un elemento al tope de la pila
   - `pop()`: Remueve y retorna el elemento del tope
   - `peek()`: Retorna el elemento del tope sin removerlo
   - `isEmpty()`: Verifica si la pila está vacía
   - `size()`: Retorna el número de elementos
   - `clear()`: Limpia todos los elementos

2. **ICalculator** - ADT para la calculadora postfix
   - `evaluate(String expression)`: Evalúa una expresión postfix y retorna el resultado

#### Implementaciones
1. **StackArrayList<T>** - Implementación de IStack usando ArrayList (arreglo dinámico)
   - Utiliza genéricos para soportar cualquier tipo de dato
   - Implementa todas las operaciones de la interfaz IStack

2. **PostfixCalculator** - Implementación de ICalculator
   - Utiliza una pila para evaluar expresiones postfix
   - Soporta operadores: +, -, *, /, %
   - Maneja errores: división por cero, operandos insuficientes, caracteres inválidos

#### Programa Principal
**Main.java** - Lee expresiones del archivo `datos.txt` y las evalúa

#### Pruebas Unitarias (JUnit)
1. **StackTest.java** - Pruebas para la implementación de la pila
2. **CalculatorTest.java** - Pruebas para la calculadora postfix

### Cómo Compilar y Ejecutar

#### Compilación
```bash
javac *.java
```

#### Ejecución
```bash
java Main
```

#### Ejecutar Pruebas JUnit
```bash
# Asegúrate de tener JUnit en el classpath
java -cp .:junit-4.13.2.jar:hamcrest-core-1.3.jar org.junit.runner.JUnitCore StackTest
java -cp .:junit-4.13.2.jar:hamcrest-core-1.3.jar org.junit.runner.JUnitCore CalculatorTest
```

### Formato del Archivo datos.txt
El archivo debe contener expresiones postfix, una por línea:
```
1 2 + 4 * 3 +
6 2 3 + *
15 3 / 2 4 * +
```

### Ejemplos de Evaluación

#### Ejemplo 1: `1 2 + 4 * 3 +`
Equivale a: ((1 + 2) * 4) + 3 = 15

Paso a paso:
1. Push 1 → Pila: [1]
2. Push 2 → Pila: [1, 2]
3. Operador + → Pop 2, Pop 1, Push(1+2) → Pila: [3]
4. Push 4 → Pila: [3, 4]
5. Operador * → Pop 4, Pop 3, Push(3*4) → Pila: [12]
6. Push 3 → Pila: [12, 3]
7. Operador + → Pop 3, Pop 12, Push(12+3) → Pila: [15]
8. Resultado: 15

#### Ejemplo 2: `6 2 3 + *`
Equivale a: 6 * (2 + 3) = 30

Paso a paso:
1. Push 6 → Pila: [6]
2. Push 2 → Pila: [6, 2]
3. Push 3 → Pila: [6, 2, 3]
4. Operador + → Pop 3, Pop 2, Push(2+3) → Pila: [6, 5]
5. Operador * → Pop 5, Pop 6, Push(6*5) → Pila: [30]
6. Resultado: 30

### Características Importantes

#### Diseño Flexible
- El programa principal puede usar **cualquier** implementación de ICalculator
- La calculadora puede usar **cualquier** implementación de IStack
- Esto permite intercambiar implementaciones entre diferentes grupos

#### Manejo de Errores
- División por cero
- Módulo por cero
- Operandos insuficientes
- Demasiados operandos
- Caracteres inválidos
- Operandos no numéricos

#### Genéricos
- La pila usa genéricos para soportar cualquier tipo de dato
- En este proyecto, se usa `IStack<Integer>` para almacenar enteros

### Diagrama UML de Clases
Ver archivo: `ClassDiagram.puml`

El diagrama muestra:
- Las interfaces IStack e ICalculator
- Las implementaciones StackArrayList y PostfixCalculator
- La clase Main que conecta todo
- Las clases de prueba StackTest y CalculatorTest
- Las relaciones entre las clases (implementación, uso, dependencia)

### Archivos Entregables
1. ✅ Diagrama UML de clases (ClassDiagram.puml)
2. ✅ IStack.java - Interfaz de la pila
3. ✅ StackArrayList.java - Implementación de la pila
4. ✅ ICalculator.java - ADT de la calculadora
5. ✅ PostfixCalculator.java - Implementación de la calculadora
6. ✅ Main.java - Programa principal
7. ✅ StackTest.java - Pruebas JUnit para la pila
8. ✅ CalculatorTest.java - Pruebas JUnit para la calculadora
9. ✅ datos.txt - Archivo de ejemplo con expresiones

### Control de Versiones (Git)
```bash
# Inicializar repositorio
git init

# Agregar archivos
git add *.java *.puml *.txt README.md

# Primer commit
git commit -m "Initial commit: Postfix calculator implementation"

# Crear repositorio en GitHub/GitLab y pushear
git remote add origin <tu-url-del-repositorio>
git push -u origin main
```

### Criterios de Calificación
- ✅ Diagrama UML de clases completo (10%)
- ✅ Creación y uso del repositorio en git (5%)
- ✅ Definición de la interfaz para la pila (5%)
- ✅ Implementación de la pila (5%)
- ✅ ADT Calculadora intercambiable (5%)
- ✅ Programa principal compatible con cualquier ADT (5%)
- ✅ Pruebas JUnit para pila y calculadora (5%)
- Evaluación oral (60%)

### Notas Adicionales
- Los operandos son enteros positivos que pueden tener varios dígitos
- Los operandos y operadores están separados por espacios
- El programa preserva el orden correcto de los operandos en operaciones no conmutativas
