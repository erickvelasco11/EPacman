package epacman.characters;

import epacman.sprites.SpritesSheet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

/**
 *
 * @author ErickSteven
 */
public class Character implements Entity {

    protected SpritesSheet spritesSheet;

    protected Point pixel;
    protected Point sprite;

    protected int indexPosition;
    protected double velocity = 1;

    protected int animationDuration = 1;
    protected int currentIndexSprite = 0;
    protected int initialSprite = 0;
    protected int counterAnimation = 0;
    protected int direction = 0;
    protected int predirection = 0;
    protected boolean animateOrder;

    protected int limitSize;
    protected Rectangle limit;
    protected Point center;

    @Override
    public void update() {
        if (counterAnimation == animationDuration) {
            if (currentIndexSprite == (QUANTITY_SPRITES + initialSprite) - 1) {
                animateOrder = false;
            } else if (currentIndexSprite == initialSprite) {
                animateOrder = true;
            }
            if (animateOrder) {
                currentIndexSprite++;
            } else {
                currentIndexSprite--;
            }
            counterAnimation = 0;
        } else {
            counterAnimation++;
        }
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.red);
        g.drawRect(limit.x, limit.y, limit.width, limit.height);
        g.setColor(Color.red);
        g.drawRect(center.x, center.y, 1, 1);
    }

}
