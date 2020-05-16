# NanoMaven [![Build Status](https://travis-ci.org/dzikoysk/nanomaven.svg?branch=master)](https://travis-ci.org/dzikoysk/nanomaven)
Lightweight repository manager for Maven artifacts. 
It is a simple solution to replace managers like Nexus, Archiva or Artifactory. 

![Preview](https://user-images.githubusercontent.com/4235722/78812901-73b8c680-79cc-11ea-95d5-9763a53e4240.png)

#### Features
* [x] Working Maven repository manager *(example: [repo.panda-lang.org](https://repo.panda-lang.org))*
* [x] Authorization *(deploy and downloads)*
* [x] Deploy *(using tokens and BCrypt)*
* [x] Customizable front page
* [x] [dependabot](https://dependabot.com/) supported
* [x] Multiple repositories under a single URL
* [x] Snapshots
* [x] CLI
* [ ] Statistics
* [ ] Proxy for the specified remote repositories
* [ ] Admin panel

#### Installation
Releases: [GitHub Downloads](https://github.com/dzikoysk/NanoMaven/releases) <br>
Requirements: 
* Java 8+
* RAM 4MB+

| Amount | Description |
|:------:|-------------|
| *4MB* | Tiny repository for personal projects |
| *8MB* - *32MB* | *--------------------^------------------* + CI |
| *48MB - 128MB* | Tiny public repository *(recommended)* |
| *128MB+* | Public repository | 

To launch NanoMaven with defined amount of RAM, use `Xmx` parameter:
```bash
java -Xmx<Amount>M -jar nanomaven.jar
```
If you will not define the memory size, NanoMaven will probably use around *~30 to ~250MB*.

#### Guide
List of available management commands

```bash
NanoMaven 2.2.2 Commands:
  help - List available commands
  status - Display metrics
  tokens - List all generated tokens
  keygen <path> <alias> - Generate a new access token for the given path
  purge - Clear cache
  stop - Shutdown server
```

To deploy artifacts we have to generate `access token` assigned to the given path. Example usages:

```bash
keygen / admin
19:55:20.692 INFO | Generated new access token for admin (/)
19:55:20.692 INFO | AW7-kaXSSXTRVL_Ip9v7ruIiqe56gh96o1XdSrqZCyTX2vUsrZU3roVOfF-YYF-y
19:55:20.723 INFO | Stored tokens: 1

keygen /org/panda-lang/nanomaven nanomaven
19:56:09.109 INFO | Generated new access token for nanomaven (/org/panda-lang/nanomaven)
19:56:09.109 INFO | OFnV-2GiZeX0cHpeDvuLo0xjUpU5wNUcpkR4521fG68U9anfqNwKsVkFcQUCK4yk
19:56:09.114 INFO | Stored tokens: 2
```

To use generated token add a new server in your `./m2/settings.xml`  

```xml
<server>
  <id>{repository-id}</id>
  <username>{alias}</username>
  <password>{token}</password>
</server>
```
