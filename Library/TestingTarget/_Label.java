import java.lang.*;
import java.util.*;
import java.io.*;
import java.text.*;
import java.awt.*;
import java.nio.*;
import java.math.*;
import org.newdawn.slick.*;
public class _Label extends _Object {
public float _posX;
public float _posY;
public String _textToWrite;
public _Label(String _t, float _xx, float _yy){
_posX = _xx;
_posY = _yy;
_textToWrite = _t;
}
public void _update(float _delta){

}
public void _change(String _t){
Global._game._Labels.remove(this);
_textToWrite = _t;
Global._game._Labels.add(this);

}
}
