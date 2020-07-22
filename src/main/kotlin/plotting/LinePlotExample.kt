package plotting

import org.math.plot.Plot2DPanel
import javax.swing.JFrame


object LinePlotExample {
    @JvmStatic
    fun main(args: Array<String>) {

        // define your data
        val x = doubleArrayOf(1.0, 2.0, 3.0, 4.0, 5.0, 6.0)
        val y = doubleArrayOf(45.0, 89.0, 6.0, 32.0, 63.0, 12.0)

        // create your PlotPanel (you can use it as a JPanel)
        val plot = Plot2DPanel()

        // define the legend position
        plot.addLegend("SOUTH")

        // add a line plot to the PlotPanel
        plot.addLinePlot("my plot", x, y)

        // put the PlotPanel in a JFrame like a JPanel
        val frame = JFrame("a line plot panel")
        frame.setSize(600, 600)
        frame.contentPane = plot
        frame.isVisible = true
    }
}