#!/usr/bin/env bash
set -e
MAVEN_VERSION="3.9.9"
PROJECT_DIR="$(cd "$(dirname "$0")" && pwd)"
WRAPPER_DIR="$PROJECT_DIR/.mvn/wrapper"
MAVEN_HOME="$WRAPPER_DIR/apache-maven-$MAVEN_VERSION"
MAVEN_ZIP="$WRAPPER_DIR/apache-maven-$MAVEN_VERSION-bin.zip"
MAVEN_URL="https://archive.apache.org/dist/maven/maven-3/$MAVEN_VERSION/binaries/apache-maven-$MAVEN_VERSION-bin.zip"

if [ ! -x "$MAVEN_HOME/bin/mvn" ]; then
  echo "Maven Wrapper: baixando Apache Maven $MAVEN_VERSION..."
  mkdir -p "$WRAPPER_DIR"
  if command -v curl >/dev/null 2>&1; then
    curl -L "$MAVEN_URL" -o "$MAVEN_ZIP"
  else
    wget "$MAVEN_URL" -O "$MAVEN_ZIP"
  fi
  unzip -q "$MAVEN_ZIP" -d "$WRAPPER_DIR"
fi

exec "$MAVEN_HOME/bin/mvn" "$@"
