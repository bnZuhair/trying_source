#! /bin/env bash

echo "Hi I'm $(whoami)" 
echo "I'm inside a freaking container YaY" 
echo ""

echo "these are some info about this file:"
echo "Owner: $(stat -c "%U" ./talking.sh)"
echo "Permissions: $(stat -c "%A" ./talking.sh)"
