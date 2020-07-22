package plotting

import org.math.array.DoubleArray.increment
import org.math.plot.Plot3DPanel
import javax.swing.JFrame


object GridPlotsExample {
    @JvmStatic
    fun main(args: Array<String>) {

        // define your data
        val x= doubleArrayOf(0.0,0.1,0.2,0.3,0.4,0.5,0.6,0.7,0.8,0.9,1.0)
        val y= doubleArrayOf(0.0,0.05,0.1,0.15,0.2,0.25,0.3,0.35,0.4,0.45,0.5,0.55,0.6,0.65,0.7,0.75,0.8,0.85,0.9,0.95,1.0)
        val z1 = f1(x, y)
        val z2 = f2(x, y)

        // create your PlotPanel (you can use it as a JPanel) with a legend at SOUTH
        val plot = Plot3DPanel("SOUTH")

        // add grid plot to the PlotPanel
        plot.addGridPlot("z=cos(PI*x)*sin(PI*y)", x, y, z1)
        plot.addGridPlot("z=sin(PI*x)*cos(PI*y)", x, y, z2)

        // put the PlotPanel in a JFrame like a JPanel
        val frame = JFrame("a plot panel")
        frame.setSize(600, 600)
        frame.contentPane = plot
        frame.isVisible = true
    }

    // function definition: z=cos(PI*x)*sin(PI*y)
    fun f1(x: Double, y: Double): Double {
        return Math.cos(x * Math.PI) * Math.sin(y * Math.PI)
    }

    // grid version of the function
    fun f1(x: DoubleArray, y: DoubleArray): Array<DoubleArray> {
        val z = Array(y.size) { DoubleArray(x.size) }
        for (i in x.indices) for (j in y.indices) z[j][i] = f1(x[i], y[j])
        return z
    }

    // another function definition: z=sin(PI*x)*cos(PI*y)
    fun f2(x: Double, y: Double): Double {
        return Math.sin(x * Math.PI) * Math.cos(y * Math.PI)
    }

    // grid version of the function
    fun f2(x: DoubleArray, y: DoubleArray): Array<DoubleArray> {
        val z = Array(y.size) { DoubleArray(x.size) }
        for (i in x.indices) for (j in y.indices) z[j][i] = f2(x[i], y[j])
        return z
    }
}