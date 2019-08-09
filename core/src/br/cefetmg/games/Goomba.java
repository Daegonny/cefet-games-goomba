/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.games;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 *
 * @author daegonny
 */
public class Goomba {
    private String textureFile;
    private int step = 2;
    private Texture spriteSheet;
    private TextureRegion[][] frames;
    private Animation walkDown;
    private Animation walkRight;
    private Animation walkUp;
    private Animation walkLeft;
    float animationTime;
    int x, y, w, h;
    boolean walking;
    private Direction dir;
    
    public Goomba(String textureFile){
        this.textureFile = textureFile;
        this.spriteSheet = new Texture(textureFile);
        this.x = 10;
        this.y = 30;
        this.w = 21;
        this.h = 24;
        this.setUpSprite(spriteSheet, w, h);
        this.walking = false;
        this.dir = Direction.downSide;
    }
    
    public void setUpSprite(Texture spriteSheet, int w, int h){
        this.frames = TextureRegion.split(spriteSheet, w, h);
        
        this.walkDown = new Animation(0.1f,
          frames[0][0], // 1ª linha, 1ª coluna
          frames[0][1], // idem, 2ª coluna
          frames[0][2],
          frames[0][3],
          frames[0][4]);
        walkDown.setPlayMode(PlayMode.LOOP_PINGPONG);
        
        this.walkRight = new Animation(0.1f,
          frames[1][0], // 1ª linha, 1ª coluna
          frames[1][1], // idem, 2ª coluna
          frames[1][2],
          frames[1][3],
          frames[1][4]);
        walkRight.setPlayMode(PlayMode.LOOP_PINGPONG);
        
        this.walkUp = new Animation(0.1f,
          frames[2][0], // 1ª linha, 1ª coluna
          frames[2][1], // idem, 2ª coluna
          frames[2][2],
          frames[2][3],
          frames[2][4]);
        walkUp.setPlayMode(PlayMode.LOOP_PINGPONG);
        
        this.walkLeft = new Animation(0.1f,
          frames[3][0], // 1ª linha, 1ª coluna
          frames[3][1], // idem, 2ª coluna
          frames[3][2],
          frames[3][3],
          frames[3][4]);
        walkLeft.setPlayMode(PlayMode.LOOP_PINGPONG);        
        
        this.animationTime = 0;
    }
    
    public void update(float delta){
        this.animationTime += Gdx.graphics.getDeltaTime();
        
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) && this.x < (Gdx.graphics.getWidth() - this.w)) {
            this.dir = Direction.rightSide;
            this.x += dir.stepX;
            this.y += dir.stepY;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT) && this.x > 0) {
           this.dir = Direction.leftSide;
           this.x += dir.stepX;
           this.y += dir.stepY;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.UP) && this.y < (Gdx.graphics.getHeight() - this.w)) {
            this.dir = Direction.upSide;
            this.x += dir.stepX;
            this.y += dir.stepY;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN) && this.y > 0) {
            this.dir = Direction.downSide;
            this.x += dir.stepX;
            this.y += dir.stepY;
        }
    }
    
    public void render(SpriteBatch batch){
       switch(this.dir){
           case downSide: 
               batch.draw((TextureRegion) walkDown.getKeyFrame(animationTime), x, y);
               break;
            
            case rightSide: 
               batch.draw((TextureRegion) walkRight.getKeyFrame(animationTime), x, y);
               break;
               
            case upSide: 
               batch.draw((TextureRegion) walkUp.getKeyFrame(animationTime), x, y);
               break;
               
            case leftSide: 
               batch.draw((TextureRegion) walkLeft.getKeyFrame(animationTime), x, y);
               break;
       }
        
    }
    
}
