package git_showcase

import org.apache.spark.sql.SparkSession

/**
 * Hello world!
 *
 */
object App  {
  def main(args: Array[String]): Unit = {

    println( "Hello World!" )

    val sparkSession = SparkSession.builder().master("local").getOrCreate()
    wordCount(sparkSession)
  }

  def wordCount(spark: SparkSession)={

    import spark.implicits._
    val data = spark.sparkContext.parallelize(Seq( (1) ,(2))).toDF("numbere")
    data.show


  }
}
