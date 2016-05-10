import java.lang.*;
import java.util.*;
import java.io.*;
import java.text.*;
import java.awt.*;
import java.nio.*;
import java.math.*;
import org.newdawn.slick.*;
public class _Sprite extends _Object {
public float _posX;
public float _posY;
public float _sizeX;
public float _sizeY;
public String _id;
public _Sprite(float _xx, float _yy, float _sizeXX, float _sizeYY, String _ID){
_posX = _xx;
_posY = _yy;
_sizeX = _sizeXX;
_sizeY = _sizeYY;
_id = _ID;
}
public void _update(float _delta){

}
public void _collision(_Sprite _other){

}
public _Vector _GetCenter(){
_Vector _center =  new _Vector(0f, 0f);
_center._SetX(_posX + _sizeX / 2f);
_center._SetY(_posY + _sizeY / 2f);
return _center;

}
}
