from Point import Point

class Circle(Point):
    def __init__(self, x, y, r):
        Point.__init__(self, x, y)
        self.__radius = r
    
    def setRadius(self, r):
        self.__radius = r

    def getRadius(self):
        return self.__radius

 
    def getCircumference(self):
        return (2 * 3.1416 * self.__radius)
	  
    def getArea(self):
        return (3.1416 * self.__radius * self.__radius)

    def printCircle(self):
        print("Center: ")
        Point.printPoint(self)

        print("Radius: ", self.__radius)
        print("Circumference: ", self.getCircumference())
        print("Area: ", self.getArea())
