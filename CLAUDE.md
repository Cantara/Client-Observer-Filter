# Client-Observer-Filter

## Purpose
A servlet filter library that identifies and observes API clients by tracking cookie IDs, client IPs, and browser types. Integrating this library into your API allows you to observe individual user behaviors and generate client usage reports.

## Tech Stack
- Language: Java 8+
- Framework: Servlet API (Dropwizard compatible)
- Build: Maven
- Key dependencies: javax.servlet-api, Constretto, Guava, SLF4J

## Architecture
Standalone servlet filter library designed to be embedded into any Java web application. It intercepts HTTP requests, extracts client identification data (cookies, IP, user-agent), and logs observations. Follows a simple filter-chain pattern with pluggable reporting.

## Key Entry Points
- `ClientObserverFilter` - Main servlet filter class
- `pom.xml` - Maven build configuration

## Development
```bash
# Build
mvn clean install

# Test
mvn test
```

## Domain Context
API observability and client analytics. Tracks which clients are using your API endpoints, enabling usage analysis and behavioral insights. Part of the Cantara monitoring and operations toolset.
