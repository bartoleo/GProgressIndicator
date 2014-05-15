import static org.fusesource.jansi.Ansi.ansi
import org.fusesource.jansi.Ansi.Erase

def printMessageWithProgress(def message, def percentage, def width, def done){
    def percentageGraph = ""
    if (percentage>=100){
        println ansi().a("\r$message $done").eraseLine(Erase.FORWARD)
    } else {
        width.times{
            if (it<width*percentage/100){
                percentageGraph+="#"
            } else {
                percentageGraph+=" "
            }
        }
        print ansi().a("\r$message [$percentageGraph]").eraseLine(Erase.FORWARD)
    }
}

//example:
print "testing"
101.times{
    printMessageWithProgress "testing", it, 20, "done"
    sleep 10
}
println "end"