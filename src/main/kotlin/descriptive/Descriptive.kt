package descriptive

import java.util.*
import kotlin.math.floor
import kotlin.math.sqrt


object Descriptive {
    fun mean (a:List<Double>):Double{
        var res=0.0
        for (i in a){
            res+=i
        }
        return res/a.size
    }
    fun median(a:List<Double>):Double{
        val sorted=a.sorted()
        if (sorted.size%2==0){
            val i1=sorted.size/2
            val i2=i1-1
            return (sorted[i1]+sorted[i2])/2
        }else{
            val i= floor((sorted.size/2).toDouble()).toInt()
            return sorted[i]
        }
    }
    fun mode(a:List<Double>):Double{
        val res= mutableMapOf<Double,Int>()
        val listnya= mutableListOf<Pair<Double,Int>>()
        for (i in a){
            if (res.containsKey(i)){
                res[i]=res[i]!!+1
            }else{
                res[i]=1
            }
        }
        for ((k,v) in res){
            var a = Pair(k,v)
            listnya.add(a)
        }
        listnya.sortBy { it.second }
        return listnya.last().first
    }
    fun varians(a:List<Double>):Double{
        val mean= mean(a)
        var difftotal=0.0
        for (i in a){
            var diff=i-mean
            difftotal+=diff*diff
        }
        var res=difftotal/a.size
        return res
    }
    fun standardDeviaton(a:List<Double>):Double{
        return(sqrt(varians(a)))
    }
}
fun main(){
    var a=mutableListOf<Double>(5.0,2.0,2.0,2.0,7.0,4.0,1.0)
    println(a.sorted())
    println(Descriptive.median(a))
    println(Descriptive.mode(a))
    println(Descriptive.varians(a))
    println(Descriptive.standardDeviaton(a))
    var c=Random(10)
    println(c)
}