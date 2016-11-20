require 'Point'
class Circle < Point
    attr_accessor :x, :y, :radius

    def initialize(x, y, r)
       super(x, y)
       @radius = r
    end
    def setRadius(r)
        @radius = r
    end

    def getRadius()
        return @radius
	  end

    def getCircumference()
        return (2 * 3.1416 * @radius)
	  end

    def getArea()
        return (3.1416 * @radius * @radius)
    end

    def printCircle()
        print 'Center: '

        printPoint()
        print "Radius: " ,  @radius
        puts
        print "Circumference: " , getCircumference()
        puts
        print "Area: " , getArea()
        puts
    end  
end
