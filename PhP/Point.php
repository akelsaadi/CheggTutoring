<?php
class Point {
    private $x, $y;

   function  __construct($x, $y){
        $this->x = $x;
        $this->y = $y;
    }

    function setPoint($x, $y){
        $this->x = $x;
        $this->y = $y;
    }

    function getX(){
        return $this->x;
    }

    function getY(){
        return $this->y;
    }

    function printPoint(){
        echo  '['. $this->x . ' , '.  $this->y. ']' .'<br />';
    }
}
