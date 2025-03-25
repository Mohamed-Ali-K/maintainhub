#!/bin/bash

# Colors for output
GREEN='\033[0;32m'
RED='\033[0;31m'
NC='\033[0m' # No Color

# Check if gh CLI is installed
if ! command -v gh &> /dev/null; then
    echo -e "${RED}GitHub CLI is not installed. Please install it first:${NC}"
    echo "https://cli.github.com/manual/installation"
    exit 1
fi

# Check if user is logged in to GitHub
if ! gh auth status &> /dev/null; then
    echo -e "${RED}Please login to GitHub first:${NC}"
    echo "gh auth login"
    exit 1
fi

# Get repository name
REPO=$(gh repo view --json nameWithOwner -q .nameWithOwner)

# Function to set secret
set_secret() {
    local secret_name=$1
    local secret_value=$2
    echo -e "${GREEN}Setting $secret_name...${NC}"
    gh secret set $secret_name -b "$secret_value" -R $REPO
}

# Database Configuration
set_secret "DB_HOST" "localhost"
set_secret "DB_PORT" "5432"
set_secret "DB_NAME" "cmms_db"
set_secret "DB_USER" "cmms_user"
set_secret "DB_PASSWORD" "cmms_password"

# JWT Configuration
set_secret "JWT_SECRET" "your_jwt_secret_key_here"
set_secret "JWT_EXPIRATION" "86400000"

# Server Configuration
set_secret "SERVER_PORT" "8080"

# Docker Hub Configuration
set_secret "DOCKERHUB_USERNAME" "your_dockerhub_username"
set_secret "DOCKERHUB_TOKEN" "your_dockerhub_token"

echo -e "${GREEN}All secrets have been set!${NC}"
echo -e "${RED}Please make sure to update the values with your actual production credentials!${NC}" 