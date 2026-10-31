# AutoBaterias · RedPill Tech

Sistema de registro de ventas y validación de garantías para un negocio de baterías.
Proyecto de Desarrollo de Software · UAM · Grupo 1 – RedPill Tech.

| Rol | Responsable |
|---|---|
| Producto / Integración | Juan David Gomez Tangarife |
| Backend / Datos | Yeferson Valencia Aristizabal |
| Calidad | Manuel Noreña Cardona |

- **Jira:** https://yete3312.atlassian.net/jira/software/projects/RPT/boards/2
- **Stack:** Java 21 · Spring Boot · Spring Data JPA · PostgreSQL · Flyway · Maven

## Cómo ejecutar

1. Crear la base de datos en PostgreSQL (ver `DataBaseAutoBaterias.yml`).
2. Copiar `.env.example` como `.env` y completar los valores locales. **El `.env` nunca se sube al repositorio.**
3. Ejecutar:

```bash
./mvnw spring-boot:run      # levantar la API
./mvnw verify               # compilar y correr pruebas
```

## Ramas

```
main      ← estable, solo recibe desde develop
develop   ← integración
feature/* ← una rama por subtarea de Jira
```

- Formato: `feature/<ID Jira>-<RF>` → ej. `feature/RPT-23-RF-06`
- Toda rama nace desde `develop`.

## Commits

Formato: `tipo(ID Jira): descripción en presente`

```
feat(RPT-23): valida vigencia de la garantía
fix(RPT-24): agrega restricción de fecha límite
```

Tipos permitidos: `feat`, `fix`, `test`, `docs`, `refactor`.

## Pull requests

- Siempre hacia `develop` (nunca directo a `main`).
- Título con el ID de Jira: `RPT-23 Contrato POST /api/garantias/validaciones`.
- Mínimo **1 revisor de otro rol**.
- Sin conflictos y con pruebas en verde antes de aprobar.

## Definición de Hecho (DoD técnica)

- [ ] Compila (`mvn verify`).
- [ ] Pruebas unitarias en verde.
- [ ] CA-02 y CA-03 verificados por Calidad en Postman.
- [ ] PR aprobado y fusionado en `develop`.
- [ ] Sin credenciales en el repositorio.
- [ ] Subtarea en **Hecho** en Jira.

## Enlace Jira – Git

El ID de Jira (`RPT-xx`) va en la rama, en cada commit y en el título del PR. Con la app **GitHub for Jira** se ve el trabajo desde cada ítem.
