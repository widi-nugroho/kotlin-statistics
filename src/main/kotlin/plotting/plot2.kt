package plotting
import com.github.doyaaaaaken.kotlincsv.dsl.csvReader
import jetbrains.letsPlot.geom.geom_point
import jetbrains.letsPlot.lets_plot
import org.math.plot.Plot2DPanel
import javax.swing.JFrame

fun colToInt(col:String,data:List<Map<String,String>>):List<Int>{
    var out= mutableListOf<Int>()
    for (i in data){
        var t=i[col]!!.toInt()
        out.add(t)
    }
    return out
}
fun colToDouble(col:String,data:List<Map<String,String>>): DoubleArray {

    var out= mutableListOf<Double>()
    for (i in data){
        var t=i[col]!!.toDouble()
        out.add(t)
    }
    var d=DoubleArray(out.size)
    for (i in 0..out.size-1){
        d.set(i,out[i])
    }
    return d
}
fun colToString(col:String,data:List<Map<String,String>>):List<String>{
    var out= mutableListOf<String>()
    for (i in data){
        var t=i[col]!!
        out.add(t)
    }
    return out
}
fun main(){
    var datas= mutableListOf<Map<String,String>>()
    var data= csvReader().open("/home/widi/projects/kotlin-statistics/src/main/resources/mpg.csv") {
        readAllWithHeader().forEach { row ->
            datas.add(row)
        }
    }
    val df = mapOf(
            "mpg" to colToDouble("mpg",datas),
            "cyl" to colToInt("cylinders",datas),
            "dis" to colToDouble("displacement",datas),
            "hp" to colToDouble("horsepower",datas),
            "wght" to colToDouble("weight",datas),
            "acc" to colToDouble("acceleration",datas),
            "mdl" to colToInt("model_year",datas),
            "org" to colToInt("origin",datas),
            "name" to colToString("name",datas)
    )
    println(df)
    val p2=Plot2DPanel()
    p2.addLegend("SOUTH")
    //p2.addLinePlot("my plot", x, y)
    val p = lets_plot(df) {x = "mpg"; y = "acc"} + geom_point(df)
    p.show()
}