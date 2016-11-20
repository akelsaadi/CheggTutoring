class Point
    attr_accessor :x, :y
    def initialize (x, y)
        @x = x
        @y = y
    end
    def setPoint(x, y)
        @x = x
        @y = y
    end
    def getX()
        return @x
    end
    def getY()
        return @y
    end
    def printPoint()
        print  '[', @x , ' , ',  @y, ']'
        puts
    end
end
