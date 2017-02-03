package edu.knoldus

/**
  * Created by prashant on 03-02-2017.
  */

import java.io._
//import scala.io._

class ListOfFiles {

  def getDirectories(directoryName: String): List[File] = {
    val directories = new File(directoryName).listFiles.filter(_.isDirectory).map(_.getName).toList
    //val files= foreach (dir => directories)dir.listFiles.filter(_.isFile).toList
    var files:List[File]=Nil
    if (directories.nonEmpty){
      for (dir <- directories) {

        files = files ::: getFiles(dir)
      }
    files
    }
    else
    new File (directoryName).listFiles.filter(_.isFile).toList

  }

  def getFiles(directory: String): List[File] = {
    val dir = new File(directory)
        if(dir.listFiles.filter(_.isDirectory).nonEmpty) {
          getDirectories(dir.toString)

        }
      //dir.listFiles.filter(_.isFile).toList

    else {
      //List[File]()
          dir.listFiles.filter(_.isFile).toList
    }
  }

}

object MyObj extends App {
  val obj = new ListOfFiles
  for (file<-obj.getDirectories("C:\\Users\\prashant\\Desktop\\project31-01-2017\\src"))
    println(file)
}