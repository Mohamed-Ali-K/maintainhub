# Setting up GitHub Secrets

This guide explains how to set up the required secrets for the GitHub Actions workflows.

## Prerequisites

1. Install GitHub CLI (gh):
   ```bash
   # For Ubuntu/Debian
   curl -fsSL https://cli.github.com/packages/githubcli-archive-keyring.gpg | sudo dd of=/usr/share/keyrings/githubcli-archive-keyring.gpg
   echo "deb [arch=$(dpkg --print-architecture) signed-by=/usr/share/keyrings/githubcli-archive-keyring.gpg] https://cli.github.com/packages stable main" | sudo tee /etc/apt/sources.list.d/github-cli.list > /dev/null
   sudo apt update
   sudo apt install gh

   # For macOS
   brew install gh
   ```

2. Login to GitHub:
   ```bash
   gh auth login
   ```

## Required Secrets

### Database Configuration
- `DB_HOST`: Database host (e.g., localhost)
- `DB_PORT`: Database port (e.g., 5432)
- `DB_NAME`: Database name (e.g., cmms_db)
- `DB_USER`: Database user (e.g., cmms_user)
- `DB_PASSWORD`: Database password (secure password)

### JWT Configuration
- `JWT_SECRET`: Secret key for JWT token generation (use a strong random string)
- `JWT_EXPIRATION`: Token expiration time in milliseconds (e.g., 86400000 for 24 hours)

### Server Configuration
- `SERVER_PORT`: Application server port (e.g., 8080)

### Docker Hub Configuration
- `DOCKERHUB_USERNAME`: Your Docker Hub username
- `DOCKERHUB_TOKEN`: Your Docker Hub access token (not your password)

## Setting up Secrets

### Method 1: Using the Setup Script

1. Navigate to the project root:
   ```bash
   cd maintainhub
   ```

2. Run the setup script:
   ```bash
   ./scripts/setup-secrets.sh
   ```

3. Update the values with your actual credentials

### Method 2: Manual Setup

1. Go to your GitHub repository
2. Click on "Settings"
3. Click on "Secrets and variables" → "Actions"
4. Click "New repository secret"
5. Add each secret with its value

## Security Best Practices

1. Never commit secrets to the repository
2. Use strong, unique passwords
3. Rotate secrets regularly
4. Use different secrets for development and production
5. Limit access to secrets to only necessary team members
6. Use environment-specific values (dev, staging, prod)

## Generating Secure Values

### JWT Secret
```bash
# Generate a secure random string
openssl rand -base64 32
```

### Database Password
```bash
# Generate a secure password
openssl rand -base64 16
```

## Troubleshooting

If you encounter issues:

1. Check GitHub CLI installation:
   ```bash
   gh --version
   ```

2. Verify GitHub authentication:
   ```bash
   gh auth status
   ```

3. Check repository access:
   ```bash
   gh repo view
   ```

4. Verify secrets:
   ```bash
   gh secret list
   ``` 