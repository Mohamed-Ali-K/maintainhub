# Git Workflow Guide

## Branch Structure
- `main`: Production-ready code
- `develop`: Development branch
- Feature branches: Created from `develop`

## Workflow Rules

### 1. Branch Creation
- ✅ Create new branches ONLY from `develop`
- ❌ Never create branches from `main`
- ❌ Never commit directly to `main` or `develop`

### 2. Development Process
1. Create feature branch from `develop`:
   ```bash
   git checkout develop
   git pull origin develop
   git checkout -b feature/your-feature-name
   ```

2. Work on your feature branch
3. Commit your changes
4. Push your branch:
   ```bash
   git push origin feature/your-feature-name
   ```

### 3. Merging Process
1. Merge feature branches into `develop`:
   ```bash
   git checkout develop
   git pull origin develop
   git merge feature/your-feature-name
   git push origin develop
   ```

2. After successful merge to `develop`, delete the feature branch:
   ```bash
   git branch -d feature/your-feature-name
   git push origin --delete feature/your-feature-name
   ```

3. Merge `develop` into `main` (only when ready for production):
   ```bash
   git checkout main
   git pull origin main
   git merge develop
   git push origin main
   ```

### 4. Branch Protection Rules
- `main` branch:
  - Protected from direct pushes
  - Requires pull request reviews
  - Can only be merged from `develop`
  - Requires status checks to pass

- `develop` branch:
  - Protected from direct pushes
  - Requires pull request reviews
  - Can be merged from feature branches
  - Requires status checks to pass

### 5. Commit Messages
Use conventional commits format:
- `feat:` for new features
- `fix:` for bug fixes
- `docs:` for documentation changes
- `style:` for formatting changes
- `refactor:` for code refactoring
- `test:` for adding tests
- `chore:` for maintenance tasks

Example:
```
feat: Add user authentication
fix: Resolve database connection issue
docs: Update API documentation
```

### 6. Pull Request Process
1. Create pull request from feature branch to `develop`
2. Ensure all tests pass
3. Get code review approval
4. Merge to `develop`
5. Delete feature branch
6. Create pull request from `develop` to `main` when ready for production

### 7. Emergency Hotfixes
If urgent fixes are needed in production:
1. Create hotfix branch from `main`:
   ```bash
   git checkout main
   git pull origin main
   git checkout -b hotfix/issue-description
   ```
2. Make changes and commit
3. Merge hotfix to both `main` and `develop`
4. Delete hotfix branch

## Best Practices
1. Keep branches up to date with their parent branch
2. Resolve conflicts locally before pushing
3. Write clear commit messages
4. Review your changes before committing
5. Keep commits atomic and focused
6. Test thoroughly before merging
7. Clean up branches after merging 