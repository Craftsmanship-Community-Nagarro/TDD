FROM mcr.microsoft.com/vscode/devcontainers/base:ubuntu-22.04

# Args for customization
ARG GRADLE_VERSION=8.8
ARG MAVEN_VERSION=3.9.9
ARG INSTALL_GRADLE=true
ARG INSTALL_MAVEN=true
ARG INSTALL_NODE=false
ARG NODE_VERSION=lts/*

# Install Java 21
RUN apt-get update && export DEBIAN_FRONTEND=noninteractive \
    && apt-get -y install --no-install-recommends software-properties-common dos2unix \
    && add-apt-repository -y ppa:openjdk-r/ppa \
    && apt-get update \
    && apt-get -y install --no-install-recommends openjdk-21-jdk \
    && apt-get clean \
    && rm -rf /var/lib/apt/lists/*

# Set JAVA_HOME
ENV JAVA_HOME=/usr/lib/jvm/java-21-openjdk-amd64
ENV PATH="${JAVA_HOME}/bin:${PATH}"

# Install Gradle if requested
RUN if [ "${INSTALL_GRADLE}" = "true" ]; then \
    curl -sSL -o gradle.zip "https://services.gradle.org/distributions/gradle-${GRADLE_VERSION}-bin.zip" \
    && unzip gradle.zip -d /opt \
    && rm gradle.zip \
    && mv /opt/gradle-${GRADLE_VERSION} /opt/gradle \
    && ln -s /opt/gradle/bin/gradle /usr/local/bin/gradle; \
    fi

# Install Maven if requested
RUN if [ "${INSTALL_MAVEN}" = "true" ]; then \
    curl -sSL -o maven.zip "https://archive.apache.org/dist/maven/maven-3/${MAVEN_VERSION}/binaries/apache-maven-${MAVEN_VERSION}-bin.zip" \
    && unzip maven.zip -d /opt \
    && rm maven.zip \
    && mv /opt/apache-maven-${MAVEN_VERSION} /opt/maven \
    && ln -s /opt/maven/bin/mvn /usr/local/bin/mvn; \
    fi

# Install Node.js if requested
RUN if [ "${INSTALL_NODE}" = "true" ]; then \
    curl -fsSL https://deb.nodesource.com/setup_lts.x | bash - \
    && apt-get -y install --no-install-recommends nodejs \
    && apt-get clean \
    && rm -rf /var/lib/apt/lists/*; \
    fi

# Set up gradle environment variables
ENV GRADLE_HOME=/opt/gradle
ENV PATH=$PATH:/opt/gradle/bin

# Enable universe repository
RUN add-apt-repository -y universe
# Expose port 8080 and 8081
EXPOSE 8080
EXPOSE 8081
