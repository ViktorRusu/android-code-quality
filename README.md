<p align="center">
<a href="https://pinterest.github.io/ktlint/"><img src="https://img.shields.io/badge/code%20style-%E2%9D%A4-FF4081.svg" alt="ktlint"></a>
</p>

### Features 🎨
- Kotlin Static Analysis via [detekt](https://github.com/detekt/detekt) and [ktlint](https://github.com/pinterest/ktlint)

### Static Analysis 🔍
This project uses [ktlint](https://github.com/pinterest/ktlint) and [detekt](https://github.com/detekt/detekt) for source code analysis.
| Tool                                                   | Config file  | Check command      | Fix command               |
|---------------------------------------------------------|--------------|--------------------|---------------------------|
| [KtLint](https://github.com/pinterest/ktlint)           | -            | `./gradlew ktlintCheck` | `./gradlew ktlintFormat`  |
| [Detekt](https://github.com/detekt/detekt)           | [config.yml](config/detekt/config.yml)   | `./gradlew detekt` | -  |

All of these tools are integrated into a [pre-commit git hook](/scripts/git-hooks/pre-commit.sh). This ensures that the code is checked against them before each commit. 

To skip them for a particular commit, add `--no-verify` option to the commit command:
```shell
git commit -m "commit_message" --no-verify
```
