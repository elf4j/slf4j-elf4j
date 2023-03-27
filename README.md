# slf4j-elf4j

An adapter to use [elf4j-engine](https://github.com/elf4j/elf4j-engine) as the runtime logging engine
of [SLF4J](https://www.slf4j.org/).

## User Story

As an [SLF4J](https://www.slf4j.org/) logging API user, I want to opt to
use [elf4j-engine](https://github.com/elf4j/elf4j-engine) as the runtime logging engine.

## Prerequisite

* Java 8 or better

## Get It...

[![Maven Central](https://img.shields.io/maven-central/v/io.github.elf4j/slf4j-elf4j.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:%22io.github.elf4j%22%20AND%20a:%22slf4j-elf4j%22)

## Use It...

Similar to other SLF4J compatible implementations, code against the SLF4J API, and install this as a runtime-scope
dependency in Maven or other build tools alike:

```html
...
<dependency>
    <groupId>org.slf4j</groupId>
    <artifactId>slf4j-api</artifactId>
    <scope>compile</scope>
</dependency>
<dependency>
    <groupId>io.github.elf4j</groupId>
    <artifactId>slf4j-elf4j</artifactId>
    <scope>runtime</scope>
</dependency>
...
```

The usual elf4j-engine [configuration](https://github.com/elf4j/elf4j-provider#configuration) applies.