package plugins

import utils.isLinuxOrMacOs

tasks {
    register<Copy>("copyGitHooks") {
        description = "Copies the git hooks from scripts/git-hooks to the .git folder."
        group = BuildTasksGroups.gitHooks
        from("$rootDir/scripts/git-hooks/") {
            include("**/*.sh")
            rename("(.*).sh", "$1")
        }
        into("$rootDir/.git/hooks")
        fileMode = 0x777
    }

    register<Exec>("installGitHooks") {
        description = "Installs the pre-commit git hooks from scripts/git-hooks."
        group = BuildTasksGroups.gitHooks
        workingDir(rootDir)
        commandLine("chmod")
        args("-R", "+x", ".git/hooks/")
        dependsOn(named("copyGitHooks"))
        onlyIf {
            isLinuxOrMacOs()
        }
        doLast {
            logger.info("Git hooks installed successfully.")
        }
    }

    register<Delete>("deleteGitHooks") {
        description = "Delete the pre-commit git hooks."
        group = BuildTasksGroups.gitHooks
        delete(fileTree(".git/hooks/"))
    }

    afterEvaluate {
        tasks["clean"].dependsOn(tasks.named("installGitHooks"))
    }
}
