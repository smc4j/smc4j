# Contributing to SMC4J

Thank you for your interest in contributing to **SMC4J**, an open-source Java library for implementing Smart Money Concepts (SMC). We welcome contributions from the community to help improve the library, add new features, and fix issues. This document outlines the guidelines for contributing to the project.

## How to Contribute

### 1. Getting Started
- **Fork the Repository**: Fork the [SMC4J repository](https://github.com/smc4j/smc4j) to your GitHub account.
- **Clone Your Fork**: Clone your forked repository to your local machine:
  ```bash
  git clone https://github.com/YOUR_USERNAME/smc4j.git
  ```
- **Set Up the Development Environment**:
    - Ensure you have Java 11 or later installed.
    - Use Maven or Gradle to manage dependencies (see [README.md](README.md) for setup instructions).
    - Install an IDE like IntelliJ IDEA or Eclipse for Java development.
- **Create a Branch**: Create a new branch for your changes:
  ```bash
  git checkout -b feature/your-feature-name
  ```

### 2. Making Changes
- **Follow Coding Standards**:
    - Use consistent naming conventions (e.g., camelCase for methods and variables).
    - Write clear, concise, and well-documented code (use Javadoc for public methods).
    - Ensure your code adheres to the project's style, following the existing structure.
- **Write Tests**:
    - Add unit tests for new features or bug fixes using JUnit.
    - Ensure all tests pass by running `mvn test` or `gradle test`.
- **Commit Messages**:
    - Write clear and descriptive commit messages.
    - Use the format: `[type]: Short description of changes` (e.g., `[feat]: Add Fair Value Gap detection`).
    - Types include: `feat` (new feature), `fix` (bug fix), `docs` (documentation), `test` (tests), `refactor` (code refactoring), etc.

### 3. Submitting Your Contribution
- **Push Your Changes**:
  ```bash
  git push origin feature/your-feature-name
  ```
- **Create a Pull Request (PR)**:
    - Go to the [SMC4J repository](https://github.com/smc4j/smc4j) and create a PR from your branch.
    - Provide a clear title and description for your PR, explaining the purpose and changes.
    - Reference any related issues (e.g., `Fixes #123`).
- **Code Review**:
    - Your PR will be reviewed by maintainers. Be open to feedback and make requested changes.
    - Ensure all GitHub Actions CI checks pass.

### 4. Reporting Issues
- Use the [Issues](https://github.com/smc4j/smc4j/issues) page to report bugs or suggest features.
- Provide a clear title and description, including steps to reproduce (for bugs) or a detailed explanation (for feature requests).
- Check for existing issues to avoid duplicates.

### 5. Community Guidelines
- Be respectful and inclusive in all interactions.
- Follow the [Code of Conduct](CODE_OF_CONDUCT.md) to ensure a positive and collaborative environment.

## Development Workflow
- **Dependencies**: Ensure you have all dependencies installed as per the [README.md](README.md).
- **Building the Project**:
    - For Maven: `mvn clean install`
    - For Gradle: `gradle build`
- **Running Tests**: Use `mvn test` or `gradle test` to verify your changes.
- **Formatting**: Use an IDE's auto-format feature to maintain consistent code style.
- **Documentation**: Update Javadoc and relevant documentation (e.g., README.md) for new features or changes.

## Areas for Contribution
We welcome contributions in the following areas:
- **New SMC Features**: Implement additional Smart Money Concepts or enhance existing ones.
- **Performance Improvements**: Optimize algorithms for faster market analysis.
- **Bug Fixes**: Address reported issues to improve reliability.
- **Documentation**: Improve code comments, README, or create tutorials and examples.
- **Tests**: Add or improve unit tests to increase code coverage.
- **CI/CD Enhancements**: Improve GitHub Actions workflows for better automation.

## Questions?
If you have questions or need help, feel free to:
- Open an issue on the [GitHub Issues page](https://github.com/smc4j/smc4j/issues).
- Reach out to maintainers via GitHub Discussions.

Thank you for contributing to SMC4J! Your efforts help make this library a valuable tool for the trading community.
