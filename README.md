Bndtools and Maven: A Brave New World
=====================================

This repository contains the project code for the OSGi Community Event 2017 tutorial [Bndtools and Maven: A Brave New World](https://www.eclipsecon.org/europe2017/session/bndtools-and-maven-brave-new-world), presented by [Neil Bartlett](mailto:neil.bartlett@paremus.com) and [Tim Ward](mailto:tim.ward@paremus.com).

This repository contains a series of Git commits that represent the state of the tutorial at various stages. You can use the tags to fast-forward (or rewind) to any stage. For example to skip to the start of stage 2:

    git reset --hard stage02 && git clean -fdx

Building and Running
--------------------

If you just want to see the end result, checkout HEAD and run:

    mvn verify
    java -jar _assembly/target/application.jar

Then navigate to [http://localhost:8080/index.html](http://localhost:8080/index.html).