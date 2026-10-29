# Text Plugin System

A command-line text processing tool that can be extended with plugins. The core never changes: a new feature is a new plugin (Open/Closed Principle), and the core depends only on the `SzovegPlugin` interface (Dependency Inversion Principle).

## Requirements

- Java 11
- Windows, Git Bash (or any shell with `javac`)

## Structure

- `src/core` (package `szovegplugin`): the interface, `PluginBetolto` (ServiceLoader), `Lanc` (pipeline), `Main` (command line)
- `src/plugins` (package `szovegplugin.plugins`): the five plugins and `META-INF/services`
- `test`: JUnit 4 tests and `HibasPlugin`, a plugin that always throws (test only, not registered)

See the class diagram in [docs/uml.md](docs/uml.md).

## Build and run

```
javac -d out $(find src -name "*.java")
cp -r src/plugins/META-INF out/
java -cp out szovegplugin.Main --list
```

`javac` does not copy `META-INF`, so the `cp` step is needed after every build.

## Options

| Option | Meaning |
|---|---|
| `--plugin a,b,c` | plugins to run, in this order |
| `--in file` | read input from a file (default: stdin) |
| `--out file` | write output to a file (default: stdout) |
| `--list` | list the available plugins |

## Available plugins

| Name | What it does |
|---|---|
| `nagybetu` | converts the text to upper case |
| `szamlal` | counts the words |
| `ekezettelen` | removes accents |
| `palindrom` | checks if the text is a palindrome |
| `caesar` | Caesar cipher, shift 3 |

## Examples

```
echo "Árvíztűrő tükörfúrógép" | java -cp out szovegplugin.Main --plugin ekezettelen,nagybetu
ARVIZTURO TUKORFUROGEP

echo "Árvíztűrő tükörfúrógép" | java -cp out szovegplugin.Main --plugin ekezettelen,nagybetu,szamlal
2

java -cp out szovegplugin.Main --plugin nagybetu --in in.txt --out ki.txt
```

If a plugin throws an exception or does not support the input, the chain logs a warning to stderr, skips that plugin and continues with the last good value.

## How to write a new plugin in 5 steps

1. Create a class in `src/plugins/szovegplugin/plugins/` that `implements SzovegPlugin`.
2. Give it a public no-argument constructor (the default one is enough), because `ServiceLoader` needs it.
3. Implement `nev()` (the command-line name), `leiras()` and `feldolgoz(String)`. Optionally override `tamogatja(String)`.
4. Add the full class name on a new line to `src/plugins/META-INF/services/szovegplugin.SzovegPlugin`.
5. Rebuild, copy `META-INF` to `out`, and check with `--list`. The core code is not touched.

## Tests

`test/szovegplugin/SzovegPluginTest.java` has 8 JUnit 4 tests: each plugin, the chain order, the failing plugin being skipped (`HibasPlugin`), and the loader finding all five plugins. Run them in NetBeans (Test File) with JUnit 4.13.2 and Hamcrest.

## AI usage

I used Claude as a tutor. It did not write my code: it gave me a step-by-step plan, skeleton code with TODO comments and the key lines as comments, and corrected the code I sent back. The text of the plugin descriptions (`leiras()`), the `Lanc.leiras()` text, and this README were drafted by Claude and I checked them. I typed the code into the project myself.