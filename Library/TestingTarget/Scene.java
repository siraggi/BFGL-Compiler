import java.util.ArrayList;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.Color;
import org.newdawn.slick.Image;


public class Scene extends BasicGame{


    public Scene(String gamename)
    {
    		super(gamename);
    }

    public void init(GameContainer gc) throws SlickException {
        Global._game._height = gc.getHeight();
        Global._game._width = gc.getWidth();


_Player _player =  new _Player();
_Block _block =  new _Block();
float _x = 5f;
_x = _x + 5f;
float _y = _player._g;
_y = _x * 2f;

    }

    public void update(GameContainer gc, int delta) throws SlickException {
        Input input = gc.getInput();

        if(input.isKeyDown(input.KEY_ESCAPE)){
        	Global._input._key._ESCAPE._isDown = true;
        }
        else{
        	Global._input._key._ESCAPE._isDown = false;
        }
        if(input.isKeyDown(input.KEY_1)){
        	Global._input._key._num1._isDown = true;
        }
        else{
        	Global._input._key._num1._isDown = false;
        }
        if(input.isKeyDown(input.KEY_2)){
        	Global._input._key._num2._isDown = true;
        }
        else{
        	Global._input._key._num2._isDown = false;
        }
        if(input.isKeyDown(input.KEY_3)){
        	Global._input._key._num3._isDown = true;
        }
        else{
        	Global._input._key._num3._isDown = false;
        }
        if(input.isKeyDown(input.KEY_4)){
        	Global._input._key._num4._isDown = true;
        }
        else{
        	Global._input._key._num4._isDown = false;
        }
        if(input.isKeyDown(input.KEY_5)){
        	Global._input._key._num5._isDown = true;
        }
        else{
        	Global._input._key._num5._isDown = false;
        }
        if(input.isKeyDown(input.KEY_6)){
        	Global._input._key._num6._isDown = true;
        }
        else{
        	Global._input._key._num6._isDown = false;
        }
        if(input.isKeyDown(input.KEY_7)){
        	Global._input._key._num7._isDown = true;
        }
        else{
        	Global._input._key._num7._isDown = false;
        }
        if(input.isKeyDown(input.KEY_8)){
        	Global._input._key._num8._isDown = true;
        }
        else{
        	Global._input._key._num8._isDown = false;
        }
        if(input.isKeyDown(input.KEY_9)){
        	Global._input._key._num9._isDown = true;
        }
        else{
        	Global._input._key._num9._isDown = false;
        }
        if(input.isKeyDown(input.KEY_0)){
        	Global._input._key._num0._isDown = true;
        }
        else{
        	Global._input._key._num0._isDown = false;
        }
        if(input.isKeyDown(input.KEY_BACK)){
        	Global._input._key._BACK._isDown = true;
        }
        else{
        	Global._input._key._BACK._isDown = false;
        }
        if(input.isKeyDown(input.KEY_TAB)){
        	Global._input._key._TAB._isDown = true;
        }
        else{
        	Global._input._key._TAB._isDown = false;
        }
        if(input.isKeyDown(input.KEY_Q)){
        	Global._input._key._Q._isDown = true;
        }
        else{
        	Global._input._key._Q._isDown = false;
        }
        if(input.isKeyDown(input.KEY_W)){
        	Global._input._key._W._isDown = true;
        }
        else{
        	Global._input._key._W._isDown = false;
        }
        if(input.isKeyDown(input.KEY_E)){
        	Global._input._key._E._isDown = true;
        }
        else{
        	Global._input._key._E._isDown = false;
        }
        if(input.isKeyDown(input.KEY_R)){
        	Global._input._key._R._isDown = true;
        }
        else{
        	Global._input._key._R._isDown = false;
        }
        if(input.isKeyDown(input.KEY_T)){
        	Global._input._key._T._isDown = true;
        }
        else{
        	Global._input._key._T._isDown = false;
        }
        if(input.isKeyDown(input.KEY_Y)){
        	Global._input._key._Y._isDown = true;
        }
        else{
        	Global._input._key._Y._isDown = false;
        }
        if(input.isKeyDown(input.KEY_U)){
        	Global._input._key._U._isDown = true;
        }
        else{
        	Global._input._key._U._isDown = false;
        }
        if(input.isKeyDown(input.KEY_I)){
        	Global._input._key._I._isDown = true;
        }
        else{
        	Global._input._key._I._isDown = false;
        }
        if(input.isKeyDown(input.KEY_O)){
        	Global._input._key._O._isDown = true;
        }
        else{
        	Global._input._key._O._isDown = false;
        }
        if(input.isKeyDown(input.KEY_P)){
        	Global._input._key._P._isDown = true;
        }
        else{
        	Global._input._key._P._isDown = false;
        }
        if(input.isKeyDown(input.KEY_RETURN)){
        	Global._input._key._RETURN._isDown = true;
        }
        else{
        	Global._input._key._RETURN._isDown = false;
        }
        if(input.isKeyDown(input.KEY_LCONTROL)){
        	Global._input._key._LCONTROL._isDown = true;
        }
        else{
        	Global._input._key._LCONTROL._isDown = false;
        }
        if(input.isKeyDown(input.KEY_A)){
        	Global._input._key._A._isDown = true;
        }
        else{
        	Global._input._key._A._isDown = false;
        }
        if(input.isKeyDown(input.KEY_S)){
        	Global._input._key._S._isDown = true;
        }
        else{
        	Global._input._key._S._isDown = false;
        }
        if(input.isKeyDown(input.KEY_D)){
        	Global._input._key._D._isDown = true;
        }
        else{
        	Global._input._key._D._isDown = false;
        }
        if(input.isKeyDown(input.KEY_F)){
        	Global._input._key._F._isDown = true;
        }
        else{
        	Global._input._key._F._isDown = false;
        }
        if(input.isKeyDown(input.KEY_G)){
        	Global._input._key._G._isDown = true;
        }
        else{
        	Global._input._key._G._isDown = false;
        }
        if(input.isKeyDown(input.KEY_H)){
        	Global._input._key._H._isDown = true;
        }
        else{
        	Global._input._key._H._isDown = false;
        }
        if(input.isKeyDown(input.KEY_J)){
        	Global._input._key._J._isDown = true;
        }
        else{
        	Global._input._key._J._isDown = false;
        }
        if(input.isKeyDown(input.KEY_K)){
        	Global._input._key._K._isDown = true;
        }
        else{
        	Global._input._key._K._isDown = false;
        }
        if(input.isKeyDown(input.KEY_LSHIFT)){
        	Global._input._key._LSHIFT._isDown = true;
        }
        else{
        	Global._input._key._LSHIFT._isDown = false;
        }
        if(input.isKeyDown(input.KEY_Z)){
        	Global._input._key._Z._isDown = true;
        }
        else{
        	Global._input._key._Z._isDown = false;
        }
        if(input.isKeyDown(input.KEY_X)){
        	Global._input._key._X._isDown = true;
        }
        else{
        	Global._input._key._X._isDown = false;
        }
        if(input.isKeyDown(input.KEY_C)){
        	Global._input._key._C._isDown = true;
        }
        else{
        	Global._input._key._C._isDown = false;
        }
        if(input.isKeyDown(input.KEY_V)){
        	Global._input._key._V._isDown = true;
        }
        else{
        	Global._input._key._V._isDown = false;
        }
        if(input.isKeyDown(input.KEY_B)){
        	Global._input._key._B._isDown = true;
        }
        else{
        	Global._input._key._B._isDown = false;
        }
        if(input.isKeyDown(input.KEY_N)){
        	Global._input._key._N._isDown = true;
        }
        else{
        	Global._input._key._N._isDown = false;
        }
        if(input.isKeyDown(input.KEY_M)){
        	Global._input._key._M._isDown = true;
        }
        else{
        	Global._input._key._M._isDown = false;
        }
        if(input.isKeyDown(input.KEY_COMMA)){
        	Global._input._key._COMMA._isDown = true;
        }
        else{
        	Global._input._key._COMMA._isDown = false;
        }
        if(input.isKeyDown(input.KEY_PERIOD)){
        	Global._input._key._PERIOD._isDown = true;
        }
        else{
        	Global._input._key._PERIOD._isDown = false;
        }
        if(input.isKeyDown(input.KEY_SLASH)){
        	Global._input._key._SLASH._isDown = true;
        }
        else{
        	Global._input._key._SLASH._isDown = false;
        }
        if(input.isKeyDown(input.KEY_RSHIFT)){
        	Global._input._key._RSHIFT._isDown = true;
        }
        else{
        	Global._input._key._RSHIFT._isDown = false;
        }
        if(input.isKeyDown(input.KEY_MULTIPLY)){
        	Global._input._key._MULTIPLY._isDown = true;
        }
        else{
        	Global._input._key._MULTIPLY._isDown = false;
        }
        if(input.isKeyDown(input.KEY_LALT)){
        	Global._input._key._LALT._isDown = true;
        }
        else{
        	Global._input._key._LALT._isDown = false;
        }
        if(input.isKeyDown(input.KEY_SPACE)){
        	Global._input._key._SPACE._isDown = true;
        }
        else{
        	Global._input._key._SPACE._isDown = false;
        }
        if(input.isKeyDown(input.KEY_F1)){
        	Global._input._key._F1._isDown = true;
        }
        else{
        	Global._input._key._F1._isDown = false;
        }
        if(input.isKeyDown(input.KEY_F2)){
        	Global._input._key._F2._isDown = true;
        }
        else{
        	Global._input._key._F2._isDown = false;
        }
        if(input.isKeyDown(input.KEY_F3)){
        	Global._input._key._F3._isDown = true;
        }
        else{
        	Global._input._key._F3._isDown = false;
        }
        if(input.isKeyDown(input.KEY_F4)){
        	Global._input._key._F4._isDown = true;
        }
        else{
        	Global._input._key._F4._isDown = false;
        }
        if(input.isKeyDown(input.KEY_F5)){
        	Global._input._key._F5._isDown = true;
        }
        else{
        	Global._input._key._F5._isDown = false;
        }
        if(input.isKeyDown(input.KEY_F6)){
        	Global._input._key._F6._isDown = true;
        }
        else{
        	Global._input._key._F6._isDown = false;
        }
        if(input.isKeyDown(input.KEY_F7)){
        	Global._input._key._F7._isDown = true;
        }
        else{
        	Global._input._key._F7._isDown = false;
        }
        if(input.isKeyDown(input.KEY_F8)){
        	Global._input._key._F8._isDown = true;
        }
        else{
        	Global._input._key._F8._isDown = false;
        }
        if(input.isKeyDown(input.KEY_F9)){
        	Global._input._key._F9._isDown = true;
        }
        else{
        	Global._input._key._F9._isDown = false;
        }
        if(input.isKeyDown(input.KEY_F10)){
        	Global._input._key._F10._isDown = true;
        }
        else{
        	Global._input._key._F10._isDown = false;
        }
        if(input.isKeyDown(input.KEY_NUMLOCK)){
        	Global._input._key._NUMLOCK._isDown = true;
        }
        else{
        	Global._input._key._NUMLOCK._isDown = false;
        }
        if(input.isKeyDown(input.KEY_SCROLL)){
        	Global._input._key._SCROLL._isDown = true;
        }
        else{
        	Global._input._key._SCROLL._isDown = false;
        }
        if(input.isKeyDown(input.KEY_NUMPAD7)){
        	Global._input._key._NUMPAD7._isDown = true;
        }
        else{
        	Global._input._key._NUMPAD7._isDown = false;
        }
        if(input.isKeyDown(input.KEY_NUMPAD8)){
        	Global._input._key._NUMPAD8._isDown = true;
        }
        else{
        	Global._input._key._NUMPAD8._isDown = false;
        }
        if(input.isKeyDown(input.KEY_NUMPAD9)){
        	Global._input._key._NUMPAD9._isDown = true;
        }
        else{
        	Global._input._key._NUMPAD9._isDown = false;
        }
        if(input.isKeyDown(input.KEY_SUBTRACT)){
        	Global._input._key._SUBTRACT._isDown = true;
        }
        else{
        	Global._input._key._SUBTRACT._isDown = false;
        }
        if(input.isKeyDown(input.KEY_NUMPAD4)){
        	Global._input._key._NUMPAD4._isDown = true;
        }
        else{
        	Global._input._key._NUMPAD4._isDown = false;
        }
        if(input.isKeyDown(input.KEY_NUMPAD5)){
        	Global._input._key._NUMPAD5._isDown = true;
        }
        else{
        	Global._input._key._NUMPAD5._isDown = false;
        }
        if(input.isKeyDown(input.KEY_NUMPAD6)){
        	Global._input._key._NUMPAD6._isDown = true;
        }
        else{
        	Global._input._key._NUMPAD6._isDown = false;
        }
        if(input.isKeyDown(input.KEY_ADD)){
        	Global._input._key._ADD._isDown = true;
        }
        else{
        	Global._input._key._ADD._isDown = false;
        }
        if(input.isKeyDown(input.KEY_NUMPAD1)){
        	Global._input._key._NUMPAD1._isDown = true;
        }
        else{
        	Global._input._key._NUMPAD1._isDown = false;
        }
        if(input.isKeyDown(input.KEY_NUMPAD2)){
        	Global._input._key._NUMPAD2._isDown = true;
        }
        else{
        	Global._input._key._NUMPAD2._isDown = false;
        }
        if(input.isKeyDown(input.KEY_NUMPAD3)){
        	Global._input._key._NUMPAD3._isDown = true;
        }
        else{
        	Global._input._key._NUMPAD3._isDown = false;
        }
        if(input.isKeyDown(input.KEY_NUMPAD0)){
        	Global._input._key._NUMPAD0._isDown = true;
        }
        else{
        	Global._input._key._NUMPAD0._isDown = false;
        }
        if(input.isKeyDown(input.KEY_DECIMAL)){
        	Global._input._key._DECIMAL._isDown = true;
        }
        else{
        	Global._input._key._DECIMAL._isDown = false;
        }
        if(input.isKeyDown(input.KEY_F11)){
        	Global._input._key._F11._isDown = true;
        }
        else{
        	Global._input._key._F11._isDown = false;
        }
        if(input.isKeyDown(input.KEY_F12)){
        	Global._input._key._F12._isDown = true;
        }
        else{
        	Global._input._key._F12._isDown = false;
        }
        if(input.isKeyDown(input.KEY_RCONTROL)){
        	Global._input._key._RCONTROL._isDown = true;
        }
        else{
        	Global._input._key._RCONTROL._isDown = false;
        }
        if(input.isKeyDown(input.KEY_PAUSE)){
        	Global._input._key._PAUSE._isDown = true;
        }
        else{
        	Global._input._key._PAUSE._isDown = false;
        }
        if(input.isKeyDown(input.KEY_HOME)){
        	Global._input._key._HOME._isDown = true;
        }
        else{
        	Global._input._key._HOME._isDown = false;
        }
        if(input.isKeyDown(input.KEY_UP)){
        	Global._input._key._UP._isDown = true;
        }
        else{
        	Global._input._key._UP._isDown = false;
        }
        if(input.isKeyDown(input.KEY_LEFT)){
        	Global._input._key._LEFT._isDown = true;
        }
        else{
        	Global._input._key._LEFT._isDown = false;
        }
        if(input.isKeyDown(input.KEY_RIGHT)){
        	Global._input._key._RIGHT._isDown = true;
        }
        else{
        	Global._input._key._RIGHT._isDown = false;
        }
        if(input.isKeyDown(input.KEY_END)){
        	Global._input._key._END._isDown = true;
        }
        else{
        	Global._input._key._END._isDown = false;
        }
        if(input.isKeyDown(input.KEY_DOWN)){
        	Global._input._key._DOWN._isDown = true;
        }
        else{
        	Global._input._key._DOWN._isDown = false;
        }
        if(input.isKeyDown(input.KEY_INSERT)){
        	Global._input._key._INSERT._isDown = true;
        }
        else{
        	Global._input._key._INSERT._isDown = false;
        }
        if(input.isKeyDown(input.KEY_DELETE)){
        	Global._input._key._DELETE._isDown = true;
        }
        else{
        	Global._input._key._DELETE._isDown = false;
        }
        if(input.isKeyDown(input.KEY_LWIN)){
        	Global._input._key._LWIN._isDown = true;
        }
        else{
        	Global._input._key._LWIN._isDown = false;
        }
        if(input.isKeyDown(input.KEY_RWIN)){
        	Global._input._key._RWIN._isDown = true;
        }
        else{
        	Global._input._key._RWIN._isDown = false;
        }




        for(_Sprite s : Global._game._Sprites) {
            for(_Sprite other : Global._game._Sprites){
                if(!s.equals(other) && (new Rectangle(s._posX, s._posY, s._sizeX, s._sizeY)).intersects(new Rectangle(other._posX, other._posY, other._sizeX, other._sizeY))){
                    s._collision(other);
                }
            }

            s._update(delta);
        }

        for(_Label l : Global._game._Labels) {
            l._update(delta);
        }
    }

    public void render(GameContainer gc, Graphics g) throws SlickException {
        Image background;
        if(!Global._game._background.equals("")){
            background = new Image(Global._game._background);
            background.draw(0, 0, gc.getWidth(), gc.getHeight());
        }

        for(_Sprite s : Global._game._Sprites) {

            if(!s._texture.equals("")) {
                Image img = new Image(s._texture);
                img.draw(s._posX, s._posY, s._sizeX, s._sizeY);
            }
            else{
                g.draw(new Rectangle(s._posX, s._posY, s._sizeX, s._sizeY));
            }


        }
        for(_Label l : Global._game._Labels) {
            g.drawString(l._textToWrite, l._posX, l._posY);
        }
        g.drawString("" + Global._game._Sprites.size(), 150, 100);
    }

}
