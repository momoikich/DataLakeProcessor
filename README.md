
# Data Lake Processor

Data Lake Processor is a Spark Scala application for processing and analyzing data. It includes functionalities for data ingestion, transformation, quality checks, aggregation, and more.

## Prerequisites

- Apache Spark installed on your machine.
- Hadoop binaries configured (if required).

## Usage

1. Clone the repository:

   ```bash
   git clone https://github.com/momoikich/DataLakeProcessor.git
   cd data-lake-processor
   ```

2. Build the project:

   ```bash
   sbt clean compile
   ```

3. Run the Data Lake Processor:

   ```bash
   sbt run
   ```

## Configuration

- Adjust SparkSession settings in `DataLakeProcessor.scala` as needed.
- Configure Hadoop home settings if required.

## Features

- **Data Ingestion**: Reads data from a CSV file. Replace the path with your data source.

- **Data Transformation**: Converts the "Name" column to uppercase.

- **Data Quality Checks**: Removes rows with null values.

- **Aggregation**: Counts occurrences of each city for individuals older than 25.

- **Data Enrichment**: Adds a new column "IsAdult" based on the age threshold.

- **Data Partitioning**: Repartitions data by the "City" column.

- **Window Function for Analysis**: Ranks individuals within each city based on age.

## Additional Notes

- Ensure Hadoop binaries are configured if you encounter Hadoop-related issues.
- Adjust paths and configurations based on your specific setup.

## Author

Mohamed IKICH