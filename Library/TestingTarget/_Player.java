import java.lang.*;
import java.util.*;
import java.io.*;
import java.text.*;
import java.awt.*;
import java.nio.*;
import java.math.*;
import org.newdawn.slick.*;
public class _Player extends _Sprite {
public float _g = 5f;
public _Player(){
super(100f, Global._math._getRandomNum(100f), 100f, 10f, "Player");Global._game._Sprites.add(this);
}
public void _f(float _n){
_g = _n;

}
public void _update(float _delta){
if(Global._input._key._D._isDown){
_posX = _posX + 10f;
}
}
public void _collision(_Sprite _other){
if(_other._id == "Block"){
_posX = 0f;
}
}
}
