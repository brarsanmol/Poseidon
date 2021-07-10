# Poseidon
A library to easily modify the Minecraft tablist.

## Requirements
* Java 8 or Greater
* ProtocolLib 4.5.0
* Spigot (1.8 or Greater)

## Installation
> Enter the following into your terminal.
```shell
git clone https://github.com/brarsanmol/Poseidon.git
cd Poseidon
mvn clean install
```
> Then add the following snippet into your pom.xml.
```xml
<dependency>
    <groupId>ca.anmolbrar</groupId>
    <artifactId>Poseidon</artifactId>
    <version>1.2</version>
    <type>jar</type>
    <scope>compile</scope>
</dependency>
```

## Usage

> The code sample below is a basic implementation to show you how to get up and running with the library.
```java
import org.bukkit.plugin.java.JavaPlugin;

public final class PoseidonPlugin extends JavaPlugin {

    private static PoseidonPlugin instance;
    private Poseidon poseidon;
    private PoseidonTablistTask task;

    @Override
    public void onEnable() {
        instance = this;
        this.poseidon = new Poseidon(this, 10L);
        this.task = new PoseidonTablistTask();
    }

    @Override
    public void onDisable() {
        this.task.cancel();
        this.poseidon = null;
        instance = null;
    }

    public static PoseidonPlugin getInstance() {
        return instance;
    }

    public Poseidon getPoseidon() {
        return poseidon;
    }
}
```

```java
import org.bukkit.scheduler.BukkitRunnable;

public final class PoseidonTablistTask extends BukkitRunnable {

    public PoseidonTablistTask() {
        runTaskTimerAsynchronously(Poseidon.getInstance().getPlugin(), 20L, 20L);
    }

    @Override
    public void run() {
        PoseidonPlugin.getInstance().getPoseidon().getTablistManager().getTablists().values().forEach(tablist -> {
            for (int column = 0; column < 4; column++) {
                for (int row = 0; row < 20; row++) {
                    tablist.getSlot(column, row).setText("Slot: " + column + ", " + row);
                }
            }
        });
    }
}
```

> Result

![Result of Usage Code](https://i.imgur.com/w4SYJVV.png)

## Contributing
Have a feature that you want to add, or a bug fix? Feel free to open a pull request or an issue!

## Upcoming Features
* Support 1.7.10.
* Add ability to change skins.
* Make tablist size configurable.
* Utility method to clear player tablist.
* Provide default tablist.
* Javadocs

## Contributors
* [Anmol Brar](https://www.github.com/brarsanmol)

## License
* [MIT](LICENSE.md)