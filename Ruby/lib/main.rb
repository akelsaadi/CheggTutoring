require 'Circle'

    circle1 = Circle.new(3, 2.5, 4)
    puts"***** Circle 1 *****"
    circle1.printCircle()
    puts

    circle1.setPoint(-2.5, 7)
    circle1.setRadius(4)
    puts"***** Circle 1 modified *****"
    circle1.printCircle()
    puts

    circle2 = Circle.new(0, 0, 0)
    print 'Enter x Coordinates of the center: '
    x = gets.chomp.to_i
    print 'Enter y Coordinates of the center: '
    y = gets.chomp.to_i
    print 'Enter radius:'
    r = gets.chomp.to_i
    circle2.setPoint(x, y)
    circle2.setRadius(r)
    puts '***** Circle 2 *****'
    circle2.printCircle()
    puts
