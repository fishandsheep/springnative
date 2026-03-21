# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

This is a Spring Boot 4 demo project for experimenting with GraalVM native image compilation. The project uses Spring Native to compile Java applications into native executables for faster startup and lower memory footprint.

**Tech Stack:**
- Spring Boot 4.0.3
- Java 25
- GraalVM native-maven-plugin
- Maven wrapper (mvnw)

## Build Commands

### Standard Maven Commands
```bash
./mvnw clean package      # Build JAR
./mvnw test               # Run tests
./mvnw spring-boot:run    # Run application
```

### Native Image Compilation

**Default (glibc):**
```bash
./mvnw -Pnative native:compile
```

**Mostly static (glibc only):**
```bash
./mvnw -Pnative native:compile -DbuildArgs=-H:+StaticExecutableWithDynamicLibC
```

**Fully static (musl only):**
```bash
./mvnw -Pnative native:compile -DbuildArgs=--static,--libc=musl
```

**Note:** Fully static compilation requires a JDK with static musl libraries from https://github.com/graalvm/labs-openjdk-*/releases

### Running the Native Executable
```bash
./target/springnative
```

## Project Structure

```
src/main/java/com/example/springnative/
├── SpringnativeApplication.java    # Main entry point
└── contoller/
    └── NativeController.java       # REST controller example
```

## Key Points

- Use `./mvnw` (Maven wrapper) instead of `mvn` for consistent builds
- The native profile (`-Pnative`) activates GraalVM native compilation
- Native compilation requires GraalVM to be installed
- After native compilation, the executable is output to `target/springnative`
