import java.lang.*;
import java.util.*;
import java.io.*;
import java.text.*;
import java.awt.*;
import java.nio.*;
import java.math.*;
import org.newdawn.slick.*;
public class _Vector{
public float _x;
public float _y;
public _Vector(float _dclx, float _dcly){
_x = _dclx;
_y = _dcly;
}
public void _SetX(float _value){
_x = _value;

}
public void _SetY(float _value){
_y = _value;

}
public void _Normelise(){
float _tempX;
float _tempY;
if(_x < 0f){
_tempX = (-_x);
}
else{
_tempX = _x;
}
if(_y < 0f){
_tempY = (-_y);
}
else{
_tempY = _y;
}
float _temp = _tempX + _tempY;
_x = _x / _temp;
_y = _y / _temp;

}
public float _tempX;
public float _tempY;
public _Vector _DirVector(_Vector _point){
_Vector _temp =  new _Vector(_x - _point._x, _y - _point._y);
return _temp;

}
public void _MultiVector(float _amount){
_x = _x * _amount;
_y = _y * _amount;

}
}
