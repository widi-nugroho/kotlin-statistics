package plotting

import org.math.array.StatisticSample
import org.math.plot.Plot2DPanel
import javax.swing.JFrame


object HistogramExample {
    @JvmStatic
    fun main(args: Array<String>) {

        // define your data
        val x =
            StatisticSample.randomLogNormal(1000, 0.0, 0.5) // 1000 random numbers from a log normal statistical law

        // create your PlotPanel (you can use it as a JPanel)
        val plot = Plot2DPanel()

        // add the histogram (50 slices) of x to the PlotPanel
        plot.addHistogramPlot("Log Normal population", x, 50)

        // put the PlotPanel in a JFrame like a JPanel
        val frame = JFrame("a plot panel")
        frame.setSize(600, 600)
        frame.contentPane = plot
        frame.isVisible = true
    }
}