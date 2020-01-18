package main.scala.dataframeAPI


import org.apache.spark.sql.types.{IntegerType, StringType, StructField, StructType}
import org.apache.spark.sql.{Row, SparkSession}

object JoinTest {



  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("joinTest").master("local").getOrCreate()
      //.conf("spark.sql.autoBroadcastJoinThreshold",-1)

    spark.sqlContext.setConf("spark.sql.autoBroadcastJoinThreshold","-1")
    joinTest_inner(spark)


  }

  def joinTest_inner(spark : SparkSession ) : Unit ={
    //val order = spark.sparkContext.parallelize( Seq( (1,"a"),(2,"b"),(3,"c") , (null,"null_order") )).toDF("order_id" , "order_name")

    val order = spark.sparkContext.parallelize( Seq( (Row(1,"a")), Row(2,"b"),Row(null,"null_order")))
    val someSchema = List(
      StructField("number", IntegerType, true),
      StructField("word", StringType, true)
    )

    val schema = StructType(List(
      StructField("order_id",IntegerType,true),
      StructField("order_name",StringType,true)
    ))
    val orderDF = spark.createDataFrame(order, schema)

    val customer = spark.sparkContext.parallelize( Seq( Row(1,"c1"),Row(2,"c2"),Row(null,"c3") , Row(null,"null_cust") ))
    val schema_cust = StructType(List(
      StructField("cust_id",IntegerType,true),
      StructField("cust_name",StringType,true)
    ))

    val custDF = spark.createDataFrame(customer, schema_cust)

    val order_cust = orderDF.join(custDF , orderDF("order_id") === custDF("cust_id") , "inner")

    //order_cust.explain(true)

    order_cust.show()
    /*
    +--------+----------+-------+---------+
|order_id|order_name|cust_id|cust_name|
+--------+----------+-------+---------+
|       1|         a|      1|       c1|
|       2|         b|      2|       c2|
+--------+----------+-------+---------+
     */

    val order_cust_1 = orderDF.join(custDF , orderDF("order_id") <=> custDF("cust_id") , "inner")
    order_cust_1.show()
    /*
    +--------+----------+-------+---------+
|order_id|order_name|cust_id|cust_name|
+--------+----------+-------+---------+
|       1|         a|      1|       c1|
|       2|         b|      2|       c2|
|    null|null_order|   null|       c3|
|    null|null_order|   null|null_cust|
+--------+----------+-------+---------+
     */

  }


}
