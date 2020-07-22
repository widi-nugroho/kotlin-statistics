package plotting

import org.math.array.StatisticSample
import org.math.plot.Plot2DPanel
import org.math.plot.plotObjects.BaseLabel
import java.awt.Color
import java.awt.Font
import javax.swing.JFrame


object CustomPlotExample {
    @JvmStatic
    fun main(args: Array<String>) {

        // define your data
        val x =
            StatisticSample.randomNormal(1000, 0.0, 1.0) // 1000 random numbers from a normal (Gaussian) statistical law
        val y =
            StatisticSample.randomUniform(1000, -3.0, 3.0) // 1000 random numbers from a uniform statistical law

        // create your PlotPanel (you can use it as a JPanel)
        val plot = Plot2DPanel()

        // legend at SOUTH
        plot.addLegend("SOUTH")

        // add the histogram (50 slices) of x to the PlotPanel
        plot.addHistogramPlot("Gaussian population", x, 50)

        // add the histogram (50 slices) of y to the PlotPanel in GREEN
        plot.addHistogramPlot("Uniform population", Color.RED, y, 50)

        // add a title
        val title = BaseLabel("...My nice plot...", Color.RED, 0.5, 1.1)
        title.setFont(Font("Courier", Font.BOLD, 20))
        plot.addPlotable(title)
/*
        // change name of axes
        plot.setAxesLabels("<X>", "frequency")

        // customize X axe
        // rotate light labels
        plot.getAxe(0).setLightLabelAngle(-Math.PI / 4)
        // change axe title position relatively to the base of the plot
        plot.getAxe(0).setLabelPosition(0.5, -0.15)

        // customize Y axe
        // rotate light labels
        plot.getAxe(1).setLightLabelAngle(-Math.PI / 4)
        // change axe title position relatively to the base of the plot
        plot.getAxe(1).setLabelPosition(-0.15, 0.5)
        // change axe title angle
        plot.getAxe(1).setLabelAngle(-Math.PI / 2)
*/
        // put the PlotPanel in a JFrame like a JPanel
        val frame = JFrame("a plot panel")
        frame.setSize(600, 600)
        frame.contentPane = plot
        frame.isVisible = true
    }
}