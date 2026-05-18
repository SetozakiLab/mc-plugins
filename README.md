# mc-plugins

Minecraft server plugins developed and maintained by Setozaki Lab.

This repository is a monorepo for custom Paper plugins used in lab-managed
Minecraft servers. It keeps plugin source code, local development server
configuration, and build tooling in one place.

This project is not affiliated with Mojang, Microsoft, or PaperMC.

## Plugins

| Plugin | Status | Description |
| --- | --- | --- |
| [TimeKeeper](plugins/time-keeper/README.md) | Planned / prototype | Limits continuous play time and encourages players to take breaks. |

## Requirements

- Java 21
- Docker with Docker Compose
- Git
- Optional: [mise](https://mise.jdx.dev/) for installing the Java version defined in `mise.toml`

Use the Gradle wrapper included in this repository. A separate Gradle
installation is not required.

## Quick Start

Install the configured Java runtime if you use `mise`:

```sh
mise install
```

Build all plugins:

```sh
./gradlew build
```

Start the local Paper development server:

```sh
docker compose -f docker/compose.yml up -d
```

Follow server logs:

```sh
docker compose -f docker/compose.yml logs -f minecraft
```

Stop the development server:

```sh
docker compose -f docker/compose.yml down
```

## Repository Layout

```text
.
+-- docker/                 # Local Paper development server
+-- gradle/                 # Gradle wrapper files
+-- plugins/                # Plugin projects
|   `-- time-keeper/        # TimeKeeper plugin
+-- build.gradle            # Root Gradle build
+-- settings.gradle         # Gradle project settings
`-- mise.toml               # Tool version hints
```

The development server stores local Minecraft data under `docker/data/`.
That directory is ignored by Git and may contain generated worlds, logs,
downloaded Paper files, and installed plugin JARs.

## Development Workflow

Create or edit a plugin under `plugins/<plugin-id>/`.

Build the full repository before testing:

```sh
./gradlew build
```

Build a single plugin when iterating:

```sh
./gradlew :plugins:time-keeper:build
```

Copy the generated plugin JAR from the plugin's `build/libs/` directory into
the local server's `docker/data/plugins/` directory, then restart the server:

```sh
docker compose -f docker/compose.yml restart minecraft
```

When adding a new plugin, add it as a Gradle subproject and include its
`plugin.yml` metadata under `src/main/resources/`.

## Local Server

The development server is defined in `docker/compose.yml`.

Current defaults:

- Server type: Paper
- Minecraft version: 1.21.10
- Mode: creative
- Difficulty: peaceful
- Online mode: disabled for local development
- Port: `25565`

These defaults are intended for local testing only. Do not reuse the local
development server configuration as production configuration without review.

## License

This repository is licensed under the [MIT License](LICENSE).
