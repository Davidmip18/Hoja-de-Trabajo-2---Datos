# Instrucciones para Control de Versiones con Git

## Configuración Inicial

### 1. Instalar Git (si no lo tienes)
```bash
# En Ubuntu/Debian
sudo apt-get install git

# En Mac
brew install git

# En Windows
# Descargar de: https://git-scm.com/download/win
```

### 2. Configurar Git (primera vez)
```bash
git config --global user.name "Tu Nombre"
git config --global user.email "tu.email@uvg.edu.gt"
```

## Crear Repositorio Local

### 3. Inicializar el repositorio
```bash
# Navegar a la carpeta del proyecto
cd ruta/a/tu/proyecto

# Inicializar git
git init

# Verificar estado
git status
```

### 4. Crear archivo .gitignore
```bash
# Crear archivo para ignorar archivos compilados
cat > .gitignore << EOF
# Archivos compilados de Java
*.class

# Package Files
*.jar
*.war
*.ear

# IDE files
.idea/
*.iml
.vscode/
.classpath
.project
.settings/

# OS files
.DS_Store
Thumbs.db
EOF
```

### 5. Agregar archivos al repositorio
```bash
# Agregar todos los archivos Java
git add *.java

# Agregar archivos de documentación
git add README.md
git add ClassDiagram.puml
git add ClassDiagram.svg
git add datos.txt
git add .gitignore

# Verificar qué archivos se agregarán
git status
```

### 6. Hacer el primer commit
```bash
# Commit inicial
git commit -m "Initial commit: Implementación de calculadora postfix

- Interfaz IStack genérica para pila
- Implementación StackArrayList con ArrayList
- Interfaz ICalculator para calculadora
- Implementación PostfixCalculator
- Programa principal Main.java
- Pruebas JUnit para Stack y Calculator
- Diagrama UML de clases
- Documentación README"

# Ver historial
git log
```

## Crear Repositorio Remoto en GitHub

### 7. Crear repositorio en GitHub
1. Ve a https://github.com
2. Click en "New repository"
3. Nombre: `postfix-calculator-uvg`
4. Descripción: "Evaluador de expresiones postfix - CC2016 UVG"
5. Selecciona "Private" o "Public" según prefieras
6. NO inicialices con README (ya lo tenemos)
7. Click "Create repository"

### 8. Conectar repositorio local con GitHub
```bash
# Agregar remote (sustituye TU_USUARIO con tu usuario de GitHub)
git remote add origin https://github.com/TU_USUARIO/postfix-calculator-uvg.git

# Verificar remote
git remote -v

# Subir el código
git branch -M main
git push -u origin main
```

## Trabajo en Equipo (Ambos Integrantes)

### 9. El compañero clona el repositorio
```bash
# Tu compañero debe hacer:
git clone https://github.com/TU_USUARIO/postfix-calculator-uvg.git
cd postfix-calculator-uvg
```

### 10. Flujo de trabajo colaborativo

#### Antes de empezar a trabajar
```bash
# Siempre actualizar antes de trabajar
git pull origin main
```

#### Mientras trabajas
```bash
# Ver cambios
git status

# Ver diferencias
git diff

# Agregar cambios específicos
git add archivo_modificado.java

# O agregar todos los cambios
git add .

# Hacer commit
git commit -m "Descripción clara de los cambios realizados"
```

#### Después de trabajar
```bash
# Subir cambios
git push origin main
```

### 11. División de trabajo sugerida

**Integrante 1:**
- Implementar IStack y StackArrayList
- Crear StackTest.java
- Commit: "Implementación de pila genérica con ArrayList"

**Integrante 2:**
- Implementar ICalculator y PostfixCalculator
- Crear CalculatorTest.java
- Commit: "Implementación de calculadora postfix"

**Ambos:**
- Main.java (uno crea estructura básica, otro agrega manejo de errores)
- README.md (uno escribe documentación, otro agrega ejemplos)
- Diagrama UML (uno crea versión inicial, otro revisa y mejora)

### 12. Resolver conflictos (si ocurren)
```bash
# Si hay conflicto al hacer pull
git pull origin main

# Git marcará los archivos con conflicto
# Editar archivos y resolver manualmente
# Buscar marcas: <<<<<<< HEAD, =======, >>>>>>>

# Después de resolver
git add archivo_con_conflicto.java
git commit -m "Resuelto conflicto en archivo_con_conflicto.java"
git push origin main
```

## Buenas Prácticas

### 13. Mensajes de commit descriptivos
```bash
# MAL:
git commit -m "cambios"
git commit -m "fix"

# BIEN:
git commit -m "Agregado manejo de excepción para división por cero"
git commit -m "Implementados métodos push y pop en StackArrayList"
git commit -m "Agregadas pruebas JUnit para operaciones básicas de pila"
```

### 14. Commits frecuentes
- Hacer commit cada vez que completes una funcionalidad
- NO esperar a terminar todo para hacer un solo commit
- Cada integrante debe tener varios commits en el historial

### 15. Verificar que todo funciona antes de push
```bash
# Compilar
javac *.java

# Ejecutar pruebas
java Main

# Si todo está bien, hacer push
git push origin main
```

## Comandos Útiles

```bash
# Ver historial de commits
git log

# Ver historial resumido
git log --oneline

# Ver quién hizo qué
git log --pretty=format:"%h - %an, %ar : %s"

# Ver cambios de un commit específico
git show COMMIT_HASH

# Ver ramas
git branch

# Ver estado del repositorio
git status

# Ver diferencias
git diff

# Deshacer cambios no guardados
git checkout -- archivo.java

# Ver archivos ignorados
cat .gitignore
```

## Agregar Colaboradores

### 16. Dar acceso al compañero y profesor
1. Ve al repositorio en GitHub
2. Click en "Settings"
3. Click en "Manage access" o "Collaborators"
4. Click en "Add people"
5. Agregar:
   - Tu compañero de trabajo
   - Tu profesor (si solicita acceso)
   - Tu auxiliar (si solicita acceso)

## Ejemplo de Sesión Completa

```bash
# Inicio del día
git pull origin main

# Trabajar en tu parte
# ... editar archivos ...

# Ver qué cambió
git status
git diff

# Guardar cambios
git add StackArrayList.java
git add StackTest.java
git commit -m "Implementada clase StackArrayList con pruebas unitarias

- Agregado constructor y atributo elements
- Implementados métodos push, pop, peek
- Implementados métodos isEmpty, size, clear
- Agregadas 9 pruebas JUnit que cubren casos normales y edge cases"

# Subir cambios
git push origin main

# Fin del día
```

## Verificación para la Entrega

Antes de entregar, verificar que:
- [ ] Ambos integrantes tienen commits en el repositorio
- [ ] Cada integrante tiene al menos una clase completa commiteada
- [ ] Los mensajes de commit son descriptivos
- [ ] El historial muestra trabajo incremental (no todo en un commit)
- [ ] El README tiene la URL del repositorio
- [ ] El profesor/auxiliar tiene acceso al repositorio

```bash
# Verificar commits de cada integrante
git log --pretty=format:"%h - %an, %ar : %s"

# Verificar URL del repositorio
git remote -v
```

## Enlaces de Repositorio para Entregar

Formato para Canvas:
```
Repositorio GitHub: https://github.com/TU_USUARIO/postfix-calculator-uvg
Integrantes:
- Integrante 1: [nombre] - [carné]
- Integrante 2: [nombre] - [carné]

Nota: El repositorio es [privado/público] y se ha dado acceso a [profesor] y [auxiliar]
```
