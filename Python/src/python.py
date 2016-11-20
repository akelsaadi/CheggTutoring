import Circle

def main():
    circle1 = Circle.Circle(3, 2.5, 4)
    print("***** Circle 1 *****")
    circle1.printCircle()


    circle1.setPoint(-2.5, 7)
    circle1.setRadius(4)
    print("***** Circle 1 modified *****")
    circle1.printCircle()


    circle2 = Circle.Circle(0, 0, 0)
    x = input('Enter x Coordinates of the center:')
    y = input('Enter y Coordinates of the center:')
    r = input('Enter radius:')
    circle2.setPoint(x, y)
    circle2.setRadius(r)
    print("***** Circle 2 *****")
    circle2.printCircle()
    
main()