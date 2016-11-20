<?php

include ("Point");

class Circle extends Point {
    private $x, $y, $radius;

    function  __construct($x, $y, $r) {
        $this->radius = $r;
        parent::__construct($x, $y);
    }

    function setRadius($r){
        $this->radius = $r;
    }

    function getRadius(){
        return $this->radius;
    }

    function getCircumference(){
        return (2 * 3.1416 * $this->radius);
    }

    function getArea(){
        return (3.1416 * $this->radius * $this->radius);
    }

    function printCircle(){
        echo 'Center: ';
        $this->printPoint();
        echo "Radius: " .  $this->radius .'<br />';
        echo "Circumference: " . $this->getCircumference().'<br />';
        echo "Area: "  . $this->getArea() .'<br />';
    }
}
?>
