# Quick start:

Setting Git up:

```bash
git config --global user.name "{your_name}"
git config --global user.email "{your_email@example.com}"
```

Creating or cloning repository:

```bash
git init # to create
# or
git clone {your_repository_url} #to clone
git commit -m"First Commit"
```

Adding files to remote repository:

```bash
git add {file} # add the specified file
git add .  # add all files besides higher directories
git commit -m "{your_commit_message}"
git push
```

All done!

# Configure tooling:

To set the git in your pc for the first time after the installation you will need to run two commands on your terminal:

```bash
git config --global user.name "{your_name}"
git config --global user.email "{your_email@example.com}"
```

These commands will set the name and email that you want to be shown on your commits.

# Creating or cloning a repository:

When creating a repository you need to be in the folder that you want to create the repository and then run the following command:

```bash
git init
```

And simply like that you already create your local repository but it are not on GitHub yet, to send the repository to GitHub we need to make a commit, we can do it using the command:

```bash
git commit -m"First Commit"
```

If you followed all the steps to here you should have a remote repository on your GitHub now.

We also have the option to clone a remote repository instead of create one, to do it we need to run this command:

```bash
git clone {your_repository_url}
```

This command will “download” all the files, branches and commits existents on the repository.

# Branches management:

We can think about branches as parallels universes of a same repository that are independent between them,  all the changes that you make will be made in the branch that you are currently in, to check which branch you are you can use:

```bash
git status
```

To manage the branch we can use some commands, here are the most common:

Creates a new branch with the name that you choose.

```bash
git branch {new_branch_name}
```

Switch to the specified branch and updates the directory.

```bash
git checkout {existent_branch_name}
```

Combines the specified branch into the branch that you are currently in. 

```bash
git merge {existent_branch}
```

Delete the specified branch.

```bash
git branch -d {existent_branch}
```

# Synchronizing changes:

In this topic we will learn how to sync your local repository with the remote one existing in your GitHub.

Download all history from the remote repository.

```bash
git fetch
```

Combines the remote repository branch with the current local one.

```bash
git merge
```

Upload all local branch commits to the remote repository on GitHub.

```bash
git push
```

Updates the local branch with all new commits from the remote repository branch. This command is a combination of “git fetch” and “git merge”.

```bash
git pull
```

# Making changes:

These commands are all to browse and inspect the evolution of the local repository files:

To list the version history we use:

```bash
git log # for the current branch
git log --follow {file} # for a file, including renames
```

To show the content differences between two branches, we can use:

```bash
git diff {branch_a}...{branch_b}
```

To show the metadata and content changes of a specific commit, we use:

```bash
git show {specific_commit}
```

To prepare the file for versioning, we use:

```bash
git add {file} # add the specified file
git add .  # add all files besides higher directories
```

To record added files permanently in version history, we use:

```bash
git commit -m "{your_commit_message}"
```

# Mistakes Handling:

Sometimes we can commit something by mistake, and to this situations we can use the “git reset” command in two different ways:

Undoes all commits after the specified commit:

```bash
git reset {specific_commit}
```

Discards all history and changes back to the specified commit:

```bash
git reset --hard [specific_commit]
```