# cy-notify-lib

Core notification library for CY-Notify system.

## Overview

A library for managing notifications using Spring Boot and Freemarker templates.

## Deployment

```bash
mvn release:prepare -P github
```
This command:
- Checks for uncommitted changes
- Updates version numbers in POM files
- Creates a new git tag
- Commits the changes
- Pushes to GitHub

```bash
mvn release:perform -P github
```
This command:
- Checks out the tagged version
- Builds and tests the code
- Deploys artifacts to GitHub packages
- Updates to next SNAPSHOT version

**Note:** Both commands require:
- Valid GitHub authentication token
- Clean working directory
- Proper GitHub permissions