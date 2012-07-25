#!/bin/sh

java -Xmx512M -Xss1M -XX:+CMSClassUnloadingEnabled -XX:MaxPermSize=128M \
  $SBTOPTS -jar $(dirname "$0")/sbt-launch.jar "$@"
