package com.example

import org.apache.spark.sql.{SparkSession, DataFrame}
import org.apache.spark.sql.functions._
import org.apache.spark.sql.expressions.Window

object DataLakeProcessor {

  def main(args: Array[String]): Unit = {
    // Initialize SparkSession
    val spark = SparkSession.builder
        .appName("DataLakeProcessor")
        .master("local[*]")
        .config("spark.hadoop.fs.defaultFS", "file:///")
        .getOrCreate()


    // Ingest data (Replace this with your actual data source)
    val rawData: DataFrame = spark.read.option("header", "true").csv(raw"C:\Users\hammi\OneDrive\Bureau\hello-world\src\main\scala\csv\file.csv")

    // Data Transformation
    val transformedData: DataFrame = transformData(rawData)

    // Data Quality Checks
    val cleanData: DataFrame = performDataQualityChecks(transformedData)

    // Display the processed data
    cleanData.show()

    // Aggregation
    val aggregatedData: DataFrame = aggregateData(cleanData)

    // Display the aggregated data
    aggregatedData.show()

    // Data Enrichment
    val enrichedData: DataFrame = enrichData(cleanData)

    // Display the enriched data
    enrichedData.show()

    // Data Partitioning
    val partitionedData: DataFrame = partitionData(cleanData)

    // Display the partitioned data
    partitionedData.show()

    // Window Function for Analysis
    val windowSpec = Window.partitionBy("City").orderBy(desc("Age"))
    val rankData: DataFrame = cleanData.withColumn("Rank", rank().over(windowSpec))

    // Display data with rank
    rankData.show()

    // Stop SparkSession
    spark.stop()
  }

  def transformData(data: DataFrame): DataFrame = {
    // Example Transformation: Convert column to uppercase
    data.withColumn("Name", upper(col("Name")))
  }

  def performDataQualityChecks(data: DataFrame): DataFrame = {
    // Example Data Quality Check: Remove rows with null values
    data.na.drop()
  }

  def aggregateData(data: DataFrame): DataFrame = {
    // Aggregation: Count occurrences of each city for individuals older than 25
    data.filter(col("Age").cast("int") > 25)
      .groupBy("City")
      .agg(count("*").alias("Count"))
  }

  def enrichData(data: DataFrame): DataFrame = {
    // Example Data Enrichment: Add a new column "IsAdult"
    data.withColumn("IsAdult", when(col("Age").cast("int") >= 18, "Yes").otherwise("No"))
  }

  def partitionData(data: DataFrame): DataFrame = {
    // Example Data Partitioning: Partition data by the "City" column
    data.repartition(col("City"))
  }
}
