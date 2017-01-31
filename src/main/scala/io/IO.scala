package io

import java.io.File
import scala.io.Source

class IO {
val dir = new File("/home/rc/workspaces/ISOF/isof_test_ng/")
/*
def listDirs(x:String) = {
    (new File(x))
      .listFiles()
      .filter(_.isDirectory)
      .map(_.getAbsolutePath)
}
listDirs(dir).foreach(println)
*/
def _list_( file : File):List[File] = {
  var list:List[File] = List()
  file.listFiles.foreach{
    f => f match {
      case f if f.isDirectory => list=list:::_list_(f)
      case f if f.isFile && f.getName.indexOf(".hdb")>0 => list=f::list
      case _ => "not interesting"
    }
  }
  list
  }
def _list__( file : File):List[File] = {
  var list:List[File] = List()
  file.listFiles.foreach{
    f => f match {
      case f if f.isDirectory => list=list:::_list__(f)
      case f if f.isFile => list=f::list
    }
  }
  // println("_list__, list= "+list)
  list
  }
  def list0Level(file : File):List[File] = {
    var list = List()
    file.listFiles.foreach{
      x => x match {
        case x if x.isFile => println("plik "+x.getName); println("-----");
        case x if x.isDirectory => println("katalog "+x.getName)
      }
    }
    list
  }
  def readFileLines(file: File) = {
      getFileSource(file)
      .getLines
      .foreach(x => println(x))
  }
  def getFileSource(file:File) ={
    Source.fromFile(file.getAbsolutePath)
  }
}
object IO {
  def main(args: Array[String]){
    println("IO")
    val io = new IO()
    // println(io._list__(new File("/home/rc/temp")).size)
    // println(io._list__(new File("/home/rc/vm")).size)
    val lista = io._list_(io.dir)
      // lista.foreach{ x => println(x.getAbsolutePath) }
      println("+++++++++++++++++++++++++++++++++++++")
      val file = lista(1000)
      println(file)
      // io.readFile(lista(1000))
      val chars = io.getFileSource(file).toList
      println(chars.length)
      println(chars)
  }
}
