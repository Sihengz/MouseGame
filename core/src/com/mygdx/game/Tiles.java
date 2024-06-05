package com.mygdx.game;

import java.util.Iterator;
import java.util.function.Consumer;

public class Tiles implements Iterable<Tile>{
    final Tile[][] array;

    public Tiles(int width, int length) {
        this.array = new Tile[width][length];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < length; j++) {
                array[i][j] = new Tile();
            }
        }
    }


    @Override
    public Iterator<Tile> iterator() {
        return null;
    }
}
