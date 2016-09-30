# MapScienceGNI

For correct installation:

You need to install maven (version 2 or 3) and import the project into your IDE of choice (Eclipse/Intellij/etc/etc)

Unfoldingmaps.org do not have a maven artefact of the jars available. Therefore, you have to install the following jars from the /extlib folder into your local maven repository:
- unfolding.0.9.6.jar (unfoldingMaps version 0.9.6)
- json4processing.jar (unfoldingMaps version 0.9.6)
- core.jar (this is an old version 1.5.1 of processing). Unfortunately there is no maven artefact for it
The maven command line to install into your local repo is: (assuming your jars are in the current working directory/folder):

mvn install:install-file -Dfile=./unfolding.0.9.6.jar -DgroupId=org.unfoldingmaps -DartifactId=unfolding -Dversion=0.9.6 -Dpackaging=jar

mvn install:install-file -Dfile=./json4processing.jar -DgroupId=org.unfoldingmaps -DartifactId=json4processing -Dversion=0.9.6 -Dpackaging=jar

mvn install:install-file -Dfile=./core.jar -DgroupId=org.processing -DartifactId=core -Dversion=1.5.1 -Dpackaging=jar