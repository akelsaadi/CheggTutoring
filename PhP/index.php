<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
    <title></title>
    <?php
    include ("Circle.php");
    ?>
</head>
<body>
    <?php
    $circle1 = new Circle(3, 2.5, 4);
    echo '***** Circle 1 *****' . '<br />';
    $circle1->printCircle();

    
    $circle1->setPoint(-2.5, 7);
    $circle1->setRadius(4);
    echo '<br />' . '***** Circle 1 Modified *****' . '<br />';
    $circle1->printCircle();

    echo '<br />' . '***** Circle 3 *****' . '<br />';
    $circle2 = new Circle(0, 0, 0);

    echo '<br />' . 'Enter x Coordinates of the center: ';
    $x = 2;
    echo '<br />' . 'Enter y Coordinates of the center: ';
    $y = 2;
    echo '<br />' . 'Enter radius:';
    $r = 2;
    $circle2->setPoint($x, $y);
    $circle2->setRadius($r);
    $circle2->printCircle();
    ?>
</body>

</html>
