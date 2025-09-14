# SMC4J - Smart Money Concepts Java Library

Welcome to **SMC4J**, a comprehensive Java library implementing Smart Money Concepts (SMC) for financial market analysis and trading strategies. This library is designed to provide developers with tools to integrate advanced SMC techniques into their trading applications. It is available as a GitHub package, making it easy to include in your Java projects.

## Features

SMC4J provides a robust set of tools to implement Smart Money Concepts, enabling traders and developers to analyze market structures, liquidity, and price action with precision. Below is a list of the implemented Smart Money Concepts along with brief descriptions:

- **Order Blocks**: Zones where significant buy or sell orders are placed by institutional traders, often acting as support or resistance levels. SMC4J identifies bullish and bearish order blocks for strategic entry points.
- **Fair Value Gaps (FVG)**: Price gaps created due to imbalances in buying and selling pressure, indicating potential areas for price to return and fill. The library detects these gaps for precise market analysis.
- **Liquidity Grabs**: Areas where stop-loss orders are clustered, often targeted by smart money to trigger liquidity. SMC4J provides methods to identify potential liquidity zones.
- **Break of Structure (BOS)**: A shift in market structure indicating a trend continuation. The library includes algorithms to detect BOS for trend-following strategies.
- **Change of Character (CHoCH)**: A reversal in market structure signaling a potential trend change. SMC4J helps identify these pivotal moments for reversal trading.
- **Imbalance Zones**: Areas where rapid price movements leave unfilled orders, often revisited by price. The library maps these zones for trade planning.
- **Supply and Demand Zones**: High-probability areas where institutional traders place orders. SMC4J calculates these zones to enhance trade decision-making.
- **Market Structure Analysis**: Tools to analyze higher highs, higher lows, lower highs, and lower lows to determine trend direction and strength.
- **Smart Money Reversals**: Patterns indicating potential reversals driven by institutional activity, implemented for predictive accuracy.

These features empower developers to build sophisticated trading algorithms leveraging institutional trading behaviors.

## Installation

SMC4J is hosted as a GitHub Package. Follow the steps below to integrate it into your Java projects using Maven or Gradle.

### Maven

1. **Add the GitHub Package Repository**:
   Add the GitHub Packages repository to your `pom.xml` file.

   ```xml
   <repositories>
       <repository>
           <id>github-smc4j</id>
           <name>GitHub SMC4J Packages</name>
           <url>https://maven.pkg.github.com/smc4j/smc4j</url>
       </repository>
   </repositories>
   ```

2. **Add the Dependency**:
   Include the SMC4J dependency in your `pom.xml`.

   ```xml
   <dependency>
       <groupId>com.smc4j</groupId>
       <artifactId>smc4j</artifactId>
       <version>1.0.0</version>
   </dependency>
   ```

3. **Authenticate with GitHub**:
   Since GitHub Packages requires authentication, add your GitHub credentials to your `~/.m2/settings.xml` file.

   ```xml
   <settings>
       <servers>
           <server>
               <id>github-smc4j</id>
               <username>YOUR_GITHUB_USERNAME</username>
               <password>YOUR_GITHUB_PERSONAL_ACCESS_TOKEN</password>
           </server>
       </servers>
   </settings>
   ```

   Generate a Personal Access Token (PAT) from GitHub with `read:packages` scope.

4. **Build Your Project**:
   Run `mvn install` to download and include SMC4J in your project.

### Gradle

1. **Add the GitHub Package Repository**:
   Update your `build.gradle` file to include the GitHub Packages repository.

   ```gradle
   repositories {
       maven {
           url = uri("https://maven.pkg.github.com/smc4j/smc4j")
           credentials {
               username = project.findProperty("gpr.user") ?: System.getenv("GITHUB_USERNAME")
               password = project.findProperty("gpr.key") ?: System.getenv("GITHUB_TOKEN")
           }
       }
   }
   ```

2. **Add the Dependency**:
   Include the SMC4J dependency in your `build.gradle`.

   ```gradle
   dependencies {
       implementation 'com.smc4j:smc4j:1.0.0'
   }
   ```

3. **Set Up Authentication**:
   Create a `gradle.properties` file in your `~/.gradle` directory or project root with your GitHub credentials.

   ```properties
   gpr.user=YOUR_GITHUB_USERNAME
   gpr.key=YOUR_GITHUB_PERSONAL_ACCESS_TOKEN
   ```

   Alternatively, set `GITHUB_USERNAME` and `GITHUB_TOKEN` as environment variables.

4. **Build Your Project**:
   Run `gradle build` to include SMC4J in your project.

Replace `PriceData` with your actual market data input. Refer to the [GitHub repository](https://github.com/smc4j/smc4j) for detailed documentation and additional examples.

## GitHub Actions Status

The SMC4J library is built and tested using GitHub Actions to ensure reliability and compatibility. Below is the status of the latest build:

![GitHub Actions Build Status](https://github.com/smc4j/smc4j/actions/workflows/gradle-build.yml/badge.svg)

Check the [GitHub Actions page](https://github.com/smc4j/smc4j/actions) for detailed build logs and results.

## Current Version

| Version | Release Date | Notes |
|---------|--------------|-------|
| 0.0.1   | 2025-10-05   | Initial release with core SMC features |

## Contributing

Contributions are welcome! Please follow these steps:
1. Fork the repository.
2. Create a new branch (`git checkout -b feature/your-feature`).
3. Commit your changes (`git commit -m 'Add your feature'`).
4. Push to the branch (`git push origin feature/your-feature`).
5. Open a Pull Request.

See [CONTRIBUTING.md](CONTRIBUTING.md) for more details.

## License

This project is licensed under the Apache-2.0 License. See the [LICENSE](LICENSE) file for details.
