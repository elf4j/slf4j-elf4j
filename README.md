# slf4j-elf4j

An [SLF4J](https://www.slf4j.org/) binding to use the [elf4j-impl-core](https://github.com/elf4j/elf4j-impl-core)
library as the runtime logging engine.

## User Story

As an [SLF4J](https://www.slf4j.org/) logging API user, I want to opt to
use [elf4j-impl-core](https://github.com/elf4j/elf4j-impl-core) as the runtime logging engine.

## Prerequisite

* Java 8 or better
* SLF4J 2.x.x

## Get It...

[![Maven Central](https://img.shields.io/maven-central/v/io.github.elf4j/slf4j-elf4j.svg?label=Maven%20Central)](https://central.sonatype.com/search?smo=true&q=pkg%253Amaven%252Fio.github.elf4j%252Fslf4j-elf4j)

## Use it...

Similar to other SLF4J compatible implementations, code against the SLF4J API, and include this module as a
runtime-scope dependency in Maven or other build tools alike. The
usual [elf4j-impl configurations](https://github.com/elf4j/elf4j-impl#configuration) apply.