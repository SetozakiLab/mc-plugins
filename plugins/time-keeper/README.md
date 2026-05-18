# TimeKeeper

TimeKeeper is a Paper plugin planned for Setozaki Lab Minecraft servers.

Its goal is to limit continuous play time and encourage players to take breaks
without requiring manual server operator intervention.

## Status

TimeKeeper is currently a planned / prototype plugin. The plugin metadata and
entrypoint exist, and the intended gameplay behavior is being designed and
implemented.

Planned capabilities include:

- Tracking continuous player session time
- Warning players before a configured play-time limit is reached
- Encouraging or enforcing break periods after long sessions
- Keeping the behavior configurable for lab server policies

## Target Server

- Server implementation: Paper
- API version: 1.21
- Java version: 21

## Build

Build only TimeKeeper from the repository root:

```sh
./gradlew :plugins:time-keeper:build
```

The generated plugin JAR is expected under:

```text
plugins/time-keeper/build/libs/
```

## Local Testing

Start the development server from the repository root:

```sh
docker compose -f docker/compose.yml up -d
```

Copy the generated TimeKeeper JAR into the local server plugin directory:

```sh
cp plugins/time-keeper/build/libs/*.jar docker/data/plugins/
```

Restart the Minecraft container:

```sh
docker compose -f docker/compose.yml restart minecraft
```

Check the server logs:

```sh
docker compose -f docker/compose.yml logs -f minecraft
```

## Plugin Metadata

The Bukkit/Paper plugin metadata lives in:

```text
src/main/resources/plugin.yml
```

Current metadata:

- Name: `TimeKeeper`
- Main class: `jp.szlab.mcplugins.timekeeper.TimeKeeperPlugin`
- API version: `1.21`
