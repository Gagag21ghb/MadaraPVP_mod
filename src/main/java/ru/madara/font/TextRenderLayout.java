package ru.madara.font;


public enum TextRenderLayout {
    ENG(40, 60);
    private final int x;
    private final int y;

    TextRenderLayout(int x, int y) {
        this.x = x;
        this.y = y;
    }

    int getX() {
        return x;
    }
    int getY() {
        return y;
    }
}
