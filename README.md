# DataLakeProcessor

DataLakeProcessor est une application Spark Scala permettant d'ingérer, de transformer et d'analyser de grands ensembles de données à l'aide d'Apache Spark.

## Prérequis

Avant d'exécuter l'application, assurez-vous d'avoir installé les éléments suivants :

- Apache Spark (version 3.2.0)
- Scala (version 2.13.12)
- SBT (Scala Build Tool)

## Utilisation

1. Clonez le dépôt :

   ```bash
   git clone https://github.com/momoikich/DataLakeProcessor.git
   cd DataLakeProcessor
   ```

2. Compilez le projet :

   ```bash
   sbt clean compile
   ```

3. Exécutez l'application :

   ```bash
   sbt run
   ```

4. Consultez les données traitées :

   L'application affichera les données transformées et agrégées dans la console.

## Configuration

- Modifiez la source de données d'entrée :

  Remplacez le chemin du fichier CSV dans la fonction `main` de `DataLakeProcessor.scala` par le chemin de votre source de données réelle.

  ```scala
  val rawData: DataFrame = spark.read.option("header", "true").csv("votre/chemin/vers/les/données.csv")
  ```

- Personnalisez les transformations :

  Ajustez les fonctions `transformData` et `performDataQualityChecks` dans `DataLakeProcessor.scala` en fonction de vos besoins de traitement des données.

## Contribution

N'hésitez pas à contribuer en ouvrant des problèmes ou en soumettant des demandes de fusion.

## Licence

Ce projet est sous licence [MIT](LICENSE).
```

Assurez-vous de personnaliser le fichier README en fonction de la structure de votre projet et des détails spécifiques.
 
