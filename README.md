> [!WARNING]  
> This project has been archived and is no longer being actively developed by Elhub.

# common-orchid-theme

[<img src="https://img.shields.io/badge/repo-github-blue" alt=""/>](https://github.com/elhub/common-orchid-theme)

## Table of Contents

* [About](#about)
* [Getting Started](#getting-started)
  * [Prerequisites](#prerequisites)
  * [Installation](#installation)
* [Usage](#usage)
  * [Gradle](#gradle)
  * [Kotlin](#kotlin-script)
* [Testing](#testing)
* [Roadmap](#roadmap)
* [Contributing](#contributing)
* [Owners](#owners)
* [License](#license)


## About

This project is Elhub's standard theme for our Orchid-based documentation. It is based off the standard Orchid BSDoc theme.

## Getting Started

### Prerequisites

See the [quick start guide at orchid.run](https://orchid.run/wiki/user-manual/getting-started/quickstart). This is a
Gradle/Kotlin project.

This project requires [elhub-gradle](https://github.com/elhub/common-elhub-gradle).

If you do not have access to Elhub's internal repository, simply download the above project, assemble the custom gradle
distribution and edit the distributionUrl in _this projects_ gradle-wrapper.properties to point to your local file. 

### Installation

To build the custom distribution:

```sh
./gradlew assemble
```

To publish:
```sh
./gradlew publish
```

## Usage

The theme can be used in one of two ways: either add the theme in your build.gradle.kts or set it in your orchid.kts
script. If you're using elhub-gradle, common-elhub-gradle is predefined as the theme.

### Gradle

Add the Orchid Implementation 

```kotlin
orchidImplementation("io.github.javaeden.orchid:OrchidAll:$orchidVersion")
orchidImplementation("no.elhub.common:common-orchid-theme:1.0-SNAPSHOT")
```

And set the theme to Elhub.

### Kotlin Script

The example/orchid.kts contains a kscript file that can be used to build and serve pages with this theme,
assuming the repository and theme dependency is set up appropriately.

    kscript orchid.kts serve 

## Testing

Gradle unit tests:

```sh
./gradlew test
```

## Contributing

Contributing, issues and feature requests are welcome. See the 
[Contributing](https://github.com/elhub/common-orchid-theme/blob/main/CONTRIBUTING.md) file.

## Owners

This project is developed by [Elhub](https://wwww.elhub.no). For the specific development group responsible for this
code, see the [Codeowners](https://github.com/elhub/common-orchid-theme/blob/main/CODEOWNERS) file.

## License

This project is [MIT](https://github.com/elhub/common-orchid-theme/blob/main/LICENSE.md) licensed.
